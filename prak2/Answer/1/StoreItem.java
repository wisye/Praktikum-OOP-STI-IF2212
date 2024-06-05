public abstract class StoreItem {
    private String brand;
    private String model;

    /**
     * StoreItem constructor
     * @param brand
     * @param model
     */
    public StoreItem(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    /**
     * Mengembalikan atribut brand
     * @return brand
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Mencetak detail sebuah barang dengan format seperti berikut (tanpa [])
     * Brand: [Nama brand]
     * Model: [Nama model]
     */
    public void displayDetails() {
        System.out.printf("Brand: %s\n", this.brand);
        System.out.printf("Model: %s\n", this.model);
    }

    public abstract int calculatePrice();
}