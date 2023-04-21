/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connection.ConexaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.TipoBeans;

/**
 *
 * @author edson
 */
public class TipoDao extends ConexaoBD {

    public boolean save(TipoBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("  INSERT INTO public.tipo(\n"
                    + "	    descricao_tipo, ativo_tipo,  usuario_id,registro_tipo)\n"
                    + "	VALUES (   ?,?, ?,now());");

            pst.setString(1, beans.getDescricao().toUpperCase());
            pst.setBoolean(2, beans.isAtivo());
            pst.setInt(3, beans.getUsuario());

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

    public boolean update(TipoBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.tipo\n"
                    + "SET  descricao_tipo=?, ativo_tipo=?,usuario_id=?,registro_tipo = now() \n"
                    + "WHERE id_tipo=?;");

            pst.setString(1, beans.getDescricao().toUpperCase());
            pst.setBoolean(2, beans.isAtivo());
            pst.setInt(3, beans.getUsuario());
            pst.setInt(4, beans.getId());

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

    public boolean delete(TipoBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM public.tipo\n"
                    + "WHERE id_tipo=" + beans.getId());
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

    public boolean deactivate(TipoBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.tipo\n"
                    + "SET   ativo_tipo=false,usuario_id=? \n"
                    + "WHERE id_tipo=?;");
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

    public ArrayList<TipoBeans> findAll(String pesquisa, boolean verdade) {
        String estaAtivo = "";
        if (!verdade == true) {
            estaAtivo = "ativo_tipo = true and";
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_tipo,   descricao_tipo, ativo_tipo, usuario_id, registro_tipo\n"
                + "FROM public.tipo WHERE  " + estaAtivo + " (coalesce((id_tipo)) ||' '|| coalesce((descricao_tipo)||' '||coalesce((ativo_tipo)))ilike '%" + pesquisa + "%') "
                + "ORDER BY id_tipo DESC ;"); // LIMIT 10
        try {
            rs.first();
            do {
                if (verdade) {
                    dados.add(new Object[]{rs.getInt("id_tipo"), rs.getBoolean("ativo_tipo"),
                        rs.getString("descricao_tipo")
                    });
                } else {
                    dados.add(new Object[]{rs.getInt("id_tipo"),
                        rs.getString("descricao_tipo")});
                }
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

//    public ArrayList<TipoBeans> findAllOn() {
//
//        ArrayList dados = new ArrayList();
//        conexao();
//        executaSql2("SELECT id_tipo,   descricao_tipo, ativo_tipo,usuario_id\n"
//                + "	FROM public.tipo WHERE ativo_tipo = true ORDER BY id_tipo DESC ;"); // LIMIT 10
//        try {
//            rs.first();
//            do {
//
//                dados.add(new Object[]{rs.getInt("id_tipo"),
//                    rs.getString("descricao_tipo")});
//            } while (rs.next());
//        } catch (SQLException ex) {
//            System.out.println("Erro " + ex);
//        }
//        desconecta();
////        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
//        return dados;
//    }
    public ArrayList<TipoBeans> findOne(int id) {

        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_tipo,   descricao_tipo, ativo_tipo, usuario_id,registro_tipo\n"
                + "	FROM public.tipo  WHERE id_tipo =" + id);
        try {
            rs.first();

            do {
                TipoBeans unidade = new TipoBeans();
                unidade.setId((rs.getInt("id_tipo")));

                unidade.setDescricao(rs.getString("descricao_tipo"));
                unidade.setDataHora(rs.getTimestamp("registro_tipo"));

                dados.add(unidade);
            } while (rs.next());

        } catch (SQLException ex) {
            System.out.println("##################Erro \nfindOne\n\n" + ex + "\n\n######################");
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

    public ArrayList<TipoBeans> PreencheTipo(int id) {
        String txt = "";
        if (id != 0) {
            txt = " where  id_tipo = " + id;
        } else {
            txt = " where ativo_tipo =true";
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT  id_tipo,  descricao_tipo FROM public.tipo  " + txt + "   order by descricao_tipo asc ");
        try {
            rs.first();
            do {
                TipoBeans beans = new TipoBeans();
                beans.setDescricao(rs.getString("descricao_tipo"));
                beans.setId((rs.getInt("id_tipo")));
                dados.add(beans);
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("SQLException -- " + ex);
        }
        desconecta();
        return dados;

    }
}
