
package entidades;

public class clsDistrito {
    private int int_id_distrito;
    private String str_nombre;
    private clsProvincia objProvincia;

    public clsDistrito() {
    }

    public int getInt_id_distrito() {
        return int_id_distrito;
    }

    public void setInt_id_distrito(int int_id_distrito) {
        this.int_id_distrito = int_id_distrito;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

   
    public clsProvincia getObjProvincia() {
        return objProvincia;
    }

    public void setObjProvincia(clsProvincia objProvincia) {
        this.objProvincia = objProvincia;
    }

  
}
