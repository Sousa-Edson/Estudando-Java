/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connection.ConexaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.EmpresaBeans;

/**
 *
 * @author edson
 */
public class EmpresaDao extends ConexaoBD {

    public boolean save(EmpresaBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("INSERT INTO public.empresa\n"
                    + "(nome_empresa, cnpj_empresa, inscricao_empresa, descricao_empresa, telefone_empresa, endereco_empresa, no_empresa, cep_empresa, complemento_empresa, bairro_empresa, "
                    + "cidade_empresa, observacao_empresa, ativo_empresa, cliente_empresa, fornecedor_empresa, registro_empresa, usuario_id)\n"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?);");

            pst.setString(1, beans.getNome_empresa().toUpperCase());
            pst.setString(2, beans.getCnpj_empresa());
            pst.setString(3, beans.getInscricao_empresa());
            pst.setString(4, beans.getDescricao_empresa());
            pst.setString(5, beans.getTelefone_empresa());
            pst.setString(6, beans.getEndereco_empresa());
            pst.setString(7, beans.getNo_empresa());
            pst.setString(8, beans.getCep_empresa());
            pst.setString(9, beans.getComplemento_empresa());
            pst.setString(10, beans.getBairro_empresa());
            pst.setString(11, beans.getCidade_empresa());
            pst.setString(12, beans.getObservacao_empresa());
            pst.setBoolean(13, beans.isAtivo());
            pst.setBoolean(14, beans.isCliente_empresa());
            pst.setBoolean(15, beans.isFornecedor_empresa());;
            pst.setInt(16, beans.getUsuario());

            pst.execute();

            JOptionPane.showMessageDialog(null, "cadastrado com sucesso. ");
            desconecta();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar . \n" + ex);
            desconecta();
            return false;
        }

    }

    public boolean update(EmpresaBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.empresa\n"
                    + "SET nome_empresa=?, cnpj_empresa=?, inscricao_empresa=?, descricao_empresa=?, telefone_empresa=?, endereco_empresa=?, no_empresa=?, cep_empresa=?,"
                    + " complemento_empresa=?, bairro_empresa=?, "
                    + "cidade_empresa=?, observacao_empresa=?, ativo_empresa=?, cliente_empresa=?, fornecedor_empresa=?, registro_empresa=now(), "
                    + "usuario_id=?\n"
                    + "WHERE id_empresa=?");

            pst.setString(1, beans.getNome_empresa().toUpperCase());
            pst.setString(2, beans.getCnpj_empresa());
            pst.setString(3, beans.getInscricao_empresa());
            pst.setString(4, beans.getDescricao_empresa());
            pst.setString(5, beans.getTelefone_empresa());
            pst.setString(6, beans.getEndereco_empresa());
            pst.setString(7, beans.getNo_empresa());
            pst.setString(8, beans.getCep_empresa());
            pst.setString(9, beans.getComplemento_empresa());
            pst.setString(10, beans.getBairro_empresa());
            pst.setString(11, beans.getCidade_empresa());
            pst.setString(12, beans.getObservacao_empresa());
            pst.setBoolean(13, beans.isAtivo());
            pst.setBoolean(14, beans.isCliente_empresa());
            pst.setBoolean(15, beans.isFornecedor_empresa());;
            pst.setInt(16, beans.getUsuario());
            pst.setInt(17, beans.getId_empresa());

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

    public boolean delete(EmpresaBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement(" DELETE FROM public.empresa\n"
                    + "WHERE id_empresa=" + beans.getId_empresa());
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

    public boolean deactivate(EmpresaBeans beans) {
        conexao();
        try {
            java.sql.PreparedStatement pst = con.prepareStatement("UPDATE public.empresa\n"
                    + "SET   ativo_empresa=false,usuario_id=? \n"
                    + "WHERE id_empresa=?;");
            pst.setInt(1, beans.getUsuario());
            pst.setInt(2, beans.getId_empresa());

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

    /*
    SELECT id_empresa, nome_empresa, cnpj_empresa, inscricao_empresa, descricao_empresa, telefone_empresa, endereco_empresa, no_empresa, 
    cep_empresa, complemento_empresa, bairro_empresa, cidade_empresa, observacao_empresa, ativo_empresa, cliente_empresa, fornecedor_empresa, 
    registro_empresa, usuario_id
FROM public.empresa;

     */
    public ArrayList<EmpresaBeans> findAll(String pesquisa, boolean verdade) {
        String estaAtivo = "";
        if (!verdade == true) {
            estaAtivo = "ativo_empresa = true and";
        }
        ArrayList dados = new ArrayList();
        conexao();
        executaSql2("SELECT id_empresa, nome_empresa, descricao_empresa, ativo_empresa, usuario_id\n"
                + "	FROM public.empresa WHERE " + estaAtivo + " (coalesce((id_empresa)) ||' '||coalesce((nome_empresa)) ||' '||coalesce((descricao_empresa) )ilike '%" + pesquisa + "%') ORDER BY id_empresa DESC ;"); // LIMIT 10
        try {
            rs.first();
            do {
                if (verdade) {
                    dados.add(new Object[]{rs.getInt("id_empresa"), rs.getBoolean("ativo_empresa"),
                        rs.getString("nome_empresa"), rs.getString("descricao_empresa")
                    });
                } else {
                    dados.add(new Object[]{rs.getInt("id_empresa"),
                        rs.getString("nome_empresa"), rs.getString("descricao_empresa")});
                }
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

    public ArrayList<EmpresaBeans> findOne(int id) {

        ArrayList dados = new ArrayList();
        conexao();
        executaSql2(" \n"
                + "    SELECT id_empresa, nome_empresa, cnpj_empresa, inscricao_empresa, descricao_empresa, telefone_empresa, endereco_empresa, no_empresa, \n"
                + "    cep_empresa, complemento_empresa, bairro_empresa, cidade_empresa, observacao_empresa, ativo_empresa, cliente_empresa, fornecedor_empresa, \n"
                + "    registro_empresa, usuario_id\n"
                + "FROM public.empresa  WHERE id_empresa =" + id);
        try {
            rs.first();

            do {
                EmpresaBeans obj = new EmpresaBeans();
                obj.setId_empresa((rs.getInt("id_empresa")));
                obj.setNome_empresa(rs.getString("nome_empresa"));
                obj.setCnpj_empresa(rs.getString("cnpj_empresa"));
                obj.setInscricao_empresa(rs.getString("inscricao_empresa"));
                obj.setDescricao_empresa(rs.getString("descricao_empresa"));
                obj.setTelefone_empresa(rs.getString("telefone_empresa"));
                obj.setEndereco_empresa(rs.getString("endereco_empresa"));
                obj.setNo_empresa(rs.getString("no_empresa"));
                obj.setCep_empresa(rs.getString("cep_empresa"));
                obj.setComplemento_empresa(rs.getString("complemento_empresa"));
                obj.setBairro_empresa(rs.getString("bairro_empresa"));
                obj.setCidade_empresa(rs.getString("cidade_empresa"));
                obj.setObservacao_empresa(rs.getString("observacao_empresa"));
                obj.setAtivo(rs.getBoolean("ativo_empresa"));
                obj.setCliente_empresa(rs.getBoolean("cliente_empresa"));
                obj.setFornecedor_empresa(rs.getBoolean("fornecedor_empresa"));

                obj.setUsuario(rs.getInt("usuario_id"));
                obj.setDataHora(rs.getTimestamp("registro_empresa"));

                dados.add(obj);
            } while (rs.next());

        } catch (SQLException ex) {
            System.out.println("##################Erro \nfindOne\n\n" + ex + "\n\n######################");
        }
        desconecta();
//        System.out.println("repository.UnidadeDao.findAllUnidades() "+dados.toString());
        return dados;
    }

    public ArrayList<EmpresaBeans> PreencheEmpresa(int id) {
        String txt = "";
        if (id != 0) {
            txt = " where  id_empresa = " + id;
        } else {
            txt = " where ativo_empresa =true";
        }
        ArrayList empresas = new ArrayList();
        conexao();
        executaSql2("SELECT  id_empresa, nome_empresa,descricao_empresa FROM empresa  " + txt + "   order by nome_empresa asc ");
        try {
            rs.first();
            do {
                EmpresaBeans obj = new EmpresaBeans();
                obj.setNome_empresa(rs.getString("nome_empresa"));
                obj.setId_empresa((rs.getInt("id_empresa")));
                empresas.add(obj);
            } while (rs.next());
        } catch (SQLException ex) {
            System.out.println("SQLException -- " + ex);
        }
        desconecta();
        return empresas;

    }

}
