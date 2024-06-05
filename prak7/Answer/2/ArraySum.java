import java.util.ArrayList;

/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

public class ArraySum {
    // nWorkers menyatakan jumlah maksimum threads yang tersedia
    private int nWorkers;
    // array untuk menampung array masukan
    private Integer[] arr;
    /**
     * Tambahkan atribut kelas yang dibutuhkan
     */ 

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    ArraySum(int nWorkers, Integer[] arr) {
        this.nWorkers = nWorkers;
        this.arr = arr;

    }

    /**
     * Implementasi
     * method sum akan membuat sejumlah thread dan memetakan array masukan secara merata ke semua threads yang dapat dibuat
     */
    public int sum() throws InterruptedException {
        if(nWorkers > arr.length){
            nWorkers = arr.length;
        }
        Thread[] thread = new Thread[nWorkers];
        int chunkSize = (int) Math.floor((double) arr.length/nWorkers);
        int[] sumArr = new int[nWorkers];
        try{
            for(int i = 0; i < nWorkers; i++){
                int start = i * chunkSize;
                int end;
                if(i == nWorkers - 1){
                    end = arr.length;
                }
                else{
                    end = start + chunkSize;
                }
                final int tmp = i;
                thread[i] = new Thread(new Runnable() {
                    @Override
                    public void run(){
                        sumArr[tmp] = partialSum(start, end);
                    }
                });
                thread[i].start();
            }

            for (Thread t : thread) {
                t.join();
            }
        }
        catch(InterruptedException e){
            throw new InterruptedException();
        }

        int retval = 0;
        for (int i : sumArr) {
            retval += i;
        }

        return retval;
    }

    /**
     * Implementasi
     * method partialSum akan melakukan penjumlahan elemen-elemen array pada index `start` sampai `end-1`
     */
    protected int partialSum(int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}