/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.seguridad.entidades;

import java.util.Date;

/**
 *
 * @author EdHam
 */
public class clsSesionPersonalVehiculo {
    private int int_sesion_personal_vehiculo;
    private Date dat_fecha_entrada;
    private String str_vehiculoe_marca;
    private String str_vehiculoe_modelo;
    private String str_vehiculoe_placa;
    private String str_vehiculoe_numero;

    public clsSesionPersonalVehiculo(String entidad) {
        String [] parametro = entidad.split("\\<+parametro+>");   
        this.int_sesion_personal_vehiculo = Integer.parseInt(parametro[0].trim());        
        this.dat_fecha_entrada = new Date(Long.parseLong(parametro[1].trim()));
        this.str_vehiculoe_marca = parametro[2].trim();
        this.str_vehiculoe_modelo = parametro[3].trim();
        this.str_vehiculoe_placa = parametro[4].trim();
        this.str_vehiculoe_numero = parametro[5].trim();
    }
    
    public clsSesionPersonalVehiculo() {
    }

    public int getInt_sesion_personal_vehiculo() {
        return int_sesion_personal_vehiculo;
    }

    public void setInt_sesion_personal_vehiculo(int int_sesion_personal_vehiculo) {
        this.int_sesion_personal_vehiculo = int_sesion_personal_vehiculo;
    }

    public Date getDat_fecha_entrada() {
        return dat_fecha_entrada;
    }

    public void setDat_fecha_entrada(Date dat_fecha_entrada) {
        this.dat_fecha_entrada = dat_fecha_entrada;
    }

    public String getStr_vehiculoe_marca() {
        return str_vehiculoe_marca;
    }

    public void setStr_vehiculoe_marca(String str_vehiculoe_marca) {
        this.str_vehiculoe_marca = str_vehiculoe_marca;
    }

    public String getStr_vehiculoe_modelo() {
        return str_vehiculoe_modelo;
    }

    public void setStr_vehiculoe_modelo(String str_vehiculoe_modelo) {
        this.str_vehiculoe_modelo = str_vehiculoe_modelo;
    }

    public String getStr_vehiculoe_placa() {
        return str_vehiculoe_placa;
    }

    public void setStr_vehiculoe_placa(String str_vehiculoe_placa) {
        this.str_vehiculoe_placa = str_vehiculoe_placa;
    }

    public String getStr_vehiculoe_numero() {
        return str_vehiculoe_numero;
    }

    public void setStr_vehiculoe_numero(String str_vehiculoe_numero) {
        this.str_vehiculoe_numero = str_vehiculoe_numero;
    }


}
