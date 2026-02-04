package br.com.mauwor.obras.app;

import br.com.mauwor.obras.domain.Obra;
import br.com.mauwor.obras.domain.Servico;
import br.com.mauwor.obras.service.ObraService;
import br.com.mauwor.obras.service.ServicoService;
//import java.security.Provider.Service;

import java.util.List;
import java.util.Scanner;

public class Main {

    // Scanner para entrada de dados do usuário
    private static Scanner scanner = new Scanner(System.in);

    // Service responsável pelas regras de negócio
    private static ObraService obraService = new ObraService();
    //
    private static ServicoService servicoService = new ServicoService();
    public static void main(String[] args) {

        int opcao;

        // Loop principal do sistema
        do {
            exibirMenuPrincipal();
            opcao = lerInteiro();
                      
            switch (opcao) {
                case 1:
                    cadastrarObra();
                    break;
        
                case 2:
                    listarObras();
                    break;
                case 3:
                    gerenciarServicosDaObra();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
        
                default:
                    System.out.println("Opção inválida!");
            }
        
        } while (opcao != 0);
        
    }

    // Exibe o menu principal
    //===== MENU PRINCIPAL =====
    private static void exibirMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE OBRAS ===");
        System.out.println("1 - Cadastrar obra");
        System.out.println("2 - Listar obras");
        System.out.println("3 - Gerenciar serviços da obra");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Fluxo de cadastro de obra
    //===== CADASTRAR OBRA ======
    private static void cadastrarObra() {

        System.out.print("Nome da obra: ");
        String nome = scanner.nextLine();
        
        //isBlank => usado no java 11
        if(nome.isBlank()){
                System.out.print("Nome da Obra não pode ser vazio");
            return;
        }

        System.out.print("Nome do cliente: ");
        String cliente = scanner.nextLine();

        // Chama o service para criar a obra
        obraService.criarObra(nome, cliente);
        System.out.println("Obra cadastrada com sucesso!");
    }

    // Exibe todas as obras cadastradas
    //====== LISTAR OBRAS ======
    private static void listarObras() {

        List<Obra> obras = obraService.listarObras();

        if (obras.isEmpty()) {
            System.out.println("Nenhuma obra cadastrada.");
            return;
        }

        System.out.println("\n--- OBRAS CADASTRADAS ---");

        for (Obra obra : obras) {
            System.out.println(
                    "ID: " + obra.getId() +
                    " | Nome: " + obra.getNome() +
                    " | Cliente: " + obra.getCliente() +
                    " | Status: " + obra.getStatus()
            );
        }
    }

    //===== GERENCIAR SERVIÇOS =====

    private static void gerenciarServicosDaObra(){

        Obra obra = selecionarObra();
        if(obra == null)return;

        int opcao;

        do{

            exibirMenuServicos(obra);
            opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    adicionarServico(obra);
                    break;
                case 2:
                    listarServicos(obra);
                    break;
                case 3:
                    atualizarOrcamento(obra);
                    break;
                case 4:
                    removerServico(obra);
                    break;
                case 5: 
                System.out.println("Total da obra: R$ "+ obra.getValorTotal());
                break;
                case 0:
                    break;
                default:
                    System.out.println("Opção invalida!");
            }  

        } while (opcao != 0);
    }
        
        // Criando os métodos auxiliares
        //=====MÉTODOS AUXILIARES =====

        private static Obra selecionarObra(){
            List<Obra> obras = obraService.listarObras();

            if(obras.isEmpty()){
                System.out.println("Nenhuma obra cadastrada");
                return null;
            }
          
            System.out.println("\nSelecione a obra pelo ID");
            for( Obra obra : obras){
                System.out.println(obra.getId() + " - " + obra.getNome());
            }
            System.out.println("ID da obra (0 para voltar): ");
            int id = lerInteiro();
            
            if(id == 0){
                 return null;
            }
            return obraService.buscarPorId(id);
        }

        private static void exibirMenuServicos(Obra obra){
            System.out.println("\n===SERVIÇOS DA OBRA: " + obra.getNome() + " ===");
            System.out.println("1 - Adicionar serviço");
            System.out.println("2 - Listar serviços");
            System.out.println("3 - Atualizar orçamento do serviço");
            System.out.println("4 - Remover serviço");
            System.out.println("5 - Ver valor total da obra");
            System.out.println("0 - Voltar");
            System.out.println("Escolha uma opção");

        }

        private static void adicionarServico( Obra obra){
            System.out.println("Descrição do serviço: ");
            String descricao = scanner.nextLine();

            if(descricao.isBlank()){
                System.out.println("Descrição não pode ser vazia.");
                return;
            }

            servicoService.adicionarServicoNaObra(obra, descricao);
            System.out.println("Serviço adicionado com sucesso!");
        }

        private static void listarServicos(Obra obra){
            List<Servico> servicos = obra.getServicos();
            
            if(servicos.isEmpty()){
                System.out.println("Nenhum serviço cadastrado.");
                return;
            }
            for (Servico servico : servicos){
                System.out.println(
                    "ID: " + servico.getId() +
                    " | " + servico.getDescricao() +
                    " | Total: R$" + servico.getTotal()
                );
            }
        }

        private static void atualizarOrcamento(Obra obra){
            Servico servico = selecionarServico(obra);
           
            if(servico==null){
                return;
            }
           
            System.out.println("Quantidade: ");
            double quantidade = lerDouble();

            System.out.println("Valor unitário: ");
            double valor = lerDouble();

            if (quantidade <= 0 || valor <= 0){

                System.out.println("Valores devem ser maiores que zero.");
                return;
            }
            
            servicoService.atualizarOrcamento(servico, quantidade, valor);
            System.out.println("ORÇAMENTO ATUALIZADO!");
        }

        private static void removerServico(Obra obra){

            Servico servico = selecionarServico(obra);
            if ( servico == null ){
                return;
            }
            obra.getServicos().remove(servico);
            System.out.println("Serviço Removido");
        }

        private static Servico selecionarServico(Obra obra){
            List<Servico> servicos = obra.getServicos();
            if (servicos.isEmpty()){
                System.out.println("Nenhum SERVIÇO cadastrado");
                return null; 
            }

            for (Servico servico : servicos) {
                System.out.println(servico.getId() + " - " + servico.getDescricao());
            }
            int id =lerInteiro();
            for ( Servico servico : servicos){
                if (servico.getId() == id){

                    return servico;
                }

            }   
            System.out.println("Serviço não encontrado.");                     
            return null;
        }
        //===== LEITURA SEGURA =====
        private static int lerInteiro() {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                return -1;
            }
        }
        private static double lerDouble() {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                return -1;
                
            }

        }
    }

