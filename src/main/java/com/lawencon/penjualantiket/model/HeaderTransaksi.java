package com.lawencon.penjualantiket.model;

import java.util.List;

public class HeaderTransaksi {
	private int idHeader;
	private double total;	
	private String vocer;
	private double diskon;
	private List<DetailTransaksi> listDetail;
	
	public int getIdHeader() {
		return idHeader;
	}
	public String getVocer() {
		return vocer;
	}
	public void setVocer(String vocer) {
		this.vocer = vocer;
	}
	public double getDiskon() {
		return diskon;
	}
	public void setDiskon(double diskon) {
		this.diskon = diskon;
	}
	public List<DetailTransaksi> getListDetail() {
		return listDetail;
	}
	public void setListDetail(List<DetailTransaksi> listDetail) {
		this.listDetail = listDetail;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public void setIdHeader(int idHeader) {
		this.idHeader = idHeader;
	}
	
	
	
}
