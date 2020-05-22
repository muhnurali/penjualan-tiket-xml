package com.lawencon.penjualantiket.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;

import com.lawencon.penjualantiket.model.Constants;
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

	public void transaksiPesawat(DetailTransaksi detail, Scanner sc, String nama, Boolean kondisi,
			List<DetailTransaksi> listDetail, int menu, int kursi) {
		detail.setIdDetail(ThreadLocalRandom.current().nextInt());
		detail.setJenisTiket("Pesawat");
		detail.setHarga(Constants.HARGA_PESAWAT);
		System.out.println("=== Pembelian Tiket Pesawat ===");
		sc.nextLine();
		do {
			System.out.print("Nama Pemesan : ");
			nama = sc.nextLine();
			if (nama.equals("")) {
				System.out.println("Inputan Kosong");
				kondisi = false;
			} else if (listDetail.isEmpty()) {
				detail.setNama(nama);
				kondisi = true;
			} else if (this.cekNama(listDetail, nama) == true) {
				System.out.println("Nama sudah terdaftar");
				kondisi = false;
			} else {
				detail.setNama(nama);
				kondisi = true;
			}
		} while (kondisi == false);

		this.showKeberangkatanPesawat();
		do {
			try {
				System.out.print("Pilih Jadwal Keberangkatan : ");
				menu = sc.nextInt();
				if (this.showKursiPesawat(menu) == true) {
					detail.setBerangkat(this.selectKeberangkatanPesawat(menu));
					kondisi = true;
				} else {
					kondisi = false;
				}
			} catch (Exception e) {
				System.out.println("Inputan Hanya Angka Yang Diperbolehkan");
				kondisi = false;
				sc.nextLine();
			}
		} while (kondisi == false);
		do {
			System.out.print("Pilih Kursi : ");
			kursi = sc.nextInt();
			try {
				detail.setKursi(this.selectKursi(menu, kursi));
				kondisi = true;
			} catch (Exception e) {
				System.out.println("Inputan Hanya Angka Yang Diperbolehkan");
				kondisi = false;
				sc.nextLine();
			}
		} while (kondisi == false);
		listDetail.add(detail);
	}

	public void transaksiKereta(DetailTransaksi detail, Scanner sc, String nama, boolean kondisi,
			List<DetailTransaksi> listDetail, int menu, int kursi) {
		detail.setIdDetail(ThreadLocalRandom.current().nextInt());
		detail.setJenisTiket("Kereta");
		detail.setHarga(Constants.HARGA_KERETA);
		System.out.println("=== Pembelian Tiket Kereta ===");
		sc.nextLine();
		do {
			System.out.print("Nama Pemesan : ");
			nama = sc.nextLine();
			if (nama.equals("")) {
				System.out.println("Inputan Kosong");
				kondisi = false;
			} else if (listDetail.isEmpty()) {
				detail.setNama(nama);
				kondisi = true;
			} else if (this.cekNama(listDetail, nama) == true) {
				System.out.println("Nama sudah terdaftar");
				kondisi = false;
			} else {
				detail.setNama(nama);
				kondisi = true;
			}
		} while (kondisi == false);

		this.showKeberangkatanKereta();
		do {
			try {
				System.out.print("Pilih Jadwal Keberangkatan : ");
				menu = sc.nextInt();
				if (this.showKursiKereta(menu) == true) {
					detail.setBerangkat(this.selectKeberangkatanKereta(menu));
					kondisi = true;
				} else {
					System.out.println("Inputan Hanya Angka Yang Diperbolehkan");
					kondisi = false;
					sc.nextLine();
				}
			} catch (Exception e) {
				System.out.println("Inputan Hanya Angka Yang Diperbolehkan");
				kondisi = false;
				sc.nextLine();
			}
		} while (kondisi == false);
		do {
			System.out.print("Pilih Kursi : ");
			kursi = sc.nextInt();
			try {
				detail.setKursi(this.selectKursiKereta(menu, kursi));
				kondisi = true;
			} catch (Exception e) {
				System.out.println("Inputan Hanya Angka Yang Diperbolehkan");
				kondisi = false;
				sc.nextLine();
			}
		} while (kondisi == false);
		listDetail.add(detail);
	}

	public void transaksiBus(DetailTransaksi detail, Scanner sc, String nama, int menu, boolean kondisi,
			List<DetailTransaksi> listDetail, int kursi) {
		detail.setIdDetail(ThreadLocalRandom.current().nextInt());
		detail.setJenisTiket("Bus");
		detail.setHarga(Constants.HARGA_BUS);
		System.out.println("=== Pembelian Tiket Bus ===");
		sc.nextLine();
		do {
			System.out.print("Nama Pemesan : ");
			nama = sc.nextLine();
			if (nama.equals("")) {
				System.out.println("Inputan Kosong");
				kondisi = false;
			} else if (listDetail.isEmpty()) {
				detail.setNama(nama);
				kondisi = true;
			} else if (this.cekNama(listDetail, nama) == true) {
				System.out.println("Nama sudah terdaftar");
				kondisi = false;
			} else {
				detail.setNama(nama);
				kondisi = true;
			}
		} while (kondisi == false);

		this.showKeberangkatanBus();
		do {
			try {
				System.out.print("Pilih Jadwal Keberangkatan : ");
				menu = sc.nextInt();
				if (this.showKursiBus(menu) == true) {
					detail.setBerangkat(this.selectKeberangkatanBus(menu));
					kondisi = true;
				} else {
					kondisi = false;
				}
			} catch (Exception e) {
				System.out.println("Inputan Hanya Angka Yang Diperbolehkan");
				kondisi = false;
				sc.nextLine();
			}
		} while (kondisi == false);
		do {
			System.out.print("Pilih Kursi : ");
			kursi = sc.nextInt();
			try {
				detail.setKursi(this.selectKursiBus(menu, kursi));
				kondisi = true;
			} catch (Exception e) {
				System.out.println("Inputan Hanya Angka Yang Diperbolehkan");
				kondisi = false;
				sc.nextLine();
			}
		} while (kondisi == false);
		listDetail.add(detail);
	}

	public void checkOut(HeaderTransaksi header, int menu, Scanner sc, boolean kondisi, double total, String vocer,
			List<HeaderTransaksi> listHeader, List<DetailTransaksi> listDetail) {
		header.setIdHeader(ThreadLocalRandom.current().nextInt());

		do {
			System.out.print("Gunakan Vocer ? 1. Ya, 2. Tidak : ");
			try {
				menu = sc.nextInt();
				if (menu < 1 && menu > 2) {
					System.out.println("Menu Tidak Ditemukan");
					kondisi = false;
				} else {
					if (menu == 1) {
						sc.nextLine();
						System.out.print("Masukan Kode Vocer : ");
						vocer = sc.nextLine();
						if (vocer.equals("")) {
							System.out.println("Vocer Tidak Ditemukan");
							kondisi = false;
						} else if (this.cekVocer(vocer) == true) {
							header.setVocer(vocer);
							header.setDiskon(this.getDiskon(vocer));
							System.out.println("Anda mendapatkan diskon " + header.getDiskon() * 100 + "%");
							kondisi = true;
						} else {
							header.setVocer("");
							System.out.println("Vocer Tidak Ditemukan");
							kondisi = true;
						}
					} else if (menu == 2) {
						kondisi = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Inputan Salah, Hanya Angka Yang Diperbolehkan");
				kondisi = false;
				sc.nextLine();
			}
		} while (kondisi == false);

		total = total - (total * header.getDiskon());
		header.setTotal(total);
		header.setListDetail(listDetail);
		listHeader.add(header);
		this.checkOut(header);
		total = 0;
		listDetail = new ArrayList<>();
	}

	public void showMenu() {
		System.out.println("===Penjualan Tiket===");
		System.out.println("1. Tiket Pesawat");
		System.out.println("2. Tiket Kereta");
		System.out.println("3. Tiket Bus");
		System.out.println("4. History");
		System.out.println("9. Checkout");
		System.out.println("0. Exit");
	}

	public void addKursi() {
		this.addKursiPesawat();
		this.addKursiKereta();
		this.addKursiBus();
	}
}
