package entities;
import java.util.UUID;

public class MaquinaLavarRoupa {
    String idMaquinaLavaRoupa;
    String marca;
    String capacidade;
    String tipo;
    String programasDeLavagem;
    String velocidadeDeCentrifugacao;
    String consumoDeEnergia;
    int estoque;

    public MaquinaLavarRoupa(
        String marca, 
        String capacidade, 
        String tipo, 
        String programasDeLavagem, 
        String velocidadeDeCentrifugacao, 
        String consumoDeEnergia
    ){
        UUID uuid = UUID.randomUUID();

        this.idMaquinaLavaRoupa = uuid.toString();
        this.marca = marca;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.programasDeLavagem = programasDeLavagem;
        this.velocidadeDeCentrifugacao = velocidadeDeCentrifugacao;
        this.consumoDeEnergia = consumoDeEnergia;
        this.estoque = 20;
    }

    public String getIdMaquinaLavaRoupa() {
        return idMaquinaLavaRoupa;
    }


    public void setIdMaquinaLavaRoupa(String idMaquinaLavaRoupa) {
        this.idMaquinaLavaRoupa = idMaquinaLavaRoupa;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getCapacidade() {
        return capacidade;
    }


    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getProgramasDeLavagem() {
        return programasDeLavagem;
    }


    public void setProgramasDeLavagem(String programasDeLavagem) {
        this.programasDeLavagem = programasDeLavagem;
    }


    public String getVelocidadeDeCentrifugacao() {
        return velocidadeDeCentrifugacao;
    }


    public void setVelocidadeDeCentrifugacao(String velocidadeDeCentrifugacao) {
        this.velocidadeDeCentrifugacao = velocidadeDeCentrifugacao;
    }


    public String getConsumoDeEnergia() {
        return consumoDeEnergia;
    }


    public void setConsumoDeEnergia(String consumoDeEnergia) {
        this.consumoDeEnergia = consumoDeEnergia;
    }


    public int getEstoque() {
        return estoque;
    }


    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}
