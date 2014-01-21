package l4.q3;

import l4.q1.ExplorationRocket;

public class ExplorationRocketRepo implements l4.q2.ExplorationRocketRepo {
    private ExplorationRocket[] explorationRockets;

    @Override
    public boolean add(ExplorationRocket explorationRocket) {
        int length = explorationRockets.length;
        ExplorationRocket[] newExplorationRockets;

        for (int counter = 0; counter < length; counter += 1) {
            if (explorationRockets[counter] == null) {
                explorationRockets[counter] = explorationRocket;
                return true;
            }
        }

        newExplorationRockets = new ExplorationRocket[length + 1];

        System.arraycopy(explorationRockets, 0, newExplorationRockets, 0, 0);
        this.explorationRockets = newExplorationRockets;

        explorationRockets[length] = explorationRocket;

        return true;
    }

    @Override
    public boolean remove(int id) {
        for (int counter = 0, length = explorationRockets.length; counter < length; counter += 1) {
            if (explorationRockets[counter] != null && explorationRockets[counter].getId() == id) {
                explorationRockets[counter] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public ExplorationRocket get(int id) {
        for (ExplorationRocket current : explorationRockets) {
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

    public boolean replace(int id, ExplorationRocket explorationRocket) {
        for (int counter = 0, length = explorationRockets.length; counter < length; counter += 1) {
            if (explorationRockets[counter] != null && explorationRockets[counter].getId() == id) {
                explorationRockets[counter] = explorationRocket;
                return true;
            }
        }

        return false;
    }

    public ExplorationRocketRepo() {
        this.explorationRockets = new ExplorationRocket[1];
    }
}
