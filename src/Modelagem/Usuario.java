/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

/**
 *
 * @author vsouza
 */
public class Usuario {
    private String nome;
    private String email;
    private String login;
    private String senha;
    private int id;
    private Object con;

    Conexao conUsuario = new Conexao();
    public Usuario() {
        this("","","","",0);
    }

    public Usuario(String nome, String email, String login, String senha, int id) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
    
    public void cadastrarUsuario(){
        String sql;
        sql = "Insert into usuario(nome, email,login,senha) values"+
                    "('" + getNome() + "','" + getEmail() + "','" + getLogin() + "','" + getSenha() + "')";
        conUsuario.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Registrado com sucesso");
    }
    
    public ResultSet consultar(){
        ResultSet tabela;
        tabela = null;
        
        String sql= "Select * from usuario";
        tabela = conUsuario.RetornarResultset(sql);
     return tabela;   
    }
    
    public void excluir(){
        String sql;
        sql= "Delete from usuario where id="+ getId();
        conUsuario.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso...");
    }
    
     public void alterar(){
        String sql;
        sql="Update usuario set nome='"+ getNome()+"', email='"+getEmail()+"',senha='"+getSenha()+"',login='"+getLogin()+"' where id="+ getId();
        conUsuario.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro alterado com sucesso...");
        
    }

 
}
