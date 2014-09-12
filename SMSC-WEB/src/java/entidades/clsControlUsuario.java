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
public class clsControlUsuario {
    private int int_control_usuario;
    private Date dat_fecha_creacion;
    private Date dat_fecha_finalizacion;
    private clsUsuario objUsuario;
    private clsControl objControl;

    public clsControlUsuario() {
    }

    public int getInt_control_usuario() {
        return int_control_usuario;
    }

    public void setInt_control_usuario(int int_control_usuario) {
        this.int_control_usuario = int_control_usuario;
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

    public clsUsuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(clsUsuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public clsControl getObjControl() {
        return objControl;
    }

    public void setObjControl(clsControl objControl) {
        this.objControl = objControl;
    }
    
}
