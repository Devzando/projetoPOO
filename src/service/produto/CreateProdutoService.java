package service.produto;

import entities.Produto;
import repositoryImplements.produto.ProdutoRepository;

public class CreateProdutoService<T> {
    private ProdutoRepository<T> produtoRepository;

    public CreateProdutoService(){
        this.produtoRepository = new ProdutoRepository<>();
    }

    public String create(Produto produto){
        String result = this.produtoRepository.create(produto);
        return result;
    }
   
}
