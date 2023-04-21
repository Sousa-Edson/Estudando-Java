/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author edson
 */
public class DataHoraAtual {

    public Date DataAtual() {
        Date dataSistema = new Date();
        return dataSistema;
    }

    public String HoraAtual() {
        Calendar now = Calendar.getInstance();
        return String.format("%1$tH:%1$tM", now);

    }
}
