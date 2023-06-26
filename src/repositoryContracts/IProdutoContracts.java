package repositoryContracts;

import java.util.List;

import entities.Produto;

public interface IProdutoContracts {
    String create(Produto produto);
    List<Produto> readAll();
    String update(Produto produto, String idProduto);
    String delete(String idProduto);
}
