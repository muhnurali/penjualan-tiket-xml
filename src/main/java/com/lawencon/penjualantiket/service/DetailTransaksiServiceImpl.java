package com.lawencon.penjualantiket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lawencon.penjualantiket.model.DetailTransaksi;

@Service
public class DetailTransaksiServiceImpl implements DetailTransaksiService {

	private String[] keberangkatanPesawat = { "Jakarta-Bali, Senin, 25 Mei 2020, 08:00 WIB",
			"Jakarta-Bali, Selasa, 26 Mei 2020, 13:00 WIB", "Jakarta-Bali, Rabu, 27 Mei 2020, 19:00 WIB" };

	private List<String> kursiPesawat1 = new ArrayList<String>();
	private List<String> kursiPesawat2 = new ArrayList<String>();
	private List<String> kursiPesawat3 = new ArrayList<String>();

	private String[] keberangkatanKereta = { "Jakarta-Sumedang, Kamis, 28 Mei 2020, 08:00 WIB",
			"Jakarta-Sumedang, Jumat, 29 Mei 2020, 13:00 WIB", "Jakarta-Sumedang, Sabtu, 30 Mei 2020, 19:00 WIB" };

	private List<String> kursiKereta1 = new ArrayList<String>();
	private List<String> kursiKereta2 = new ArrayList<String>();
	private List<String> kursiKereta3 = new ArrayList<String>();

	private String[] keberangkatanBus = { "Jakarta- Bandung, Minggu, 31 Mei 2020, 08:00 WIB",
			"Jakarta- Bandung, Senin, 1 Juni 2020, 13:00 WIB", "Jakarta- Bandung, Selasa, 2 Juni 2020, 19:00 WIB" };

	private List<String> kursiBus1 = new ArrayList<String>();
	private List<String> kursiBus2 = new ArrayList<String>();
	private List<String> kursiBus3 = new ArrayList<String>();

	public void showKeberangkatanPesawat() throws Exception {
		System.out.println("=== Jadwal Keberangkatan Pesawat ===");
		for (int i = 0; i < keberangkatanPesawat.length; i++) {
			System.out.println(i + 1 + ". " + keberangkatanPesawat[i]);
		}
	}

	public void addKursiPesawat() throws Exception {
		kursiPesawat1.add("P1");
		kursiPesawat1.add("P2");
		kursiPesawat1.add("P3");
		kursiPesawat2.add("P1");
		kursiPesawat2.add("P2");
		kursiPesawat2.add("P3");
		kursiPesawat3.add("P1");
		kursiPesawat3.add("P2");
		kursiPesawat3.add("P3");
	}

	@Override
	public void showKursiPesawat(int noKeberangkatan) throws Exception {
		switch (noKeberangkatan) {
		case 1:
			System.out.println("=== Kursi ===");
			for (int i = 0; i < kursiPesawat1.size(); i++) {
				System.out.println(i + 1 + ". " + kursiPesawat1.get(i));
			}
			break;
		case 2:
			System.out.println("=== Kursi ===");
			for (int i = 0; i < kursiPesawat2.size(); i++) {
				System.out.println(i + 1 + ". " + kursiPesawat2.get(i));
			}
			break;
		case 3:
			System.out.println("=== Kursi ===");
			for (int i = 0; i < kursiPesawat3.size(); i++) {
				System.out.println(i + 1 + ". " + kursiPesawat3.get(i));
			}
			break;
		default:
			throw new Exception();
		}
	}

	@Override
	public String selectKursiPesawat(int noKeberangkatan, int noKursi) throws Exception {
		String temp = "";
		switch (noKeberangkatan) {
		case 1:
			temp = kursiPesawat1.get(noKursi - 1);
			kursiPesawat1.remove(noKursi - 1);
			break;
		case 2:
			temp = kursiPesawat2.get(noKursi - 1);
			kursiPesawat2.remove(noKursi - 1);
			break;
		case 3:
			temp = kursiPesawat3.get(noKursi - 1);
			kursiPesawat3.remove(noKursi - 1);
			break;
		default:
			throw new Exception();
		}
		return temp;
	}

	@Override
	public String selectKeberangkatanPesawat(int noKeberangkatan) throws Exception {
		String temp = "";
		switch (noKeberangkatan) {
		case 1:
			temp = keberangkatanPesawat[0];
			return temp;
		case 2:
			temp = keberangkatanPesawat[1];
			return temp;
		case 3:
			temp = keberangkatanPesawat[2];
			return temp;
		default:
			throw new Exception();
		}
	}

