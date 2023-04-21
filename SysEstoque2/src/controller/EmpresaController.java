/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.EmpresaBeans;
import model.ModeloTabela;
import model.ProdutoBeans;
import repository.EmpresaDao;
import service.Conversor;
import view.EmpresaForm;

/**
 *
 * @author edson
 */
public class EmpresaController extends EmpresaDao {

    Conversor conversor = new Conversor();
    private final EmpresaForm view;

    private EmpresaBeans beans;

    ItemController itemController = new ItemController();
    String id_empresa = "";

    public EmpresaController(EmpresaForm view) {
        this.view = view;
        this.beans = new EmpresaBeans();

    }

    public void clear() {
        view.getjTextFieldNome().requestFocus();
        view.getjTextFieldNome().setText("");
        view.getjFormattedTextFieldCnpj().setText("");
        view.getjTextFieldInscricao().setText("");
        view.getjTextFieldDescricao().setText("");
        view.getjFormattedTextFieldTelefone().setText("");
        view.getjTextFieldEndereco().setText("");
        view.getjTextFieldNumero().setText("");
        view.getjFormattedTextFieldCep().setText("");
        view.getjTextFieldComplemento().setText("");
        view.getjTextFieldBairro().setText("");
        view.getjTextFieldCidade().setText("");
        view.getjTextArea_Observacao().setText("");

        view.getCkCliente().setSelected(false);
        view.getCkFornecedor().setSelected(false);

        view.setIdEmpresa(0);
        id_empresa = "";
        view.getBtnSalvar().setEnabled(false);
    }

