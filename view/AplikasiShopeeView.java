package shopee.view;

import java.util.Scanner;

public class AplikasiShopeeView {

    private Scanner scanner;

    public AplikasiShopeeView() {
        scanner = new Scanner(System.in);
    }

    public void tampilkanMenuAdmin() {
        System.out.println("=== Menu Admin ===");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tambah Stok");
        System.out.println("3. Pasang Harga");
        System.out.println("4. Hapus Produk");
        System.out.println("5. Keluar");
    }

    public void tampilkanMenuPembeli() {
        System.out.println("=== Menu Pembeli ===");
        System.out.println("1. Lihat Produk");
        System.out.println("2. Lihat Pesanan");
        System.out.println("3. Keluar");
    }

    public void tampilkanInfoProduk(String idProduk, String nama, double harga, int stok) {
        System.out.println("ID Produk: " + idProduk);
        System.out.println("Nama Produk: " + nama);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public double getDoubleInput(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine());
    }
}
