/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author gilvan
 */
public class CadastroPOO {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
    private static final PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           try (scanner) {
            int opcao;
            do {
                exibirMenu();
                opcao = receberOpcao();
                switch (opcao) {
                    case 1 -> incluirPessoa();
                    case 2 -> alterarPessoa();
                    case 3 -> excluirPessoa();
                    case 4 -> exibirPessoaPorId();
                    case 5 -> exibirTodasPessoas();
                    case 6 -> salvarDados();
                    case 7 -> recuperarDados();
                    case 0 -> System.out.println("Finalizando...");
                    default -> System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        }       
    }
    
    
     private static void exibirMenu() {
        System.out.println("Selecione a opção:");
        System.out.println("1 - Incluir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Exibir pelo ID");
        System.out.println("5 - Exibir todos");
        System.out.println("6 - Salvar dados");
        System.out.println("7 - Recuperar dados");
        System.out.println("0 - Finalizar");
    }

    private static int receberOpcao() {
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    private static void incluirPessoa() {
        System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
        int tipoCadastro = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado
        try {
            switch (tipoCadastro) {
                case 1 -> incluirPessoaFisica();
                case 2 -> incluirPessoaJuridica();
                default -> System.out.println("Opção inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de digitar um número.");
        }
    }

    private static void incluirPessoaFisica() {
        System.out.println("Digite o ID, nome, CPF e idade (separados por espaços):");
        int id = scanner.nextInt();
        String nome = scanner.next();
        String cpf = scanner.next();
        int idade = scanner.nextInt();
        repoPessoaFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
        System.out.println("Pessoa física cadastrada com sucesso.");
    }

    private static void incluirPessoaJuridica() {
        System.out.println("Digite o ID, nome e CNPJ (separados por espaços):");
        int id = scanner.nextInt();
        String nome = scanner.next();
        String cnpj = scanner.next();
        repoPessoaJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
        System.out.println("Pessoa jurídica cadastrada com sucesso.");
    }

    private static void alterarPessoa() {
        
    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
    int tipoCadastro = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do teclado
    try {
        switch (tipoCadastro) {
            case 1 -> alterarPessoaFisica();
            case 2 -> alterarPessoaJuridica();
            default -> System.out.println("Opção inválida.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Certifique-se de digitar um número.");
    }
}

private static void alterarPessoaFisica() {
    System.out.println("Digite o ID da pessoa física que deseja alterar:");
    int id = scanner.nextInt();
    PessoaFisica pessoa = repoPessoaFisica.obter(id);
    if (pessoa != null) {
        System.out.println("Dados atuais da pessoa física:");
        pessoa.exibir();
        System.out.println("Digite os novos dados (nome, CPF, idade):");
        String nome = scanner.next();
        String cpf = scanner.next();
        int idade = scanner.nextInt();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setIdade(idade);
        repoPessoaFisica.alterar(pessoa);
        System.out.println("Pessoa física alterada com sucesso.");
    } else {
        System.out.println("Pessoa física com o ID especificado não encontrada.");
    }
}

private static void alterarPessoaJuridica() {
    System.out.println("Digite o ID da pessoa jurídica que deseja alterar:");
    int id = scanner.nextInt();
    PessoaJuridica pessoa = repoPessoaJuridica.obter(id);
    if (pessoa != null) {
        System.out.println("Dados atuais da pessoa jurídica:");
        pessoa.exibir();
        System.out.println("Digite os novos dados (nome, CNPJ):");
        String nome = scanner.next();
        String cnpj = scanner.next();
        pessoa.setNome(nome);
        pessoa.setCnpj(cnpj);
        repoPessoaJuridica.alterar(pessoa);
        System.out.println("Pessoa jurídica alterada com sucesso.");
    } else {
        System.out.println("Pessoa jurídica com o ID especificado não encontrada.");
    }


    }

    private static void excluirPessoa() {
    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
    int tipoCadastro = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do teclado
    try {
        switch (tipoCadastro) {
            case 1 -> excluirPessoaFisica();
            case 2 -> excluirPessoaJuridica();
            default -> System.out.println("Opção inválida.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Certifique-se de digitar um número.");
    }
}

private static void excluirPessoaFisica() {
    System.out.println("Digite o ID da pessoa física que deseja excluir:");
    int id = scanner.nextInt();
    PessoaFisica pessoa = repoPessoaFisica.obter(id);
    if (pessoa != null) {
        repoPessoaFisica.excluir(id);
        System.out.println("Pessoa física excluída com sucesso.");
    } else {
        System.out.println("Pessoa física com o ID especificado não encontrada.");
    }
}

private static void excluirPessoaJuridica() {
    System.out.println("Digite o ID da pessoa jurídica que deseja excluir:");
    int id = scanner.nextInt();
    PessoaJuridica pessoa = repoPessoaJuridica.obter(id);
    if (pessoa != null) {
        repoPessoaJuridica.excluir(id);
        System.out.println("Pessoa jurídica excluída com sucesso.");
    } else {
        System.out.println("Pessoa jurídica com o ID especificado não encontrada.");
    }
}


    private static void exibirPessoaPorId() {
    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
    int tipoCadastro = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do teclado
    try {
        switch (tipoCadastro) {
            case 1 -> exibirPessoaFisicaPorId();
            case 2 -> exibirPessoaJuridicaPorId();
            default -> System.out.println("Opção inválida.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Certifique-se de digitar um número.");
    }
}

private static void exibirPessoaFisicaPorId() {
    System.out.println("Digite o ID da pessoa física que deseja exibir:");
    int id = scanner.nextInt();
    PessoaFisica pessoa = repoPessoaFisica.obter(id);
    if (pessoa != null) {
        pessoa.exibir();
    } else {
        System.out.println("Pessoa física com o ID especificado não encontrada.");
    }
}

private static void exibirPessoaJuridicaPorId() {
    System.out.println("Digite o ID da pessoa jurídica que deseja exibir:");
    int id = scanner.nextInt();
    PessoaJuridica pessoa = repoPessoaJuridica.obter(id);
    if (pessoa != null) {
        pessoa.exibir();
    } else {
        System.out.println("Pessoa jurídica com o ID especificado não encontrada.");
    }
}


    private static void exibirTodasPessoas() {
    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
    int tipoCadastro = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do teclado
    try {
        switch (tipoCadastro) {
            case 1 -> exibirTodasPessoasFisicas();
            case 2 -> exibirTodasPessoasJuridicas();
            default -> System.out.println("Opção inválida.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Certifique-se de digitar um número.");
    }
}

private static void exibirTodasPessoasFisicas() {
    System.out.println("Pessoas Físicas:");
    for (PessoaFisica pessoa : repoPessoaFisica.obterTodos()) {
        pessoa.exibir();
        System.out.println();
    }
}

private static void exibirTodasPessoasJuridicas() {
    System.out.println("Pessoas Jurídicas:");
    for (PessoaJuridica pessoa : repoPessoaJuridica.obterTodos()) {
        pessoa.exibir();
        System.out.println();
    }
}


    private static void salvarDados() {
    System.out.println("Digite o prefixo dos arquivos para salvar:");
    String prefixoSalvar = scanner.next();
    try {
        repoPessoaFisica.persistir(prefixoSalvar + ".fisica.bin");
        repoPessoaJuridica.persistir(prefixoSalvar + ".juridica.bin");
        System.out.println("Dados salvos com sucesso.");
    } catch (IOException e) {
        System.out.println("Erro ao salvar dados: " + e.getMessage());
    }
}


    private static void recuperarDados() {
    System.out.println("Digite o prefixo dos arquivos para recuperar:");
    String prefixoRecuperar = scanner.next();
    try {
        repoPessoaFisica.recuperar(prefixoRecuperar + ".fisica.bin");
        repoPessoaJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
        System.out.println("Dados recuperados com sucesso!");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
    }
}

    
}
