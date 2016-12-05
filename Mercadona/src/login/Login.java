package login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Singleton.MysqlConnect;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom= request.getParameter("nombre");
		String pasrword= request.getParameter("pasrword");
		String apellido1=request.getParameter("apellido1");
		String apellido2=request.getParameter("apellido2");
		String direccion=request.getParameter("direccion");
		String usuario=request.getParameter("usuario");
		String edad=request.getParameter("edad");
		
		
		MysqlConnect c = MysqlConnect.getDbCon();
		
		if(request.getParameter("registrarte")!=null){		
			
			try {
				
				c.insert("INSERT INTO cliente (nombre,apellido1,apellido2,direccion,edad,usuario,contrasena)  VALUES ('"+nom+"','"+apellido1+"','"+apellido2+"','"
				+direccion+"','"+edad+"','"+usuario+"','"+pasrword+"');");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("jsp/usuario.jsp").forward(request, response);
			
		}
		else{
			
			ResultSet rs=null;
			try {
				
				
				rs = c.query("SELECT * FROM cliente WHERE usuario='"+usuario+"' AND contrasena='"+pasrword+"'");
				if(rs.next()){
					request.getSession().setAttribute("usuario", rs.getString("nombre"));
					request.getSession().setAttribute("id", rs.getString(1));	
					request.setAttribute("clientes", rs);
					request.getRequestDispatcher("jsp/usuario.jsp").forward(request, response);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
