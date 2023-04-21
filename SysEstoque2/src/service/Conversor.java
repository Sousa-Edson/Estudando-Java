/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author edson
 */
public class Conversor {

    public String limitString(String texto, int tamanho) {
        try {
            return texto.substring(0, tamanho);
        } catch (Exception e) {
            return texto;
        }

    }

    //converter double para string
    public String doubleForString(Double d) {
        String txt = "";
        try {
            Locale ptBr = new Locale("pt", "BR");
            txt = NumberFormat.getInstance(ptBr).format(d);
        } catch (Exception e) {
            txt = "";
        }
        return txt;
    }

    // converter string em double
    public double stringForDouble(String txt) {
        Double v = 0.0;
        String valor = txt.replace(".", "").replace(",", ".");
        try {
            v = Double.valueOf(valor);
        } catch (Exception e) {
            v = 0.0;
        }
        return v;
    }

    // converter data e hora para string
    public String DataAtual(Date dt) {
        try {
            return "Atualizado em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dt);

        } catch (Exception e) {
        }
        return "Atualizado em: vazio";
    }

    // converter string em formato data
    public String stringFormatDate(String texto) {
        String txt = texto.replace("/", "").replace("-", "");
        String dia = "", mes = "", ano = "";
        System.out.println("tamanho " + txt.length());

        if (txt.length() >= 8) {
            dia = txt.substring(0, 2) + "-" + txt.substring(2, 4) + "-" + txt.substring(4, 6) + txt.substring(6, 8);
            txt = dia;
        }
        return txt;
    }

    // converter string em formato hora
    public String stringFormatHour(String txt) {
        txt = txt.replace(":", "").replace(" ", "");
        if (!txt.matches("^[0-9]*$")) {
            txt = "";
        } else {
            if (txt.length() >= 4) {
                int h = Integer.parseInt(txt.substring(0, 2));
                int m = Integer.parseInt(txt.substring(2, 4));
                txt = txt.substring(0, 2) + ":" + txt.substring(2, 4);
                if (h > 23 | m > 59) {
                    txt = "";
                }
            }
        }
        return txt;
    }

    // converter string em dinheiro
    public String stringMoney(String txt) {
        String retorno = "0";
        Double dValor = 0.0;
        txt = txt.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".").trim();
        if (txt == null | txt.equals("") | txt == (null) | " ".equals(txt)) {
            System.out.println("Interface.ProdCadastroJIF.ManipulaValor()");
        } else {
            try {
                dValor = Double.valueOf(txt);
            } catch (Exception e) {
                System.err.println("##ERRO\nservice.Conversor.stringMoney()\n" + e);
            }
            BigDecimal df = new BigDecimal(dValor);
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            nf.setMinimumFractionDigits(3);
            retorno = nf.format(df);
        }
        return retorno;
    }
    // converter double em dinheiro

    public String stringMoneyDouble(Double dValor) {
        String retorno = "0";
        BigDecimal df = new BigDecimal(dValor);
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMinimumFractionDigits(3);
        retorno = nf.format(df);
        return retorno;
    }
    // converter string em quantidade

    public String stringAmount(String txt) {
        String retorno = "0";
        Double dValor = 0.0;
        txt = txt.replace(" ", "").replace(".", "").replace(",", ".").trim();
        if (txt == null | txt.equals("") | txt == (null) | " ".equals(txt)) {
            System.out.println("Interface.ProdCadastroJIF.ManipulaValor()");
        } else {
            try {
                dValor = Double.valueOf(txt);
            } catch (Exception e) {
                System.err.println("##ERRO\nservice.Conversor.stringAmount()\n" + e);
            }
            BigDecimal df = new BigDecimal(dValor);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(3);
            retorno = nf.format(df);
        }
        return retorno;
    }
    // converter double em quantidade

    public String stringAmountDouble(Double dValor) {
        String retorno = "0";
        BigDecimal df = new BigDecimal(dValor);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(3);
        retorno = nf.format(df);
        return retorno;
    }
    // receber apenas numero inteiro

    public String stringForInteger(String txt) {
        if (txt.matches("^[0-9]*$")) {
            return (txt);
        }
        return "0";
    }
}
