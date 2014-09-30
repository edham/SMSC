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
public class clsPersonalVehiculo {
    private int int_id_personal_vehiculo;
    private Date dat_fecha_registro;
    private int int_estado;
    private List<clsDetallePersonalVehiculo> lista;

    public clsPersonalVehiculo() {
    }

    public int getInt_id_personal_vehiculo() {
        return int_id_personal_vehiculo;
    }

    public void setInt_id_personal_vehiculo(int int_id_personal_vehiculo) {
        this.int_id_personal_vehiculo = int_id_personal_vehiculo;
    }

    public Date getDat_fecha_registro() {
        return dat_fecha_registro;
    }

    public void setDat_fecha_registro(Date dat_fecha_registro) {
        this.dat_fecha_registro = dat_fecha_registro;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public List<clsDetallePersonalVehiculo> getLista() {
        return lista;
    }

    public void setLista(List<clsDetallePersonalVehiculo> lista) {
        this.lista = lista;
    }
    
}
