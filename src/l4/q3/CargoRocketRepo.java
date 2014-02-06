package l4.q3;

import l4.q1.CargoRocket;

public class CargoRocketRepo implements l4.q2.CargoRocketRepo {
    private CargoRocket[] cargoRockets;

    @Override
    public boolean add(CargoRocket cargoRocket) {
        int length = cargoRockets.length;
        CargoRocket[] newCargoRockets;

        for (int counter = 0; counter < length; counter += 1) {
            if (cargoRockets[counter] == null) {
                cargoRockets[counter] = cargoRocket;
                return true;
            }
        }

        newCargoRockets = new CargoRocket[length + 1];

        System.arraycopy(cargoRockets, 0, newCargoRockets, 0, length);
        this.cargoRockets = newCargoRockets;

        cargoRockets[length] = cargoRocket;

        return true;
    }

    @Override
    public boolean remove(int id) {
        for (int counter = 0, length = cargoRockets.length; counter < length; counter += 1) {
            if (cargoRockets[counter] != null && cargoRockets[counter].getId() == id) {
                cargoRockets[counter] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public CargoRocket get(int id) {
        for (CargoRocket current : cargoRockets) {
            if (current != null && current.getId() == id) {
                return current;
            }
        }

        return null;
    }

    @Override
    public boolean has(int id) {
        return (this.get(id) != null);
    }

    public boolean replace(int id, CargoRocket cargoRocket) {
        for (int counter = 0, length = cargoRockets.length; counter < length; counter += 1) {
            if (cargoRockets[counter] != null && cargoRockets[counter].getId() == id) {
                cargoRockets[counter] = cargoRocket;
                return true;
            }
        }

        return false;
    }

    public CargoRocketRepo() {
        this.cargoRockets = new CargoRocket[1];
    }
}
