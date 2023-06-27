package entities;

import java.util.UUID;

public class Cliente implements Comparable<Cliente> {
    private String idCliente;
    private String nome;
    private String email;
    private String senha;
    private double saldo;
    private String tipoCliente;
    private int quantidadeCompras;

    
    
    
    public Cliente(String nome, String email, String senha){
        UUID uuid = UUID.randomUUID();
        
        this.idCliente = uuid.toString();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.saldo = 0;
        this.tipoCliente = "Cliente";
        this.quantidadeCompras = 0;
    }

    public int getQuantidadeCompras() {
        return quantidadeCompras;
    }

    public void setQuantidadeCompras(int quantidadeCompras) {
        this.quantidadeCompras = quantidadeCompras;
    }
    
    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
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

    @Override
    public int compareTo(Cliente cliente) {
          if (this.getQuantidadeCompras() > cliente.getQuantidadeCompras()) {
            return 1;
        } else if(this.getQuantidadeCompras() < cliente.getQuantidadeCompras()) {
            return -1;
        } else {
            return 0;
        }
    }

}
