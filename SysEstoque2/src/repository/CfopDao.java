/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connection.ConexaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.CfopBeans;

/**
 *
 * @author edson
 */
public class CfopDao extends ConexaoBD {

    public boolean save(CfopBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("  INSERT INTO public.cfop(\n"
                    + "	  sigla_cfop, descricao_cfop, ativo_cfop,  usuario_id,registro_cfop)\n"
                    + "	VALUES (   ?, ?,?, ?,now());");

            pst.setString(1, beans.getNcm());
            pst.setString(2, beans.getDescricao().toUpperCase());
            pst.setBoolean(3, beans.isAtivo());
            pst.setInt(4, beans.getUsuario());

            pst.execute();

            JOptionPane.showMessageDialog(null, " cadastrado com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar . \n" + ex);
            desconecta();
            return false;
        }

    }

    public boolean update(CfopBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.cfop\n"
                    + "SET sigla_cfop=?, descricao_cfop=?, ativo_cfop=?,usuario_id=?,registro_cfop = now() \n"
                    + "WHERE id_cfop=?;");

            pst.setString(1, beans.getNcm());
            pst.setString(2, beans.getDescricao().toUpperCase());
            pst.setBoolean(3, beans.isAtivo());
            pst.setInt(4, beans.getUsuario());
            pst.setInt(5, beans.getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, " atualizada com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar . \n" + ex);
            desconecta();
            return false;
        }

    }

    public boolean delete(CfopBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM public.cfop\n"
                    + "WHERE id_cfop=" + beans.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, " deletada com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar . \n" + ex);
            desconecta();
            return false;
        }
    }

    public boolean deactivate(CfopBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.cfop\n"
                    + "SET   ativo_cfop=false,usuario_id=? \n"
                    + "WHERE id_cfop=?;");
            pst.setInt(1, beans.getUsuario());
            pst.setInt(2, beans.getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, "desativado com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desativado . \n" + ex);
            desconecta();
            return false;
        }

    }

    public ArrayList<CfopBeans> findAll(String pesquisa, boolean verdade) {
        String estaAtivo = "";
        if (!verdade == true) {
            estaAtivo = "ativo_cfop = true and";
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_cfop, sigla_cfop, descricao_cfop, ativo_cfop, usuario_id, registro_cfop\n"
                + "FROM public.cfop WHERE " + estaAtivo + "  (coalesce((id_cfop)) ||' '||coalesce((sigla_cfop)) ||' '||coalesce((descricao_cfop)||' '||coalesce((ativo_cfop)))ilike '%" + pesquisa + "%') "
                + "ORDER BY id_cfop DESC ;"); // LIMIT 10
        try {
            rs.first();
            do {
                if (verdade) {
                    dados.add(new Object[]{rs.getInt("id_cfop"), rs.getBoolean("ativo_cfop"),
                        rs.getString("sigla_cfop"), rs.getString("descricao_cfop")
                    });
                } else {
                    dados.add(new Object[]{rs.getInt("id_cfop"),
                        rs.getString("sigla_cfop"), rs.getString("descricao_cfop")});
                }
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }
//
//    public ArrayList<CfopBeans> findAllOn() {
//
//        ArrayList dados = new ArrayList();
//        conexao();
//        executaSql2("SELECT id_cfop, sigla_cfop, descricao_cfop, ativo_cfop,usuario_id\n"
//                + "	FROM public.cfop WHERE ativo_cfop = true ORDER BY id_cfop DESC ;"); // LIMIT 10
//        try {
//            rs.first();
//            do {
//
//                dados.add(new Object[]{rs.getInt("id_cfop"),
//                    rs.getString("sigla_cfop"), rs.getString("descricao_cfop")});
//            } while (rs.next());
//        } catch (SQLException ex) {
//            System.out.println("Erro " + ex);
//        }
//        desconecta();
////        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
//        return dados;
//    }

    public ArrayList<CfopBeans> findOne(int id) {

        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_cfop, sigla_cfop, descricao_cfop, ativo_cfop, usuario_id,registro_cfop\n"
                + "	FROM public.cfop  WHERE id_cfop =" + id);
        try {
            rs.first();

            do {
                CfopBeans obj = new CfopBeans();
                obj.setId((rs.getInt("id_cfop")));
                obj.setNcm(rs.getString("sigla_cfop"));
                obj.setDescricao(rs.getString("descricao_cfop"));
                obj.setDataHora(rs.getTimestamp("registro_cfop"));

                dados.add(obj);
            } while (rs.next());

        } catch (SQLException ex) {
            System.out.println("##################Erro \nfindOne\n\n" + ex + "\n\n######################");
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

    public ArrayList<CfopBeans> PreencheCfop(int id) {
        String txt = "";
        if (id != 0) {
            txt = " where  id_cfop = " + id;
        } else {
            txt = " where ativo_cfop =true";
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT  id_cfop, sigla_cfop,descricao_cfop FROM public.cfop " + txt + "  order by descricao_cfop asc ");
        try {
            rs.first();
            do {
                CfopBeans ncm1 = new CfopBeans();
                ncm1.setNcm(rs.getString("sigla_cfop"));
                ncm1.setId((rs.getInt("id_cfop")));
                dados.add(ncm1);
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("SQLException -- " + ex);
        }
        desconecta();
        return dados;

    }
}
