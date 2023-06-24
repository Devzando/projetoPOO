package entities;

public class MaquinaLavarRoupa extends Produto{
    String programasDeLavagem;
    String velocidadeDeCentrifugacao;
    String consumoDeEnergia;

    public MaquinaLavarRoupa(
        String marca, 
        String capacidade, 
        String tipo,
        String cor,
        String preco,
        String dimensoes,
        String nome,
        String programasDeLavagem, 
        String velocidadeDeCentrifugacao, 
        String consumoDeEnergia
    ){
        super(marca, capacidade, tipo, cor, preco, dimensoes, nome);

        this.programasDeLavagem = programasDeLavagem;
        this.velocidadeDeCentrifugacao = velocidadeDeCentrifugacao;
        this.consumoDeEnergia = consumoDeEnergia;
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

}
