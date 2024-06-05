// Lengkapi definisi class
public class RedAstronaut extends Player implements Impostor{
        // Atribut skill bertipe data String
        private String skill;
        // Atribut DEFAULT_SKILL bertipe data String dengan nilai "experienced"
        public static String DEFAULT_SKILL = "experienced";

        public RedAstronaut(String name) {
                // Panggil constructor dengan parameter name, DEFAULT_SUS_LEVEL, dan
                // DEFAULT_SKILL
                super(name, DEFAULT_SUS_LEVEL);
                this.skill = DEFAULT_SKILL;
        }

        public RedAstronaut(String name, int susLevel, String skill) {
                // Panggil constructor dari superclass dengan parameter name dan susLevel
                // Isi variabel skill dengan parameter skill yang sudah diubah menjadi lowercase
                super(name, susLevel);
                this.skill = skill.toLowerCase();
                super.setFrozen(false);
        }

        /*
         * Player yang frozen tidak bisa melakukan emergency meeting.
         * Mengadakan meeting dan memilih untuk mengeluarkan (freeze) Player yang paling
         * mencurigakan, hanya mempertimbangkan Player yang tidak frozen
         * Player dengan susLevel tertinggi (yang BUKAN Impostor yang saat ini yang
         * memanggil pertemuan) akan dituduh sebagai Impostor dan akan dikeluarkan
         * Jika dua pemain memiliki susLevel tertinggi yang sama, tidak ada pemain yang
         * akan dikeluarkan.
         * **Hint**: Tidak perlu mengiterasi seluruh array.
         * Pastikan untuk mengubah variabel frozen dari pemain menjadi true saat
         * mengeluarkan pemain (jangan memanggil metode "freeze"!)
         * Di akhir pemungutan suara, periksa apakah permainan telah berakhir
         * menggunakan metode yang disediakan di Player.java
         * Tidak mengembalikan apapun
         */
        public void emergencyMeeting() {
                if(!this.isFrozen()){
                        int sus = -99999;
                        int count = 0;
                        int idx = 0;
                        Player[] crew = getPlayers();
                        for (int i = 0; i < crew.length; i++) {
                                if(crew[i].getSusLevel() > sus &&
                                !crew[i].isFrozen() &&
                                crew[i] != this){
                                       sus = crew[i].getSusLevel();
                                       idx = i;
                                       count = 0;
                                }
                                if(crew[i].getSusLevel() == sus){
                                        count++;
                                }
                        }
                        if(count == 1){
                                crew[idx].setFrozen(true);
                        }
                        gameOver();
                }
        }

        /*
         * Mengimplementasikan metode yang disediakan di antarmuka Impostor.
         * Tidak mungkin untuk melakukan freeze Impostor lain, dan Impostor yang frozen
         * tidak dapat mencoba untuk melakukan freeze. Jika Player yang diberikan
         * Impostor, metode harus berakhir. Melakukan freeze pada Player yang sudah beku
         * juga tidak berpengaruh apa-apa.
         * Freeze berhasil jika susLevel RedAstronaut lebih rendah dari Player tersebut
         * Jika freeze tidak berhasil, susLevel RedAstronaut berlipat ganda (kalikan
         * susLevel saat ini dengan 2)
         * Ingat untuk mengubah nilai boolean frozen untuk Crewmate sesuai kebutuhan.
         * Setelah percobaan freeze, periksa apakah permainan telah berakhir menggunakan
         * metode yang disediakan di Player.java
         * Tidak mengembalikan apapun
         */
        public void freeze(Player p) {
                if(p instanceof BlueAstronaut && (!this.isFrozen())){
                        if(compareTo(p) < 0){
                                p.setFrozen(true);
                        }
                        else{
                                this.setSusLevel(getSusLevel() * 2);
                        }
                }
                gameOver();
        }

        /*
         * Tidak mungkin menyabotase Impostor lain, dan Impostor yang frozen tidak dapat
         * menyabotase. Menyabotase Player yang frozen tidak akan berpengaruh apa-apa.
         * Jika susLevel Impostor di bawah 20, mereka meningkatkan susLevel Crewmate
         * sebesar 50%
         * Jika tidak, mereka hanya bisa meningkatkan susLevel Crewmate sebesar 25%
         * (Catatan: Dalam kedua kasus, susLevel Crewmate dibulatkan ke bawah ke nilai
         * int terdekat)
         * Tidak mengembalikan apapun
         */
        public void sabotage(Player p) {
                if(p instanceof BlueAstronaut && (!this.isFrozen())){
                        if(getSusLevel() < 20){
                                p.setSusLevel((int) (p.getSusLevel() * 1.5));
                        }
                        else{
                                p.setSusLevel((int) (p.getSusLevel() * 1.25));
                        }
                    }
        }

        /*
         * Dua Red sama jika mereka keduanya memiliki nama, frozen, susLevel, dan skill
         * yang sama
         * Mengembalikan sebuah boolean
         */
        public boolean equals(Object o) {
                if(o instanceof RedAstronaut){
                        RedAstronaut p = (RedAstronaut) o;
                        return skill.equals(p.skill) && super.equals(o);
                }
                else{
                        return false;
                }
        }

        /*
         * Mengembalikan String yang menggambarkan RedAstronaut sebagai berikut:
         * `"My name is [name], and I have a `susLevel` of [susLevel]. I am currently (frozen / not frozen). I am an [skill] player!"
         * `
         * Jika susLevel lebih besar dari 15, kembalikan keluaran dalam huruf kapital
         * semua. (Hint: toUppercase)
         * (Note: gantikan nilai dalam tanda kurung [] dengan nilai sebenarnya)
         * Anda harus menggunakan metode toString() dari kelas Player.
         */
        public String toString() {
                String curr = super.toString();
                curr += " I am an " + this.skill + " player!";
                if(super.getSusLevel() > 15){
                        curr.toUpperCase();
                }
                return curr;
        }
}
