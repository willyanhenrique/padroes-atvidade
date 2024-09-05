import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Tarefa> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nGerenciador de Tarefas:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Listar tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = obterInteiro();
            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    removerTarefa();
                    break;
                case 3:
                    marcarTarefaComoConcluida();
                    break;
                case 4:
                    listarTarefas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static int obterInteiro() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                scanner.next();
            }
        }
    }

    private static String obterTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static void adicionarTarefa() {
        scanner.nextLine();
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = obterTexto("");

        System.out.println("Escolha o tipo de tarefa:");
        System.out.println("1. Normal");
        System.out.println("2. Prioritária");
        System.out.print("Escolha uma opção: ");
        int tipo = obterInteiro();

        Tarefa tarefa;
        if (tipo == 2) {
            tarefa = new TarefaPrioritaria(descricao);
        } else {
            tarefa = new TarefaNormal(descricao);
        }

        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    private static void removerTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para remover.");
            return;
        }
        listarTarefas();
        System.out.print("Digite o índice da tarefa a ser removida: ");
        int indice = obterInteiro();
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Índice inválido! Tente novamente.");
        }
    }

    private static void marcarTarefaComoConcluida() {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para marcar como concluídas.");
            return;
        }
        listarTarefas();
        System.out.print("Digite o índice da tarefa a ser marcada como concluída: ");
        int indice = obterInteiro();
        if (indice >= 0 && indice < tarefas.size()) {
            Tarefa tarefa = tarefas.get(indice);
            tarefa.setConcluida(true);
            System.out.println("Tarefa marcada como concluída.");
        } else {
            System.out.println("Índice inválido! Tente novamente.");
        }
    }

    private static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para listar.");
            return;
        }
        System.out.println("Lista de tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            System.out.println(i + ". " + tarefa);
        }
    }
}
