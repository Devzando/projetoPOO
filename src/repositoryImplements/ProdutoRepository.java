package repositoryImplements;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entities.Produto;
import repositoryContracts.IProdutoContracts;

public class ProdutoRepository implements IProdutoContracts {
    private Gson gson;

    public ProdutoRepository() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public String create(Produto produto) {

        try {
            List<Produto> produtosExistentes = readAll();
            produtosExistentes.add(produto);

            FileWriter writer = new FileWriter("./src/database/produto.json");
            gson.toJson(produtosExistentes, writer);
            writer.close();

            return "Produto criado com sucesso!";
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar produto!");
        }

    }

    public List<Produto> readAll() {
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            File file = new File("./src/database/produto.json");
            if (file.length() == 0) {
                return produtos;
            }

            Reader reader = new FileReader("./src/database/produto.json");
            Type type = new TypeToken<List<Produto>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar produtos!");
        }
    }

    public String update(Produto produto, String idProduto) {
        List<Produto> produtos = readAll();

        if (produtos.size() == 0) {
            return "Não há produtos cadastrados!";
        }

         for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getIdProduto().equals(idProduto)) {
                produtos.set(i, produto);
                break;
            }

            if (i == produtos.size() - 1) {
                return "Produto não encontrado!";
            }
        }

        try {
            Writer writer = new FileWriter("./src/database/produto.json");
            gson.toJson(produtos, writer);
            writer.close();
            return "Produto atualizado com sucesso!";
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar produto!");
        }

    }

    public String delete(String idProduto) {
        List<Produto> produtos = readAll();

        if (produtos.size() == 0) {
            return "Não há produtos cadastrados!";
        }

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getIdProduto().equals(idProduto)) {
                produtos.remove(i);
                break;
            }

            if (i == produtos.size() - 1) {
                return "Produto não encontrado!";
            }
        }
        
        try {
            Writer writer = new FileWriter("./src/database/produto.json");
            gson.toJson(produtos, writer);
            writer.close();
            return "Produto deletado com sucesso!";
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar produto!");
        }

    }

}
