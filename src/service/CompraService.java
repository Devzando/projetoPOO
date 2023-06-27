package service;

import entities.Compra;
import repositoryImplements.CompraRepository;

public class CompraService {
    private CompraRepository compraRepository;

    public CompraService() {
        this.compraRepository = new CompraRepository();
    }

    public String executeBuy(Compra compra){
        String result = compraRepository.buy(compra);
        return result;
    }

    public int executeTotalSalesPerMonth(){
        int result = compraRepository.totalSalesPerMonth();
        return result;
    }

    public String executeGetProductWithMoreOrLessSales(int choose){
        String result = compraRepository.getProductWithMoreOrLessSales(choose);
        return result;
    }

    public String executeGetBetterClient(){
        String result = compraRepository.getBetterClient();
        return result;
    }
}
