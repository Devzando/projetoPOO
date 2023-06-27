package Controller;

import entities.Compra;
import service.CompraService;

public class CompraController {
    private CompraService compraService;

    public CompraController() {
        this.compraService = new CompraService();
    }

    public String handleBuyCompra(Compra compra){
        String result = this.compraService.executeBuy(compra);
        return result;
    }

    public int handleTotalSalesPerMonth(){
        int result = this.compraService.executeTotalSalesPerMonth();
        return result;
    }

    public String handleGetProductWithMoreOrLessSales(int choose){
        String result = this.compraService.executeGetProductWithMoreOrLessSales(choose);
        return result;
    }

    public String handleGetBetterClient(){
        String result = this.compraService.executeGetBetterClient();
        return result;
    }
}
