public class Ucrypt {

    /**
     * Mengembalikan string yang telah dihash
     * 
     * Hash dilakukan dengan cara:
     * 1. Mengubah kata menjadi bahasa Umandana
     * 2. Menggeser karakter sebanyak huruf vokal pada kata awal
     * 3. Apabila karakter merupakan digit angka maka:
     * 3.1 Digit diubah menjadi huruf kecil sesuai urutan alfabet (a urutan ke-0)
     * 3.2 Karakter kemudian digeser sebanyak huruf vokal pada kata awal
     * Contoh: hash(tes123) = tepreses123 -> ufqsftftcde
     * 
     * @param word kata yang akan dihash
     * @return kata yang telah dihash
     */
    public static StringBuilder hash(String word) {
        int cnt = word.replaceAll("[^aiueoAIUEO]", "").length();
        String um = Umandana.toUmandana(word);

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < um.length(); i++) {
            if(Character.isDigit(um.charAt(i))){
                tmp.append((char)(Character.getNumericValue(um.charAt(i)) + 'a'));
            }
            else{
                tmp.append(um.charAt(i));
            }
        }

        StringBuilder retval = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            retval.append((char)((tmp.charAt(i) + cnt - 'a') % 26 + 'a'));
        }
        return retval;
    }

    /**
     * Mengecek apakah parameter hashed merupakan parameter plain yang telah dihash
     * 
     * @param plain  kata sebelum dihash
     * @param hashed kata setelah dihash
     * @return true apabila hashed merupakan plain yang telah dihash
     */
    public static boolean compare(String plain, String hashed) {
        return (hash(plain)).toString().equals(hashed);
    }
}
