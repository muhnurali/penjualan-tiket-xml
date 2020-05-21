package com.lawencon.penjualantiket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lawencon.penjualantiket.controller.TransaksiController;
import com.lawencon.penjualantiket.model.Constants;
import com.lawencon.penjualantiket.model.DetailTransaksi;
import com.lawencon.penjualantiket.model.HeaderTransaksi;

/**
 * MUHAMMAD NUR ALI
 */
public class App {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 0, kursi = 0;
		double total = 0;
		String vocer = "", nama = "";
		boolean kondisi = true;

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-setter.xml");
		TransaksiController transaksiController = context.getBean("transaksiController", TransaksiController.class);

		DetailTransaksi detail;
		HeaderTransaksi header;
		List<HeaderTransaksi> listHeader = new ArrayList<>();
		List<DetailTransaksi> listDetail = new ArrayList<>();
		transaksiController.addKursiPesawat();
		transaksiController.addKursiKereta();
		transaksiController.addKursiBus();

		do {
			showMenu();
			try {
				System.out.print("Pilih Menu : ");
				menu = sc.nextInt();
				switch (menu) {
				case 1:
					detail = new DetailTransaksi();
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
						} else if (transaksiController.cekNama(listDetail, nama) == true) {
							System.out.println("Nama sudah terdaftar");
							kondisi = false;
						} else {
							detail.setNama(nama);
							kondisi = true;
						}
					} while (kondisi == false);

					transaksiController.showKeberangkatanPesawat();
					do {
						try {
							System.out.print("Pilih Jadwal Keberangkatan : ");
							menu = sc.nextInt();
							if (transaksiController.showKursiPesawat(menu) == true) {
								detail.setBerangkat(transaksiController.selectKeberangkatanPesawat(menu));
								kondisi = true;
							} else {
								kondisi = false;
							}
						} catch (Exception e) {
							kondisi = false;
						}
					} while (kondisi == false);
					do {
						System.out.print("Pilih Menu : ");
						kursi = sc.nextInt();
						try {
							detail.setKursi(transaksiController.selectKursi(menu, kursi));
							kondisi = true;
						} catch (Exception e) {
							kondisi = false;
						}
					} while (kondisi == false);
					listDetail.add(detail);
					total = total + detail.getHarga();
					break;
				case 2:
					detail = new DetailTransaksi();
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
						} else if (transaksiController.cekNama(listDetail, nama) == true) {
							System.out.println("Nama sudah terdaftar");
							kondisi = false;
						} else {
							detail.setNama(nama);
							kondisi = true;
						}
					} while (kondisi == false);

					transaksiController.showKeberangkatanKereta();
					do {
						try {
							System.out.print("Pilih Jadwal Keberangkatan : ");
							menu = sc.nextInt();
							if (transaksiController.showKursiKereta(menu) == true) {
								detail.setBerangkat(transaksiController.selectKeberangkatanKereta(menu));
								kondisi = true;
							} else {
								kondisi = false;
							}
						} catch (Exception e) {
							kondisi = false;
						}
					} while (kondisi == false);
					do {
						System.out.print("Pilih Menu : ");
						kursi = sc.nextInt();
						try {
							detail.setKursi(transaksiController.selectKursiKereta(menu, kursi));
							kondisi = true;
						} catch (Exception e) {
							kondisi = false;
						}
					} while (kondisi == false);
					listDetail.add(detail);
					total = total + detail.getHarga();
					break;
				case 3:
					detail = new DetailTransaksi();
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
						} else if (transaksiController.cekNama(listDetail, nama) == true) {
							System.out.println("Nama sudah terdaftar");
							kondisi = false;
						} else {
							detail.setNama(nama);
							kondisi = true;
						}
					} while (kondisi == false);

					transaksiController.showKeberangkatanBus();
					do {
						try {
							System.out.print("Pilih Jadwal Keberangkatan : ");
							menu = sc.nextInt();
							if (transaksiController.showKursiBus(menu) == true) {
								detail.setBerangkat(transaksiController.selectKeberangkatanBus(menu));
								kondisi = true;
							} else {
								kondisi = false;
							}
						} catch (Exception e) {
							kondisi = false;
						}
					} while (kondisi == false);
					do {
						System.out.print("Pilih Menu : ");
						kursi = sc.nextInt();
						try {
							detail.setKursi(transaksiController.selectKursiBus(menu, kursi));
							kondisi = true;
						} catch (Exception e) {
							kondisi = false;
						}
					} while (kondisi == false);
					listDetail.add(detail);
					total = total + detail.getHarga();
					break;
				case 4:
					transaksiController.showHistory(listHeader);
					break;
				case 9:
					header = new HeaderTransaksi();
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
									} else if (transaksiController.cekVocer(vocer) == true) {
										header.setVocer(vocer);
										header.setDiskon(transaksiController.getDiskon(vocer));
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
					transaksiController.checkOut(header);
					total = 0;
					listDetail = new ArrayList<>();
					break;
				case 0:
					kondisi = false;
					System.out.println("\n===Terimakasih Sudah Menggunakan Aplikasi Ini===");
					break;
				default:
					System.out.println("\nMenu Tidak Ditemukan");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("\nInputan Salah, Hanya Angka Yang Diperbolehkan");
				sc.nextLine();
			}
		} while (menu != 0 || kondisi == true);
		sc.close();
	}
	
	private static void showMenu() {
		System.out.println("===Penjualan Tiket===");
		System.out.println("1. Tiket Pesawat");
		System.out.println("2. Tiket Kereta");
		System.out.println("3. Tiket Bus");
		System.out.println("4. History");
		System.out.println("9. Checkout");
		System.out.println("0. Exit");
	}
}
