package l4.q3;

import l4.q1.Cargo;

public class CargoRepo implements l4.q2.CargoRepo {
    private Cargo[] cargoes;

    @Override
    public boolean add(Cargo cargo) {
        int length = cargoes.length;
        Cargo[] newCargoes;

        for (int counter = 0; counter < length; counter += 1) {
            if (cargoes[counter] == null) {
                cargoes[counter] = cargo;
                return true;
            }
        }

        newCargoes = new Cargo[length + 1];

        System.arraycopy(cargoes, 0, newCargoes, 0, length);
        this.cargoes = newCargoes;

        cargoes[length] = cargo;

        return true;
    }

    @Override
    public boolean remove(int id) {
        for (int counter = 0, length = cargoes.length; counter < length; counter += 1) {
            if (cargoes[counter] != null && cargoes[counter].getId() == id) {
                cargoes[counter] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public Cargo get(int id) {
        for (Cargo current : cargoes) {
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

    public boolean replace(int id, Cargo cargo) {
        for (int counter = 0, length = cargoes.length; counter < length; counter += 1) {
            if (cargoes[counter] != null && cargoes[counter].getId() == id) {
                cargoes[counter] = cargo;
                return true;
            }
        }

        return false;
    }

    public CargoRepo() {
        this.cargoes = new Cargo[1];
    }
}
