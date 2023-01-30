package br.com.agencia.model;

import java.util.Date;

public class Passagem {
  
  private int passagem_id;
  private int dia_viagem;
  private int mes_viagem;
  private int ano_viagem;
  private String origem;
  private String destino;
  private String Status_compra;
  private Date data_compra;
  private int cliente_id;

  public String getStatus_compra() {
    return Status_compra;
  }
  
  public void setStatus_compra(String status_compra) {
    Status_compra = status_compra;
  }

  public Date getData_compra() {
    return data_compra;
  }

  public void setData_compra(Date data_compra) {
    this.data_compra = data_compra;
  }

  public int getCliente_id() {
    return cliente_id;
  }

  public void setCliente_id(int cliente_id) {
    this.cliente_id = cliente_id;
  }

  public int getPassagemId() {
    return passagem_id;
  }

  public void setPassagemId(int passagem_id) {
    this.passagem_id = passagem_id;
  }

  public int getDiaViagem() {
    return dia_viagem;
  }

  public int getMesViagem() {
    return mes_viagem;
  }

  public int getAnoViagem() {
    return ano_viagem;
  }

  public void setDataViagem(int dia_viagem, int mes_viagem, int ano_viagem) {
    this.dia_viagem = dia_viagem;
    this.mes_viagem = mes_viagem;
    this.ano_viagem = ano_viagem;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }
}
