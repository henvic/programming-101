package l4.q4;

import l4.q1.*;
import l4.q3.*;

public class BackEnd {
    private CargoRepo cargoRepo;
    private CargoRocketRepo cargoRocketRepo;
    private ExplorationRobotRepo explorationRobotRepo;
    private ExplorationRocketRepo explorationRocketRepo;

    private void validate (ExplorationRobot explorationRobot) throws InvalidCargoException {
        if (!explorationRobot.isFreighter() && explorationRobot.getMaxCargoCells() > 0) {
            throw new InvalidCargoException("robot != freighter");
        }
    }

    public boolean add (Cargo cargo) throws ObjectAlreadyExistsException {
        if (cargoRepo.has(cargo.getId())) {
            throw new ObjectAlreadyExistsException();
        }

        return cargoRepo.add(cargo);
    }

    public void deleteCargo (int id) throws ObjectNotFoundException {
        boolean deleted = cargoRepo.remove(id);

        if (!deleted) {
            throw new ObjectNotFoundException();
        }
    }

    public boolean updateCargo (int id, Cargo cargo) throws ObjectNotFoundException {
        if (!cargoRepo.has(id)) {
            throw new ObjectNotFoundException();
        }

        return cargoRepo.replace(id, cargo);
    }

    public Cargo getCargo (int id) throws ObjectNotFoundException {
        Cargo cargo = cargoRepo.get(id);

        if (cargo == null) {
            throw new ObjectNotFoundException();
        }

        return cargo;
    }

    public boolean add (CargoRocket cargoRocket) throws ObjectAlreadyExistsException {
        if (cargoRocketRepo.has(cargoRocket.getId())) {
            throw new ObjectAlreadyExistsException();
        }

        return cargoRocketRepo.add(cargoRocket);
    }

    public void deleteCargoRocket (int id) throws ObjectNotFoundException {
        boolean deleted = cargoRocketRepo.remove(id);

        if (!deleted) {
            throw new ObjectNotFoundException();
        }
    }

    public boolean updateCargoRocket (int id, CargoRocket cargoRocket) throws ObjectNotFoundException {
        if (!cargoRocketRepo.has(id)) {
            throw new ObjectNotFoundException();
        }

        return cargoRocketRepo.replace(id, cargoRocket);
    }

    public CargoRocket getCargoRocket (int id) throws ObjectNotFoundException {
        CargoRocket cargoRocket = cargoRocketRepo.get(id);

        if (cargoRocket == null) {
            throw new ObjectNotFoundException();
        }

        return cargoRocket;
    }

    public boolean add (ExplorationRobot explorationRobot) throws ObjectAlreadyExistsException, InvalidCargoException {
        if (explorationRobotRepo.has(explorationRobot.getId())) {
            throw new ObjectAlreadyExistsException();
        }

        this.validate(explorationRobot);

        return explorationRobotRepo.add(explorationRobot);
    }

    public void deleteExplorationRobot (int id) throws ObjectNotFoundException {
        boolean deleted = explorationRobotRepo.remove(id);

        if (!deleted) {
            throw new ObjectNotFoundException();
        }
    }

    public boolean updateExplorationRobot (int id, ExplorationRobot explorationRobot)
            throws ObjectNotFoundException, InvalidCargoException {
        if (!explorationRobotRepo.has(id)) {
            throw new ObjectNotFoundException();
        }

        this.validate(explorationRobot);

        return explorationRobotRepo.replace(id, explorationRobot);
    }

    public ExplorationRobot getExplorationRobot (int id) throws ObjectNotFoundException {
        ExplorationRobot explorationRobot = explorationRobotRepo.get(id);

        if (explorationRobot == null) {
            throw new ObjectNotFoundException();
        }

        return explorationRobot;
    }

    public boolean add (ExplorationRocket explorationRocket) throws ObjectAlreadyExistsException {
        if (explorationRocketRepo.has(explorationRocket.getId())) {
            throw new ObjectAlreadyExistsException();
        }

        return explorationRocketRepo.add(explorationRocket);
    }

    public void deleteExplorationRocket (int id) throws ObjectNotFoundException {
        boolean deleted = explorationRocketRepo.remove(id);

        if (!deleted) {
            throw new ObjectNotFoundException();
        }
    }

    public boolean updateExplorationRocket (int id, ExplorationRocket explorationRocket)
            throws ObjectNotFoundException {
        if (!explorationRocketRepo.has(id)) {
            throw new ObjectNotFoundException();
        }

        return explorationRocketRepo.replace(id, explorationRocket);
    }

    public ExplorationRocket getExplorationRocket (int id) throws ObjectNotFoundException {
        ExplorationRocket explorationRocket = explorationRocketRepo.get(id);

        if (explorationRocket == null) {
            throw new ObjectNotFoundException();
        }

        return explorationRocket;
    }

    public BackEnd(CargoRepo cargoRepo,
                   CargoRocketRepo cargoRocketRepo,
                   ExplorationRobotRepo explorationRobotRepo,
                   ExplorationRocketRepo explorationRocketRepo) {
        this.cargoRepo = cargoRepo;
        this.cargoRocketRepo = cargoRocketRepo;
        this.explorationRobotRepo = explorationRobotRepo;
        this.explorationRocketRepo = explorationRocketRepo;
    }
}
