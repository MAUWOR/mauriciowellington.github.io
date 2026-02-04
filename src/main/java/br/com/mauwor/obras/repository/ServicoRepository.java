package br.com.mauwor.obras.repository;

import br.com.mauwor.obras.domain.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoRepository {

    private List<Servico> servicos = new ArrayList<>();

    // CREATE
    public void salvar(Servico servico) {
        servicos.add(servico);
    }

    // READ
    public List<Servico> listarTodos() {
        return servicos;
    }

    // DELETE
    public void remover(Servico servico) {
        servicos.remove(servico);
    }
}