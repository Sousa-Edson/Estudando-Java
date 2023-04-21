/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author edson
 */
public class ItemBeans extends ProdutoBeans {

    private int id;
    private int idProduto;
    private int nota;
    private String complemento;
    private Double quantidade;
    private boolean ativo; //alterar aqui
    private int usuario;
    private Timestamp dataHora;
    private int status;
       private int idList;

    public ItemBeans() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    @Override
    public String toString() {
        return "ItemBeans{" + "id=" + id + ", idProduto=" + idProduto + ", nota=" + nota + ", complemento=" + complemento + ", quantidade=" + quantidade + ", ativo=" + ativo + ", usuario=" + usuario + ", dataHora=" + dataHora + ", status=" + status + ", idList=" + idList + '}';
    }
    

}
