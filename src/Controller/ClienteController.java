package Controller;

import java.util.List;

import entities.Cliente;
import service.ClienteService;

public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(){
        this.clienteService = new ClienteService();
    }

    public String handleCreateCliente(Cliente cliente){
        String result = this.clienteService.executeCreate(cliente);
        return result;
    }

    public Cliente handleReadCliente(String idCliente) {
        Cliente result = this.clienteService.executeRead(idCliente);
        return result;
    }

    public String handleUpdateCliente(Cliente cliente, String idCliente){
        String result = this.clienteService.executeUpdate(cliente, idCliente);
        return result;
    }

    public String handleDeleteCliente(String idCliente){
        String result = this.clienteService.executeDelete(idCliente);
        return result;
    }

    public Cliente handleLoginCliente(String email, String senha){
        Cliente result = this.clienteService.executeLogin(email, senha);
        return result;
    }
}
