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
public class clsTipoPersonal {
    private int int_id_tipo_personal;
    private String str_nombre;
    private String str_descripcion;
    private int int_estado;

    public clsTipoPersonal() {
    }

    public clsTipoPersonal(int int_id_tipo_personal) {
        this.int_id_tipo_personal = int_id_tipo_personal;
    }

    public int getInt_id_tipo_personal() {
        return int_id_tipo_personal;
    }

    public void setInt_id_tipo_personal(int int_id_tipo_personal) {
        this.int_id_tipo_personal = int_id_tipo_personal;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }
    
}
