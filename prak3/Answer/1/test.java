public class test {
    public static void main(String[] args){
        VehicleManager vm = new VehicleManager();
        Motorcycle mo = new Motorcycle();
        vm.addVehicle(mo);
        vm.changeAllTyres();
    }
}
