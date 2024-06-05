import java.util.*;

public class PenjurusanTPB {

    public static class Mahasiswa {
        private Integer NIM;
        private String Nama;
        private Double IP;
        private Double UKT;
        
        public Mahasiswa(Integer NIM, String nama, Double IP, Double UKT) { 
            // TODO!
            this.NIM = NIM;
            this.Nama = nama;
            this.IP = IP;
            this.UKT = UKT;
        }

        public Integer getNIM() { 
            // TODO!
            return NIM;
        }
        
        public String getNama() {
            // TODO!
            return Nama;
        }

        public Double getIP() {
            // TODO!
            return IP;
        }

        public Double getUKT() {
            // TODO!
            return UKT;
        }
    }

    private static class MahasiswaComparator implements Comparator<Mahasiswa> {
        /**
         * Membandingkan Mahasiswa dengan urutan sebagai berikut:
         *  1. UKT yang lebih besar akan diprioritaskan.
         *  2. IP yang lebih besar akan diprioritaskan.
         *  3. NIM yang lebih kecil akan diprioritaskan. (NIM dipastikan unik)
         */
        public int compare(Mahasiswa mahasiswa1, Mahasiswa mahasiswa2) {
            // TODO!
            if(mahasiswa1.getUKT() > mahasiswa2.getUKT()){
                return -1;
            }
            else if(mahasiswa1.getUKT() < mahasiswa2.getUKT()){
                return 1;
            }
            else{
                if(mahasiswa1.getIP() > mahasiswa2.getIP()){
                    return -1;
                }
                else if(mahasiswa1.getIP() < mahasiswa2.getIP()){
                    return 1;
                }
                else{
                    if(mahasiswa1.getNIM() > mahasiswa2.getNIM()){
                        return 1;
                    }
                    else if(mahasiswa1.getNIM() < mahasiswa2.getNIM()){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            }
            // if(mahasiswa1.UKT != mahasiswa2.UKT){
            //     return mahasiswa1.UKT.compareTo(mahasiswa2.UKT);
            // }
            // else if(mahasiswa1.IP != mahasiswa2.IP){
            //     return mahasiswa1.IP.compareTo(mahasiswa2.IP);
            // }
            // else{
            //     return mahasiswa1.NIM.compareTo(mahasiswa2.NIM);
            // }
        }
    }

    /**
     * Menerima List<Mahasiswa> yang tidak terurut
     * Mengembalikan PriorityQueue<Mahasiswa> yang sudah terurut berdasarkan prioritas.
     */
    public static PriorityQueue<Mahasiswa> PembangkitanAntrianPrioritas(List<Mahasiswa> list) {
        // TODO!
        PriorityQueue<Mahasiswa> pq = new PriorityQueue<>(new MahasiswaComparator());

        for (Mahasiswa mahasiswa : list) {
            pq.add(mahasiswa);
        }
        return pq;
    }
}
