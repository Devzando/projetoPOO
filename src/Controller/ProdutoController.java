package Controller;

import java.util.List;

import entities.Produto;
import service.produto.CreateProdutoService;
import service.produto.ReadProdutoService;

public class ProdutoController<T> {
    private CreateProdutoService<T> createProdutoService;
    private ReadProdutoService<T> readProdutoService;

    public ProdutoController(){
        this.createProdutoService = new CreateProdutoService<>();
        this.readProdutoService = new ReadProdutoService<>();
    }

    public String handleCreateProduto(Produto produto){
        String result = this.createProdutoService.create(produto);
        return result;
    }

    public List<Produto> handleReadProduto(){
        List<Produto> result = this.readProdutoService.read();
        return result;
    }

}
