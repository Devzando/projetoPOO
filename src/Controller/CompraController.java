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
}
