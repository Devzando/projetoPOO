package service;

import java.util.List;

import entities.Produto;
import repositoryImplements.ProdutoRepository;

public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService() {
        this.produtoRepository = new ProdutoRepository();
    }

    public String executeCreate(Produto produto){
        String result = this.produtoRepository.create(produto);
        return result;
    }
    public List<Produto> executeReadAll(){
        List<Produto> result = this.produtoRepository.readAll();
        return result;
    }
    public String executeUpdate(Produto produto, String idProduto){
        String result = this.produtoRepository.update(produto, idProduto);
        return result;
    }
    public String executeDelete(String idProduto){
        String result = this.produtoRepository.delete(idProduto);
        return result;
    }
    public Produto executeRead(String idProduto){
        Produto result = this.produtoRepository.read(idProduto);
        return result;
    }
}
