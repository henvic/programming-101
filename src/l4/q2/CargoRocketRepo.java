package l4.q2;

import l4.q1.CargoRocket;

public interface CargoRocketRepo {
    public boolean add (CargoRocket cargoRocket);
    public boolean remove (int id);
    public CargoRocket get (int id);
    public boolean has (int id);
}
