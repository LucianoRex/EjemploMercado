package Singleton;

public class Producto {

	String pro;
	int cantidad;

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto(String pro, int cantidad) {
		super();
		this.pro = pro;
		this.cantidad = cantidad;

	}

}
