/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Senai
 */
public class conexao {
        private static final String url = "jdbc:mysql://localhost:3306/senai_final?useSSL=false";
    private static final String usuario = "root";
    private static final String senha = "1234";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
