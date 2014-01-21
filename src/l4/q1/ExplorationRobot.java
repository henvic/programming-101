package l4.q1;

public class ExplorationRobot extends SpecialInstrument {
    private String destination;
    private int eta;
    private int fuel;
    private boolean freighter;
    private int maxCargoCells;
    private int[] cargo;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public boolean isFreighter() {
        return freighter;
    }

    public void setFreighter(boolean freighter) {
        this.freighter = freighter;
    }

    public int getMaxCargoCells() {
        return maxCargoCells;
    }

    public void setMaxCargoCells(int maxCargoCells) {
        this.maxCargoCells = maxCargoCells;
    }

    public int[] getCargo() {
        return cargo;
    }

    public void setCargo(int[] cargo) {
        this.cargo = cargo;
    }

    public ExplorationRobot() {
    }

    public ExplorationRobot(int id, int cost,
                            String destination, int eta, int fuel, boolean freighter,
                            int maxCargoCells, int[] cargo) {
        super(id, cost);
        this.destination = destination;
        this.eta = eta;
        this.fuel = fuel;
        this.freighter = freighter;
        this.maxCargoCells = maxCargoCells;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        int[] cargo = this.getCargo();
        String maxCargoCells = "-";
        String cargoList = "";

        if (this.isFreighter()) {
            maxCargoCells = Integer.toString(this.getMaxCargoCells());
        }

        for (int counter = 0, length = this.getCargo().length; counter < length; counter += 1) {
            if (cargo[counter] != 0) {
                cargoList += "#" + cargo[counter];

                if (counter < length - 2) {
                    cargoList += ", ";
                }
            }
        }

        if (cargoList.equals("")) {
            cargoList = "-";
        }

        return "Robô de exploração #" + this.getId() + " \n" +
                "Custo: " + this.getCost() + " \n" +
                "Destino: " + this.getDestination() + "\n" +
                "ETA: " + this.getEta() + "\n" +
                "Combustível: " + this.getFuel() + "\n" +
                "Quantidade máxima de carga:" + maxCargoCells + "\n" +
                "IDs das cargas atuais: " + cargoList;
    }
}
