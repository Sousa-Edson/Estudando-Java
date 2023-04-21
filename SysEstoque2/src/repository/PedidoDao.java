/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connection.ConexaoBD;

import java.sql.SQLException;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.EntradaBeans;

/**
 *
 * @author edson
 */
public class PedidoDao extends ConexaoBD {

    public boolean save(EntradaBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement(" INSERT INTO public.nota\n"
                    + "(cfop_id, nota, chave, data_nota, hora, usuario_id, registro_nota, empresa_id)\n"
                    + "VALUES(?, ?, ?, ?, ?, ?, now(), ?);");

            pst.setInt(1, beans.getCfop());
            pst.setString(2, beans.getNota());
            pst.setString(3, beans.getChave());
            java.util.Date dt = beans.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            pst.setDate(4, d);
            pst.setString(5, beans.getHora());
            pst.setInt(6, beans.getUsuario());
//            pst.setTimestamp(7, beans.getDataHora());
            pst.setInt(7, beans.getCliente());
            pst.execute();

            JOptionPane.showMessageDialog(null, "  cadastrado com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar  . \n" + ex);
            desconecta();
            return false;
        }

    }

    public boolean update(EntradaBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.nota\n"
                    + "SET cfop_id=?, nota=?, chave=?, data_nota=?, hora=?, usuario_id=?, registro_nota=now(), empresa_id=?\n"
                    + "WHERE id_nota=? ;");
            pst.setInt(1, beans.getCfop());
            pst.setString(2, beans.getNota());
            pst.setString(3, beans.getChave());
            java.util.Date dt = beans.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            pst.setDate(4, d);
            pst.setString(5, beans.getHora());
            pst.setInt(6, beans.getUsuario());
//            pst.setTimestamp(7, beans.getDataHora());
            pst.setInt(7, beans.getCliente());
            pst.setInt(8, beans.getId());
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

    public boolean delete(EntradaBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("DELETE FROM public.nota\n"
                    + "WHERE id_nota=" + beans.getId());
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

    public boolean deactivate(EntradaBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.nota\n"
                    + "SET   usuario_id=? \n" //ativo_unidade=false,
                    + "WHERE id_nota=?;");
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

    public ArrayList<EntradaBeans> findAll(String pesquisa, boolean verdade) {
        String estaAtivo = "";
        if (!verdade == true) {
            estaAtivo = "";//ativo_unidade = true and
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_nota, cfop_id, nota, chave, data_nota, hora, n.usuario_id, registro_nota, empresa_id,nome_empresa \n"
                + "	FROM public.nota as n inner join empresa on id_empresa = empresa_id WHERE " + estaAtivo + " (coalesce((nota)) ||' '||coalesce((chave)) ||' '||coalesce((data_nota) ))ilike '%" + pesquisa + "%' ORDER BY id_nota DESC ;"); // LIMIT 10
        try {
            rs.first();
            do {
                if (verdade) {
                    dados.add(new Object[]{rs.getInt("id_nota"), rs.getDate("data_nota"),//rs.getBoolean(""),
                        rs.getString("nota"), rs.getString("nome_empresa")
                    });
                } else {
                    dados.add(new Object[]{rs.getInt("id_nota"), rs.getDate("data_nota"),//rs.getBoolean(""),
                        rs.getString("nota"), rs.getString("nome_empresa")});
                }
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

    public ArrayList<EntradaBeans> findOne(int id) {

        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("select id_nota, cfop_id, nota, chave, data_nota, hora, n.usuario_id, registro_nota, empresa_id\n"
                + "	FROM public.nota as n  WHERE id_nota =" + id);
        try {
            rs.first();

            do {
                EntradaBeans obj = new EntradaBeans();
                obj.setId((rs.getInt("id_nota")));
                obj.setCfop(rs.getInt("cfop_id"));
                obj.setNota(rs.getString("nota"));
                obj.setChave(rs.getString("chave"));
                obj.setData(rs.getDate("data_nota"));
                obj.setHora(rs.getString("hora"));
                obj.setDataHora(rs.getTimestamp("registro_nota"));
                obj.setCliente(rs.getInt("empresa_id"));

                dados.add(obj);
            } while (rs.next());

        } catch (SQLException ex) {
            System.out.println("##################Erro \nfindOne\n\n" + ex + "\n\n######################");
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

    public int lasRecord() {
        int ultimo = 0;
        conexao();
        executaSql2("select id_nota FROM public.nota order by id_nota desc");
        try {
            rs.first();
            
                ultimo = rs.getInt("id_nota");
           
        } catch (SQLException ex) {
            System.out.println("##################Erro \nlasRecord\n\n" + ex + "\n\n######################");
        }
        desconecta();
        return ultimo;
    }

//    public ArrayList<EntradaBeans> PreencheUnidade(int id) {
//        String txt = "";
//        if (id != 0) {
//            txt = " where  id_unidade = " + id;
//        } else {
//            txt = " where ativo_unidade =true";
//        }
//        ArrayList unidades = new ArrayList();
//        conexao();
//        executaSql2("SELECT  id_unidade, sigla_unidade,descricao_unidade FROM unidade  " + txt + "   order by descricao_unidade asc ");
//        try {
//            rs.first();
//            do {
//                EntradaBeans unidade = new EntradaBeans();
////                unidade.setSigla(rs.getString("sigla_unidade"));
////                unidade.setId((rs.getInt("id_unidade")));
////                unidades.add(unidade);
//            } while (rs.next());
//        } catch (SQLException ex) {
//            System.out.println("SQLException -- " + ex);
//        }
//        desconecta();
//        return unidades;
//        
//    }
}
