/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.mymaven01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "candidato")
public class Candidato {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome_candidato")
    private String nomeCandidado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCandidado() {
        return nomeCandidado;
    }

    public void setNomeCandidado(String nomeCandidado) {
        this.nomeCandidado = nomeCandidado;
    }

}
