/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connection.ConexaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ProdutoBeans;
import service.Conversor;

/**
 *
 * @author edson
 */
public class ProdutoDao extends ConexaoBD {

    Conversor conversor = new Conversor();

    public boolean save(ProdutoBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("   INSERT INTO public.produto\n"
                    + "(descricao_produto, tipo_id, unidade_id, ncm_id, informacao_produto, usuario_id, ativo_produto, valor_produto,registro_produto )\n"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?,now());");

            pst.setString(1, beans.getDescricao().toUpperCase());
            pst.setInt(2, beans.getTipo());
            pst.setInt(3, beans.getUnidade());
            pst.setInt(4, beans.getNcm());
            pst.setString(5, beans.getInformacao().toUpperCase());
            pst.setInt(6, beans.getUsuario());
            pst.setBoolean(7, beans.isAtivo());
            pst.setDouble(8, beans.getValor());

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

    public boolean update(ProdutoBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.produto\n"
                    + "SET descricao_produto=?, tipo_id=?, unidade_id=?, ncm_id=?, informacao_produto=?, usuario_id=?, ativo_produto=?, valor_produto=?,registro_produto=now()\n"
                    + "WHERE id_produto=?;");

            pst.setString(1, beans.getDescricao().toUpperCase());
            pst.setInt(2, beans.getTipo());
            pst.setInt(3, beans.getUnidade());
            pst.setInt(4, beans.getNcm());
            pst.setString(5, beans.getInformacao().toUpperCase());
            pst.setInt(6, beans.getUsuario());
            pst.setBoolean(7, beans.isAtivo());
            pst.setDouble(8, beans.getValor());
            pst.setInt(9, beans.getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, "  atualizada com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar  . \n" + ex);
            desconecta();
            return false;
        }

    }

    public boolean delete(ProdutoBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM public.produto\n"
                    + "WHERE id_produto=" + beans.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "  deletada com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar  . \n" + ex);
            desconecta();
            return false;
        }
    }

    public boolean deactivate(ProdutoBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.produto\n"
                    + "SET   ativo_produto=false,usuario_id=? \n"
                    + "WHERE id_produto=?;");
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

    public ArrayList<ProdutoBeans> findAll(String pesquisa, boolean verdade) {
        System.out.println(verdade);
        String estaAtivo = "";
        if (!verdade == true) {
            estaAtivo = "ativo_produto = true and";
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_produto, descricao_produto, tipo_id, unidade_id, ncm_id, informacao_produto, p.usuario_id, ativo_produto, valor_produto,sigla_unidade,descricao_unidade,descricao_tipo\n"
                + "FROM public.produto as p\n"
                + "INNER JOIN tipo on tipo_id = id_tipo\n"
                + "INNER JOIN unidade on unidade_id = id_unidade\n"
                + "	 WHERE " + estaAtivo + "(coalesce((id_produto)) ||' '||coalesce((descricao_produto)) ||' '||coalesce((informacao_produto)||' '||coalesce((ativo_produto)))ilike '%" + pesquisa + "%') ORDER BY id_produto DESC ;"); // LIMIT 10
        try {
            rs.first();
            do {
                if (verdade) {
                    dados.add(new Object[]{rs.getInt("id_produto"), rs.getBoolean("ativo_produto"), rs.getString("descricao_tipo"),
                        rs.getString("descricao_produto"), rs.getString("descricao_unidade"), conversor.doubleForString(rs.getDouble("valor_produto"))
                    });
                } else {
                    dados.add(new Object[]{rs.getInt("id_produto"), rs.getString("descricao_tipo"),
                        rs.getString("descricao_produto"), rs.getString("sigla_unidade"), conversor.stringMoney(conversor.doubleForString(rs.getDouble("valor_produto")))});
                }
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("Erro \nfindAll\n" + ex);
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

//    public ArrayList<ProdutoBeans> findAllOn() {
//
//        ArrayList dados = new ArrayList();
//        conexao();
//        executaSql2("SELECT id_produto, descricao_produto, tipo_id, unidade_id, ncm_id, informacao_produto, p.usuario_id, ativo_produto, valor_produto ,descricao_unidade,descricao_tipo\n"
//                + "FROM public.produto as p\n"
//                + "INNER JOIN tipo on tipo_id = id_tipo\n"
//                + "INNER JOIN unidade on unidade_id = id_unidade\n"
//                + "	  WHERE ativo_produto = true ORDER BY id_produto DESC ;"); // LIMIT 10
//        try {
//            rs.first();
//            do {
//
//                dados.add(new Object[]{rs.getInt("id_produto"),  rs.getString("descricao_tipo"),
//                    rs.getString("descricao_produto"), rs.getString("descricao_unidade"), conversor.doubleForString(rs.getDouble("valor_produto"))});
//            } while (rs.next());
//        } catch (SQLException ex) {
//            System.out.println("Erro \nfindAllOn\n" + ex);
//        }
//        desconecta();
////        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
//        return dados;
//    }
    public ArrayList<ProdutoBeans> findOne(int id) {

        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_produto, descricao_produto, informacao_produto, ativo_produto,valor_produto, p.usuario_id,\n"
                + "unidade_id,sigla_unidade,ncm_id,tipo_id,registro_produto\n"
                + ""
                + "	FROM public.produto as p  inner join unidade on unidade_id = id_unidade WHERE id_produto =" + id);
        try {
            rs.first();

            do {
                ProdutoBeans produto = new ProdutoBeans();
                produto.setId((rs.getInt("id_produto")));
                produto.setDescricao(rs.getString("descricao_produto"));
                produto.setInformacao(rs.getString("informacao_produto"));
                produto.setValor(rs.getDouble("valor_produto"));
                produto.setUnidade((rs.getInt("unidade_id")));
                produto.setSigla(rs.getString("sigla_unidade"));
                produto.setNcm((rs.getInt("ncm_id")));
                produto.setTipo((rs.getInt("tipo_id")));
                produto.setDataHora(rs.getTimestamp("registro_produto"));
                dados.add(produto);
            } while (rs.next());

        } catch (SQLException ex) {
            System.out.println("##################Erro \nfindOne\n\n" + ex + "\n\n######################");
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }
}
