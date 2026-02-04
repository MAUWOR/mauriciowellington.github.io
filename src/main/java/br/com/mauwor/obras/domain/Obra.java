package br.com.mauwor.obras.domain;
import java.util.ArrayList;
import java.util.List;

public class Obra {

    private Long id;
    private String nome;
    private String cliente;
    private String status;
    private List<Servico> servicos = new ArrayList<>();

    public Obra(Long id, String nome, String cliente){

        this.id = id;
        this.nome = nome;
        this.cliente = cliente;
        this.status = "Em andamento";
    }

    public void adicionarServico( Servico servico) {
        servicos.add(servico);
        
    }
public List<Servico> getServicos(){
    return servicos;

}   
public double getValorTotal() {
    double total = 0;

    for (Servico servico : servicos){
        total+=servico.getTotal();
    }

    return total;

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
