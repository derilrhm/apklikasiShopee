package shopee.model;

import java.util.ArrayList;
import java.util.List;

public class Pengguna {
    private String id;
    private String nama;
    private String email;
    private String kataSandi;
    private String role;
    private List<Pesanan> pesananList;  // Menyimpan pesanan

    // Constructor
    public Pengguna(String id, String nama, String email, String kataSandi, String role) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.kataSandi = kataSandi;
        this.role = role;
        this.pesananList = new ArrayList<>();  // Inisialisasi daftar pesanan
    }

    // Getter dan Setter untuk id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter dan Setter untuk nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan Setter untuk email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter dan Setter untuk kataSandi
    public String getKataSandi() {
        return kataSandi;
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }

    // Getter dan Setter untuk role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Getter dan Setter untuk pesananList
    public List<Pesanan> getPesananList() {
        return pesananList;
    }

    public void setPesananList(List<Pesanan> pesananList) {
        this.pesananList = pesananList;
    }

    // Metode login untuk memverifikasi email dan kata sandi
    public boolean login(String email, String kataSandi) {
        return this.email.equals(email) && this.kataSandi.equals(kataSandi);
    }

    // Menambahkan pesanan ke dalam daftar pesanan
    public void tambahPesanan(Pesanan pesanan) {
        pesananList.add(pesanan);
    }
}
