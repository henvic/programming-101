package l4.q5;

import l4.q1.*;
import l4.q3.*;
import l4.q4.*;

public class Facade {
    private BackEnd program;
    private int nextUniversalId = 0;

    private int getNextUniversalId () {
        nextUniversalId += 1;
        return nextUniversalId;
    }

    private int getNextFreeCargoCellPosition (int[] cells) {
        for (int counter = 0, length = cells.length; counter < length; counter += 1) {
            if (cells[counter] == 0) {
                return counter;
            }
        }

        return -1;
    }

    private void removeCargoCellReference (int id, Object specialInstrument) {
        int[] cells = new int[0];

        if (specialInstrument instanceof CargoRocket) {
            cells = ((CargoRocket) specialInstrument).getCargo();
        }

        if (specialInstrument instanceof ExplorationRobot) {
            cells = ((ExplorationRobot) specialInstrument).getCargo();
        }

        for (int counter = 0, length = cells.length; counter < length; counter += 1) {
            if (cells[counter] == id) {
                cells[counter] = 0;
            }
        }

        if (specialInstrument instanceof CargoRocket) {
            ((CargoRocket) specialInstrument).setCargo(cells);
        }

        if (specialInstrument instanceof ExplorationRobot) {
            ((ExplorationRobot) specialInstrument).setCargo(cells);
        }
    }

    public int createCargo (String name, int amount, int specialInstrument)
            throws ObjectNotFoundException, ObjectAlreadyExistsException,
            InvalidInstrumentTypeException, ExhaustedCargoCellsException, IllegalNumberException {
        int cells[] = new int[0];
        int free;
        Cargo cargo;
        Object instrument = this.get(specialInstrument);

        if (amount < 0) {
            throw new IllegalNumberException();
        }

        if (!(instrument instanceof CargoRocket) && !(instrument instanceof ExplorationRobot)) {
            throw new InvalidInstrumentTypeException("Cargo should be for CargoRocket or ExplorationRobot only.");
        }

        if (instrument instanceof CargoRocket) {
            cells = ((CargoRocket) instrument).getCargo();
        }

        if (instrument instanceof ExplorationRobot) {
            cells = ((ExplorationRobot) instrument).getCargo();
        }

        free = this.getNextFreeCargoCellPosition(cells);

        if (free == -1) {
            throw new ExhaustedCargoCellsException();
        }

        cargo = new Cargo(this.getNextUniversalId(), amount, specialInstrument, name);

        program.add(cargo);

        cells[free] = cargo.getId();

        if (instrument instanceof CargoRocket) {
            ((CargoRocket) instrument).setCargo(cells);
        }

        if (instrument instanceof ExplorationRobot) {
            ((ExplorationRobot) instrument).setCargo(cells);
        }

        return cargo.getId();
    }

    public int createCargoRocket (int cost, int height, int length, int width,
                                  int fuel, String destination, String pilot,
                                  int maxCargoCells) throws IllegalNumberException {
        int id = this.getNextUniversalId();

        if (cost < 0 || height < 0 || length < 0 || width < 0 || fuel < 0) {
            throw new IllegalNumberException();
        }

        try {
            CargoRocket cargoRocket = new CargoRocket(id, cost,
                    height, length, width, fuel, destination, pilot, maxCargoCells);
            program.add(cargoRocket);
        } catch (ObjectAlreadyExistsException ignore) { //it's ok to assume it's never gonna happen
        }

        return id;
    }

    public int createExplorationRocket (int cost, int height, int length, int width,
                                  int fuel, String destination, String pilot, String[] passengers) {
        int id = this.getNextUniversalId();

        try {
            ExplorationRocket explorationRocket = new ExplorationRocket(id, cost,
                    height, length, width, fuel, destination, pilot, passengers);
            program.add(explorationRocket);
        } catch (ObjectAlreadyExistsException ignore) { //it's ok to assume it's never gonna happen
        }

        return id;
    }

    public int createExplorationRobot (int cost, String destination, int eta, int fuel,
                                       boolean freighter, int maxCargoCells) throws InvalidCargoException {
        int id = this.getNextUniversalId();

        try {
            ExplorationRobot explorationRobot = new ExplorationRobot(id, cost,
                    destination, eta, fuel, freighter, maxCargoCells, new int[maxCargoCells]);
            program.add(explorationRobot);
        } catch (ObjectAlreadyExistsException ignore) { //it's ok to assume it's never gonna happen
        }

        return id;
    }

    public void delete (int id) throws TypeMismatchException, ObjectNotFoundException {
        Object o = this.get(id);
        Object specialInstrument;

        if (o instanceof Cargo) {
            specialInstrument = this.get(((Cargo) o).getSpecialInstrument());
            this.removeCargoCellReference(id, specialInstrument);
            program.deleteCargo(id);
            return;
        }

        if (o instanceof CargoRocket) {
            program.deleteCargoRocket(id);
            return;
        }

        if (o instanceof ExplorationRobot) {
            program.deleteExplorationRobot(id);
            return;
        }

        if (o instanceof ExplorationRocket) {
            program.deleteExplorationRocket(id);
            return;
        }

        throw new TypeMismatchException();
    }

    public void update (Rocket original, int fuel, String pilot, String destination) {
        original.setPilot(pilot);
        original.setFuel(fuel);
        original.setDestination(destination);
    }

    public void update (ExplorationRobot explorationRobot, int fuel, int eta, String destination) {
        explorationRobot.setFuel(fuel);
        explorationRobot.setEta(eta);
        explorationRobot.setDestination(destination);
    }

    public Object get (int id) throws ObjectNotFoundException {
        try {
            return program.getCargo(id);
        } catch (ObjectNotFoundException ignore) {
        }

        try {
            return program.getCargoRocket(id);
        } catch (ObjectNotFoundException ignore) {
        }

        try {
            return program.getExplorationRobot(id);
        } catch (ObjectNotFoundException ignore) {
        }

        try {
            return program.getExplorationRocket(id);
        } catch (ObjectNotFoundException ignore) {
        }

        throw new ObjectNotFoundException();
    }

    public Facade () {
        program = new BackEnd(new CargoRepo(),
                new CargoRocketRepo(),
                new ExplorationRobotRepo(),
                new ExplorationRocketRepo()
        );
    }
}
