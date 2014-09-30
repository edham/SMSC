/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author EdHam
 */
public class clsDetallePersonalVehiculo {
    private int id_detalle_personal_vehiculo;
    private int id_personal_vehiculo;
    private clsPersonal objPersonal;

    public clsDetallePersonalVehiculo() {
    }

    public int getId_detalle_personal_vehiculo() {
        return id_detalle_personal_vehiculo;
    }

    public void setId_detalle_personal_vehiculo(int id_detalle_personal_vehiculo) {
        this.id_detalle_personal_vehiculo = id_detalle_personal_vehiculo;
    }

    public int getId_personal_vehiculo() {
        return id_personal_vehiculo;
    }

    public void setId_personal_vehiculo(int id_personal_vehiculo) {
        this.id_personal_vehiculo = id_personal_vehiculo;
    }

    public clsPersonal getObjPersonal() {
        return objPersonal;
    }

    public void setObjPersonal(clsPersonal objPersonal) {
        this.objPersonal = objPersonal;
    }
    
}
