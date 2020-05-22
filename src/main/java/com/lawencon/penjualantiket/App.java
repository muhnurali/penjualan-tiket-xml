package com.lawencon.penjualantiket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lawencon.penjualantiket.controller.TransaksiController;
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
		transaksiController.addKursi();

		do {
			transaksiController.showMenu();
			try {
				System.out.print("Pilih Menu : ");
				menu = sc.nextInt();
				switch (menu) {
				case 1:
					detail = new DetailTransaksi();
					transaksiController.transaksiPesawat(detail, sc, nama, kondisi, listDetail, menu, kursi);
					total = total + detail.getHarga();
					break;
				case 2:
					detail = new DetailTransaksi();
					transaksiController.transaksiKereta(detail, sc, nama, kondisi, listDetail, menu, kursi);
					total = total + detail.getHarga();
					break;
				case 3:
					detail = new DetailTransaksi();
					transaksiController.transaksiBus(detail, sc, nama, menu, kondisi, listDetail, kursi);
					total = total + detail.getHarga();
					break;
				case 4:
					transaksiController.showHistory(listHeader);
					break;
				case 9:
					header = new HeaderTransaksi();
					transaksiController.checkOut(header, menu, sc, kondisi, total, vocer, listHeader, listDetail);
					break;
				case 0:
					kondisi = false;
					System.out.println("\n===Terimakasih Sudah Menggunakan Aplikasi Ini===");
					break;
				default:
					System.out.println("Menu Tidak Ditemukan\n");
					break;
				}
			} catch (Exception e) {
				System.out.println("Inputan Salah, Hanya Angka Yang Diperbolehkan\n");
				sc.nextLine();
			}
		} while (menu != 0 || kondisi == true);
		sc.close();
	}

}
