import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
        // Atribut jumlah task yang harus diselesaikan (integer)
        private int numTasks;
        // Atribut kecepatan menyelesaikan task (integer, nonzero positive)
        private int taskSpeed;
        // Atribut untuk mengecek apakah task sudah selesai pertama kali
        private boolean done;
        // Atribut DEFAULT_NUM_TASKS bertipe data int dengan nilai 6
        public static int DEFAULT_NUM_TASKS = 6;
        // Atribut DEFAULT_TASK_SPEED bertipe data int dengan nilai 10
        public static int DEFAULT_TASK_SPEED = 10;

        public BlueAstronaut(String name) {
                // Panggil constructor dengan parameter name, DEFAULT_SUS_LEVEL,
                // DEFAULT_NUM_TASKS, dan DEFAULT_TASK_SPEED
                super(name, Player.DEFAULT_SUS_LEVEL);
                this.numTasks = DEFAULT_NUM_TASKS;
                this.taskSpeed = DEFAULT_TASK_SPEED;
                this.done = false;
        }

        public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
                // Panggil constructor dari superclass dengan parameter name dan susLevel
                // Isi variabel numTasks dan taskSpeed dengan parameter yang sesuai
                super(name, susLevel);
                this.numTasks = numTasks;
                this.taskSpeed = taskSpeed;
                this.done = false;
        }

        /*
        
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
         * BlueAstronaut yang frozen tidak dapat menyelesaikan tugas.
         * Jika taskSpeed lebih besar dari 20, kurangi numTasks sebanyak 2. Jika tidak,
         * kurangi 1 dari numTasks.
         * Jika numTasks turun di bawah 0, tetapkan menjadi 0
         * Setelah BlueAstronaut selesai dengan tugas mereka, yang berarti numTasks sama
         * dengan 0 (hanya untuk pertama kali),
         * Cetak `"I have completed all my tasks"`
         * Kemudian kurangi susLevel BlueAstronaut sebesar 50% (dibulatkan ke bawah)
         * Tidak mengembalikan apapun.
         */
        public void completeTask() {
                if(!isFrozen()){
                        if(numTasks == 0 && !done){
                                System.out.println("I have completed all my tasks");
                                this.setSusLevel((int) (getSusLevel() * 0.5));
                                this.done = true;
                        }
                        else{
                                if(this.taskSpeed > 20){
                                        this.numTasks -= 2;
                                }
                                else{
                                        this.numTasks--;
                                }
                                if(this.numTasks <= 0){
                                        this.numTasks = 0;
                                }
                        }
                }
        }

        /*
         * Dua BlueAstronaut sama jika mereka keduanya memiliki nama yang sama, frozen,
         * susLevel, numTasks, dan taskSpeed
         * Mengembalikan sebuah boolean.
         */
        public boolean equals(Object o) {
                BlueAstronaut p = (BlueAstronaut) o;
                return super.equals(o) && p.numTasks == numTasks &&
                        p.taskSpeed == taskSpeed;
        }

        /*
         * Mengembalikan String yang menggambarkan BlueAstronaut sebagai berikut:
         * `"My name is [name], and I have a `susLevel` of [susLevel]. I am currently (frozen / not frozen). I have [numTasks] left over."
         * `
         * Jika susLevel lebih besar dari 15, kembalikan keluaran dalam huruf kapital
         * semua. (Hint: toUppercase)
         * (Note: gantikan nilai dalam tanda kurung [] dengan nilai sebenarnya)
         * Anda harus menggunakan metode toString() dari kelas Player.
         */
        public String toString() {
                String curr = super.toString();
                curr += " I have " + numTasks + " left over.";
                if(getSusLevel() > 15){
                        curr.toUpperCase();
                }
                return curr;
        }
}
