package com.lawencon.penjualantiket.service;

import java.util.List;

import com.lawencon.penjualantiket.model.HeaderTransaksi;

public interface HeaderTransaksiService {
	boolean cekVocer(String vocer) throws Exception;
	double getDiskon(String vocer) throws Exception;
	void checkOut(HeaderTransaksi header) throws Exception;
	void showHistory(List<HeaderTransaksi> listHeader) throws Exception;
}
