package servert;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Singleton.MysqlConnect;

/**
 * Servlet implementation class ControlCesta
 */
@WebServlet("/ControlCesta")
public class ControlCesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlCesta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MysqlConnect c = MysqlConnect.getDbCon();
		ResultSet rs=null;
		ArrayList<Producto> cesta = new ArrayList<>();
	
		if (request.getParameter("incluir")!=null){
		
		
			try {
				
				rs=c.query(" SELECT pro.id, pro.nombre, pro.peso, pro.precio, pro.imagen, pro.descripcion FROM producto pro");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("producto", rs);
			request.getRequestDispatcher("jsp/listaproductos.jsp").forward(request, response);
			
		
		}
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
