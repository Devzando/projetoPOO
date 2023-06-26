import Controller.CompraController;
import entities.Compra;

public class TesteCompra {
    public static void main(String[] args) {
        Compra compra = new Compra(
            "e8709332-e0a7-43e8-bc0c-4d6cc84f6c77",
            "2a530a7c-cdd7-4c74-8178-269eba858c19",
            1
        );

        CompraController compraController = new CompraController();

        //Comprando um produto
        Object result = compraController.handleBuyCompra(compra);
        System.out.println(result);
    }
}
