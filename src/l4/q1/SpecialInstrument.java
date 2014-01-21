package l4.q1;

abstract public class SpecialInstrument {
    private int id;
    private int cost;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    protected void setCost(int cost) {
        this.cost = cost;
    }

    protected SpecialInstrument() {
    }

    protected SpecialInstrument(int id, int cost) {

        this.id = id;
        this.cost = cost;
    }
}
