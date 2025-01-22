package shopee.model;

public class Pesanan {
    private Produk produk;
    private int jumlahBeli;

    public Pesanan(Produk produk, int jumlahBeli) {
        this.produk = produk;
        this.jumlahBeli = jumlahBeli;
    }

    @Override
    public String toString() {
        return "Produk: " + produk.getNama() + ", Jumlah: " + jumlahBeli + ", Total Harga: " + (produk.getHarga() * jumlahBeli);
    }

}
