package com.lawencon.penjualantiket.service;

import java.util.List;

import com.lawencon.penjualantiket.model.DetailTransaksi;

public interface DetailTransaksiService {
	void showKeberangkatanPesawat() throws Exception;

	void showKursiPesawat(int noKeberangkatan) throws Exception;

	String selectKursiPesawat(int noKeberangkatan, int noKursi) throws Exception;

	String selectKeberangkatanPesawat(int noKeberangkatan) throws Exception;

	void addKursiPesawat() throws Exception;

	boolean cekNama(List<DetailTransaksi> listDetail, String nama) throws Exception;

	void addKursiKereta() throws Exception;

	void showKeberangkatanKereta() throws Exception;

	void showKursiKereta(int noKeberangkatan) throws Exception;

	String selectKeberangkatanKereta(int noKeberangkatan) throws Exception;

	String selectKursiKereta(int noKeberangkatan, int noKursi) throws Exception;

	void addKursiBus() throws Exception;

	void showKeberangkatanBus() throws Exception;

	void showKursiBus(int noKeberangkatan) throws Exception;

	String selectKeberangkatanBus(int noKeberangkatan) throws Exception;

	String selectKursiBus(int noKeberangkatan, int noKursi) throws Exception;
}
