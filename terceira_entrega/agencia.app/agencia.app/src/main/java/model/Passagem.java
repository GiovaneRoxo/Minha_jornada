package model;

import java.sql.Date;

public class Passagem {

	private int passagem_id;
	private int fk_Cliente_cliente_id;
	private String data_viagem;
	private String destino;
	private String origem;
	private String status_compra;
	private Date data_compra;
	
	public int getPassagem_id() {
		return passagem_id;
	}
	public void setPassagem_id(int passagem_id) {
		this.passagem_id = passagem_id;
	}
	public int getFk_Cliente_cliente_id() {
		return fk_Cliente_cliente_id;
	}
	public void setFk_Cliente_cliente_id(int fk_Cliente_cliente_id) {
		this.fk_Cliente_cliente_id = fk_Cliente_cliente_id;
	}
	public String getData_viagem() {
		return data_viagem;
	}
	public void setData_viagem(String data_viagem) {
		this.data_viagem = data_viagem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getStatus_compra() {
		return status_compra;
	}
	public void setStatus_compra(String status_compra) {
		this.status_compra = status_compra;
	}
	public Date getData_compra() {
		return data_compra;
	}
	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}	
}
