package l2.Building;

import java.util.Scanner;

public class Main {
    private Scanner input;
    
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
        building.setName(this.input.nextLine());

        System.out.print("Endereço: ");
        building.setAddress1stLine(this.input.nextLine());

        System.out.print("Bairro: ");
        building.setAddress2ndLine(this.input.nextLine());

        System.out.print("Cidade: ");
        building.setCity(this.input.nextLine());

        System.out.print("Estado: ");
        building.setState(this.input.nextLine());

        System.out.print("Andares: ");
        building.setFloors(getPositive(this.input.nextInt()));
        this.input.nextLine();

        System.out.print("Unidades por andar: ");
        building.setUnitsPerFloor(getPositive(this.input.nextInt()));
        this.input.nextLine();

        System.out.print("Área comum: ");
        building.setExtra(this.input.nextLine());

        System.out.print("\n\nEspecificações dos apartamentos\n");
        building.setUnit(configureUnit(input, unit));

        return building;
    }

    public Unit configureUnit (Scanner input, Unit unit) {
        System.out.print("Área: ");
        unit.setArea(getPositive(this.input.nextInt()));
        this.input.nextLine();

        System.out.print("Banheiros: ");
        unit.setBathrooms(getPositive(this.input.nextInt()));
        this.input.nextLine();

        System.out.print("Quartos: ");
        unit.setRooms(getPositive(this.input.nextInt()));
        this.input.nextLine();

        System.out.print("Suítes: ");
        unit.setDeluxeRooms(getPositive(this.input.nextInt()));
        this.input.nextLine();

        System.out.print("Vagas: ");
        unit.setParkingSlots(getPositive(this.input.nextInt()));
        this.input.nextLine();

        System.out.print("Preço: ");
        unit.setPrice(getPositive(this.input.nextInt()));
        this.input.nextLine();

        return unit;
    }

    public void main (String[] args) {
        this.input = new Scanner(System.in);

        System.out.print(this.configureBuilding(this.input, new Building(), new Unit()).toString());
    }
}
