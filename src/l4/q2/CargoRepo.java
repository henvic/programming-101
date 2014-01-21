package l4.q2;

import l4.q1.Cargo;

public interface CargoRepo {
    public boolean add (Cargo cargo);
    public boolean remove (int id);
    public Cargo get (int id);
    public boolean has (int id);
}
