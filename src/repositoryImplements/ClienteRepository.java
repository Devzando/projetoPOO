package repositoryImplements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entities.Cliente;
import repositoryContracts.IClienteContracts;

public class ClienteRepository implements IClienteContracts {
    private Gson gson;

    public ClienteRepository() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public String create(Cliente cliente) {

        try {
            List<Cliente> clientesExistentes = readAll();
            for (int i = 0; i < clientesExistentes.size(); i++) {
                if (clientesExistentes.get(i).getEmail().equals(cliente.getEmail())) {
                    throw new RuntimeException("Email já cadastrado");
                }
            }

            clientesExistentes.add(cliente);

            FileWriter writer = new FileWriter("./src/database/cliente.json");
            gson.toJson(clientesExistentes, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar cliente");
        }

        return "Cliente criado com sucesso";
    }

    public Cliente read(String idCliente) {
        List<Cliente> clientes = new ArrayList<>();

        try {

            Reader reader = new java.io.FileReader("./src/database/cliente.json");
            Type type = new TypeToken<List<Cliente>>() {
            }.getType();
            clientes = gson.fromJson(reader, type);

            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getIdCliente().equals(idCliente)) {
                    return clientes.get(i);
                }

                if (i == clientes.size() - 1) {
                    return null;
                }
            }

            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler cliente");
        }
        
    }

    public List<Cliente> readAll() {
        List<Cliente> clientes = new ArrayList<>();

        try {
            File file = new File("./src/database/cliente.json");
            if (file.length() == 0) {
                return clientes;
            }

            Reader reader = new java.io.FileReader("./src/database/cliente.json");
            Type type = new TypeToken<List<Cliente>>() {
            }.getType();
            clientes = gson.fromJson(reader, type);
            
            return clientes;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler clientes");
        }

    }

    public String update(Cliente cliente, String idCliente) {
        List<Cliente> clientes = readAll();

        try {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getIdCliente().equals(idCliente)) {
                    clientes.set(i, cliente);
                    FileWriter writer = new FileWriter("./src/database/cliente.json");
                    gson.toJson(clientes, writer);
                    writer.close();
                }
            }
            return "Cliente atualizado com sucesso";
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar cliente");
        }

    }

    public String delete(String idCliente) {
        List<Cliente> clientes = readAll();

        try {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getIdCliente().equals(idCliente)) {
                    clientes.remove(i);
                    FileWriter writer = new FileWriter("./src/database/cliente.json");
                    gson.toJson(clientes, writer);
                    writer.close();
                }
            }
            return "Cliente deletado com sucesso";
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar cliente");
        }

    }

    public Cliente login(String email, String senha){
        List<Cliente> clientes = readAll();

        try {
            for (int i = 0; i < clientes.size(); i++) {
                if(clientes.get(i).getEmail().equals(email) && clientes.get(i).getSenha().equals(senha)){
                    return clientes.get(i);
                }
    
                if(i == clientes.size() - 1){
                    throw new RuntimeException("Email ou senha incorretos");
                }
            }
            
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao fazer login");
        }


    } 

}
