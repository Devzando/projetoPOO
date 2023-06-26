import java.util.List;

import Controller.ClienteController;
import entities.Cliente;

public class TesteCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(
            "tomas",
            "tomas@gmail.com",
            "123"
        );


        ClienteController clienteController = new ClienteController();
        
        //criando um cliente
        String result = clienteController.handleCreateCliente(cliente);
        System.out.println(result);

        //lendo um cliente por id
        // Cliente result2 = clienteController.handleReadCliente("037b1cf5-f46a-4d36-8099-681c77564cdc");
        // System.out.println(result2.getNome());

        //atualizando um cliente
        // String result4 = clienteController.handleUpdateCliente(cliente, "037b1cf5-f46a-4d36-8099-681c77564cdc");
        // System.out.println(result4);

        //deletando um cliente
        // String result5 = clienteController.handleDeleteCliente("bc3432bb-a8bd-4995-ad7c-a3e136925412");
        // System.out.println(result5);

        //logando um cliente
        // Cliente result6 = clienteController.handleLoginCliente("gabriel@gmail.com", "123");
        // System.out.println(result6.getNome());

    }
}
