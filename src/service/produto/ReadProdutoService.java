package service.produto;

import java.util.List;

import entities.Produto;
import repositoryImplements.produto.ProdutoRepository;

public class ReadProdutoService<T> {
    private ProdutoRepository<T> produtoRepository;

    public ReadProdutoService(){
        this.produtoRepository = new ProdutoRepository<>();
    }

     public List<Produto> read(){
        List<Produto> result = this.produtoRepository.read();
        return result;
    }
}
