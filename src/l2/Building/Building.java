package l2.Building;

public class Building {
    private int id = -1;
    private String name;
    private String address1stLine;
    private String address2ndLine;
    private String city;
    private String state;
    private int floors;
    private int unitsPerFloor;
    private String extra;
    private Unit unit;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1stLine() {
        return this.address1stLine;
    }

    public void setAddress1stLine(String address1stLine) {
        this.address1stLine = address1stLine;
    }

    public String getAddress2ndLine() {
        return this.address2ndLine;
    }

    public void setAddress2ndLine(String address2ndLine) {
        this.address2ndLine = address2ndLine;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getFloors() {
        return this.floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getUnitsPerFloor() {
        return this.unitsPerFloor;
    }

    public void setUnitsPerFloor(int unitsPerFloor) {
        this.unitsPerFloor = unitsPerFloor;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Unit getUnit() {
        return this.unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        String output = "";

        if (this.getId() != -1) {
            output += "ID: " + this.id + "\n";
        }

        output +=
            "Nome: " + this.getName() + "\n" +
            "Endereço: " + this.getAddress1stLine() + "\n" +
            this.getAddress2ndLine() + "\n" +
            this.getCity() + " - " + this.getState() + "\n" +
            "Andares: " + this.getFloors() + "\n" +
            "Apartamentos por andar: " + this.getUnitsPerFloor() + "\n" +
            "Área comum: " + this.getExtra() + "\n\n" +
            "Apartamentos:\n" + this.getUnit() + "\n";

        return output;
    }
}
