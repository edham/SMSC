
package dao;


import entidades.clsDepartamento;
import entidades.clsProvincia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

public class clsProvinciaDAO {
    
    
       public static List<clsProvincia> listarProvinciaXDepartamento(int IdDepartamento) throws Exception
    {
        List<clsProvincia> listProvincia = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT id_provincia,nombre,id_departamento FROM provincia where id_departamento="+IdDepartamento;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listProvincia == null)
                    listProvincia = new ArrayList<clsProvincia>();
                
                clsDepartamento Departamento = new clsDepartamento();
                Departamento.setInt_id_departamento(dr.getInt(3));
                
                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setInt_id_provincia(dr.getInt(1));
                objProvincia.setStr_nombre(dr.getString(2));
                objProvincia.setObjDepartamento(Departamento);

                listProvincia.add(objProvincia);
            }

        } catch (Exception e) {
            throw new Exception("Listar Provincia "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listProvincia;
    }
 
}
