/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.ItemBeans;
import model.ProdutoBeans;
import repository.ItemDao;
import service.Conversor;

/**
 *
 * @author edson
 */
public class ItemController {

    Conversor conversor = new Conversor();
    public static ArrayList<ItemBeans> itemList = new ArrayList<>();
    public static ArrayList<ItemBeans> removeList = new ArrayList<>();

    public void teste() {
        for (int i = 0; i < 3; i++) {
            addItem("1", "1", "complemnto " + i, "" + i, "");
        }
    }

    public void addItem(String idProduto, String idNota, String complemento, String quantidade, String id) {
        ItemBeans beans = new ItemBeans();
        ProdutoController p = new ProdutoController(null);
        beans.setIdProduto(Integer.parseInt(idProduto));
        beans.setNota(Integer.parseInt(idNota));
        beans.setComplemento(complemento);
        beans.setQuantidade(conversor.stringForDouble(quantidade));
        beans.setUsuario(1); // apagar aqui depois
        for (ProdutoBeans pr : p.loadOne(Integer.parseInt(idProduto))) {
            beans.setDescricao(pr.getDescricao());
            beans.setSigla(pr.getSigla());
            beans.setValor(pr.getValor());
        }
        beans.setIdList(itemList.size() + 1);
        beans.setId(Integer.parseInt(id));
        itemList.add(beans);

    }

    public void removeItem(int id) {
        try {
            for (ItemBeans i : this.itemList) {
                if (i.getIdList() == id) {
                    this.itemList.remove(i);
                    removeList.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println("erro " + e);
        }
        System.out.println("-----------------------------------------");
        for (ItemBeans j : removeList) {
            System.out.println("j == "+j.toString());
        }
        System.out.println("-----------------------------------------");
    }

    public ArrayList<ItemBeans> loadItem() {
        ArrayList dados = new ArrayList();
        for (ItemBeans b : itemList) {
            dados.add(new Object[]{
                b.getIdList(), b.getIdProduto(), b.getDescricao(), b.getComplemento(), b.getSigla(), conversor.stringAmountDouble(b.getQuantidade()),
                conversor.stringMoneyDouble(b.getValor()), conversor.stringMoneyDouble(b.getValor() * b.getQuantidade())
            });
        }

        return dados;

    }

    public void eraseItem() {
        itemList = new ArrayList();
        removeList = new ArrayList();
//        dados = new ArrayList();
    }

    public Boolean create(int nota, int usuario, int status) {
        ItemDao itemDao = new ItemDao();
        try {
            for (ItemBeans itemBeans : itemList) {
                if (itemBeans.getNota() == 0) {
                    itemBeans.setNota(nota);
                    itemBeans.setUsuario(usuario);
                    itemBeans.setStatus(status);
                    itemDao.save(itemBeans);
                }
            }
            delete();
            return true;
        } catch (Exception e) {
            System.out.println("######### ERRO \n" + e);
            return false;
        }

    }

    public void delete() {
        ItemDao itemDao = new ItemDao();
        try {
            for (ItemBeans itemBeans : removeList) {
                itemDao.delete(itemBeans);
            }

        } catch (Exception e) {
            System.out.println("######### ERRO \n" + e);

        }
    }

    public void PreencheItens(int id) {
        ItemDao DAOU = new ItemDao();
        for (ItemBeans u : DAOU.PreencheItem(id)) {
            addItem("" + u.getIdProduto(), "" + u.getNota(), "" + u.getComplemento(), conversor.doubleForString(u.getQuantidade()), "" + u.getId());
        }

    }
}
