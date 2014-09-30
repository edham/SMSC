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
public class clsRecorridoSesionPersonalVehiculo {
    private int int_id_recorrido_sesion_personal_vehiculo;
    private int int_id_sesion_personal_vehiculo;
    private double dou_latitud;
    private double dou_longitud;
    private Date dat_fecha_registro;

    public clsRecorridoSesionPersonalVehiculo() {
    }

    public int getInt_id_recorrido_sesion_personal_vehiculo() {
        return int_id_recorrido_sesion_personal_vehiculo;
    }

    public void setInt_id_recorrido_sesion_personal_vehiculo(int int_id_recorrido_sesion_personal_vehiculo) {
        this.int_id_recorrido_sesion_personal_vehiculo = int_id_recorrido_sesion_personal_vehiculo;
    }

    public int getInt_id_sesion_personal_vehiculo() {
        return int_id_sesion_personal_vehiculo;
    }

    public void setInt_id_sesion_personal_vehiculo(int int_id_sesion_personal_vehiculo) {
        this.int_id_sesion_personal_vehiculo = int_id_sesion_personal_vehiculo;
    }

    public double getDou_latitud() {
        return dou_latitud;
    }

    public void setDou_latitud(double dou_latitud) {
        this.dou_latitud = dou_latitud;
    }

    public double getDou_longitud() {
        return dou_longitud;
    }

    public void setDou_longitud(double dou_longitud) {
        this.dou_longitud = dou_longitud;
    }

    public Date getDat_fecha_registro() {
        return dat_fecha_registro;
    }

    public void setDat_fecha_registro(Date dat_fecha_registro) {
        this.dat_fecha_registro = dat_fecha_registro;
    }
    
}
