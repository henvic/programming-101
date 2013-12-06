package l2.Building;

import java.util.Scanner;

public class Main {
    //not allowed to use Math.abs,
    //this is a compromise to offer the user the better experience
    private int getPositive(int number) {
        if (number < 0) {
            number *= -1;
        }

        return number;
    }

    public Building configureBuilding (Scanner input, Building building, Unit unit) {
        System.out.print("Nome: ");
        building.setName(input.nextLine());

        System.out.print("Endereço: ");
        building.setAddress1stLine(input.nextLine());

        System.out.print("Bairro: ");
        building.setAddress2ndLine(input.nextLine());

        System.out.print("Cidade: ");
        building.setCity(input.nextLine());

        System.out.print("Estado: ");
        building.setState(input.nextLine());

        System.out.print("Andares: ");
        building.setFloors(getPositive(input.nextInt()));
        input.nextLine();

        System.out.print("Unidades por andar: ");
        building.setUnitsPerFloor(getPositive(input.nextInt()));
        input.nextLine();

        System.out.print("Área comum: ");
        building.setExtra(input.nextLine());

        System.out.print("\n\nEspecificações dos apartamentos\n");
        building.setUnit(configureUnit(input, unit));

        return building;
    }

    public Unit configureUnit (Scanner input, Unit unit) {
        System.out.print("Área: ");
        unit.setArea(getPositive(input.nextInt()));
        input.nextLine();

        System.out.print("Banheiros: ");
        unit.setBathrooms(getPositive(input.nextInt()));
        input.nextLine();

        System.out.print("Quartos: ");
        unit.setRooms(getPositive(input.nextInt()));
        input.nextLine();

        System.out.print("Suítes: ");
        unit.setDeluxeRooms(getPositive(input.nextInt()));
        input.nextLine();

        System.out.print("Vagas: ");
        unit.setParkingSlots(getPositive(input.nextInt()));
        input.nextLine();

        System.out.print("Preço: ");
        unit.setPrice(getPositive(input.nextInt()));
        input.nextLine();

        return unit;
    }

    public void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print(this.configureBuilding(input, new Building(), new Unit()).toString());
    }
}
