/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connection.ConexaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.UnidadeBeans;

/**
 *
 * @author edson
 */
public class UnidadeDao extends ConexaoBD {

    public boolean save(UnidadeBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("  INSERT INTO public.unidade(\n"
                    + "	  sigla_unidade, descricao_unidade, ativo_unidade,fragmentado, usuario_id,registro_unidade)\n"
                    + "	VALUES (  ?, ?, ?,?, ?,now());");

            pst.setString(1, beans.getSigla().toUpperCase());
            pst.setString(2, beans.getDescricao().toUpperCase());
            pst.setBoolean(3, beans.isAtivo());
            pst.setBoolean(4, beans.isFragmentado());
            pst.setInt(5, beans.getUsuario());

            pst.execute();

            JOptionPane.showMessageDialog(null, "unidade cadastrado com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar unidade. \nSalvar_Unidade\n" + ex);
            desconecta();
            return false;
        }

    }

    public boolean update(UnidadeBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.unidade\n"
                    + "SET sigla_unidade=?, descricao_unidade=?, ativo_unidade=?, fragmentado=?,usuario_id=?,registro_unidade=now() \n"
                    + "WHERE id_unidade=?;");

            pst.setString(1, beans.getSigla().toUpperCase());
            pst.setString(2, beans.getDescricao().toUpperCase());
            pst.setBoolean(3, beans.isAtivo());
            pst.setBoolean(4, beans.isFragmentado());
            pst.setInt(5, beans.getUsuario());
            pst.setInt(6, beans.getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, "unidade atualizada com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar unidade. \n" + ex);
            desconecta();
            return false;
        }

    }

    public boolean delete(UnidadeBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM public.unidade\n"
                    + "WHERE id_unidade=" + beans.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "unidade deletada com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar unidade. \n" + ex);
            desconecta();
            return false;
        }
    }

    public boolean deactivate(UnidadeBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.unidade\n"
                    + "SET   ativo_unidade=false,usuario_id=? \n"
                    + "WHERE id_unidade=?;");
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

    public ArrayList<UnidadeBeans> findAll(String pesquisa, boolean verdade) {
        String estaAtivo = "";
        if (!verdade == true) {
            estaAtivo = "ativo_unidade = true and";
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_unidade, sigla_unidade, descricao_unidade, ativo_unidade,fragmentado, usuario_id\n"
                + "	FROM public.unidade WHERE " + estaAtivo + " (coalesce((id_unidade)) ||' '||coalesce((sigla_unidade)) ||' '||coalesce((descricao_unidade)||' '||coalesce((ativo_unidade)))ilike '%" + pesquisa + "%') ORDER BY id_unidade DESC ;"); // LIMIT 10
        try {
            rs.first();
            do {
                if (verdade) {
                    dados.add(new Object[]{rs.getInt("id_unidade"), rs.getBoolean("ativo_unidade"),
                        rs.getString("sigla_unidade"), rs.getString("descricao_unidade"), rs.getBoolean("fragmentado") == true ? "Sim" : "Não"
                    });
                } else {
                    dados.add(new Object[]{rs.getInt("id_unidade"),
                        rs.getString("sigla_unidade"), rs.getString("descricao_unidade"), rs.getBoolean("fragmentado") == true ? "Sim" : "Não"});
                }
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

    public ArrayList<UnidadeBeans> findOne(int id) {

        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_unidade, sigla_unidade, descricao_unidade, ativo_unidade,fragmentado, usuario_id,registro_unidade\n"
                + "	FROM public.unidade  WHERE id_unidade =" + id);
        try {
            rs.first();

            do {
                UnidadeBeans unidade = new UnidadeBeans();
                unidade.setId((rs.getInt("id_unidade")));
                unidade.setSigla(rs.getString("sigla_unidade"));
                unidade.setDescricao(rs.getString("descricao_unidade"));
                unidade.setFragmentado(rs.getBoolean("fragmentado"));
                unidade.setDataHora(rs.getTimestamp("registro_unidade"));

                dados.add(unidade);
            } while (rs.next());

        } catch (SQLException ex) {
            System.out.println("##################Erro \nfindOne\n\n" + ex + "\n\n######################");
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

    public ArrayList<UnidadeBeans> PreencheUnidade(int id) {
        String txt = "";
        if (id != 0) {
            txt = " where  id_unidade = " + id;
        }else{
             txt = " where ativo_unidade =true" ;
        }
        ArrayList unidades = new ArrayList();
        conexao();
        executaSql2("SELECT  id_unidade, sigla_unidade,descricao_unidade FROM unidade  "+txt+"   order by descricao_unidade asc ");
        try {
            rs.first();
            do {
                UnidadeBeans unidade = new UnidadeBeans();
                unidade.setSigla(rs.getString("sigla_unidade"));
                unidade.setId((rs.getInt("id_unidade")));
                unidades.add(unidade);
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("SQLException -- " + ex);
        }
        desconecta();
        return unidades;

    }
}
