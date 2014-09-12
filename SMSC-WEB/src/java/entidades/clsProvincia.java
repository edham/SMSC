
package entidades;


public class clsProvincia {
    private int int_id_provincia;
    private String str_nombre;
    private clsDepartamento objDepartamento;

    public clsProvincia() {
    }

    public int getInt_id_provincia() {
        return int_id_provincia;
    }

    public void setInt_id_provincia(int int_id_provincia) {
        this.int_id_provincia = int_id_provincia;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }


    public clsDepartamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setObjDepartamento(clsDepartamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }

    
}
