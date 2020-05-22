package com.lawencon.penjualantiket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lawencon.penjualantiket.model.DetailTransaksi;
import com.lawencon.penjualantiket.model.HeaderTransaksi;

@Service
public class HeaderTransaksiServiceImpl implements HeaderTransaksiService {

	private String[] vocer = { "VC001", "VC002", "VC003" };

	@Override
	public boolean cekVocer(String vocer) throws Exception {
		if (vocer.equals(this.vocer[0])) {
			return true;
		} else if (vocer.equals(this.vocer[1])) {
			return true;
		} else if (vocer.equals(this.vocer[2])) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double getDiskon(String vocer) throws Exception {
		if (vocer.equals(this.vocer[0])) {
			return 0.2;
		} else if (vocer.equals(this.vocer[1])) {
			return 0.3;
		} else if (vocer.equals(this.vocer[2])) {
			return 0.5;
		} else {
			return 0;
		}
	}

	@Override
	public void checkOut(HeaderTransaksi header) throws Exception {
		double total = header.getListDetail().stream().mapToDouble(DetailTransaksi::getHarga).sum();
		System.out.println("=== TRANSAKSI PEMBELIAN TIKET ===");
		System.out.println("Id Transaksi : " + header.getIdHeader());

		header.getListDetail().forEach(x -> {
			System.out.println("--------------------------------");
			System.out.println("Nama : " + x.getNama());
			System.out.println("Jenis Tiket : " + x.getJenisTiket());
			System.out.println("Tanggal Berangkat : " + x.getBerangkat());
			System.out.println("Kursi : " + x.getKursi());
			System.out.println("Harga : " + x.getHarga());
		});
		System.out.println("--------------------------------");
		System.out.println("Total : Rp. " + total);
		System.out.println("Vocer : " + header.getVocer());
		System.out.println("Diskon : " + (header.getDiskon() * 100) + "%");
		System.out.println("Total Bayar : Rp. " + header.getTotal());
		System.out.println("=================================\n");
	}

	@Override
	public void showHistory(List<HeaderTransaksi> listHeader) throws Exception {
		System.out.println("=== HISTORY TRANSAKSI ===");
		listHeader.forEach(x -> {
			System.out.println("Id Transaksi : " + x.getIdHeader());
			System.out.println("Vocer : " + x.getVocer());
			System.out.println("Diskon : " + (x.getDiskon() * 100) + "%");
			System.out.println("Total Bayar : Rp. " + x.getTotal());
			x.getListDetail().forEach(y -> {
				System.out.println("--------------------------------");
				System.out.println("Nama : " + y.getNama());
				System.out.println("Jenis Tiket : " + y.getJenisTiket());
				System.out.println("Tanggal Berangkat : " + y.getBerangkat());
				System.out.println("Kursi : " + y.getKursi());
				System.out.println("Harga : " + y.getHarga());
			});
			System.out.println("=================================\n");
		});
	}

}
