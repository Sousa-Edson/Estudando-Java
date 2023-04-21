/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author edson
 */
public class ConexaoBD {

    public Statement stm;
    public ResultSet rs;
    public Connection con;

    private final String caminho = "jdbc:postgresql://localhost:5432/SysEstoque2";
    private final String driver = "org.postgresql.Driver";
    private final String usuario = "admin"; //postgres
    private final String senha = "123456"; //1

    public void conexao() {
        System.setProperty("jdbc.Drivers", driver);
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
//            JOptionPane.showMessageDialog(null, "Conectado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com BD\n" + ex.getMessage());
        }
    }

    public void executaSql(String sql) {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar SQL\n( Favor verificar):\nConexaoBD\n " + ex.getMessage());
        }
    }

    public void executaSql2(String sql) {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("connection.ConexaoBD.executaSql2()\n "
                    + "Erro ao executar SQL\n( Favor verificar):\n Verifique a conexao BD\n"
                    + ex.getMessage());
        }
    }

    public void desconecta() {
        System.setProperty("jdbc.Driver", driver);
        try {
            con.close();
//            System.out.println("connection.ConexaoBD.desconecta()");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com BD:\n" + ex.getMessage());
        }

    }

}
