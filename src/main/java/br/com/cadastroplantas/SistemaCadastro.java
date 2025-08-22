package br.com.cadastroplantas;

import java.util.List;
import java.util.Scanner;

public class SistemaCadastro {
    private static Scanner sc = new Scanner(System.in);
    private static int proximoId = 1; // ID sequencial

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistema de Cadastro de Plantas ===");
            System.out.println("1 - Cadastrar nova planta");
            System.out.println("2 - Listar todas as plantas");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarPlanta();
                    break;
                case "2":
                    listarTodas();
                    break;
                case "3":
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarPlanta() {
        System.out.print("Nome científico: ");
        String nomeCientifico = sc.nextLine();

        System.out.print("Nome popular: ");
        String nomePopular = sc.nextLine();

        System.out.print("Ambiente ideal: ");
        String ambiente = sc.nextLine();

        System.out.print("Necessidade de rega: ");
        String rega = sc.nextLine();

        System.out.print("Tipo da planta: ");
        String categoria = sc.nextLine();

        Planta planta = new Planta(proximoId++, ambiente, categoria, nomeCientifico, nomePopular, rega);
        PersistenciaPlanta.salvarPlanta(planta);

        System.out.println("Planta cadastrada com ID: " + planta.getNomePopular());
        System.out.println("Arquivo salvo em 'dadosPlantas/" + planta.getNomePopular() + ".json'");
    }

    private static void listarTodas() {
        List<Planta> plantas = PersistenciaPlanta.listarPlantas();
        if (plantas.isEmpty()) {
            System.out.println("Nenhuma planta cadastrada.");
        } else {
            System.out.println("=== Todas as plantas ===");
            plantas.forEach(System.out::println);
        }
    }
}
