/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connection.ConexaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ItemBeans;
import model.ItemBeans;

/**
 *
 * @author edson
 */
public class ItemDao extends ConexaoBD {

    public boolean save(ItemBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("INSERT INTO public.item\n"
                    + "(id_prod_item, nota_item, qtd_item, complemento_item, registro_item, usuario_id, status_item)\n"
                    + "VALUES(?, ?, ?, ?, now(), ?, ?);");

            pst.setInt(1, beans.getIdProduto());
            pst.setInt(2, beans.getNota());
            pst.setDouble(3, beans.getQuantidade());
            pst.setString(4, beans.getComplemento());
            pst.setInt(5, beans.getUsuario());
            pst.setInt(6, beans.getStatus());

            pst.execute();

//            JOptionPane.showMessageDialog(null, "  cadastrado com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar  . \n" + ex);
            desconecta();
            return false;
        }

    }

    public boolean update(ItemBeans beans) {
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

    public boolean delete(ItemBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM public.item\n"
                    + "WHERE id_item=" + beans.getId());
            pst.execute();
//            JOptionPane.showMessageDialog(null, "unidade deletada com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar  . \n" + ex);
            desconecta();
            return false;
        }
    }

    public boolean deactivate(ItemBeans beans) {
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

    public ArrayList<ItemBeans> findAll(String pesquisa, boolean verdade) {
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

    public ArrayList<ItemBeans> findOne(int id) {

        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_unidade, sigla_unidade, descricao_unidade, ativo_unidade,fragmentado, usuario_id,registro_unidade\n"
                + "	FROM public.unidade  WHERE id_unidade =" + id);
        try {
            rs.first();

            do {
                ItemBeans unidade = new ItemBeans();
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

    /*
    SELECT id_item, id_prod_item, nota_item, qtd_item, complemento_item, registro_item, usuario_id, status_item
FROM public.item;

     */
    public ArrayList<ItemBeans> PreencheItem(int id) {
        String txt = "";
        if (id != 0) {
            txt = " where  nota_item = " + id;
        } else {
            txt = " where status_item =true";
        }
        ArrayList itens = new ArrayList();
        conexao();
        executaSql2("SELECT  id_item, id_prod_item, nota_item, qtd_item, complemento_item, registro_item, usuario_id, status_item"
                + " FROM item  " + txt + "   order by id_item asc ");
        try {
            rs.first();
            do {
                ItemBeans obj = new ItemBeans();
                obj.setId(rs.getInt("id_item"));
                obj.setIdProduto((rs.getInt("id_prod_item")));
                obj.setNota(rs.getInt("nota_item"));
                obj.setQuantidade(rs.getDouble("qtd_item"));
                obj.setComplemento(rs.getString("complemento_item"));
                itens.add(obj);
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("SQLException -- " + ex);
        }
        desconecta();
        return itens;

    }
}
