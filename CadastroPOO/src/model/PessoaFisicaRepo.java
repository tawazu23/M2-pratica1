/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilvan
 */
public class PessoaFisicaRepo implements Serializable {

    private List<PessoaFisica> listaPessoasFisicas;

    public PessoaFisicaRepo() {
        listaPessoasFisicas = new ArrayList<>();
    }


    public void inserir(PessoaFisica pessoaFisica) {
        listaPessoasFisicas.add(pessoaFisica);
    }


    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < listaPessoasFisicas.size(); i++) {
            PessoaFisica pf = listaPessoasFisicas.get(i);
            if (pf.getId() == pessoaFisica.getId()) {
                listaPessoasFisicas.set(i, pessoaFisica);
                break;
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < listaPessoasFisicas.size(); i++) {
            PessoaFisica pf = listaPessoasFisicas.get(i);
            if (pf.getId() == id) {
                listaPessoasFisicas.remove(i);
                break;
            }
        }
    }


    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : listaPessoasFisicas) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }


    public List<PessoaFisica> obterTodos() {
        return listaPessoasFisicas;
    }


    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(listaPessoasFisicas);
        }
    }


    //@SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoasFisicas = (List<PessoaFisica>) inputStream.readObject();
        }
    }
    
}
