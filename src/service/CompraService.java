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
}
