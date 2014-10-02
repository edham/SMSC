
<%@page import="dao.clsConexion"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.DriverManager"%>
<%       
 if(request.getParameter("Id") != null && request.getParameter("Id") != "" )
   {
Blob image = null;
		Connection con = null;
		byte[] imgData = null ;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			
			con = clsConexion.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select foto from personal where  id_personal ="+request.getParameter("Id"));
			if (rs.next()) {
				image = rs.getBlob(1);
				imgData = image.getBytes(1,(int)image.length());
			} else {
				out.println("Display Blob Example");
				out.println("image not found for given id>");
				return;
			}
	// display the image
         response.setContentType("image/gif");
         OutputStream o = response.getOutputStream();
         o.write(imgData);
         o.flush();
         o.close();
		} catch (Exception e) {
			out.println("Unable To Display image");
			out.println("Image Display Error=" + e.getMessage());
			return;
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
	%>