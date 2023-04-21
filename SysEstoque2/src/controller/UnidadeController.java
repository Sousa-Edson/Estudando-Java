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
import model.ModeloTabela;
import model.UnidadeBeans;
import repository.UnidadeDao;
import service.Conversor;
import view.UnidadeForm;

/**
 *
 * @author edson
 */
public class UnidadeController extends UnidadeDao {

    Conversor conversor = new Conversor();
    private final UnidadeForm view;

    private UnidadeBeans beans;

    public UnidadeController(UnidadeForm view) {
        this.view = view;
        this.beans = new UnidadeBeans();

    }

    public void clear() {
        view.getTxtSigla().setText(null);
        view.getTxtDescricao().setText(null);
        view.getTxtPesquisa().setText(null);
        view.getCkFragmentado().setSelected(false);
        view.getTxtSigla().requestFocus();
        view.getBtnSalvar().setEnabled(false);
        view.getBtnSalvar().setText("Salvar");
        view.setIdUnidade(0);
        view.getBtnExcluir().setVisible(false);
        view.getTxtDataHora().setText(" ");
        view.getTxtNomeUsuario().setText(" ");
        loadTable("", false);

    }

    public void create() {
        try {
            beans.setSigla(view.getTxtSigla().getText());
            beans.setDescricao(view.getTxtDescricao().getText());
            beans.setFragmentado(view.getCkFragmentado().isSelected());
            beans.setAtivo(true);
            beans.setUsuario(1);
            beans.setId(view.getIdUnidade());

            if (view.getIdUnidade() == 0) {
                if (save(beans)) {
                    clear();
                }

            } else {
                if (update(beans)) {
                    clear();
                }
            }

        } catch (Exception e) {
            System.out.println("######### ERRO \n" + e);
        }
    }

    public void destroy(int id) {
        beans.setId(id);
        beans.setUsuario(1);
        if (delete(beans) == true) {
            clear();
        } else {
            deactivate(beans);
            clear();
        }

    }

    public void loadTable(String texto, boolean verdade) {
        String[] colunas = new String[]{"Id", "Sigla", "Descrição", "Fragmentado"};
        ArrayList dados;
        if (verdade == true) {
            colunas = new String[]{"Id", "Ativo", "Sigla", "Descrição", "Fragmentado"};
        }
        dados = (ArrayList) findAll(texto, verdade);

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        view.getTabela().setModel(modelo);
        RowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
        view.getTabela().setRowSorter(sorter);
//         view.getTabela().getColumnModel().getColumn(0).setPreferredWidth(60);
        view.getTabela().getColumnModel().getColumn(0).setResizable(true);
//         view.getTabela().getColumnModel().getColumn(1).setPreferredWidth(60);
        view.getTabela().getColumnModel().getColumn(1).setResizable(true);
//         view.getTabela().getColumnModel().getColumn(2).setPreferredWidth(60);
        view.getTabela().getColumnModel().getColumn(2).setResizable(true);
        view.getTabela().getTableHeader().setReorderingAllowed(false);
        view.getTabela().getColumnModel().getColumn(3).setResizable(true);
        view.getTabela().getTableHeader().setReorderingAllowed(false);
        view.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        view.getTabela().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void pressKeys() {
        if (view.getTxtSigla().getText().length() >= 2 && view.getTxtDescricao().getText().length() > 2) {
            view.getBtnSalvar().setEnabled(true);
        } else {
            view.getBtnSalvar().setEnabled(false);
        }
    }

    public void loadRecord(int id) {
        for (UnidadeBeans u : findOne(id)) {
            view.setIdUnidade(id);
            view.getTxtSigla().setText(u.getSigla());
            view.getTxtDescricao().setText(u.getDescricao());
            view.getCkFragmentado().setSelected(u.isFragmentado());

            view.getTxtDataHora().setText("" + conversor.DataAtual(u.getDataHora()));
            view.getTxtNomeUsuario().setText("teste");
        }
        pressKeys();
        view.getBtnSalvar().setText("Atualizar");
    }

}
