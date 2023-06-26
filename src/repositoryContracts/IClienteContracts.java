package repositoryContracts;

import java.util.List;

import entities.Cliente;

public interface IClienteContracts {
    String create(Cliente cliente) throws Exception;
    Cliente read(String idCliente) throws Exception;
    List<Cliente> readAll() throws Exception;
    String update(Cliente cliente, String idCliente) throws Exception;
    String delete(String idCliente) throws Exception;
    Cliente login(String email, String senha) throws Exception;
}
