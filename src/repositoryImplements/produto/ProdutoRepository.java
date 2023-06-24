package repositoryImplements.produto;

import entities.MaquinaLavarRoupa;
import entities.Produto;
import repositoryContracts.produto.IProdutoContracts;

public class ProdutoRepository implements IProdutoContracts<Produto> {
    public String create(Produto maquinaLavarRoupa) {
        return "Produto criado com sucesso!";
    }
}
