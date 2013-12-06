package l2.Building;

public class Unit {
    private int area;
    private int bathrooms;
    private int rooms;
    private int deluxeRooms;
    private int parkingSlots;
    private int price;

    public int getArea() {
        return this.area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getBathrooms() {
        return this.bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getRooms() {
        return this.rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getDeluxeRooms() {
        return this.deluxeRooms;
    }

    public void setDeluxeRooms(int deluxeRooms) {
        this.deluxeRooms = deluxeRooms;
    }

    public int getParkingSlots() {
        return this.parkingSlots;
    }

    public void setParkingSlots(int parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Área: " + this.area + "\n" +
            "Banheiros: " + this.bathrooms + "\n" +
            "Quartos: " + this.rooms + "\n" +
            "Suítes: " + this.deluxeRooms + "\n" +
            "Vagas: " + this.parkingSlots + "\n" +
            "Preço: " + this.price + "\n";
    }
}
