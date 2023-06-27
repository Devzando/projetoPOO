import java.util.List;

import Controller.ProdutoController;
import entities.Produto;

public class TesteProduto {
    public static void main(String[] args) {
        Produto produto = new Produto(
            "marca gabriel", 
            "capacidade dhhdndh", 
            "Televisao", 
            "cor djndud", 
            1500, 
            "dimensoes dhdydh",
            "MaquinaLavarRoupa",
            "consumoDeEnergia dhdydh"
        );

        // Produto produto2 = new Produto(
        //     "marca gabriel", 
        //     "capacidade dhhdndh", 
        //     "MaquinaLavarRoupa 2", 
        //     "cor djndud", 
        //     "preco jdjdnd", 
        //     "dimensoes dhdydh",
        //     "nome dhdydh",
        //     "consumoDeEnergia dhdydh"
        // );

        ProdutoController produtoController = new ProdutoController();
        //criando um produto
        String result = produtoController.handleCreateProduto(produto);
        System.out.println(result);

        //lendo os produtos
        // List<Produto> produtos = produtoController.handleReadProduto();
        // for (Produto p : produtos) {
        //    System.out.println(p.getTipo());
        // }

        // atualizando um produto
        // Produto p2;
        // List<Produto> produtos = produtoController.handleReadProduto();
        // for (int i = 0; i < produtos.size(); i++) {
        //     if(produtos.get(i).getIdProduto().equals("777e3773-59c1-4e3d-9d42-fa42c9f6b549")){
        //         produtos.get(i).setTipo("MaquinaLavarRoupa 3");
        //         p2 = produtos.get(i);

        //         String result = produtoController.handleUpdateProduto(p2, "777e3773-59c1-4e3d-9d42-fa42c9f6b549");
        //         System.out.println(result);
        //     }
        // }

        //deletando um produto
        // String result = produtoController.handleDeleteProduto("279dd36d-d108-4ffa-9c8f-2b8b2ad1a27a");
        // System.out.println(result);
    }
}
