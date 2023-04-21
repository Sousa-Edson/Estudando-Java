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
import model.CfopBeans;
import model.EmpresaBeans;
import model.EntradaBeans;
import model.ItemBeans;
import model.ModeloTabela;
import model.ProdutoBeans;
import repository.CfopDao;
import repository.EmpresaDao;
import repository.EntradaDao;
import repository.ItemDao;
import view.PedidoForm;

/**
 *
 * @author edson
 */
public class PedidoController extends EntradaDao {

//    Conversor conversor = new Conversor();
    private final PedidoForm view;

    private final ItemBeans beans;

    ItemController itemController = new ItemController();
    String id_produto = "";
    ArrayList dados = null;

    public PedidoController(PedidoForm view) {
        this.view = view;
        this.beans = new ItemBeans();

    }

    public void clear() {
//        view.getTxtIdProduto().requestFocus();
//        view.getTxtIdProduto().setText(null);
//        view.getTxtDescricao().setText(null);
//        view.getCbComplemento().setSelectedItem("");
//        view.getTxtQuantidade().setText(null);
        
        id_produto = "";
    }

    public void clearDataHora() {
//        view.getjDateChooser1().setDate(null);
//        view.getTxtHora().setText("");
//        view.getTxtNota().setText(null);
//        view.getTxtChave().setText(null);
    }

    public void clearDados() {

        dados = null;
        itemController.eraseItem();

        System.out.println("clearDados \n" + dados + "\n");
    }

    public Boolean create() {
        Boolean verdade = false;
        try {
            beans.setIdProduto(Integer.parseInt(view.getTxtIdProduto().getText()));
            beans.setNota(0);
            beans.setQuantidade(Double.parseDouble( view.getTxtQuantidade().getText()));
            beans.setComplemento(""+view.getCbComplemento().getSelectedItem());
            beans.setUsuario(1); // corrigir depois
            beans.setStatus(1);
            
             
             
        } catch (Exception e) {
            System.out.println("######### ERRO \n" + e);
            verdade = false;
        }
        return verdade;
    }

    public void destroy(int id) {
        beans.setId(id);

        beans.setUsuario(1);
//        if (delete(beans) == true) {
//            clear();
//        } else {
//            deactivate(beans);
//            clear();
//        }

    }

    public void loadTable(String texto, boolean verdade) {
//        String[] colunas = new String[]{"#", "Data", "Nota N°", "Cliente"};
//        ArrayList dados;
//        if (verdade == true) {
//            colunas = new String[]{"#", "Ativo", "Data", "Nota N°", "Cliente"};
//        }
//        dados = (ArrayList) findAll(texto, verdade);
//
//        ModeloTabela modelo = new ModeloTabela(dados, colunas);
//        view.getTabela().setModel(modelo);
//        RowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
//        view.getTabela().setRowSorter(sorter);
//        view.getTabela().getColumnModel().getColumn(0).setResizable(true);
//        view.getTabela().getColumnModel().getColumn(1).setResizable(true);
//        view.getTabela().getColumnModel().getColumn(2).setResizable(true);
//        view.getTabela().getTableHeader().setReorderingAllowed(false);
//        view.getTabela().getColumnModel().getColumn(3).setResizable(true);
//        view.getTabela().getTableHeader().setReorderingAllowed(false);
//        view.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//        view.getTabela().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void pressKeys() {
//        if (view.getTxtNota().getText().length() >= 1 && view.getTxtChave().getText().length() >= 1 && dados != null) {
//            view.getBtnSalvar().setEnabled(true);
//        } else {
//            view.getBtnSalvar().setEnabled(false);
//        }
    }

    public void loadRecord(int id) {
//        for (EntradaBeans u : findOne(id)) {
//            view.setIdNota(u.getId());
//            view.getTxtNota().setText(u.getNota());
//            view.getTxtChave().setText(u.getChave());
//            view.getjDateChooser1().setDate(u.getData());
//            view.getTxtHora().setText(u.getHora());
//
////            view.getCbTipo().setSelectedItem(u.getCliente());
//            PreencheEmpresa(u.getCliente());
//            PreencheCfop(u.getCfop());
//
//            view.getTxtNomeUsuario().setText("teste");
//        }
//        pressKeys();
//        view.getBtnSalvar().setText("Atualizar");
    }

    public void addItem() {
//        if (id_produto.length() >= 1) {
//            try {
//                 itemController.addItem(id_produto, "0",
//                    view.getCbComplemento().getSelectedItem().toString(),
//                    view.getTxtQuantidade().getText(), "0");
////            itemController.PreencheItens(0);
//            loadTableItem();
//            clear();
//            } catch (Exception e) {
//                System.err.println("##\nerro\n"+e);
//            }
//           
//        }
    }

    public void preencheItem(int id) {
        itemController.PreencheItens(id);
    }

    public void removeItem(int id) {
        itemController.removeItem(id);
        loadTableItem();

    }

    public void testeItem() {
        itemController.teste();
        loadTableItem();
    }

    public void buscarProduto(String idProduto) {
//        ProdutoController p = new ProdutoController(null);
//        if (!idProduto.endsWith("") | idProduto.length() >= 1) {
//            for (ProdutoBeans obj : p.loadOne(Integer.parseInt(idProduto))) {
//                view.getTxtDescricao().setText(obj.getDescricao());
//                id_produto = "" + obj.getId();
//                view.getCbComplemento().requestFocus();
//            }
//        }
    }

    public void loadTableItem() {
//        String[] colunas = new String[]{"#", "Id produto", "Descrição", "Complemento", "Sigla", "Quantidade", "Valor Unitário", "Valor Total"};
//        dados = (ArrayList) itemController.loadItem();
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

    //temporario
    public void PreencheEmpresa(int id) {
//        view.getCbEmpresa().removeAllItems();
//        EmpresaDao DAOU = new EmpresaDao();
//        for (EmpresaBeans u : DAOU.PreencheEmpresa(id)) {
//            view.getCbEmpresa().addItem(u);
//        }
    }
    //temporario

    public void PreencheCfop(int id) {
//        view.getCbCfop().removeAllItems();
//        CfopDao DAOU = new CfopDao();
//        for (CfopBeans u : DAOU.PreencheCfop(id)) {
//            view.getCbCfop().addItem(u);
//        }
    }

    
}
