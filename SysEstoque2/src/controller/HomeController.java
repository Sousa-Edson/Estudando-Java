/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import view.EmpresaForm;
import view.EntradaForm;
import view.HomeForm;
import view.NcmForm;
import view.ProdutoForm;
import view.TipoForm;
import view.UnidadeForm;

/**
 *
 * @author edson
 */
public class HomeController {

    private HomeForm view;

    public HomeController(HomeForm view) {
        this.view = view;

    }
    Color backendIn = new java.awt.Color(100, 100, 100);
    Color backendOut = new java.awt.Color(255, 255, 255);
    Color backendClik = new java.awt.Color(255, 0, 255);

    public void hover(java.awt.event.MouseEvent evt, int area) {
//        System.out.println("##\n" + evt.toString());
        Color back = evt.paramString().contains("MOUSE_ENTERED") == true ? backendIn : evt.paramString().contains("MOUSE_CLICKED") == true ? backendClik : backendOut;
        Color front = evt.paramString().contains("MOUSE_ENTERED") == true ? Color.yellow : Color.black;

        switch (area) {
            case 1:
                view.getPnDashBoard().setBackground(back);
                view.getLblDashBoard().setForeground(front);
                break;
            case 2:
                view.getPnPedido().setBackground(back);
                view.getLblPedido().setForeground(front);
                break;
            case 3:
                view.getPnExpedicao().setBackground(back);
                view.getLblExpedicao().setForeground(front);
                break;
            case 4:
                view.getPnProduto().setBackground(back);
                view.getLblProduto().setForeground(front);
                break;
            case 5:
                view.getPnEntrada().setBackground(back);
                view.getLblEntrada().setForeground(front);
                break;
            case 6:
                view.getPnMais().setBackground(back);
                view.getLblMais().setForeground(front);
                break;

            case 7:
                view.getPnHome().setBackground(back);
                view.getLblHome().setForeground(front);
                break;

            case 8:
                view.getPnUnidade().setBackground(back);
                view.getLblUnidade().setForeground(front);
                break;

            case 9:
                view.getPnRelatorio().setBackground(back);
                view.getLblRelatorio().setForeground(front);
                break;

            case 10:
                view.getPnNcm().setBackground(back);
                view.getLblNcm().setForeground(front);
                break;

            case 11:
                view.getPnCfop().setBackground(back);
                view.getLblCfop().setForeground(front);
                break;

            case 12:
                view.getPnMais2().setBackground(back);
                view.getLblMais2().setForeground(front);
                break;

            case 13:
                view.getPnConfiguracao().setBackground(back);
                view.getLblConfiguracao().setForeground(front);
                break;

            case 14:
                view.getPnEmpresa1().setBackground(back);
                view.getLblEmpresa1().setForeground(front);
                break;

            case 15:
                view.getPnUsuario().setBackground(back);
                view.getLblUsuario().setForeground(front);
                break;

            case 16:
                view.getPnHome1().setBackground(back);
                view.getLblHome1().setForeground(front);
                break;

            case 17:
                view.getPnBranco1().setBackground(back);
                view.getLblMais2().setForeground(front);
                break;

            case 18:
                view.getPnBranco2().setBackground(back);
                view.getLblMais2().setForeground(front);
                break;
            default:
                throw new AssertionError();
        }

    }

    public void showPainel11() {
        view.getPnModo1().setVisible(true);
        view.getPnModo2().setVisible(!true);
        view.getPnModo3().setVisible(!true);
    }

    public void showPainel12() {
        view.getPnModo1().setVisible(!true);
        view.getPnModo2().setVisible(true);
        view.getPnModo3().setVisible(!true);
    }

    public void showPainel13() {
        view.getPnModo1().setVisible(!true);
        view.getPnModo2().setVisible(!true);
        view.getPnModo3().setVisible(true);
    }

    public void showUnidade() {
        UnidadeForm unidadeForm = new UnidadeForm();
        unidadeForm.setVisible(true);
    }

    public void showProduto() {
        ProdutoForm produtoForm = new ProdutoForm();
        produtoForm.setVisible(true);
    }

    public void showNcm() {
        NcmForm ncmForm = new NcmForm();
        ncmForm.setVisible(true);
    }

    public void showTipo() {
        TipoForm tipoForm = new TipoForm();
        tipoForm.setVisible(true);
    }
    
    public void showEntrada() {
        EntradaForm entradaForm = new EntradaForm();
        entradaForm.setVisible(true);
    }
     public void showEmpresa() {
       EmpresaForm empresaForm = new EmpresaForm();
        empresaForm.setVisible(true);
    }
}
