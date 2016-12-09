package Singleton;

public class Producto {

	int pro;
	int cantidad;

	public int getPro() {
		return pro;
	}

	public void setPro(int pro) {
		this.pro = pro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto(int pro, int cantidad) {
		super();
		this.pro = pro;
		this.cantidad = cantidad;

	}

}
