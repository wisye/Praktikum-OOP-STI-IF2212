/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

public class Cart {
    /**
     * Tambahkan atribut kelas disini
     */ 

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    public Cart(Account account) {
    
    }
    
    /**
     * Implementasi
     * return account
     */
    public Account getAccount() {
    
    }

    /**
     * Implementasi
     * return list item
     */
    public List<Item> getItems() {
    
    }

    /**
     * Implementasi
     * menambahkan item ke dalam list item
     */
    public void addItem(Item item) {
    
    }

    /**
     * Implementasi
     * menghapus semua item yang memiliki nama sesuai dengan parameter name
     * 
     * Apabila keranjang kosong, lempar exception "Tidak ada barang di dalam keranjang"
     * Apabila barang tidak ditemukan, lempar exception "Barang tidak ditemukan di dalam keranjang"
     */
    public void removeItem(String name) {
    
    }

    /**
     * Implementasi
     * mengembalikan total harga semua barang di dalam keranjang
     */
    public int getTotalPrice() {
    
    }

    /**
     * Implementasi
     * mengurangi saldo sejumlah total harga semua barang
     * mengosongkan keranjang
     * 
     * Apabila keranjang kosong, lempar exception "Keranjang kosong"
     * Apabila saldo tidak mencukupi, lempar exception "Saldo tidak mencukupi untuk melakukan pembayaran"
     */
    public void checkout() throws Exception {
    
    }
}