package br.com.mauwor.obras.domain;

public class Servico {

    private String descricao;
    private double custo;

    public Servico(String descricao, double custo) {
        this.descricao = descricao;
        this.custo = custo; 
    }

    public String getDescricao() {
        return descricao;
    }

    public double getCusto() {
        return custo;
    }
    
}
