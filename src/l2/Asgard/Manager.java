package l2.Asgard;

public class Manager {
    private Item[] items;
    private boolean[] rig;
    private int next;

    public Manager(Item[] items, boolean[] rig, int next) {
        this.items = items;
        this.rig = rig;
        this.next = next;
    }

    public void create (Item item) {
        item.setId(this.next);
        this.items[this.next] = item;
        this.next += 1;
    }

    public boolean update (int index, Item item) {
        if (index < 0 || index > this.items.length - 1) {
            return false;
        }

        item.setId(index);

        this.items[index] = item;

        if (!item.isWorking()) {
            this.setArm(index, false);
        }

        return true;
    }

    public boolean delete (int index) {
        if (index < 0 || index > this.items.length - 1) {
            return false;
        }

        this.items[index] = null;

        return true;
    }

    public Item[] filter (Item[] items, boolean[] rig, String name, boolean onlyArmed) {
        int amount = 0;

        Item[] filtered = new Item[items.length];
        Item[] end;
        Item item;

        for (int counter = 0, length = items.length; counter < length; counter += 1) {
            item = items[counter];

            if (item == null) {
                continue;
            }

            if ((name.equals("") || item.getName().equalsIgnoreCase(name)) && (!onlyArmed || rig[counter])) {
                filtered[amount] = item;
                amount += 1;
            }
        }

        end = new Item[amount];
        System.arraycopy(filtered, 0, end, 0, amount);

        return end;
    }

    public Item[] getAll () {
        return this.items;
    }

    public Item get(int index) {
        if (index < 0 || index > this.items.length - 1) {
            return null;
        }

        return this.items[index];
    }

    public boolean[] getRig () {
        return this.rig;
    }

    public void setArm (int index, boolean status) {
        this.rig[index] = status;
    }
}
