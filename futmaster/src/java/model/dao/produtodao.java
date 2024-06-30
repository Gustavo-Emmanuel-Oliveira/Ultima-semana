/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.conexao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Produto;

/**
 *
 * @author paulo
 */
public class produtodao {

    public void insertProduto(Produto p) {
        try {

            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("insert into produto (nome,descricao,preco,imagem) values (?,?,?,?)");
            ps.setString(1, p.getNome());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getPreco());
            ps.setBytes(4, p.getImagemBytes());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Produto> read(){
        List<Produto> produtos = new ArrayList<>();
        try{
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM produto");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produto p = new Produto();
                p.setDescricao(rs.getString("descricao"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setIdProduto(rs.getInt("idProduto"));
                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
                produtos.add(p);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return produtos;
    }
}
