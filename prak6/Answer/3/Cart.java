import java.util.ArrayList;
import java.util.List;

/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

public class Cart {
    /**
     * Tambahkan atribut kelas disini
     */ 
    private Account account;
    private List<Item> items;
    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    public Cart(Account account) {
        this.account = account;
        this.items = new ArrayList<Item>();
    }
    
    /**
     * Implementasi
     * return account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Implementasi
     * return list item
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Implementasi
     * menambahkan item ke dalam list item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Implementasi
     * menghapus semua item yang memiliki nama sesuai dengan parameter name
     * 
     * Apabila keranjang kosong, lempar exception "Tidak ada barang di dalam keranjang"
     * Apabila barang tidak ditemukan, lempar exception "Barang tidak ditemukan di dalam keranjang"
     */
    public void removeItem(String name) throws Exception{
        boolean exists = false;
        if(items.size() == 0){
            throw new Exception("Tidak ada barang di dalam keranjang");
        }
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equals(name)){
                items.remove(i);
                exists = true;
            }
        }
        if(!exists){
            throw new Exception("Barang tidak ditemukan di dalam keranjang");
        }
    }

    /**
     * Implementasi
     * mengembalikan total harga semua barang di dalam keranjang
     */
    public int getTotalPrice() {
        int total = 0;
        for (Item item : items) {
            total += item.getTotalPrice();
        }
        return total;
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
        if(items.size() == 0){
            throw new Exception("Keranjang kosong");
        }
        if(account.getSaldo() < getTotalPrice()){
            throw new Exception("Saldo tidak mencukupi untuk melakukan pembayaran");
        }
        else{
            account.reduceSaldo(getTotalPrice());
            items.clear();
        }
    }
}