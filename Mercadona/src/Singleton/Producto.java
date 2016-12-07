package Singleton;

public class Producto {
	
int pro;
int cantidad;
int cantotal;
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
public int getCantotal() {
	return cantotal;
}
public void setCantotal(int cantotal) {
	this.cantotal = cantotal;
}
public Producto(int pro, int cantidad, int cantotal) {
	super();
	this.pro = pro;
	this.cantidad = cantidad;
	this.cantotal = cantotal;
}

}
