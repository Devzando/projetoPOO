package entities;

import java.util.UUID;
import java.time.LocalDate;

public class Compra {
    private String idCompra;
    private String idCliente;
    private String idProduto;
    private LocalDate dataCompra;
    private int quantidade;
    private double valorTotal;
    private String nomeCliente;
    private String nomeProduto;

    
    public Compra(String idCliente, String idProduto, int quantidade) {
        UUID uuid = UUID.randomUUID();
        
        this.idCompra = uuid.toString();
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.dataCompra = LocalDate.now();
        this.quantidade = quantidade;
        this.valorTotal = 0;
    }

    public Compra(String idCliente, String nomeCliente, String nomeProduto, LocalDate dataCompra, int quantidade, double valorTotal) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.dataCompra = dataCompra;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
