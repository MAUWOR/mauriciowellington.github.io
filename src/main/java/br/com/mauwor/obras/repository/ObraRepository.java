package br.com.mauwor.obras.repository;

import br.com.mauwor.obras.domain.Obra;

import java.util.ArrayList;
import java.util.List;

public class ObraRepository {

    // Lista que simula um banco de dados em memória
    private List<Obra> obras = new ArrayList<>();

    // Salva uma nova obra
    public void salvar(Obra obra) {
        obras.add(obra);
    }

    // Retorna todas as obras cadastradas
    public List<Obra> listarTodas() {
        return obras;
    }
    public Obra buscarPorId(Long id) {

        for (Obra obra : obras) {
            if (obra.getId().equals(id)) {
                return obra;
            }
        }
    
        return null; // não encontrou
    }
}