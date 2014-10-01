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
public class clsRespuestaIncidente {
    private int int_id_respuesta_incidente;    
    private Date dat_fecha_creacion;
    private Date dat_fecha_finalizacion;
    private String str_descripccion;
    private byte[] byte_foto;
    private int int_estado;
    private clsIncidente objIncidente;
    private clsSesionPersonalVehiculo objSesionPersonalVehiculo;

    public clsRespuestaIncidente() {
        this.byte_foto=null;
    }

    public clsRespuestaIncidente(int int_id_respuesta_incidente) {
        this.int_id_respuesta_incidente = int_id_respuesta_incidente;
    }

    public int getInt_id_respuesta_incidente() {
        return int_id_respuesta_incidente;
    }

    public void setInt_id_respuesta_incidente(int int_id_respuesta_incidente) {
        this.int_id_respuesta_incidente = int_id_respuesta_incidente;
    }

    public Date getDat_fecha_creacion() {
        return dat_fecha_creacion;
    }

    public void setDat_fecha_creacion(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }

    public Date getDat_fecha_finalizacion() {
        return dat_fecha_finalizacion;
    }

    public void setDat_fecha_finalizacion(Date dat_fecha_finalizacion) {
        this.dat_fecha_finalizacion = dat_fecha_finalizacion;
    }

    public String getStr_descripccion() {
        return str_descripccion;
    }

    public void setStr_descripccion(String str_descripccion) {
        this.str_descripccion = str_descripccion;
    }

    public byte[] getByte_foto() {
        return byte_foto;
    }

    public void setByte_foto(byte[] byte_foto) {
        this.byte_foto = byte_foto;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public clsIncidente getObjIncidente() {
        return objIncidente;
    }

    public void setObjIncidente(clsIncidente objIncidente) {
        this.objIncidente = objIncidente;
    }

    public clsSesionPersonalVehiculo getObjSesionPersonalVehiculo() {
        return objSesionPersonalVehiculo;
    }

    public void setObjSesionPersonalVehiculo(clsSesionPersonalVehiculo objSesionPersonalVehiculo) {
        this.objSesionPersonalVehiculo = objSesionPersonalVehiculo;
    }
    
}
