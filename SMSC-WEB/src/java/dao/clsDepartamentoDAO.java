
package dao;


import entidades.clsDepartamento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

public class clsDepartamentoDAO {    
    public static List<clsDepartamento> listarDepartamento() throws Exception {
        List<clsDepartamento> listDepartamento = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT id_departamento,nombre FROM departamento";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listDepartamento == null)
                    listDepartamento = new ArrayList<clsDepartamento>();
                    clsDepartamento Departamento = new clsDepartamento();
                    Departamento.setInt_id_departamento(dr.getInt(1));
                    Departamento.setStr_nombre(dr.getString(2));
                    listDepartamento.add(Departamento);
            }
        } catch (Exception e) {
            throw new Exception("Listar Departamento "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listDepartamento;
    } 
}
