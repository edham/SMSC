/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.Date;

/**
 *
 * @author EdHam
 */
public class clsVehiculo {
    private int int_id_vehiculo;
    private String str_marca;
    private String str_modelo;
    private String str_placa;
    private String str_numero;
    private Date dat_fecha_registro;
    private Date dat_fecha_actualizacion;
    public int int_estado;

    public clsVehiculo() {
    }

    public clsVehiculo(int int_id_vehiculo) {
        this.int_id_vehiculo = int_id_vehiculo;
    }

    public int getInt_id_vehiculo() {
        return int_id_vehiculo;
    }

    public void setInt_id_vehiculo(int int_id_vehiculo) {
        this.int_id_vehiculo = int_id_vehiculo;
    }

    public String getStr_marca() {
        return str_marca;
    }

    public void setStr_marca(String str_marca) {
        this.str_marca = str_marca;
    }

    public String getStr_modelo() {
        return str_modelo;
    }

    public void setStr_modelo(String str_modelo) {
        this.str_modelo = str_modelo;
    }

    public String getStr_placa() {
        return str_placa;
    }

    public void setStr_placa(String str_placa) {
        this.str_placa = str_placa;
    }

    public String getStr_numero() {
        return str_numero;
    }

    public void setStr_numero(String str_numero) {
        this.str_numero = str_numero;
    }

    public Date getDat_fecha_registro() {
        return dat_fecha_registro;
    }

    public void setDat_fecha_registro(Date dat_fecha_registro) {
        this.dat_fecha_registro = dat_fecha_registro;
    }

    public Date getDat_fecha_actualizacion() {
        return dat_fecha_actualizacion;
    }

    public void setDat_fecha_actualizacion(Date dat_fecha_actualizacion) {
        this.dat_fecha_actualizacion = dat_fecha_actualizacion;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }
    
}
