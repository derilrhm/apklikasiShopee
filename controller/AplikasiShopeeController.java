package shopee.controller;

import shopee.model.*;
import shopee.view.AplikasiShopeeView;
import java.util.HashMap;
import java.util.Map;

public class AplikasiShopeeController {

    private AplikasiShopeeView view;
    private Map<String, Pengguna> penggunaList;
    private Map<String, Produk> produkList;

    public AplikasiShopeeController() {
        this.view = new AplikasiShopeeView();
        this.penggunaList = new HashMap<>();
        this.produkList = new HashMap<>();
        initializeData();
    }

    private void initializeData() {
        
        Pengguna admin = new Pengguna("A001", "Admin", "admin@example.com", "admin123", "Admin");
        Pengguna pembeli = new Pengguna("B001", "Pembeli", "pembeli@example.com", "pembeli123", "Pembeli");
        
        penggunaList.put(admin.getEmail(), admin);
        penggunaList.put(pembeli.getEmail(), pembeli);

        
    }

    public void run() {
        while (true) {  // Loop utama aplikasi
            System.out.println("=== Selamat Datang di Aplikasi Shopee ===");
            String email = view.getUserInput("Masukkan email: ");
            String kataSandi = view.getUserInput("Masukkan kata sandi: ");
            
            Pengguna pengguna = login(email, kataSandi);

            if (pengguna != null) {
                if (pengguna.getRole().equals("Admin")) {
                    adminMenu(pengguna);  // Menu untuk admin
                } else {
                    pembeliMenu(pengguna);  // Menu untuk pembeli
                }
            } else {
                System.out.println("Email atau kata sandi salah.");
            }
        }
    }

    private Pengguna login(String email, String kataSandi) {
        Pengguna pengguna = penggunaList.get(email);
        if (pengguna != null && pengguna.login(email, kataSandi)) {
            return pengguna;
        }
        return null;
    }

    private void adminMenu(Pengguna admin) {
        while (true) {
            view.tampilkanMenuAdmin();
            int pilihan = view.getIntInput("Masukkan pilihan: ");
            
            switch (pilihan) {
                case 1: tambahProduk(); break;
                case 2: tambahStok(); break;
                case 3: pasangHarga(); break;
                case 4: hapusProduk(); break;
                case 5: return;  // Kembali ke menu login
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void pembeliMenu(Pengguna pembeli) {
        while (true) {
            view.tampilkanMenuPembeli();
            int pilihan = view.getIntInput("Masukkan pilihan: ");
            
            switch (pilihan) {
                case 1: lihatProduk(); break;
                case 2: lihatPesanan(pembeli); break;
                case 3: return;  // Kembali ke menu login
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void lihatProduk() {
        if (produkList.isEmpty()) {
            System.out.println("Tidak ada produk tersedia.");
            return;
        }
        for (Produk produk : produkList.values()) {
            view.tampilkanInfoProduk(produk.getIdProduk(), produk.getNama(), produk.getHarga(), produk.getStok());
        }
        int jumlahBeli = view.getIntInput("Masukkan jumlah produk yang ingin dibeli: ");
        String idProduk = view.getUserInput("Masukkan ID Produk: ");
        
        Produk produk = produkList.get(idProduk);
        if (produk != null) {
            if (produk.beliProduk(jumlahBeli)) {
                System.out.println("Pembelian berhasil! Total Harga: " + (produk.getHarga() * jumlahBeli));
            } else {
                System.out.println("Stok tidak mencukupi.");
            }
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    private void lihatPesanan(Pengguna pembeli) {
        if (pembeli.getPesananList().isEmpty()) {
            System.out.println("Anda belum memiliki pesanan.");
        } else {
            System.out.println("Daftar Pesanan:");
            for (Pesanan pesanan : pembeli.getPesananList()) {
                System.out.println(pesanan);
            }
        }
    }

    private void tambahProduk() {
        String idProduk = view.getUserInput("Masukkan ID Produk: ");
        String namaProduk = view.getUserInput("Masukkan Nama Produk: ");
        
        double hargaProduk = view.getDoubleInput("Masukkan Harga Produk: ");
        int stokProduk = view.getIntInput("Masukkan Stok Produk: ");
        
        Produk produk = new Produk(idProduk, namaProduk, hargaProduk, stokProduk);
        produkList.put(idProduk, produk);
        view.tampilkanInfoProduk(idProduk, namaProduk, hargaProduk, stokProduk);
    }

    private void tambahStok() {
        String idProduk = view.getUserInput("Masukkan ID Produk yang ingin ditambah stoknya: ");
        Produk produk = produkList.get(idProduk);
        
        if (produk != null) {
            int jumlahStok = view.getIntInput("Masukkan jumlah stok yang ingin ditambahkan: ");
            produk.setStok(produk.getStok() + jumlahStok);
            System.out.println("Stok berhasil ditambahkan.");
            view.tampilkanInfoProduk(produk.getIdProduk(), produk.getNama(), produk.getHarga(), produk.getStok());
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    private void pasangHarga() {
        String idProduk = view.getUserInput("Masukkan ID Produk yang ingin dipasang harganya: ");
        Produk produk = produkList.get(idProduk);
        
        if (produk != null) {
            double hargaBaru = view.getDoubleInput("Masukkan harga baru: ");
            produk.setHarga(hargaBaru);
            System.out.println("Harga produk berhasil diperbarui.");
            view.tampilkanInfoProduk(produk.getIdProduk(), produk.getNama(), produk.getHarga(), produk.getStok());
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    private void hapusProduk() {
        String idProduk = view.getUserInput("Masukkan ID Produk yang ingin dihapus: ");
        Produk produk = produkList.remove(idProduk);
        
        if (produk != null) {
            System.out.println("Produk berhasil dihapus.");
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }
}
