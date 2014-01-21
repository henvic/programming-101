package l4.q1;

abstract public class Rocket extends SpecialInstrument {
    private int height;
    private int length;
    private int width;
    private int fuel;
    private String destination;
    private String pilot;

    public Rocket(int id, int cost, int height, int length, int width, int fuel, String destination, String pilot) {
        super(id, cost);
        this.height = height;
        this.length = length;
        this.width = width;
        this.fuel = fuel;
        this.destination = destination;
        this.pilot = pilot;
    }

    public int getHeight() {

        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getFuel() {
        return fuel;
    }

    public String getDestination() {
        return destination;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }


}
