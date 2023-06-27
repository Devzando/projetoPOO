package repositoryImplements;

import java.util.List;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entities.Cliente;
import entities.Compra;
import entities.Produto;
import repositoryContracts.ICompraContracts;

public class CompraRepository implements ICompraContracts {
    private Gson gson;
    private ProdutoRepository produtoRepository;
    private ClienteRepository clienteRepository;

    public CompraRepository() {
        produtoRepository = new ProdutoRepository();
        clienteRepository = new ClienteRepository();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public String buy(Compra compra) {
        List<Produto> produtos = produtoRepository.readAll();
        List<Cliente> clientes = clienteRepository.readAll();

        try {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getIdProduto().equals(compra.getIdProduto())) {
                    if (produtos.get(i).getEstoque() < compra.getQuantidade()) {
                        throw new RuntimeException("Quantidade de produtos indisponível");
                    }

                    compra.setValorTotal(produtos.get(i).getPreco() * compra.getQuantidade());

                    for (int j = 0; j < clientes.size(); j++) {
                        if (clientes.get(j).getIdCliente().equals(compra.getIdCliente())) {
                            if (compra.getValorTotal() > clientes.get(j).getSaldo()) {
                                throw new RuntimeException("Saldo na conta insuficiente");
                            }

                            clientes.get(j).setSaldo(clientes.get(j).getSaldo() - compra.getValorTotal());
                            clientes.get(j).setQuantidadeCompras(clientes.get(j).getQuantidadeCompras() + 1);
                            clienteRepository.update(clientes.get(j), clientes.get(j).getIdCliente());

                            produtos.get(i).setEstoque(produtos.get(i).getEstoque() - compra.getQuantidade());
                            produtos.get(i).setQuantidadeVendida(
                                    produtos.get(i).getQuantidadeVendida() + compra.getQuantidade());
                            produtoRepository.update(produtos.get(i), produtos.get(i).getIdProduto());
                            generateInvoice(
                                    clientes.get(j).getIdCliente(),
                                    clientes.get(j).getNome(),
                                    produtos.get(i).getNome(),
                                    compra.getDataCompra(),
                                    compra.getQuantidade(),
                                    compra.getValorTotal());
                        }
                    }
                }
            }
            List<Compra> compraExistentes = readAllCompra();
            compraExistentes.add(compra);

            Writer writer = new FileWriter("./src/database/compra.json");
            gson.toJson(compraExistentes, writer);
            writer.close();
            return "Compra realizada com sucesso";

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao realizar compra");
        }
    }

    public void generateInvoice(
            String idCliente,
            String nomeCliente,
            String nomeProduto,
            LocalDate dataCompra,
            int quantidade,
            double valorTotal) {
        Compra fatura = new Compra(
                idCliente,
                nomeCliente,
                nomeProduto,
                dataCompra,
                quantidade,
                valorTotal);

        try {
            List<Compra> faturasExistentes = readAllFatura();
            faturasExistentes.add(fatura);

            Writer writer = new FileWriter("./src/database/fatura.json");
            gson.toJson(faturasExistentes, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao gerar fatura");
        }
    }

    public List<Compra> readAllFatura() {
        List<Compra> faturas = new ArrayList<Compra>();
        try {
            File file = new File("./src/database/fatura.json");
            if (file.length() == 0) {
                return faturas;
            }

            Reader reader = new FileReader("./src/database/fatura.json");
            Type type = new TypeToken<List<Compra>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar faturas");
        }
    }

    public List<Compra> readAllCompra() {
        List<Compra> compras = new ArrayList<Compra>();
        try {
            File file = new File("./src/database/compra.json");
            if (file.length() == 0) {
                return compras;
            }

            Reader reader = new FileReader("./src/database/compra.json");
            Type type = new TypeToken<List<Compra>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar compras");
        }
    }

    public int totalSalesPerMonth() {
        List<Compra> compras = readAllCompra();
        int total = 0;

        try {
            for (int i = 0; i < compras.size(); i++) {
                if (compras.get(i).getDataCompra().getMonthValue() == LocalDate.now().getMonthValue()) {
                    total += compras.get(i).getQuantidade();
                }

                if (i == compras.size() - 1 && total == 0) {
                    throw new RuntimeException("Nenhuma compra realizada neste mês");
                }
            }
            return total;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar compras");
        }

    }

    public String getProductWithMoreOrLessSales(int choose) {
        List<Produto> produtos = produtoRepository.readAll();

        try {
            Collections.sort(produtos);

            if (choose == 1) {
                String nomeProdutoMaior = produtos.get(produtos.size() - 1).getNome();
                return nomeProdutoMaior;
            } else {
                String nomeProdutoMenor = produtos.get(0).getNome();
                return nomeProdutoMenor;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar produtos");
        }
    }

    public String getBetterClient() {
        List<Cliente> clientes = clienteRepository.readAll();
        String nomeCliente = "";

        try {
            Collections.sort(clientes);
            nomeCliente = clientes.get(clientes.size() - 1).getNome();
            return nomeCliente;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar clientes");
        }
    }
}
