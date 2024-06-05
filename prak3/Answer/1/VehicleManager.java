import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> list = new ArrayList<Vehicle>();

    /**
     * Menambahkan kendaraan ke array
     * 
     * @param vehicle objek Vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        // Tambahkan kendaraan ke list
        this.list.add(vehicle);
    }

    /**
     * Memarkirkan semua kendaraan pada list menggunakan method park pada Vehicle
     */
    public void parkAllVehicles() {
        for (Vehicle vehicle : this.list) {
            vehicle.park();
        }
    }

    /**
     * Membuka semua pintu pada kendaraan yang memiliki pintu menggunakan method
     * openDoor pada Door
     */
    public void openAllDoors() {
        for (Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car car = (Car) vehicle;
                car.openDoor();
            }
            if(vehicle instanceof Helicopter){
                Helicopter heli = (Helicopter) vehicle;
                heli.openDoor();
            }
        }
    }

    /**
     * Menutup semua pintu pada kendaraan yang memiliki pintu menggunakan method
     * closeDoor pada Door
     */
    public void closeAllDoors() {
        for (Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car car = (Car) vehicle;
                car.closeDoor();
            }
            if(vehicle instanceof Helicopter){
                Helicopter heli = (Helicopter) vehicle;
                heli.closeDoor();
            }
        }
    }

    /**
     * Menyalakan semua mesin pada kendaraan yang memiliki mesin menggunakan method
     * startEngine pada Engine
     */
    public void startAllEngines() {
        for(Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car car = (Car) vehicle;
                car.startEngine();
            }
            if(vehicle instanceof Motorcycle){
                Motorcycle motor  = (Motorcycle) vehicle;
                motor.startEngine();
            }
            if(vehicle instanceof Helicopter){
                Helicopter heli = (Helicopter) vehicle;
                heli.startEngine();
            }
        }
    }

    /**
     * Mematikan semua mesin pada kendaraan yang memiliki mesin menggunakan method
     * stopEngine pada Engine
     */
    public void stopAllEngines() {
        for(Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car car = (Car) vehicle;
                car.stopEngine();
            }
            if(vehicle instanceof Motorcycle){
                Motorcycle motor  = (Motorcycle) vehicle;
                motor.stopEngine();
            }
            if(vehicle instanceof Helicopter){
                Helicopter heli = (Helicopter) vehicle;
                heli.stopEngine();
            }
        }
    }

    /**
     * Mengganti semua ban pada kendaraan yang memiliki ban menggunakan method
     * changeTyre pada Tyre
     */
    public void changeAllTyres() {
        for(Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car car = (Car) vehicle;
                car.changeTyre();
            }
            if(vehicle instanceof Motorcycle){
                Motorcycle motor  = (Motorcycle) vehicle;
                motor.changeTyre();
            }
            if(vehicle instanceof Bicycle){
                Bicycle heli = (Bicycle) vehicle;
                heli.changeTyre();
            }
        }
    }
}
