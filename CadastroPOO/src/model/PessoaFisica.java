/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author gilvan
 */
public class PessoaFisica extends Pessoa implements Serializable {
    private String cpf;
    private int idade;

    // Construtor padrão
    public PessoaFisica() {
        super(); // Chamando o construtor padrão da classe pai
    }

    // Construtor completo
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome); // Chamando o construtor completo da classe pai
        this.cpf = cpf;
        this.idade = idade;
    }

    // Método para exibir os dados da pessoa física (sobrescrito)
    @Override
    public void exibir() {
        super.exibir(); // Chamando o método exibir da classe pai
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
    }

    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }       
    
}
