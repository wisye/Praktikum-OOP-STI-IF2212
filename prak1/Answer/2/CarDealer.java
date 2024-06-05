public class CarDealer {
    private static int totalCar = 0;
    private String brand;
    private int carInDealer;
    private int carPrice;
    private int profit = 0;

    /**
     * CarDealer constructor
     * Inisiasi sekaligus menambah totalCar
     * @param brand
     * @param carInDealer
     * @param carPrice
     */
    public CarDealer(String brand, int carInDealer, int carPrice) {
        this.brand = brand;
        this.carInDealer = carInDealer;
        this.carPrice = carPrice;
        CarDealer.totalCar += carInDealer;
    }

    /**
     * getBrand
     * @return brand
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * getCarInDealer
     * @return carInDealer
     */
    public int getCarInDealer() {
        return this.carInDealer;
    }
    
    /**
     * getCarPrice
     * @return carPrice
     */
    public int getCarPrice() {
        return this.carPrice;
    }

    /**
     * getProfit
     * @return profit
     */
    public int getProfit() {
        return this.profit;
    }

    /**
     * getTotalCar
     * @return totalCar
     */
    public static int getTotalCar() {
        return CarDealer.totalCar;
    }

    /**
     * sellCar
     * @param amount
     * @return void
     */
    public void sellCar(int amount) {
        if(CarDealer.totalCar >= amount && this.carInDealer >= amount){
            CarDealer.totalCar -= amount;
            this.carInDealer -= amount;
            this.profit += (this.carPrice * amount);
        }
    }
}