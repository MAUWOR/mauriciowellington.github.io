package br.com.mauwor.obras.domain;

public class Obra {

    private Long id;
    private String nome;
    private String cliente;
    private String status;

    public Obra(Long id, String nome, String cliente){

        this.id = id;
        this.nome = nome;
        this.cliente = cliente;
        this.status = "Em andamento";
    }
public Long getId(){
    return id;
}
public String getNome() {
    return nome;
}
public String getCliente() {
    return cliente;
}
public String getStatus() {
    return status;
}

public void finalizar(){
    this.status="Finalizada";
}
    
}
