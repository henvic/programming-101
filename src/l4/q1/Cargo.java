package l4.q1;

public class Cargo {
    private int id;
    private int amount;
    private int specialInstrument;
    private String name;

    public Cargo() {
    }

    public Cargo(int id, int amount, int specialInstrument, String name) {
        this.id = id;
        this.amount = amount;
        this.specialInstrument = specialInstrument;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSpecialInstrument() {
        return specialInstrument;
    }

    public void setSpecialInstrument(int specialInstrument) {
        this.specialInstrument = specialInstrument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Carga #" + this.getId() + "\n" +
                "Nome: " + this.getName() + "\n" +
                "Quantidade: " + this.getAmount() + "\n" +
                "Equipando #" + this.getSpecialInstrument();
    }
}
