package br.com.mauwor.obras.service;

import br.com.mauwor.obras.domain.Obra;
import br.com.mauwor.obras.repository.ObraRepository;

import java.util.List;

public class ObraService {

    // Dependência do repositório
    private ObraRepository repository = new ObraRepository();

    // Contador simples para gerar IDs
    private Long proximoId = 1L;

    // Cria e salva uma nova obra
    public void criarObra(String nome, String cliente) {

        // Cria a obra com ID automático
        Obra obra = new Obra(proximoId, nome, cliente);

        // Salva no "banco de dados"
        repository.salvar(obra);

        // Incrementa o ID para a próxima obra
        proximoId++;
    }

    // Retorna a lista de obras cadastradas
    public List<Obra> listarObras() {
        return repository.listarTodas();
    }
    public Obra buscarPorId(long id) {
        return repository.buscarPorId(id);
    }
}
