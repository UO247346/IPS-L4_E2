package ui.presupuestos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import logic.CreaPresupuestoController;
import logic.dto.Producto;
import java.awt.Dimension;


public class ProductosPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblName;
	private JPanel container;
	private JButton btnEliminiar;
	private Producto producto;
	private CreaPresupuestosView creaPresupuesto;
	private CreaPresupuestoController presController;
	private JLabel lblTipo;
	private JLabel lblPrecio;
	private CatalogoPanel cg;


	public ProductosPanel(Producto p, JPanel container, CreaPresupuestosView creaPresupuesto, CreaPresupuestoController presController, CatalogoPanel cg) {
		setBackground(Color.WHITE);
		this.container = container;
		this.producto = p;
		this.creaPresupuesto = creaPresupuesto;
		this.presController = presController;
		this.cg = cg;
		setLayout(new GridLayout(0, 4, 0, 0));
		add(getLblName());
		add(getLblTipo());
		add(getLblPrecio());
		add(getBtnEliminar());
		getLblName().setText(p.getNombre());
		getLblTipo().setText(p.getTipo());
		getLblPrecio().setText(Double.toString(p.getPrecio()));
		this.setVisible(true);
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("New label");
			lblName.setBackground(Color.WHITE);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblName;
	}
	private JButton getBtnEliminar() {
		if (btnEliminiar == null) {
			btnEliminiar = new JButton("Eliminar");
			btnEliminiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarProducto();
				}
			});
			btnEliminiar.setToolTipText((String) null);
			btnEliminiar.setForeground(Color.BLACK);
			btnEliminiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnEliminiar.setBackground(Color.ORANGE);
		}
		return btnEliminiar;
	}

	/**
	 * metodo que elimina un producto del presupuesto, mira si despues de eliminar el producto
	 * queda alguno y si no es as� desabilita el bot�n de crear presupuesto
	 */
	protected void eliminarProducto() {
		creaPresupuesto.getTxtTotal().setText(presController.updateTotalEliminarProduct(producto));
		//para que no se pueda crear un presupuesto, si no tienes
		//productos en el
		if(!presController.hasProductosEnCompra()) {
			creaPresupuesto.getBtnCreate().setEnabled(false);
		}
		container.remove(this);
		cg.getBtnAniadir().setEnabled(true);
		//hago esto para que se muestren los cambios en el panel
		container.setVisible(false);
		container.setVisible(true);
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("New label");
			lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblTipo;
	}
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel("New label");
			lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblPrecio;
	}
}
