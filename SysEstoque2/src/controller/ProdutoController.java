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
import model.NcmBeans;
import model.ProdutoBeans;
import model.TipoBeans;
import model.UnidadeBeans;
import repository.NcmDao;
import repository.ProdutoDao;
import repository.TipoDao;
import repository.UnidadeDao;
import service.Conversor;
import view.ProdutoForm;

/**
 *
 * @author edson
 */
public class ProdutoController extends ProdutoDao {

    Conversor conversor = new Conversor();
    private final ProdutoForm view;

    private ProdutoBeans beans;

    public ProdutoController(ProdutoForm view) {
        this.view = view;
        this.beans = new ProdutoBeans();

    }

    public void clear() {
        view.getTxtDescricao().setText(null);
        view.getTxtInformacao().setText(null);
        view.getTxtPesquisa().setText(null);
        view.getTxtValor().setText("0");
        view.getTxtDescricao().requestFocus();
        view.getBtnSalvar().setEnabled(false);
        view.getBtnSalvar().setText("Salvar");
        view.setIdProduto(0);
        view.getBtnExcluir().setVisible(false);
        loadTable("", false);
    }

    public void create() {
        try {
            UnidadeBeans unidade = (UnidadeBeans) view.getCbUnidade().getSelectedItem();
            beans.setUnidade(unidade.getId());

            NcmBeans ncm = (NcmBeans) view.getCbNcm().getSelectedItem();
            beans.setNcm(ncm.getId());

            TipoBeans tipo = (TipoBeans) view.getCbTipo().getSelectedItem();
            beans.setTipo(tipo.getId());

            beans.setDescricao(view.getTxtDescricao().getText());
            beans.setAtivo(true);
            beans.setUsuario(1);
            beans.setId(view.getIdProduto());
            beans.setInformacao(view.getTxtInformacao().getText().toUpperCase());
//            String valor = view.getTxtValor().getText().replace(".", "").replace(",", ".");
//            System.out.println("valor sem ponto " + valor);
//            Double v = Double.valueOf(valor) ;
            beans.setValor(conversor.stringForDouble(view.getTxtValor().getText()));

            if (view.getIdProduto() == 0) {
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
        String[] colunas = new String[]{"Id", "Tipo", "Descrição", "Un", "Valor R$"};
        ArrayList dados;
        if (verdade == true) {
            colunas = new String[]{"Id", "Ativo", "Tipo", "Descrição", "Un", "Valor R$"};
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
        if (view.getTxtDescricao().getText().length() >= 2 && view.getTxtValor().getText().length() >= 1) {
            view.getBtnSalvar().setEnabled(true);
        } else {
            view.getBtnSalvar().setEnabled(false);
        }
    }

    public void loadRecord(int id) {
        for (ProdutoBeans p : findOne(id)) {
            view.setIdProduto(id);
            view.getTxtDescricao().setText(p.getDescricao());
            view.getTxtInformacao().setText(p.getInformacao());
            view.getTxtValor().setText(conversor.doubleForString(p.getValor()));
            PreencheUnidade(p.getUnidade());
            PreencheNcm(p.getNcm());
            PreencheTipo(p.getTipo());
            view.getTxtDataHora().setText("" + conversor.DataAtual(p.getDataHora()));
            view.getTxtNomeUsuario().setText("teste");
        }
        pressKeys();
        view.getBtnSalvar().setText("Atualizar");
    }
// public String DataAtual(Date dt) {
//        return "Atualizado em: " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(dt);
//    }

    public void PreencheUnidade(int id) {
        view.getCbUnidade().removeAllItems();
        UnidadeDao DAOU = new UnidadeDao();
        for (UnidadeBeans u : DAOU.PreencheUnidade(id)) {
            view.getCbUnidade().addItem(u);
        }
    }

    public void PreencheNcm(int id) {
        view.getCbNcm().removeAllItems();
        NcmDao DAOU = new NcmDao();
        for (NcmBeans u : DAOU.PreencheNcm(id)) {
            view.getCbNcm().addItem(u);
        }
    }

    public void PreencheTipo(int id) {
        view.getCbTipo().removeAllItems();
        TipoDao DAOU = new TipoDao();
        for (TipoBeans u : DAOU.PreencheTipo(id)) {
            view.getCbTipo().addItem(u);
        }
    }

    public ArrayList<ProdutoBeans> loadOne(int id) {
        return findOne(id);

    }
}
