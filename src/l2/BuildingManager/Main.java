package l2.BuildingManager;

import l2.Building.Building;
import l2.Building.Unit;

import java.util.Scanner;

public class Main {
    private void create (Scanner input, BuildingManager manager, l2.Building.Main buildingMain) {
        Building building;

        building = buildingMain.configureBuilding(input, new Building(), new Unit());
        manager.addBuilding(building);
        System.out.println("Imóvel adicionado!\n");
    }

    private void update (Scanner input, BuildingManager manager, l2.Building.Main buildingMain) {
        int index;
        Building building;

        System.out.print("Índice do imóvel a modificar: ");

        index = input.nextInt();

        //not allowed to use Math.abs()
        if (index < 0) {
            index *= -1;
        }

        index -= 1;
        input.nextLine();

        if (index < 0 || manager.getBuildings().length < index + 1 || manager.getBuildings()[index] == null) {
            System.out.println("Imóvel não encontrado.");
            return;
        }

        building = buildingMain.configureBuilding(input, new Building(), new Unit());
        manager.replaceBuilding(index, building);
    }
    private void list (Scanner input, BuildingManager manager) {
        int rooms = -1;
        int price = -1;
        String name, neighborhood, roomsString, priceString;
        Building[] data;

        System.out.println("Reduzir o resultado (enter para ignorar):");

        System.out.print("Nome: ");
        name = input.nextLine();

        System.out.print("Bairro: ");
        neighborhood = input.nextLine();

        System.out.print("Quartos: ");
        roomsString = input.nextLine();

        if (!roomsString.equals("")) {
            rooms = Integer.parseInt(roomsString);

            //ignore the minus sign
            if (rooms < 0) {
                rooms *= -1;
            }
        }

        System.out.print("Preço: ");
        priceString = input.nextLine();

        if (!priceString.equals("")) {
            price = Integer.parseInt(priceString);

            //ignore the minus sign
            if (price < 0) {
                price *= -1;
            }
        }

        data = manager.filter(manager.getBuildings(), name, neighborhood, rooms, price);

        if (data.length == 0) {
            System.out.println("\n\nSem resultados.\n\n");
            return;
        }

        System.out.println("\n\nResultados:\n\n");

        for (Building datum : data) {
            System.out.println("\n" + datum);
        }
    }

    private void delete (Scanner input, BuildingManager manager) {
        boolean removed;
        int index;

        System.out.print("Índice do imóvel: ");
        index = input.nextInt();
        input.nextLine();

        if (index < 0) {
            index *= -1;
        }

        removed = manager.removeBuilding(index - 1);

        System.out.println((removed) ? "Imóvel removido!" : "Imóvel não encontrado.");
    }

    public Main () {
        int code = -1;
        Scanner input;
        BuildingManager manager;

        l2.Building.Main buildingMain = new l2.Building.Main();

        manager = new BuildingManager();

        input = new Scanner(System.in);

        while (code != 5) {
            System.out.print("1) Cadastrar um imóvel\n" +
                    "2) Modificar um imóvel\n" +
                    "3) Localizar um imóvel\n" +
                    "4) Remover um imóvel\n" +
                    "5) Sair\n" +
                    "Opção: ");

            code = input.nextInt();
            input.nextLine();

            switch (code) {
                case 1: this.create(input, manager, buildingMain); break;
                case 2: this.update(input, manager, buildingMain); break;
                case 3: this.list(input, manager); break;
                case 4: this.delete(input, manager); break;
            }
        }
    }

    public static void main (String[] args) {
        new Main();
    }
}
