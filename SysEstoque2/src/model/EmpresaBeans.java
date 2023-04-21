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
/* registro_produto timestamp NULL, */
public class EmpresaBeans {

    private int id_empresa;
    private String nome_empresa;
    private String cnpj_empresa;
    private String inscricao_empresa;
    private String descricao_empresa;
    private String telefone_empresa;
    private String endereco_empresa;
    private String no_empresa;
    private String cep_empresa;
    private String complemento_empresa;
    private String bairro_empresa;
    private String cidade_empresa;
    private String observacao_empresa;
    private boolean cliente_empresa;
    private boolean fornecedor_empresa;

    private boolean ativo;
    private int usuario;
    private Timestamp dataHora;

    public EmpresaBeans() {
    }

    public EmpresaBeans(int id_empresa, String nome_empresa, String cnpj_empresa, String inscricao_empresa, String descricao_empresa, String telefone_empresa, String endereco_empresa, String no_empresa, String cep_empresa, String complemento_empresa, String bairro_empresa, String cidade_empresa, String observacao_empresa, boolean cliente_empresa, boolean fornecedor_empresa, boolean ativo, int usuario, Timestamp dataHora) {
        this.id_empresa = id_empresa;
        this.nome_empresa = nome_empresa;
        this.cnpj_empresa = cnpj_empresa;
        this.inscricao_empresa = inscricao_empresa;
        this.descricao_empresa = descricao_empresa;
        this.telefone_empresa = telefone_empresa;
        this.endereco_empresa = endereco_empresa;
        this.no_empresa = no_empresa;
        this.cep_empresa = cep_empresa;
        this.complemento_empresa = complemento_empresa;
        this.bairro_empresa = bairro_empresa;
        this.cidade_empresa = cidade_empresa;
        this.observacao_empresa = observacao_empresa;
        this.cliente_empresa = cliente_empresa;
        this.fornecedor_empresa = fornecedor_empresa;
        this.ativo = ativo;
        this.usuario = usuario;
        this.dataHora = dataHora;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void setCnpj_empresa(String cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    public String getInscricao_empresa() {
        return inscricao_empresa;
    }

    public void setInscricao_empresa(String inscricao_empresa) {
        this.inscricao_empresa = inscricao_empresa;
    }

    public String getDescricao_empresa() {
        return descricao_empresa;
    }

    public void setDescricao_empresa(String descricao_empresa) {
        this.descricao_empresa = descricao_empresa;
    }

    public String getTelefone_empresa() {
        return telefone_empresa;
    }

    public void setTelefone_empresa(String telefone_empresa) {
        this.telefone_empresa = telefone_empresa;
    }

    public String getEndereco_empresa() {
        return endereco_empresa;
    }

    public void setEndereco_empresa(String endereco_empresa) {
        this.endereco_empresa = endereco_empresa;
    }

    public String getNo_empresa() {
        return no_empresa;
    }

    public void setNo_empresa(String no_empresa) {
        this.no_empresa = no_empresa;
    }

    public String getCep_empresa() {
        return cep_empresa;
    }

    public void setCep_empresa(String cep_empresa) {
        this.cep_empresa = cep_empresa;
    }

    public String getComplemento_empresa() {
        return complemento_empresa;
    }

    public void setComplemento_empresa(String complemento_empresa) {
        this.complemento_empresa = complemento_empresa;
    }

    public String getBairro_empresa() {
        return bairro_empresa;
    }

    public void setBairro_empresa(String bairro_empresa) {
        this.bairro_empresa = bairro_empresa;
    }

    public String getCidade_empresa() {
        return cidade_empresa;
    }

    public void setCidade_empresa(String cidade_empresa) {
        this.cidade_empresa = cidade_empresa;
    }

    public String getObservacao_empresa() {
        return observacao_empresa;
    }

    public void setObservacao_empresa(String observacao_empresa) {
        this.observacao_empresa = observacao_empresa;
    }

    public boolean isCliente_empresa() {
        return cliente_empresa;
    }

    public void setCliente_empresa(boolean cliente_empresa) {
        this.cliente_empresa = cliente_empresa;
    }

    public boolean isFornecedor_empresa() {
        return fornecedor_empresa;
    }

    public void setFornecedor_empresa(boolean fornecedor_empresa) {
        this.fornecedor_empresa = fornecedor_empresa;
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

    @Override
    public String toString() {
        return nome_empresa;
    }
}
