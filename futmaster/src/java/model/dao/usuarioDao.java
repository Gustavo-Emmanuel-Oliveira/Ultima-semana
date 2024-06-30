/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.usuario;

/**
 *
 * @author Senai
 */
public class usuarioDao {
    
    public List<usuario> ler(){
        List<usuario> usuarios = new ArrayList();
       try{
           Connection con = conexao.conectar();
           PreparedStatement stmt = null;
           ResultSet rs = null;
           
           stmt = con.prepareStatement("select * from usuario");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               usuario usu = new usuario();
               usu.setIdusuario(rs.getInt("idUsuario"));
               usu.setNome(rs.getString("nome"));
               usu.setEmail(rs.getString("email"));
               usu.setSenha(rs.getString("senha"));
               usu.setCpf(rs.getString("cpf"));
               usu.setTelefone(rs.getString("telefone"));
               usuarios.add(usu);
           }
          rs.close();
          stmt.close();
          con.close();
           
       }catch(SQLException e){
           e.printStackTrace();
       }
       return usuarios;
    }
    
       public usuario logar(usuario usuario) {
        usuario usu = new usuario();

        try {

            Connection con = conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = con.prepareCall("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            rs = stmt.executeQuery();
            
            if(rs.next()){
                usuario.setIdusuario(rs.getInt("idUsuario"));
                if(rs.getInt("idUsuario") == 1){
                    usuario.setAdm(true);
                }
                System.out.println("DAO: "+usuario.getIdusuario());
            }
            
            System.out.println("deu certo");
            
            rs.close();
            stmt.close();
            con.close();
            

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usu;
    }
        public void cadastro(usuario usuario){
               try{
           Connection con = conexao.conectar();
           PreparedStatement stmt = null;
           
           stmt = con.prepareStatement("insert into usuario(nome, senha, email, cpf, telefone) values(?,?,?,?,?)");
           stmt.setString(1, usuario.getNome());
           stmt.setString(2, usuario.getSenha());
           stmt.setString(3, usuario.getEmail());
           stmt.setString(4, usuario.getCpf());
           stmt.setString(5, usuario.getTelefone());
           stmt.executeUpdate();
           

          stmt.close();
          con.close();
           
       }catch(SQLException e){
           e.printStackTrace();
       }
    }
    
}
