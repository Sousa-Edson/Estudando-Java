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
public class ProdutoBeans extends UnidadeBeans{

    private int id;
    private String descricao;
    private String informacao;
    private int tipo;
    private boolean ativo;
    private int unidade; 
    private int usuario;
    private int ncm;
    private double valor;
     private Timestamp dataHora;

    public ProdutoBeans() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getNcm() {
        return ncm;
    }

    public void setNcm(int ncm) {
        this.ncm = ncm;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    
    

    @Override
    public String toString() {
        return "ProdutoBeans{" + "id=" + id + ", descricao=" + descricao + ", informacao=" + informacao + ", tipo=" + tipo + ", ativo=" + ativo + ", unidade=" + unidade + ", usuario=" + usuario + ", ncm=" + ncm + ", valor=" + valor + '}';
    }
    

}