	@Override
	public boolean cekNama(List<DetailTransaksi> listDetail, String nama) throws Exception {
		List<DetailTransaksi> temp = listDetail.stream().filter((x) -> {
			return x.getNama().equals(nama);
		}).collect(Collectors.toList());
		if (!temp.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addKursiKereta() throws Exception {
		kursiKereta1.add("K1");
		kursiKereta1.add("K2");
		kursiKereta1.add("K3");
		kursiKereta2.add("K1");
		kursiKereta2.add("K2");
		kursiKereta2.add("K3");
		kursiKereta3.add("K1");
		kursiKereta3.add("K2");
		kursiKereta3.add("K3");
	}

	@Override
	public void showKeberangkatanKereta() throws Exception {
		System.out.println("=== Jadwal Keberangkatan Kereta ===");
		for (int i = 0; i < keberangkatanKereta.length; i++) {
			System.out.println(i + 1 + ". " + keberangkatanKereta[i]);
		}
	}

	@Override
	public void showKursiKereta(int noKeberangkatan) throws Exception {
		switch (noKeberangkatan) {
		case 1:
			System.out.println("=== Kursi ===");
			for (int i = 0; i < kursiKereta1.size(); i++) {
				System.out.println(i + 1 + ". " + kursiKereta1.get(i));
			}
			break;
		case 2:
			System.out.println("=== Kursi ===");
			for (int i = 0; i < kursiKereta2.size(); i++) {
				System.out.println(i + 1 + ". " + kursiKereta2.get(i));
			}
			break;
		case 3:
			System.out.println("=== Kursi ===");
			for (int i = 0; i < kursiKereta3.size(); i++) {
				System.out.println(i + 1 + ". " + kursiKereta3.get(i));
			}
			break;
		default:
			throw new Exception();
		}
	}

	@Override
	public String selectKursiKereta(int noKeberangkatan, int noKursi) throws Exception {
		String temp = "";
		switch (noKeberangkatan) {
		case 1:
			temp = kursiKereta1.get(noKursi - 1);
			kursiKereta1.remove(noKursi - 1);
			break;
		case 2:
			temp = kursiKereta2.get(noKursi - 1);
			kursiKereta2.remove(noKursi - 1);
			break;
		case 3:
			temp = kursiKereta3.get(noKursi - 1);
			kursiKereta3.remove(noKursi - 1);
			break;
		default:
			throw new Exception();
		}
		return temp;
	}

	@Override
	public String selectKeberangkatanKereta(int noKeberangkatan) throws Exception {
		String temp = "";
		switch (noKeberangkatan) {
		case 1:
			temp = keberangkatanKereta[0];
			return temp;
		case 2:
			temp = keberangkatanKereta[1];
			return temp;
		case 3:
			temp = keberangkatanKereta[2];
			return temp;
		default:
			throw new Exception();
		}
	}

	@Override
	public void addKursiBus() throws Exception {
		kursiBus1.add("B1");
		kursiBus1.add("B2");
		kursiBus1.add("B3");
		kursiBus2.add("B1");
		kursiBus2.add("B2");
		kursiBus2.add("B3");
		kursiBus3.add("B1");
		kursiBus3.add("B2");
		kursiBus3.add("B3");
	}

	@Override
	public void showKeberangkatanBus() throws Exception {
		System.out.println("=== Jadwal Keberangkatan Bus ===");
		for (int i = 0; i < keberangkatanBus.length; i++) {
			System.out.println(i + 1 + ". " + keberangkatanBus[i]);
		}
	}

	@Override
	public void showKursiBus(int noKeberangkatan) throws Exception {
		switch (noKeberangkatan) {
		case 1:
			System.out.println("=== Kursi ===");
			for (int i = 0; i < kursiBus1.size(); i++) {
				System.out.println(i + 1 + ". " + kursiBus1.get(i));
			}
			break;
		case 2:
			System.out.println("=== Kursi ===");
			for (int i = 0; i < kursiBus2.size(); i++) {
				System.out.println(i + 1 + ". " + kursiBus2.get(i));
			}
			break;
		case 3:
			System.out.println("=== Kursi ===");
			for (int i = 0; i < kursiBus3.size(); i++) {
				System.out.println(i + 1 + ". " + kursiBus3.get(i));
			}
			break;
		default:
			throw new Exception();
		}
	}

	@Override
	public String selectKeberangkatanBus(int noKeberangkatan) throws Exception {
		String temp = "";
		switch (noKeberangkatan) {
		case 1:
			temp = keberangkatanBus[0];
			return temp;
		case 2:
			temp = keberangkatanBus[1];
			return temp;
		case 3:
			temp = keberangkatanBus[2];
			return temp;
		default:
			throw new Exception();
		}
	}

	@Override
	public String selectKursiBus(int noKeberangkatan, int noKursi) throws Exception {
		String temp = "";
		switch (noKeberangkatan) {
		case 1:
			temp = kursiBus1.get(noKursi - 1);
			kursiBus1.remove(noKursi - 1);
			break;
		case 2:
			temp = kursiBus2.get(noKursi - 1);
			kursiBus2.remove(noKursi - 1);
			break;
		case 3:
			temp = kursiBus3.get(noKursi - 1);
			kursiBus3.remove(noKursi - 1);
			break;
		default:
			throw new Exception();
		}
		return temp;
	}

}
