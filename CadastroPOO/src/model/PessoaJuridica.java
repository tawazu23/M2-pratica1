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
public class PessoaJuridica extends Pessoa implements Serializable {

    private String cnpj;

    public PessoaJuridica() {
        super(); // Chamando o construtor padrão da classe pai
    }
    
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome); // Chamando o construtor completo da classe pai
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir() {
        super.exibir(); // Chamando o método exibir da classe pai
        System.out.println("CNPJ: " + cnpj);
    }

    // Getter e Setter para o campo adicional
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
