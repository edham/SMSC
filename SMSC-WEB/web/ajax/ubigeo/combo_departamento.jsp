<%@page import="entidades.clsDepartamento"%>
<%@page import="java.util.List"%>
<%@page import="com.clsGestor"%>
 <select id="cbDepartamento" name="cbDepartamento" onchange="getProvincia(this.value)" title="Por favor selecione un departamento!" required>
        <option value="">Selecione un Departamento</option>
      <%  List<clsDepartamento> ListDepartamento = clsGestor.listarDepartamento();
          if(ListDepartamento!=null) 
            for(clsDepartamento objDepartamento : ListDepartamento ) {%>

            <option value="<%=objDepartamento.getInt_id_departamento()%>"><%=objDepartamento.getStr_nombre()%></option>
         <%  }%>
</select>