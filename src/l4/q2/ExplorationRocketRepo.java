package l4.q2;

import l4.q1.ExplorationRocket;

public interface ExplorationRocketRepo {
    public boolean add (ExplorationRocket explorationRocket);
    public boolean remove (int id);
    public ExplorationRocket get (int id);
    public boolean has (int id);
}
