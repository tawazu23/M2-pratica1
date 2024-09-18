/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * @author gilvan
 */
public class PessoaJuridicaRepo implements Serializable {
     // ArrayList para armazenar objetos PessoaJuridica
    private List<PessoaJuridica> listaPessoasJuridicas;

    // Construtor da classe
    public PessoaJuridicaRepo() {
        listaPessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
        listaPessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
            PessoaJuridica pj = listaPessoasJuridicas.get(i);
            if (pj.getId() == pessoaJuridica.getId()) {
                listaPessoasJuridicas.set(i, pessoaJuridica);
                break;
            }
        }
    }
    
    public void excluir(int id) {
        for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
            PessoaJuridica pj = listaPessoasJuridicas.get(i);
            if (pj.getId() == id) {
                listaPessoasJuridicas.remove(i);
                break;
            }
        }
    }
    
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pj : listaPessoasJuridicas) {
            if (pj.getId() == id) {
                return pj;
            }
        }
        return null;
    }
    
    public List<PessoaJuridica> obterTodos() {
        return listaPessoasJuridicas;
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(listaPessoasJuridicas);
        }
    }
    
    //@SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoasJuridicas = (List<PessoaJuridica>) inputStream.readObject();
        }
    }
    
}
