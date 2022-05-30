/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import models.Cliente;
import DAO.ClientesDAO;
import java.util.ArrayList;

/**
 *
 * @author alexandre
 */
public class ClientesController {

    public static void Inserir(String cpf, String dataNasc, String email, String endereco, String estadoCivil, String nome, String sexo, String telefone) {
        ClientesDAO.adicionarClientes(cpf, dataNasc, email, endereco, estadoCivil, nome, sexo, telefone);
    }

    public static ArrayList<Cliente> Clientes() {
        return ClientesDAO.consultarClientes();
    }

    public static void Alterar(int id, String cpf, String dataNasc, String email, String endereco, String estadoCivil, String nome, String sexo, String telefone) {
        ClientesDAO.alterarClientes(id, cpf, dataNasc, email, endereco, estadoCivil, nome, sexo, telefone);
    }

    public static void Excluir(int id) {
        ClientesDAO.excluirClientes(id);
    }
    
    public static ArrayList<Cliente> Filtar(String filtro){
       return ClientesDAO.filtrarClientes(filtro);
    }
}
