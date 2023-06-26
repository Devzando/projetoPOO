package entities;

import java.util.UUID;

public class Cliente {
    private String idCliente;
    private String nome;
    private String email;
    private String senha;
    private double saldo;

    
    public Cliente(String nome, String email, String senha){
        UUID uuid = UUID.randomUUID();
        
        this.idCliente = uuid.toString();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.saldo = 0;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
