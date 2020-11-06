package ar.com.ifts.app.model.input;

import java.util.List;

public class RequestRealizarCompraBody {

	private Long clienteId;
	
	private Long proveedorId;
	
	private List<ProductoCantidad> productosCantidades;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<ProductoCantidad> getProductosCantidades() {
		return productosCantidades;
	}

	public void setProductosCantidades(List<ProductoCantidad> productosCantidades) {
		this.productosCantidades = productosCantidades;
	}

	public Long getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(Long proveedorId) {
		this.proveedorId = proveedorId;
	}
}
