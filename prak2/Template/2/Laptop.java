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
    
	}
    
	/**
	 * Menghitung harga dari laptop
	 * Apabila nama brand "Legowo", maka rumus: 500 + (Jika processor type = Intel, tambahkan 100, selain itu 50) + (Jumlah RAM * 10) + (Jika touch screen, tambahkan 50)
	 * Selain nama brand "Legowo", rumus: 500 + (Jika processor type = Intel, tambahkan 100, selain itu 50) + (Jumlah RAM * 20) + (Jika touch screen, tambahkan 100)
	 */
	@Override
	public int calculatePrice() {
    
	}
    }