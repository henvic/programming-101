package l4.q3;

import l4.q1.ExplorationRobot;

public class ExplorationRobotRepo implements l4.q2.ExplorationRobotRepo {
    private ExplorationRobot[] explorationRobots;

    @Override
    public boolean add(ExplorationRobot explorationRobot) {
        int length = explorationRobots.length;
        ExplorationRobot[] newExplorationRobots;

        System.out.println("robot adicionando");

        for (int counter = 0; counter < length; counter += 1) {
            if (explorationRobots[counter] == null) {
                explorationRobots[counter] = explorationRobot;
                return true;
            }
        }

        newExplorationRobots = new ExplorationRobot[length + 1];

        System.arraycopy(explorationRobots, 0, newExplorationRobots, 0, 0);
        this.explorationRobots = newExplorationRobots;

        explorationRobots[length] = explorationRobot;

        return true;
    }

    @Override
    public boolean remove(int id) {
        for (int counter = 0, length = explorationRobots.length; counter < length; counter += 1) {
            if (explorationRobots[counter] != null && explorationRobots[counter].getId() == id) {
                explorationRobots[counter] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public ExplorationRobot get(int id) {
        for (ExplorationRobot current : explorationRobots) {
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

    public boolean replace(int id, ExplorationRobot explorationRobot) {
        for (int counter = 0, length = explorationRobots.length; counter < length; counter += 1) {
            if (explorationRobots[counter] != null && explorationRobots[counter].getId() == id) {
                explorationRobots[counter] = explorationRobot;
                return true;
            }
        }

        return false;
    }

    public ExplorationRobotRepo() {
        this.explorationRobots = new ExplorationRobot[1];
    }
}
