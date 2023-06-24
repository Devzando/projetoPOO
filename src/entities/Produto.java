package entities;
import java.util.UUID;

public class Produto {
    private String idProduto;
    private String marca;
    private String capacidade;
    private String tipo;
    private String nome;
    private String cor;
    private String preco;
    private String dimensoes;
    private int estoque;

    public Produto(
        String marca, 
        String capacidade, 
        String tipo, 
        String cor, 
        String preco, 
        String dimensoes,
        String nome
    ){
        UUID uuid = UUID.randomUUID();

        this.idProduto = uuid.toString();
        this.marca = marca;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.cor = cor;
        this.preco = preco;
        this.dimensoes = dimensoes;
        this.nome = nome;
        this.estoque = 20;
    }
}
