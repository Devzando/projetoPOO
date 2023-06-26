package repositoryContracts;

import java.time.LocalDate;
import java.util.List;

import entities.Compra;

public interface ICompraContracts {
    String buy(Compra compra) throws Exception;
    void generateInvoice(
        String idCliente, 
        String nomeCliente, 
        String nomeProduto, 
        LocalDate dataCompra, 
        int quantidade, 
        double valorTotal
    ) throws Exception;
    List<Compra> readAllFatura() throws Exception;
    List<Compra> readAllCompra() throws Exception;
}
