package l4.q2;

import l4.q1.ExplorationRobot;

public interface ExplorationRobotRepo {
    public boolean add (ExplorationRobot explorationRobot);
    public boolean remove (int id);
    public ExplorationRobot get (int id);
    public boolean has (int id);
}
