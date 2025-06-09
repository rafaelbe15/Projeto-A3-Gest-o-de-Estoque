package View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Controller.FuncionarioController;
import Controller.ProdutoController;
import Controller.EntradaProdutoController;
import Controller.SaidaProdutoController;
import Controller.RelatorioEntradaController;
import Controller.RelatorioSaidaController;
import Model.Funcionario;
import Model.Produto;
import Model.EntradaProduto;
import Model.SaidaProduto;
import Model.RelatorioEntrada;
import Model.RelatorioSaida;

public class View {

    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        int opcao;
        do {
            System.out.println("\n===== SISTEMA DE GESTÃO DE ESTOQUE =====");
            System.out.println("1. Listar Funcionários");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("5. Listar Produtos");
            System.out.println("6. Cadastrar Produto");
            System.out.println("7. Atualizar Produto");
            System.out.println("8. Remover Produto");
            System.out.println("9. Registrar Entrada de Produto");
            System.out.println("10. Registrar Saída de Produto");
            System.out.println("11. Listar Relatório de Entradas");
            System.out.println("12. Listar Relatório de Saídas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> listarFuncionarios();
                case 2 -> cadastrarFuncionario();
                case 3 -> atualizarFuncionario();
                case 4 -> removerFuncionario();
                case 5 -> listarProdutos();
                case 6 -> cadastrarProduto();
                case 7 -> atualizarProduto();
                case 8 -> removerProduto();
                case 9 -> registrarEntradaProduto();
                case 10 -> registrarSaidaProduto();
                case 11 -> listarRelatorioEntradas();
                case 12 -> listarRelatorioSaidas();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // ==== FUNCIONÁRIOS ====

    private static void listarFuncionarios() {
        FuncionarioController controller = new FuncionarioController();
        try {
            List<Funcionario> funcionarios = controller.getFuncionarios();
            for (Funcionario f : funcionarios) {
                System.out.println("ID: " + f.getId() + ", Nome: " + f.getNome() + ", Cargo: " + f.getCargo());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }
    }

    private static void cadastrarFuncionario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        String sql = "INSERT INTO funcionario (nome, cargo, login, senha) VALUES ('" + nome + "', '" + cargo + "', '" + login + "', '" + senha + "')";
        new Data.Database().InsertData(sql);
    }

    private static void atualizarFuncionario() {
        System.out.print("ID do funcionário a atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Novo login: ");
        String login = scanner.nextLine();
        System.out.print("Nova senha: ");
        String senha = scanner.nextLine();

        String sql = "UPDATE funcionario SET nome = '" + nome + "', cargo = '" + cargo + "', login = '" + login + "', senha = '" + senha + "' WHERE id = " + id;
        new Data.Database().UpdateData(sql);
    }

    private static void removerFuncionario() {
        System.out.print("ID do funcionário a remover: ");
        int id = Integer.parseInt(scanner.nextLine());
        String sql = "DELETE FROM funcionario WHERE id = " + id;
        new Data.Database().DeleteData(sql);
    }

    // ==== PRODUTOS ====

    private static void listarProdutos() {
        ProdutoController controller = new ProdutoController();
        try {
            List<Produto> produtos = controller.getProdutos();
            for (Produto p : produtos) {
                System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Quantidade: " + p.getQuantidade() + ", Preço: " + p.getPreco());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
    }

    private static void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        String sql = "INSERT INTO produto (nome, quantidade, preco) VALUES ('" + nome + "', " + quantidade + ", " + preco + ")";
        new Data.Database().InsertData(sql);
    }

    private static void atualizarProduto() {
        System.out.print("ID do produto a atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        String sql = "UPDATE produto SET nome = '" + nome + "', quantidade = " + quantidade + ", preco = " + preco + " WHERE id = " + id;
        new Data.Database().UpdateData(sql);
    }

    private static void removerProduto() {
        System.out.print("ID do produto a remover: ");
        int id = Integer.parseInt(scanner.nextLine());
        String sql = "DELETE FROM produto WHERE id = " + id;
        new Data.Database().DeleteData(sql);
    }

    // ==== ENTRADA DE PRODUTOS ====

    private static void registrarEntradaProduto() {
        System.out.print("ID do Produto: ");
        int idProduto = Integer.parseInt(scanner.nextLine());
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());
        System.out.print("Fornecedor: ");
        String fornecedor = scanner.nextLine();
        LocalDate dataEntrada = LocalDate.now();

        String sql = "INSERT INTO entrada_produto (idProduto, quantidade, dataEntrada, fornecedor) VALUES (" + idProduto + ", " + quantidade + ", '" + dataEntrada + "', '" + fornecedor + "')";
        new Data.Database().InsertData(sql);
    }

    // ==== SAÍDA DE PRODUTOS ====

    private static void registrarSaidaProduto() {
        System.out.print("ID do Produto: ");
        int idProduto = Integer.parseInt(scanner.nextLine());
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());
        System.out.print("Destinatário: ");
        String destinatario = scanner.nextLine();
        LocalDate dataSaida = LocalDate.now();

        String sql = "INSERT INTO saida_produto (idProduto, quantidade, dataSaida, destinatario) VALUES (" + idProduto + ", " + quantidade + ", '" + dataSaida + "', '" + destinatario + "')";
        new Data.Database().InsertData(sql);
    }

    // ==== RELATÓRIOS ====

    private static void listarRelatorioEntradas() {
        RelatorioEntradaController controller = new RelatorioEntradaController();
        try {
            List<RelatorioEntrada> relatorios = controller.getRelatoriosEntrada();
            for (RelatorioEntrada r : relatorios) {
                System.out.println("ID: " + r.getId() + ", Entrada: " + r.getIdEntradaProduto() + ", Tipo: " + r.getTipo() + ", Data: " + r.getDataEmissao() + ", Detalhes: " + r.getDetalhes());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar relatórios de entrada: " + e.getMessage());
        }
    }

    private static void listarRelatorioSaidas() {
        RelatorioSaidaController controller = new RelatorioSaidaController();
        try {
            List<RelatorioSaida> relatorios = controller.getRelatoriosSaida();
            for (RelatorioSaida r : relatorios) {
                System.out.println("ID: " + r.getId() + ", Saída: " + r.getIdSaidaProduto() + ", Tipo: " + r.getTipo() + ", Data: " + r.getDataEmissao() + ", Detalhes: " + r.getDetalhes());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar relatórios de saída: " + e.getMessage());
        }
    }
}


