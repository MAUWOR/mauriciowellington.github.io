package br.com.mauwor.obras.domain;
import java.util.ArrayList;
import java.util.List;

public class Orcamento {

    private Obra obra;
    private List<Servico> servicos = new ArrayList<>();

public Orcamento(Obra obra) {
    this.obra = obra;
}

public void adicionarServiço(Servico servico){

    servicos.add(servico);
}
public double calcularTotal(){
    return servicos.stream()
        .mapToDouble(Servico::getValorUnitario)
        .sum();
}
public Obra getObra(){
    return obra;
}
public List<Servico> getServicos(){
    return servicos;
}

}
