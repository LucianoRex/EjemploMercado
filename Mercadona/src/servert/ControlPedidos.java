package servert;

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
 * Servlet implementation class ControlPedidos
 */
@WebServlet("/ControlPedidos")
public class ControlPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlPedidos() {
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
		MysqlConnect c = MysqlConnect.getDbCon();
		ResultSet rs=null;
			try {
				
				rs=c.query(" SELECT pro.nombre, pro.peso, pro.precio, pro.imagen, pro.descripcion FROM producto pro");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("producto", rs);
			request.getRequestDispatcher("jsp/pedidos.jsp").forward(request, response);
			
		
		
		
		
	}

}
