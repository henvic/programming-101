package hvop.q1;
import java.util.Scanner;

public class TrashTalker {
    private static String[] ok = {
            //understanding...
            "Sei...",
            "Hum...",
            "Entendo...",
            "Tá bom então.",
            "Que maravilha",
            "Se você está falando..."
    };

    private static String[] questions = {
            //games
            "Você sabia que o GTA V foi lançado?",
            "Já jogou Tetrinet? É parecido com o jogo Tetris, só que em multiplayer. Sabe quem é o campeão mundial?",
            "Você prefere jogar ping-pong ou tênis? Eu sou ótimo em tênis de mesa. E você?",
            "jogos são um desperdício de tempo, você não acha?",
            "Vamos marcar x1 qualquer dia desses?",

            //food
            "Eu prefiro comida italiana à mexicana, mas adoro quesadilhas. Você gosta de pizza?",
            "Já tomou sorvete de manga com jiló?",
            "Você gosta de tofu e soja?",
            "Sabia que um tal Robert Malthus jurava que ia acabar a comida para a humanidade e isso não faz sentido?",
            "Você gosta de fast food ou prefere ir a um bom restaurante mesmo pagando mais caro?",

            //psicologia
            "Ser ou não ser, o que você prefere?",
            "Nem tudo que você entende que eu falo é o que eu quero dizer. E aí?",
            "Nós julgamos as pessoas a cada momento. Você costuma julgar errado?",
            "Nunca cherei pó e você? Quer que eu seja seu terapeuta?",
            "Não vou poder te ajudar porque o sistema está congestionado. Gostaria de alguma ajuda?",

            //relatividade quântica
            "Você viu um gato que estava ali, mas viajou no tempo?",
            "Você está ficando vermelho! Vá mais devagar!!! Quer levar uma multa?",
            "Um gato morto-vivo é um zoombie?",
            "Eu sinto um buraco negro se aproximando de nós. Vamos fugir?",
            "Cuidado com as minhocas. Sabia que elas podem te levar para longe?"
    };

    private static String getOkMessage () {
        return ok[(int) (Math.random() * ok.length)];
    }

    public static void main (String[] args) {
        int question = 1;

        String userInput;

        Scanner input;

        input = new Scanner(System.in);

        System.out.print("O que é? Está todo mundo ocupado. Eu sou um robô.\n\n" +
                "Use \"chega\" para terminar um assunto e \"tchau\" para finalizar a nossa conversa.\n\n" +
                "Em que posso ajudá-lo? ");

        while (true) {
            userInput = input.nextLine().toLowerCase();

            if (userInput.contains("tchau")) {
                System.out.println("Tá. Até logo!");
                break;
            }

            if (userInput.contains("chega")) {
                System.out.println("Tá bom então... mas...");

                question += 6 - (question % 5);

                if (question >= 20) {
                    question = 1;
                }
            }

            System.out.println(getOkMessage());

            System.out.print(questions[question - 1] + " ");

            question = (question < 20) ? question + 1 : 1;
        }
    }
}
