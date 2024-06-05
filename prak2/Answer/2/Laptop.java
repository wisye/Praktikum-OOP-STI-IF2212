public class Laptop extends StoreItem {
    private String processorType;
    private int ram;
    private boolean isTouchScreen;

    /**
     * Laptop constructor
     * @param brand
     * @param model
     * @param processorType
     * @param ram
     * @param isTouchScreen
     */
    public Laptop(String brand, String model, String processorType, int ram, boolean isTouchScreen) {
        super(brand, model);
        this.processorType = processorType;
        this.ram = ram;
        this.isTouchScreen = isTouchScreen;
    }
    
    /**
     * Mencetak tambahan detail sebuah barang dengan format seperti berikut (tanpa [])
     * Cetak brand dan model dengan metode displayDetails dari class StoreItem
     * Processor type: [Nama processor]
     * RAM: [Jumlah RAM dengan satuan GB]
     * Touch screen: [Apabila isTouchScreen, maka cetak Yes, selain itu No]
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Processor type: %s\n", this.processorType);
        System.out.printf("RAM: %s GB\n", this.ram);
        if(isTouchScreen){
            System.out.printf("Touch screen: Yes\n");
        }
        else{
            System.out.printf("Touch screen: No\n");
        }
    }

    /**
     * Menghitung harga dari laptop
     * Apabila nama brand "Legowo", maka rumus: 500 + (Jika processor type = Intel, tambahkan 100, selain itu 50) + (Jumlah RAM * 10) + (Jika touch screen, tambahkan 50)
     * Selain nama brand "Legowo", rumus: 500 + (Jika processor type = Intel, tambahkan 100, selain itu 50) + (Jumlah RAM * 20) + (Jika touch screen, tambahkan 100)
     */
    @Override
    public int calculatePrice() {
        if(super.getBrand() == "Legowo"){
            if(this.processorType == "Intel"){
                if(this.isTouchScreen){
                    return 500 + 100 + (this.ram * 10) + 50;
                }
                else{
                    return 500 + 100 + (this.ram * 10);
                }
            }
            else{
                if(this.isTouchScreen){
                    return 500 + 50 + (this.ram * 10) + 50;
                }
                else{
                    return 500 + 50 + (this.ram * 10);
                }
            }
        }
        else{
            if(this.processorType == "Intel"){
                if(this.isTouchScreen){
                    return 500 + 100 + (this.ram * 20) + 100;
                }
                else{
                    return 500 + 100 + (this.ram * 20);
                }
            }
            else{
                if(this.isTouchScreen){
                    return 500 + 50 + (this.ram * 20) + 100;
                }
                else{
                    return 500 + 50 + (this.ram * 20);
                }
            }
        }
    }
}
