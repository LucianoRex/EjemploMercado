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
import Singleton.Producto;

/**
 * Servlet implementation class ControlCesta
 */
@WebServlet("/ControlCesta")
public class ControlCesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Producto> cesta = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlCesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MysqlConnect c = MysqlConnect.getDbCon();
		ResultSet rs = null;

		Producto venta;
		
		int id_pedido=0;

		if (request.getParameter("incluir") != null) {
			String idprod = request.getParameter("id_prod").toString();
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			venta = new Producto(idprod, cantidad);
			cesta.add(venta);
			request.setAttribute("cesta", cesta);
			request.getRequestDispatcher("ControlLista").forward(request, response);
			//response.sendRedirect("ControlLista");
		} else if (request.getParameter("fin") != null) {
			try {
				 c.insert("INSERT INTO `pedido`( `fecha_pedido`, `cliente` ) VALUES (now(),"
						+ request.getSession().getAttribute("id") +")");
				rs=c.query("SELECT * FROM `pedido` WHERE id=(SELECT MAX(id) FROM `pedido`)");
				id_pedido=rs.getInt("id");
				 rs = c.query(
							" SELECT `pp.id`, `pp.pedido`, `pp.producto`, `pp.cantidad` ,`pd.nombre` FROM `pedido_producto` pp , `producto` pd WHERE pp.pedido="
									+ id_pedido + "and pd.id=pp.producto)");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (int i = 0; i < cesta.size(); i++) {
				try {
					c.insert("INSERT INTO `pedido_producto`( `pedido`, `producto`, `cantidad`) VALUES (" + id_pedido
							+ "," + cesta.get(i).getPro() + "," + cesta.get(i).getCantidad() + ")");

					rs = c.query(
							" SELECT `pp.id`, `pp.pedido`, `pp.producto`, `pp.cantidad` ,`pd.nombre` FROM `pedido_producto` pp , `producto` pd WHERE pp.pedido="
									+ id_pedido + "and pd.id=pp.producto)");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			request.setAttribute("cesta", rs);
			request.getRequestDispatcher("jsp/confirmacion.jsp").forward(request, response);	
		}
		

		if (request.getParameter("confirmar") != null) {
			try {
				c.insert("INSERT INTO `pedido`( `confirmacion`) VALUES 1");
				cesta.clear();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getRequestDispatcher("jsp/pedido.jsp").forward(request, response);
		} else if (request.getParameter("Cancelar") != null) {

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
