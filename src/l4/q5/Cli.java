package l4.q5;

import l4.q1.*;
import l4.q4.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cli {
    // actions
    private final char CREATE = 'c';
    private final char READ = 'r';
    private final char UPDATE = 'u';
    private final char DELETE = 'd';

    // entities
    private final char CARGO_OPTION = '1';
    private final char EXPLORATION_ROCKET_OPTION = '2';
    private final char CARGO_ROCKET_OPTION = '3';
    private final char EXPLORATION_ROBOT_OPTION = '4';

    private Scanner input;
    private Facade facade;

    private String[] getArrayOfPassengers (int amount) {
        String[] passengers = new String[amount];

        for (int counter = 1; counter <= amount; counter += 1) {
            System.out.print("Passageiro " + counter + ": ");
            passengers[counter - 1] = input.nextLine();
        }

        return passengers;
    }

    private void createCargo () {
        int id, amount, specialInstrument;
        String name;

        System.out.print("Nome da carga: ");
        name = input.nextLine();

        try {
            System.out.print("Quantidade alocada: ");
            amount = input.nextInt();
            input.nextLine();

            System.out.print("Id do instrumento especial alocado: ");
            specialInstrument = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException ignore) {
            System.out.println("Tipo inválido.");
            return;
        }

        try {
            id = facade.createCargo(name, amount, specialInstrument);
            System.out.println("Carga #" + id + " criada com sucesso.");
        } catch (IllegalNumberException ignore) {
            System.out.println("Número ilegal usado. Use apenas valores absolutos.");
        } catch (InvalidInstrumentTypeException ignore) {
            System.out.println("Carga deve ser alocada apenas para foguete de carga e robô de exploração.");
        } catch (ObjectNotFoundException ignore) {
            System.out.println("O objeto (instrumento especial) não foi encontrado.");
        } catch (ObjectAlreadyExistsException ignore) {
            System.out.println("Tentativa de adicionar carga com ID já existente no repositório.");
        } catch (ExhaustedCargoCellsException ignore) {
            System.out.println("Tentativa de adicionar mais célula de carga do que o objeto aceita.");
        }
    }

    private void createExplorationRocketOption () {
        int id, cost, height, length, width, fuel, totalPassengers;
        String destination, pilot;
        String[] passengers;

        try {
            System.out.print("Custo: ");
            cost = input.nextInt();
            input.nextLine();

            System.out.print("Altura: ");
            height = input.nextInt();
            input.nextLine();

            System.out.print("Largura: ");
            width = input.nextInt();
            input.nextLine();

            System.out.print("Comprimento: ");
            length = input.nextInt();
            input.nextLine();

            System.out.print("Combustível: ");
            fuel = input.nextInt();
            input.nextLine();

            System.out.print("Destino: ");
            destination = input.nextLine();

            System.out.print("Piloto: ");
            pilot = input.nextLine();

            System.out.print("Número de passageiros: ");

            totalPassengers = input.nextInt();
            input.nextLine();

            if (totalPassengers < 0) {
                throw new IllegalNumberException();
            }

            passengers = this.getArrayOfPassengers(totalPassengers);

            id = facade.createExplorationRocket(cost, height, length, width, fuel, destination, pilot, passengers);

            System.out.println("Foguete de exploração #" + id + " criado.");
        } catch (InputMismatchException ignore) {
            System.out.println("Tipo inválido.");
        } catch (IllegalNumberException ignore) {
            System.out.println("Número ilegal usado. Use apenas valores absolutos.");
        }
    }

    private void createCargoRocketOption () {
        int id, cost, height, length, width, fuel, maxCargoCells;
        String destination, pilot;

        try {
            System.out.print("Custo: ");
            cost = input.nextInt();
            input.nextLine();

            System.out.print("Altura: ");
            height = input.nextInt();
            input.nextLine();

            System.out.print("Largura: ");
            width = input.nextInt();
            input.nextLine();

            System.out.print("Comprimento: ");
            length = input.nextInt();
            input.nextLine();

            System.out.print("Combustível: ");
            fuel = input.nextInt();
            input.nextLine();

            System.out.print("Destino: ");
            destination = input.nextLine();

            System.out.print("Piloto: ");
            pilot = input.nextLine();

            System.out.print("Máximo de cargas: ");
            maxCargoCells = input.nextInt();
            input.nextLine();

            id = facade.createCargoRocket(cost, height, length, width, fuel, destination, pilot, maxCargoCells);
            System.out.println("Foguete de carga #" + id + " criado.");
        } catch (IllegalNumberException ignore) {
            System.out.println("Número ilegal usado. Use apenas valores absolutos.");
        } catch(InputMismatchException ignore) {
            System.out.println("Tipo inválido.");
        }
    }

    private void createExplorationRobotOption () {
        int id, cost, fuel, eta, maxCargoCells;
        boolean freighter;
        String destination;

        maxCargoCells = 0;

        try {
            System.out.print("Custo: ");
            cost = input.nextInt();
            input.nextLine();

            System.out.print("Combustível: ");
            fuel = input.nextInt();
            input.nextLine();

            System.out.print("Destino: ");
            destination = input.nextLine();

            System.out.print("Tempo de chegada ao destino: ");
            eta = input.nextInt();
            input.nextLine();

            System.out.print("Armazena carga (s/n): ");
            freighter = (!input.nextLine().contains("n"));

            if (freighter) {
                System.out.print("Quantidade máxima de carga: ");
                maxCargoCells = input.nextInt();
                input.nextLine();
            }

            id = facade.createExplorationRobot(cost, destination, eta, fuel, freighter, maxCargoCells);
            System.out.println("Robô de exploração #" + id + " criado.");
        } catch (InputMismatchException ignore) {
            System.out.println("Tipo inválido.");
        } catch (IllegalNumberException ignore) {
            System.out.println("Número ilegal usado. Use apenas valores absolutos.");
        } catch (InvalidCargoException ignore) {// it's never gonna happen
        }
    }

    private void create(char object) {
        switch (object) {
            case CARGO_OPTION: this.createCargo(); break;
            case EXPLORATION_ROCKET_OPTION: this.createExplorationRocketOption(); break;
            case CARGO_ROCKET_OPTION: this.createCargoRocketOption(); break;
            case EXPLORATION_ROBOT_OPTION: this.createExplorationRobotOption(); break;
        }
    }

    private void read() {
        System.out.print("Ler objeto #");

        try {
            System.out.println(facade.get(input.nextInt()));
        } catch (InputMismatchException ignore) {
            System.out.println("Tipo inválido.");
        } catch (ObjectNotFoundException ignore) {
            System.out.println("Objeto não encontrado.");
        } finally {
            input.nextLine();
        }
    }

    private void updateRocket(Rocket rocket) {
        int fuel;
        String pilot, destination;

        try {
            System.out.print("Piloto: ");
            pilot = input.nextLine();

            System.out.print("Combustível: ");
            fuel = input.nextInt();
            input.nextLine();

            System.out.print("Destino: ");
            destination = input.nextLine();
        } catch (InputMismatchException ignore) {
            System.out.println("Tipo inválido.");
            return;
        }

        facade.update(rocket, fuel, pilot, destination);
    }

    private void updateExplorationRobot(ExplorationRobot explorationRobot) {
        int eta, fuel;
        String destination;

        //to alter the cargo, use its cli interface directly
        try {
            System.out.print("Combustível: ");
            fuel = input.nextInt();
            input.nextLine();

            System.out.print("Destino: ");
            destination = input.nextLine();

            System.out.print("Tempo de chegada ao destino: ");
            eta = input.nextInt();
            input.nextLine();

            facade.update(explorationRobot, fuel, eta, destination);
        } catch (InputMismatchException ignore) {
            System.out.println("Tipo inválido.");
        }
    }

    private void update() {
        Object o;

        System.out.print("Atualizar propriedades do objeto #");

        try {
            o = facade.get(input.nextInt());
            input.nextLine();

            if (o instanceof Rocket) {
                this.updateRocket((Rocket) o);
                return;
            }

            if (o instanceof ExplorationRobot) {
                this.updateExplorationRobot((ExplorationRobot) o);
                return;
            }

            throw new TypeMismatchException();
        } catch (ObjectNotFoundException ignore) {
            System.out.println("Objeto não encontrado.");
        } catch (TypeMismatchException ignore) {
            System.out.println("Não é permitido alterar objeto deste tipo.");
        }
    }

    private void delete() {
        System.out.print("Remover objeto #");

        try {
            facade.delete(input.nextInt());
            input.nextLine();
            System.out.println("Objeto removido.");
        } catch (InputMismatchException ignore) {
            System.out.println("Tipo inválido.");
        } catch (ObjectNotFoundException ignore) {
            System.out.println("Objeto não encontrado.");
        } catch (TypeMismatchException ignore) {
            System.out.println("Tipo de objeto não identificado.");
        }
    }

    private void make (String options) {
        char action, object = '\0';
        int length;

        length = options.length();

        if (length < 1 || (length < 2 && options.charAt(0) == 'c')) {
            System.out.println("Comando inválido.");
            return;
        }

        action = options.charAt(0);

        if (action == 'c') {
            object = options.charAt(1);
        }

        switch (action) {
            case CREATE: this.create(object); break;
            case READ: this.read(); break;
            case UPDATE: this.update(); break;
            case DELETE: this.delete(); break;
            default: System.out.println("Comando inválido.\n");
        }
    }

    public void run () {
        String options;

        System.out.print("Sistema de organização da NASA");

        while (true) {
            System.out.print("\n\nAções permitidas:\n" +
                    CREATE + " - Criar um objeto\n" +
                    READ + " - Ler um objeto\n" +
                    UPDATE + " - Atualizar um objeto\n" +
                    DELETE + " - Remover objeto\n\n" +
                    "Tipos de objetos que podem ser criados:\n" +
                    CARGO_OPTION + " - Carga\n" +
                    EXPLORATION_ROCKET_OPTION + " - Foguete de Exploração\n" +
                    CARGO_ROCKET_OPTION + " - Foguete de carga\n" +
                    EXPLORATION_ROBOT_OPTION + " - Robô de Exploração\n\n" +
                    "Formato de entrada para criação de objeto: <ação><objeto> (i.e., c4)\n" +
                    "Digite \"sair\" para fechar o programa.\n\n" +
                    "Opção: ");

            options = input.nextLine();

            if (options.equalsIgnoreCase("sair")) {
                System.out.println("Tchau!\n");
                System.exit(0);
            }

            make(options);
        }
    }

    public Cli (Scanner input, Facade facade) {
        this.input = input;
        this.facade = facade;
    }

    public static void main (String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            new Cli(input, new Facade()).run();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado no sistema.\n" +
                    "É possível que o sistema esteja em um estado inconsistente.\n");
            System.out.println(e);
        }
    }
}
