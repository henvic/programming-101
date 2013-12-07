package l2.BuildingManager;

import l2.Building.*;

public class BuildingManager {
    // 0 so it's easy to test
    private int length = 0;
    private Building[] buildings;

    public BuildingManager() {
        this.buildings = new Building[this.length];
    }

    public Building[] getBuildings () {
        return this.buildings;
    }

    private void setBuildings(Building[] buildings) {
        this.buildings = buildings;
    }

    public Building[] filter (Building[] buildings, String name, String neighborhood, int rooms, int price) {
        Building[] filtered = new Building[buildings.length];
        Building[] end;
        int amount = 0;

        for (Building building : buildings) {
            if (building == null) {
                continue;
            }

            if ((name.equals("") || building.getName().contains(name)) &&
               (neighborhood.equals("") || building.getAddress2ndLine().contains(neighborhood)) &&
               (rooms == -1 || building.getUnit().getRooms() == rooms) &&
               (price == -1 || building.getUnit().getPrice() == price)) {
                filtered[amount] = building;
                amount += 1;
            }
        }

        end = new Building[amount];
        System.arraycopy(filtered, 0, end, 0, amount);

        return end;
    }

    public Building addBuilding (Building building) {
        int offset = this.length;
        Building[] old;

        if (this.length == this.getBuildings().length) {
            old = this.getBuildings();
            // + 1 so it's easy to test...
            this.setBuildings(new Building[offset + 1]);
            System.arraycopy(old, 0, this.getBuildings(), 0, offset);
        }

        this.length += 1;

        building.setId(this.length);

        this.getBuildings()[this.length - 1] = building;

        return building;
    }

    public boolean replaceBuilding (int index, Building building) {
        if (index < 0 || this.getBuildings().length < index + 1 || this.getBuildings()[index] == null) {
            return false;
        }

        building.setId(index + 1);

        this.getBuildings()[index] = building;

        return true;
    }

    public boolean removeBuilding (int index) {
        if (index < 0 || this.getBuildings().length < index + 1 || this.getBuildings()[index] == null) {
            return false;
        }

        this.getBuildings()[index] = null;

        return true;
    }
}
