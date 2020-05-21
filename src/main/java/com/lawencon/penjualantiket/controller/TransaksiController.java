package com.lawencon.penjualantiket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lawencon.penjualantiket.model.DetailTransaksi;
import com.lawencon.penjualantiket.model.HeaderTransaksi;
import com.lawencon.penjualantiket.service.DetailTransaksiService;
import com.lawencon.penjualantiket.service.HeaderTransaksiService;

public class TransaksiController {
	@Autowired
	private DetailTransaksiService detailService;

	@Autowired
	private HeaderTransaksiService headerService;

	public void showKeberangkatanPesawat() {
		try {
			detailService.showKeberangkatanPesawat();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean showKursiPesawat(int noKeberangkatan) {
		try {
			detailService.showKursiPesawat(noKeberangkatan);
			return true;
		} catch (Exception e) {
			System.out.println("Jadwal Keberangkatan Tidak Ditemukan");
			return false;
		}
	}

	public String selectKursi(int noKeberangkatan, int noKursi) {
		try {
			return detailService.selectKursiPesawat(noKeberangkatan, noKursi);
		} catch (Exception e) {
			return "Kursi tidak ditemukan";
		}
	}

	public void addKursiPesawat() {
		try {
			detailService.addKursiPesawat();
		} catch (Exception e) {
		}
	}

	public String selectKeberangkatanPesawat(int noKeberangkatan) {
		try {
			return detailService.selectKeberangkatanPesawat(noKeberangkatan);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public boolean cekVocer(String vocer) {
		try {
			if (headerService.cekVocer(vocer) == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public double getDiskon(String vocer) {
		try {
			return headerService.getDiskon(vocer);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public void checkOut(HeaderTransaksi header) {
		try {
			headerService.checkOut(header);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showHistory(List<HeaderTransaksi> listHeader) {
		try {
			headerService.showHistory(listHeader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean cekNama(List<DetailTransaksi> listDetail, String nama) {
		try {
			return detailService.cekNama(listDetail, nama);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void addKursiKereta() {
		try {
			detailService.addKursiKereta();
		} catch (Exception e) {
		}
	}
	public void showKeberangkatanKereta() {
		try {
			detailService.showKeberangkatanKereta();
		} catch (Exception e) {
		}
	}
	public boolean showKursiKereta(int noKeberangkatan) {
		try {
			detailService.showKursiKereta(noKeberangkatan);
			return true;
		} catch (Exception e) {
			System.out.println("Jadwal Keberangkatan Tidak Ditemukan");
			return false;
		}
	}
	public String selectKeberangkatanKereta(int noKeberangkatan) {
		try {
			return detailService.selectKeberangkatanKereta(noKeberangkatan);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public String selectKursiKereta(int noKeberangkatan, int noKursi) {
		try {
			return detailService.selectKursiKereta(noKeberangkatan, noKursi);
		} catch (Exception e) {
			return "Kursi tidak ditemukan";
		}
	}
	
	public void addKursiBus() {
		try {
			detailService.addKursiBus();
		} catch (Exception e) {
		}
	}
	public void showKeberangkatanBus() {
		try {
			detailService.showKeberangkatanBus();
		} catch (Exception e) {
		}
	}
	public boolean showKursiBus(int noKeberangkatan) {
		try {
			detailService.showKursiBus(noKeberangkatan);
			return true;
		} catch (Exception e) {
			System.out.println("Jadwal Keberangkatan Tidak Ditemukan");
			return false;
		}
	} 
	public String selectKeberangkatanBus(int noKeberangkatan) {
		try {
			return detailService.selectKeberangkatanBus(noKeberangkatan);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public String selectKursiBus(int noKeberangkatan, int noKursi) {
		try {
			return detailService.selectKursiBus(noKeberangkatan, noKursi);
		} catch (Exception e) {
			return "Kursi tidak ditemukan";
		}
	}
}
