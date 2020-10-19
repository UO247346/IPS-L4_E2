package logic.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {

	private String ID_Presupuesto;
	private int DNI_Cliente;
	private LocalDateTime fecha;
	private double precio;
	private List<Producto> productos = new ArrayList<>();

	public Presupuesto(String iD_Presupuesto, int dNI_Cliente, LocalDateTime fecha, double precio,
			List<Producto> productos) {
		super();
		ID_Presupuesto = iD_Presupuesto;
		DNI_Cliente = dNI_Cliente;
		this.fecha = fecha;
		this.precio = precio;
		this.productos = productos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public String getID_Presupuesto() {
		return ID_Presupuesto;
	}

	public void setID_Presupuesto(String iD_Presupuesto) {
		ID_Presupuesto = iD_Presupuesto;
	}

	public int getDNI_Cliente() {
		return DNI_Cliente;
	}

	public void setDNI_Cliente(int dNI_Cliente) {
		DNI_Cliente = dNI_Cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}