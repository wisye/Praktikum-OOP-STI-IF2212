/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

public class Account {
    /**
     * Tambahkan atribut kelas disini
     */ 
    private String name;
    private int balance;
    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     * Atribut nama harus memiliki panjang karakter antara 3-20 karakter (inklusif)
     * Apabila nama tidak memenuhi ketentuan tersebut, akan dilempar exception "Nama pengguna harus terdiri dari 3-20 karakter"
     * Atribut balance/saldo tidak boleh bernilai negatif
     * Apabila tidak memenuhi ketentuan tersebut, akan dilempar exception "Tidak dapat membuat akun dengan saldo negatif"
     */
    public Account(String name, int balance) throws Exception{
        if(name.length() < 3 || name.length() > 20){
            throw new Exception("Nama pengguna harus terdiri dari 3-20 karakter");
        }
        else{
            this.name = name;
        }
        if(balance < 0){
            throw new Exception("Tidak dapat membuat akun dengan saldo negatif");
        }
        else{
            this.balance = balance;
        }
    }

    /**
     * Implementasi
     * return nama
     */
    public String getName() {
        return name;
    }


    /**
     * Implementasi
     * return balance/saldo
     */
    public int getSaldo() {
        return balance;
    }

    /**
     * Amount harus bernilai positif. Apabila tidak memenuhi, akan dilempar exception "Jumlah saldo yang ditambahkan harus lebih dari 0"
     * 
     * Implementasi
     * menambahkan amount ke balance/saldo
     */
    public void addSaldo(int amount) throws Exception {
        if(amount <= 0){
            throw new Exception("Jumlah saldo yang ditambahkan harus lebih dari 0");
        }
        else{
            balance += amount;
        }
    }

    /**
     * Amount harus bernilai positif. Apabila tidak memenuhi, akan dilempar exception "Jumlah saldo yang dikurangkan harus lebih dari 0"
     * 
     * Implementasi
     * mengurangkan amount ke balance/saldo
     */
    public void reduceSaldo(int amount) throws Exception{
        if(amount < 0){
            throw new Exception("Jumlah saldo yang dikurangkan harus lebih dari 0");
        }
        if(amount > balance){
            throw new Exception("Saldo tidak mencukupi");
        }
        balance -= amount;
    }
}