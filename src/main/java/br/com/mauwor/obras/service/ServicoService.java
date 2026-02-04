package br.com.mauwor.obras.service;

import br.com.mauwor.obras.domain.Obra;
import br.com.mauwor.obras.domain.Servico;

public class ServicoService {

    private Long proximoId = 1L;

    // CREATE
    public void adicionarServicoNaObra(Obra obra, String descricao) {

        Servico servico = new Servico(proximoId, descricao);

        obra.adicionarServico(servico);

        proximoId++;
    }

    // UPDATE
    public void atualizarOrcamento(
            Servico servico,
            double quantidade,
            double valorUnitario) {

        servico.setQuantidade(quantidade);
        servico.setValorUnitario(valorUnitario);
    }
    
}
