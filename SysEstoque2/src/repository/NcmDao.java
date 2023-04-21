/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connection.ConexaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.NcmBeans;

/**
 *
 * @author edson
 */
public class NcmDao extends ConexaoBD {

    public boolean save(NcmBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("  INSERT INTO public.ncm(\n"
                    + "	  sigla_ncm, descricao_ncm, ativo_ncm,  usuario_id,registro_ncm)\n"
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

    public boolean update(NcmBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.ncm\n"
                    + "SET sigla_ncm=?, descricao_ncm=?, ativo_ncm=?,usuario_id=?,registro_ncm = now() \n"
                    + "WHERE id_ncm=?;");

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

    public boolean delete(NcmBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM public.ncm\n"
                    + "WHERE id_ncm=" + beans.getId());
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

    public boolean deactivate(NcmBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.ncm\n"
                    + "SET   ativo_ncm=false,usuario_id=? \n"
                    + "WHERE id_ncm=?;");
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

    public ArrayList<NcmBeans> findAll(String pesquisa, boolean verdade) {
        String estaAtivo = "";
        if (!verdade == true) {
            estaAtivo = "ativo_ncm = true and";
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_ncm, sigla_ncm, descricao_ncm, ativo_ncm, usuario_id, registro_ncm\n"
                + "FROM public.ncm WHERE " + estaAtivo + "  (coalesce((id_ncm)) ||' '||coalesce((sigla_ncm)) ||' '||coalesce((descricao_ncm)||' '||coalesce((ativo_ncm)))ilike '%" + pesquisa + "%') "
                + "ORDER BY id_ncm DESC ;"); // LIMIT 10
        try {
            rs.first();
            do {
                if (verdade) {
                    dados.add(new Object[]{rs.getInt("id_ncm"), rs.getBoolean("ativo_ncm"),
                        rs.getString("sigla_ncm"), rs.getString("descricao_ncm")
                    });
                } else {
                    dados.add(new Object[]{rs.getInt("id_ncm"),
                        rs.getString("sigla_ncm"), rs.getString("descricao_ncm")});
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
//    public ArrayList<NcmBeans> findAllOn() {
//
//        ArrayList dados = new ArrayList();
//        conexao();
//        executaSql2("SELECT id_ncm, sigla_ncm, descricao_ncm, ativo_ncm,usuario_id\n"
//                + "	FROM public.ncm WHERE ativo_ncm = true ORDER BY id_ncm DESC ;"); // LIMIT 10
//        try {
//            rs.first();
//            do {
//
//                dados.add(new Object[]{rs.getInt("id_ncm"),
//                    rs.getString("sigla_ncm"), rs.getString("descricao_ncm")});
//            } while (rs.next());
//        } catch (SQLException ex) {
//            System.out.println("Erro " + ex);
//        }
//        desconecta();
////        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
//        return dados;
//    }

    public ArrayList<NcmBeans> findOne(int id) {

        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_ncm, sigla_ncm, descricao_ncm, ativo_ncm, usuario_id,registro_ncm\n"
                + "	FROM public.ncm  WHERE id_ncm =" + id);
        try {
            rs.first();

            do {
                NcmBeans unidade = new NcmBeans();
                unidade.setId((rs.getInt("id_ncm")));
                unidade.setNcm(rs.getString("sigla_ncm"));
                unidade.setDescricao(rs.getString("descricao_ncm"));
                unidade.setDataHora(rs.getTimestamp("registro_ncm"));

                dados.add(unidade);
            } while (rs.next());

        } catch (SQLException ex) {
            System.out.println("##################Erro \nfindOne\n\n" + ex + "\n\n######################");
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

    public ArrayList<NcmBeans> PreencheNcm(int id) {
        String txt = "";
        if (id != 0) {
            txt = " where  id_ncm = " + id;
        } else {
            txt = " where ativo_ncm =true";
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT  id_ncm, sigla_ncm,descricao_ncm FROM public.ncm " + txt + "  order by descricao_ncm asc ");
        try {
            rs.first();
            do {
                NcmBeans ncm1 = new NcmBeans();
                ncm1.setNcm(rs.getString("sigla_ncm"));
                ncm1.setId((rs.getInt("id_ncm")));
                dados.add(ncm1);
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("SQLException -- " + ex);
        }
        desconecta();
        return dados;

    }
}
