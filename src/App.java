import java.util.List;

import Controller.ProdutoController;
import dtos.IMaquinaLavarRoupaDto;
import entities.AspiradorPo;
import entities.MaquinaLavarRoupa;
import entities.Produto;

public class App {
    public static void main(String[] args) throws Exception {
        
        Produto produto = new MaquinaLavarRoupa(
            "marca gabriel 7", 
            "capacidade dhhdndh", 
            "tipo djdudhc", 
            "cor djndud", 
            "preco jdjdnd", 
            "dimensoes dhdydh",
            "maquinaLavarRoupa", 
            "programasDeLavagem dhdbhcfd", 
            "velocidadeDeCentrifugacao jdnchbd", 
            "consumoDeEnergia jdndgahasn"
        );

        if(produto instanceof AspiradorPo){
            ProdutoController<IMaquinaLavarRoupaDto> produtoController = new ProdutoController<>();
    
            //criando um produto
            String result = produtoController.handleCreateProduto(produto);
            System.out.println(result);
        }
    }
}
