import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accounts;

    /**
     * AccountManager constructor
     * 
     * Menginisiasi ArrayList Account
     */
    public AccountManager() {

    }

    /**
     * Mengecek apakah format username valid
     * Username dikatakan valid jika:
     * 1. Terdiri minimal dari 5 karakter
     * 2. Terdiri dari alfanumerik (huruf dan angka)
     * 
     * @param username username yang akan dicek
     * @return true jika sesuai ketentuan username yang valid
     */
    private static boolean isValidUsername(String username) {

    }

    /**
     * Mengecek apakah password merupakan password yang kuat
     * Password dikatakan kuat jika:
     * 1. Terdiri minimal dari 8 karakter
     * 2. Terdiri dari alfanumerik (huruf dan angka)
     * 3. Minimal terdiri dari 1 huruf dan 1 angka
     * 
     * @param password password yang akan dicek
     * @return true jika sesuai ketentuan password yang kuat
     */
    private static boolean isStrongPassword(String password) {

    }

    /**
     * Menambahkan akun baru ke dalam atribut accounts
     * 
     * Akun dapat ditambahkan jika:
     * 1. Username valid, jika tidak valid maka
     * mencetak pesan "Username tidak valid"
     * 2. Username belum terdafta, jika terdaftar maka
     * mencetak pesan "Username telah digunakan"
     * 3. Password kuat, jika tidak kuat maka
     * mencetak pesan "Password tidak cukup kuat"
     * 
     * Pengecekan dilakukan berurut berdasarkan penjelasan di atas
     * Apabila memenuhi syarat di atas, maka akun ditambahkan
     * dan password disimpan dalam format hash,
     * kemudian mencetak pesan "Akun berhasil didaftarkan"
     * 
     * @param username username dari akun baru
     * @param password password dari akun baru dalam format tidak dihash
     */
    public void addAccount(String username, String password) {

    }

    /**
     * Masuk ke akun yang telah didaftarkan
     * 
     * Apabila username akun tidak terdaftar
     * maka akan mencetak pesan "Akun tidak terdaftar"
     * 
     * Apabila password akun salah
     * maka akan mencetak pesan "Password yang dimasukkan salah"
     * 
     * Apabila username dan password sesuai
     * maka akan mencetak pesan "Berhasil masuk"
     * 
     * @param username username dari akun
     * @param password password dari akun dalam format tidak dihash
     */
    public void login(String username, String password) {

    }
}
