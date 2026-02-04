package br.com.mauwor.obras.domain;

public class Servico {

    private Long id;              // Identificador único do serviço
    private String descricao;     // Ex: Fundação, Alvenaria
    private double quantidade;    // Ex: m², horas, unidades
    private double valorUnitario; // Valor por unidade

    // Construtor
    public Servico(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // ===== GETTERS E SETTERS =====

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    // Calcula o total do serviço
    public double getTotal() {
        return quantidade * valorUnitario;
    }
}

