package entities;

import java.util.UUID;

public class Produto implements Comparable<Produto> {
    private String idProduto;
    private String marca;
    private String capacidade;
    private String tipo;
    private String nome;
    private String cor;
    private double preco;
    private String dimensoes;
    private String consumoDeEnergia;
    private int quantidadeVendida;
    private int estoque;

    public Produto() {

    }

    public Produto(
            String marca,
            String capacidade,
            String tipo,
            String cor,
            double preco,
            String dimensoes,
            String nome,
            String consumoDeEnergia) {
        UUID uuid = UUID.randomUUID();

        this.idProduto = uuid.toString();
        this.marca = marca;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.cor = cor;
        this.preco = preco;
        this.dimensoes = dimensoes;
        this.nome = nome;
        this.consumoDeEnergia = consumoDeEnergia;
        this.quantidadeVendida = 0;
        this.estoque = 20;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public String getConsumoDeEnergia() {
        return consumoDeEnergia;
    }

    public void setConsumoDeEnergia(String consumoDeEnergia) {
        this.consumoDeEnergia = consumoDeEnergia;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public int compareTo(Produto produto) {

        if (this.getQuantidadeVendida() > produto.getQuantidadeVendida()) {
            return 1;
        } else if(this.getQuantidadeVendida() < produto.getQuantidadeVendida()) {
            return -1;
        } else {
            return 0;
        }

    }

}
