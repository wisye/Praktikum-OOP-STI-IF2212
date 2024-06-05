public class Tablet extends StoreItem {
    private int screenSize;
    private boolean hasCellular;

    /**
     * Tablet constructor
     * @param brand
     * @param model
     * @param screenSize
     * @param hasCellular
     */
    public Tablet(String brand, String model, int screenSize, boolean hasCellular) {
        super(brand, model);
        this.screenSize = screenSize;
        this.hasCellular = hasCellular;
    }
    
    /**
     * Mencetak tambahan detail sebuah barang dengan format seperti berikut (tanpa [])
     * Cetak brand dan model dengan metode displayDetails dari class StoreItem
     * Screen size: [Ukuran layar dengan satuan inches]
     * Has cellular: [Apabila hasCellular, maka cetak Yes, selain itu No]
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Screen size: %d inches\n", this.screenSize);
        if(this.hasCellular){
            System.out.printf("Has cellular: Yes\n");
        }
        else{
            System.out.printf("Has cellular: No\n");
        }
    }

    /**
     * Menghitung harga dari tablet
     * Apabila nama brand "Legowo", maka rumus: 300 + (Ukuran layar * 5) + (Jika touch screen, tambahkan 50)
     * Selain nama brand "Legowo", rumus: 300 + (Ukuran layar * 15) + (Jika touch screen, tambahkan 150)
     */
    @Override
    public int calculatePrice() {
        if(super.getBrand() == "Legowo"){
            if(this.hasCellular){
                return 300 + (this.screenSize * 5) + 50;
            }
            else{
                return 300 + (this.screenSize * 5);
            }
        }
        else{
            if(this.hasCellular){
                return 300 + (this.screenSize * 15) + 150;
            }
            else{
                return 300 + (this.screenSize * 15);
            }
        }
    }
}
