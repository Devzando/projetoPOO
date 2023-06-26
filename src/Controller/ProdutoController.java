package Controller;

import java.util.List;

import entities.Produto;
import service.ProdutoService;

public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(){
        this.produtoService = new ProdutoService();
    }

    public String handleCreateProduto(Produto produto){
        String result = this.produtoService.executeCreate(produto);
        return result;
    }

    public List<Produto> handleReadProduto(){
        List<Produto> result = this.produtoService.executeReadAll();
        return result;
    }

    public String handleUpdateProduto(Produto produto, String idProduto){
        String result = this.produtoService.executeUpdate(produto, idProduto);
        return result;
    }

    public String handleDeleteProduto(String idProduto){
        String result = this.produtoService.executeDelete(idProduto);
        return result;
    }

}
