package l2.Asgard;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private Scanner input;
    private Manager manager;

    private int getIndex (String name) {
        Item[] data;

        data = this.manager.filter(this.manager.getAll(), this.manager.getRig(), name, false);

        for (Item datum : data) {
            if (datum.getName().equalsIgnoreCase(name)) {
                return datum.getId();
            }
        }

        return -1;
    }

    private int getIndex () {
        String name;

        System.out.print("Nome do ítem: ");
        name = this.input.nextLine();

        return getIndex(name);
    }

    private Item configureItem (Item item) {
        String name = "";

        while (true) {
            System.out.print("Nome: ");
            name = this.input.nextLine();

            if (getIndex(name) != -1) {
                System.out.println("Nome já usado.");
                continue;
            }

            break;
        }

        item.setName(name);

        System.out.print("Estado do ítem (quebrado / funcionando): ");
        item.setWorking(!this.input.nextLine().contains("quebrado"));

        if (item.isWorking()) {
            System.out.print("Encantado (sim/não)? ");
            item.setMagic(this.input.nextLine().contains("s"));
        }

        return item;
    }

    private void create () {
        Item item;

        item = configureItem(new Item());
        this.manager.create(item);

        System.out.println("Ítem adicionado!\n");
    }

    private void update () {
        int index;
        Item item;

        index = getIndex();

        if (index < 0) {
            System.out.println("Ítem não encontrado");
            return;
        }

        item = configureItem(new Item());
        this.manager.update(index, item);
        System.out.println("Ítem modificado");
    }

    private void list () {
        String options;
        String name;
        boolean onlyArmed;
        Item[] data;

        while (true) {
            name = "";
            onlyArmed = false;

            System.out.println("O que você deseja visualizar?\n" +
                    "a. Informações sobre um item\n" +
                    "b. Todos os itens no inventário\n" +
                    "c. Itens equipados\n" +
                    "d. Voltar");

            //accepting multiple options
            options = this.input.nextLine();

            if (options.contains("d")) {
                return;
            }

            if (options.contains("a")) {
                System.out.print("Nome do ítem: ");
                name = this.input.nextLine();
            }

            if (options.contains("c")) {
                onlyArmed = true;
            }

            if (options.contains("b")) {
                onlyArmed = false;
                name = "";
            }

            data = this.manager.filter(this.manager.getAll(), this.manager.getRig(), name, onlyArmed);

            if (data.length == 0) {
                System.out.println("\nSem resultados.\n");

                if (name.equals("")) {
                    break;
                }

                continue;
            }

            System.out.println("\nResultados:\n");

            for (Item datum : data) {
                if (datum != null) {
                    System.out.println("\n" + datum);
                }
            }

            break;
        }
    }

    private void delete () {
        int index;

        index = getIndex();

        if (index < 0) {
            System.out.println("Ítem não encontrado");
            return;
        }

        this.manager.delete(index);
        System.out.println("Ítem removido");
    }

    private void arm (boolean arm) {
        int index;

        index = getIndex();

        if (index < 0) {
            System.out.println("Ítem não encontrado");
            return;
        }

        if (!this.manager.get(index).isWorking()) {
            System.out.println("Ítem quebrado não pode ser equipado");
            return;
        }

        this.manager.setArm(index, arm);
        System.out.println("Ítem equipado");
    }

    public void getPayload () {
        int code = -1;

        while (code != 7) {
            System.out.print("1. Armazenar um item no inventário\n" +
                    "2. Equipar um item\n" +
                    "3. Desequipar um item\n" +
                    "4. Modificar um item\n" +
                    "5. Descartar um item\n" +
                    "6. Exibir itens\n" +
                    "7. Retornar à jornada\n" +
                    "Opção: ");

            code = this.input.nextInt();
            this.input.nextLine();

            switch (code) {
                case 1: this.create(); break;
                case 2: this.arm(true); break;
                case 3: this.arm(false); break;
                case 4: this.update(); break;
                case 5: this.delete(); break;
                case 6: this.list(); break;
                case 7: System.out.println("Tchau.");
            }
        }
    }

    public Main() {
        boolean[] rig = new boolean[1000];

        Arrays.fill(rig, Boolean.FALSE);

        this.manager = new Manager(new Item[1000], rig, 0);
        this.input = new Scanner(System.in);

        this.getPayload();
    }

    public static void main (String[] args) {
        new Main();
    }
}