    public boolean create() {
        try {
            beans.setNome_empresa(view.getjTextFieldNome().getText());
            beans.setCnpj_empresa(view.getjFormattedTextFieldCnpj().getText());
            beans.setInscricao_empresa(view.getjTextFieldInscricao().getText());
            beans.setDescricao_empresa(view.getjTextFieldDescricao().getText());
            beans.setTelefone_empresa(view.getjFormattedTextFieldTelefone().getText());
            beans.setEndereco_empresa(view.getjTextFieldEndereco().getText());
            beans.setNo_empresa(view.getjTextFieldNumero().getText());
            beans.setCep_empresa(view.getjFormattedTextFieldCep().getText());
            beans.setComplemento_empresa(view.getjTextFieldComplemento().getText());
            beans.setBairro_empresa(view.getjTextFieldBairro().getText());
            beans.setCidade_empresa(view.getjTextFieldCidade().getText());
            beans.setObservacao_empresa(view.getjTextArea_Observacao().getText());
            beans.setAtivo(true);
            beans.setCliente_empresa(view.getCkCliente().isSelected());
            beans.setFornecedor_empresa(view.getCkFornecedor().isSelected());
            beans.setUsuario(1);//usuario
            beans.setId_empresa(view.getIdEmpresa());

            if (view.getIdEmpresa() == 0) {
                 if (save(beans) == true) {
                    clear();
                    return true;
                } else {
                    return false;
                }
            } else {
                if (update(beans) == true) {
                    clear();
                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            System.out.println("######### ERRO \n" + e);
            return false;
        }
    }

    public void destroy(int id) {
        beans.setId_empresa(id);
        beans.setUsuario(1);
        if (delete(beans) == true) {
            clear();
        } else {
            deactivate(beans);
            clear();
        }

    }

    public void loadTable(String texto, boolean verdade) {
        String[] colunas = new String[]{"Id", "Nome", "Descrição"};
        ArrayList dados;
        if (verdade == true) {
            colunas = new String[]{"Id", "ativo", "Nome", "Descrição"};
        }
        dados = (ArrayList) findAll(texto, verdade);

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        view.getTabela().setModel(modelo);
        RowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
        view.getTabela().setRowSorter(sorter);
        view.getTabela().getColumnModel().getColumn(0).setResizable(true);
        view.getTabela().getColumnModel().getColumn(1).setResizable(true);
        view.getTabela().getColumnModel().getColumn(2).setResizable(true);
        view.getTabela().getTableHeader().setReorderingAllowed(false);
        view.getTabela().getTableHeader().setReorderingAllowed(false);
        view.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        view.getTabela().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void pressKeys() {
        if (view.getjTextFieldNome().getText().length() >= 2 && view.getjTextFieldDescricao().getText().length() >= 2
                && (view.getCkCliente().isSelected() || view.getCkFornecedor().isSelected())) {
            view.getBtnSalvar().setEnabled(true);
        } else {
            view.getBtnSalvar().setEnabled(false);
        }
    }

    public void loadRecord(int id) {
        for (EmpresaBeans obj : findOne(id)) {
            view.setIdEmpresa(obj.getId_empresa());
            view.getjTextFieldNome().setText(obj.getNome_empresa());
            view.getjFormattedTextFieldCnpj().setText(obj.getCnpj_empresa());
            view.getjTextFieldInscricao().setText(obj.getInscricao_empresa());
            view.getjTextFieldDescricao().setText(obj.getDescricao_empresa());
            view.getjFormattedTextFieldTelefone().setText(obj.getTelefone_empresa());
            view.getjTextFieldEndereco().setText(obj.getEndereco_empresa());
            view.getjTextFieldNumero().setText(obj.getNo_empresa());
            view.getjFormattedTextFieldCep().setText(obj.getCep_empresa());
            view.getjTextFieldComplemento().setText(obj.getComplemento_empresa());
            view.getjTextFieldBairro().setText(obj.getBairro_empresa());
            view.getjTextFieldCidade().setText(obj.getCidade_empresa());
            view.getjTextArea_Observacao().setText(obj.getObservacao_empresa());
            view.getCkCliente().setSelected(obj.isCliente_empresa());
            view.getCkFornecedor().setSelected(obj.isFornecedor_empresa());
            view.getTxtDataHora().setText("" + conversor.DataAtual(obj.getDataHora()));
            view.getTxtNomeUsuario().setText("teste");
        }
        pressKeys();
        view.getBtnSalvar().setText("Atualizar");
    }

    public void addItem() {
//        if (id_produto.length() >= 1) {
//            itemController.addItem(id_produto, "0",
//                    view.getCbComplemento().getSelectedItem().toString(),
//                    view.getTxtQuantidade().getText());
//            loadTableItem();
//            clear();
//        }
    }

    public void buscarProduto(String idProduto) {
//        ProdutoController p = new ProdutoController(null);
//        if (!idProduto.endsWith("") | idProduto.length() >= 1) {
//            for (ProdutoBeans obj : p.loadOne(Integer.parseInt(idProduto))) {
//                System.out.println("nome" + obj.getDescricao());
//                view.getTxtDescricao().setText(obj.getDescricao());
//                id_produto = "" + obj.getId();
//                view.getCbComplemento().requestFocus();
//            }
//        }
    }

    public void loadTableItem() {
//        String[] colunas = new String[]{"#", "Descrição", "Complemento", "Sigla", "Quantidade", "Valor Unitário", "Valor Total"};
//        ArrayList dados;
//
//        dados = (ArrayList) itemController.loadItem();
//
//        ModeloTabela modelo = new ModeloTabela(dados, colunas);
//        view.getTabelaItem().setModel(modelo);
//        RowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
//        view.getTabelaItem().setRowSorter(sorter);
//        view.getTabelaItem().getColumnModel().getColumn(0).setResizable(true);
//        view.getTabelaItem().getColumnModel().getColumn(1).setResizable(true);
//        view.getTabelaItem().getColumnModel().getColumn(2).setResizable(true);
//        view.getTabelaItem().getTableHeader().setReorderingAllowed(false);
//        view.getTabelaItem().getColumnModel().getColumn(3).setResizable(true);
//        view.getTabelaItem().getTableHeader().setReorderingAllowed(false);
//        view.getTabelaItem().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//        view.getTabelaItem().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

}
