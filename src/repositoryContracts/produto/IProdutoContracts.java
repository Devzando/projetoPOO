package repositoryContracts.produto;

import java.util.List;

import entities.Produto;

public interface IProdutoContracts {
    String create(Produto produto);
    List<Produto> read();
    // String update(T maquinaLavarRoupa, String idMaquinaLavarRoupa);
    // String delete(String idMaquinaLavarRoupa);
}
