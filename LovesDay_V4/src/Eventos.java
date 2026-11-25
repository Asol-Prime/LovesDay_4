import java.util.Random;

public class Eventos {

    // -------------------------------------------------------------
    // CHANCE DE ACONTECER UM EVENTO ANTES DE CADA ENCONTRO
    // -------------------------------------------------------------
    static int CHANCE_EVENTO = 25;

    // -------------------------------------------------------------
    // TEXTO DO EVENTO, BÔNUS DE CHANCE NO PRÓXIMO ENCONTRO (%)
    // EVENTOS DE CASH E VIDA SÃO TRATADOS SEPARADOS NO SORTEAR
    // -------------------------------------------------------------
    static String[][] EVENTOS_CHANCE = {
        {"Uma pessoa desconhecida elogiou seu visual. Que autoestima!", "10"},
        {"Começou a chover do nada e você estava sem guarda-chuva...", "-10"},
        {"Uma cartomante leu sua mão e disse que o amor está muito perto.", "15"},
        {"Você pisou num chiclete e passou o caminho todo tentando tirar.", "-5"},
        {"Ganhou uma amostra grátis de perfume numa loja. Cheirinho bom!", "5"},
    };

    // SORTEIA UM EVENTO (OU NADA) E DEVOLVE O BÔNUS DE CHANCE PARA O PRÓXIMO ENCONTRO
    public static int sortear(Status status) {
        Random random = new Random();
        if (random.nextInt(100) >= CHANCE_EVENTO) {
            return 0;
        }

        int evento = random.nextInt(EVENTOS_CHANCE.length + 2);

        // ACHOU DINHEIRO NO CHÃO
        if (evento == EVENTOS_CHANCE.length) {
            int valor = 10 + random.nextInt(21);
            status.cash += valor;
            Tela.caixa("EVENTO", "Você achou dinheiro no chão!", "+" + valor + " cash  |  Cash total: " + status.cash);
            System.out.println();
            return 0;
        }

        // ENCONTROU O EX
        if (evento == EVENTOS_CHANCE.length + 1) {
            Tela.caixa("EVENTO", "Seu ex passou e te deu um fora em público...", "Que vergonha! -1 vida");
            status.perderVida();
            System.out.println();
            return 0;
        }

        String[] sorteado = EVENTOS_CHANCE[evento];
        int bonus = Integer.parseInt(sorteado[1]);
        String efeito = (bonus > 0 ? "+" : "") + bonus + "% de chance no próximo encontro";
        Tela.caixa("EVENTO", sorteado[0], efeito);
        System.out.println();
        return bonus;
    }
}
