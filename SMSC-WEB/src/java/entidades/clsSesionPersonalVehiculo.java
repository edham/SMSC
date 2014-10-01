/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsSesionPersonalVehiculo {
    private int int_sesion_personal_vehiculo;
    private Date dat_fecha_entrada;
    private Date dat_fecha_salida;
    private int int_estado;
    private clsPersonalVehiculo objPersonalVehiculo;
    private List<clsRecorridoSesionPersonalVehiculo> lista;

    public clsSesionPersonalVehiculo() {
    }

    public clsSesionPersonalVehiculo(int int_sesion_personal_vehiculo) {
        this.int_sesion_personal_vehiculo = int_sesion_personal_vehiculo;
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

    public Date getDat_fecha_salida() {
        return dat_fecha_salida;
    }

    public void setDat_fecha_salida(Date dat_fecha_salida) {
        this.dat_fecha_salida = dat_fecha_salida;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public clsPersonalVehiculo getObjPersonalVehiculo() {
        return objPersonalVehiculo;
    }

    public void setObjPersonalVehiculo(clsPersonalVehiculo objPersonalVehiculo) {
        this.objPersonalVehiculo = objPersonalVehiculo;
    }

    public List<clsRecorridoSesionPersonalVehiculo> getLista() {
        return lista;
    }

    public void setLista(List<clsRecorridoSesionPersonalVehiculo> lista) {
        this.lista = lista;
    }
    
}
