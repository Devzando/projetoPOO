import Controller.CompraController;
import entities.Compra;

public class TesteCompra {
    public static void main(String[] args) {
        Compra compra = new Compra(
            "c9df1511-eb2e-49ea-98b2-b7e29c38f702",
            "cc8f9b2d-f6de-4a1c-a2e8-1c559f69a34c",
            6
        );

        CompraController compraController = new CompraController();

        //Comprando um produto
        // Object result = compraController.handleBuyCompra(compra);
        // System.out.println(result);

        //Lendo o total de vendas por mês
        // int result = compraController.handleTotalSalesPerMonth();
        // System.out.println(result);

        //Lendo o produto com mais vendas
        // int choose = 2;
        // String result = compraController.handleGetProductWithMoreOrLessSales(choose);
        // System.out.println(result);

        //Lendo o cliente que mais comprou
        String result = compraController.handleGetBetterClient();
        System.out.println(result);
    }
}
