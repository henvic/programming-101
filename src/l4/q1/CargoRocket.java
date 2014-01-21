package l4.q1;

public class CargoRocket extends Rocket {
    private int maxCargoCells;
    private int[] cargo;

    public CargoRocket(int id, int cost, int height, int length, int width, int fuel, String destination, String pilot,
                       int maxCargoCells, int[] cargo) {
        super(id, cost, height, length, width, fuel, destination, pilot);
        this.maxCargoCells = maxCargoCells;
        this.cargo = cargo;
    }

    public CargoRocket(int id, int cost, int height, int length, int width, int fuel, String destination, String pilot,
                       int maxCargoCells) {
        super(id, cost, height, length, width, fuel, destination, pilot);
        this.maxCargoCells = maxCargoCells;
        this.cargo = new int[maxCargoCells];
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

    @Override
    public String toString() {
        int[] cargo = this.getCargo();
        String cargoList = "";

        for (int counter = 0, length = cargo.length; counter < length; counter += 1) {
            if (cargo[counter] != 0) {
                cargoList += "#" + cargo[counter];

                if (counter < length - 1) {
                    cargoList += ", ";
                }
            }
        }

        if (cargoList.equals("")) {
            cargoList = "-";
        }

        return "Foguete de carga #" + this.getId() + " \n" +
                "Custo: " + this.getCost() + " \n" +
                "Altura: " + this.getHeight() + " \n" +
                "Comprimento: " + this.getLength() + " \n" +
                "Largura: " + this.getWidth() + " \n" +
                "Piloto: " + this.getPilot() + " \n" +
                "Combustível: " + this.getFuel() + " \n" +
                "Destino: " + this.getDestination() + " \n" +
                "Quantidade de células de carga máxima: " + this.getMaxCargoCells() + " \n" +
                "IDs das cargas atuais: " + cargoList;
    }
}
