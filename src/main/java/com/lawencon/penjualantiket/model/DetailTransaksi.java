package com.lawencon.penjualantiket.model;

public class DetailTransaksi {
	private int idDetail;
	private String nama; 
	private String jenisTiket; 
	private String kursi; 
	private int harga; 
	private String berangkat; 
	public int getIdDetail() {
		return idDetail;
	}
	public void setIdDetail(int idDetail) {
		this.idDetail = idDetail;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getJenisTiket() {
		return jenisTiket;
	}
	public void setJenisTiket(String jenisTiket) {
		this.jenisTiket = jenisTiket;
	}
	public String getKursi() {
		return kursi;
	}
	public void setKursi(String kursi) {
		this.kursi = kursi;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	public String getBerangkat() {
		return berangkat;
	}
	public void setBerangkat(String berangkat) {
		this.berangkat = berangkat;
	}
	
	
	
}
