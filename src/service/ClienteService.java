package service;

import entities.Cliente;
import repositoryImplements.ClienteRepository;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    public String executeCreate(Cliente cliente) {
        String result = clienteRepository.create(cliente);
        return result;
    }

    public Cliente executeRead(String idCliente) {
        Cliente cliente = clienteRepository.read(idCliente);
        return cliente;
    }

    public String executeUpdate(Cliente cliente, String idCliente) {
        String result = clienteRepository.update(cliente, idCliente);
        return result;
    }

    public String executeDelete(String idCliente) {
        String result = clienteRepository.delete(idCliente);
        return result;
    }

    public Cliente executeLogin(String email, String senha) {
        Cliente cliente = clienteRepository.login(email, senha);
        return cliente;
    }
}
