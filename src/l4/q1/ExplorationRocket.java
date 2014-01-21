package l4.q1;

import java.util.Arrays;

public class ExplorationRocket extends Rocket {
    private String[] passengers;

    public String[] getPassengers() {
        return passengers;
    }

    public boolean addPassenger (String passenger) {
        int length = passengers.length;
        String[] newPassengers;

        for (int counter = 0; counter < length; counter += 1) {
            if (passengers[counter] == null) {
                passengers[counter] = passenger;
                return true;
            }
        }

        newPassengers = new String[length + 1];

        System.arraycopy(passengers, 0, newPassengers, 0, 0);
        passengers = newPassengers;

        passengers[length] = passenger;

        return true;
    }

    public boolean removePassenger (String passenger) {
        if (passenger == null) {
            return false;
        }

        for (int counter = 0, length = passengers.length; counter < length; counter += 1) {
            if (passengers[counter].equalsIgnoreCase(passenger)) {
                passengers[counter] = "";
                return true;
            }
        }

        return false;
    }

    public ExplorationRocket(int id, int cost, int height, int length, int width, int fuel,
                             String destination, String pilot, String[] passengers) {
        super(id, cost, height, length, width, fuel, destination, pilot);
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        String[] passengers = this.getPassengers();
        String passengersList = "";

        for (String passenger : passengers) {
            if (passenger != null) {
                passengersList += "-" + passenger + "\n";
            }
        }

        if (passengers.length > 0) {
            passengersList = Arrays.toString(passengers);
        }

        return "Foguete de exploração #" + this.getId() + " \n" +
                "Custo: " + this.getCost() + " \n" +
                "Altura: " + this.getHeight() + " \n" +
                "Comprimento: " + this.getLength() + " \n" +
                "Largura: " + this.getWidth() + " \n" +
                "Piloto: " + this.getPilot() + " \n" +
                "Combustível: " + this.getFuel() + " \n" +
                "Destino: " + this.getDestination() + " \n" +
                "Passageiros:\n" + passengersList;
    }
}
