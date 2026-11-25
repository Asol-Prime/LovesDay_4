import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);

        Personagem personagem = null;
        Status status = null;

        while (personagem == null) {
            Tela.cabecalho("Bem-vindo");
            Tela.caixa("INICIO", "[1] - JOGAR", "[2] - CONTINUAR", "[3] - SAIR");
            System.out.print("\nEscolha uma opção: ");
            String opcaoInicio = leitor.nextLine();

            if (opcaoInicio.equals("1")) {
                personagem = Personagem.criar(leitor);
                if (personagem == null) {
                    System.out.print("\033[0m");
                    return;
                }
                status = new Status();
            } else if (opcaoInicio.equals("2")) {
                Object[] save = Save.carregar();
                if (save == null) {
                    System.out.println("Nenhum save válido encontrado!");
                    Tela.pausar(leitor);
                } else {
                    personagem = (Personagem) save[0];
                    status = (Status) save[1];
                }
            } else if (opcaoInicio.equals("3")) {
                System.out.println("Saindo do jogo...\033[0m");
                return;
            }
        }

        Tela.definirCor(personagem.genero);

        while (true) {
            Tela.cabecalho("Menu Principal");
            Tela.caixa("STATUS", personagem.nome + " | Estilo: " + personagem.estilos,
                    "Renascimentos: " + status.renascimentos + " | Dia: " + status.diaAtual + " | Matchs: " + status.matchs + " | Cash: " + status.cash + " | Vidas: " + status.vidas);
            Tela.caixa("MENU", "[1] - COMEÇAR NOVO DIA", "[2] - LOJA", "[3] - INVENTARIO", "[4] - SALVAR", "[9] - SAIR");
            System.out.print("\nEscolha uma opção: ");
            int opcaoMenu;
            try {
                opcaoMenu = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException erro) {
                continue;
            }

            switch (opcaoMenu) {
                case 1:
                    Dias.iniciar(personagem, leitor, status);
                    if (status.morreu()) {
                        Renascer.executar(leitor, status, personagem);
                    }
                    break;

                case 2:
                    Loja.abrir(leitor, status);
                    break;

                case 3:
                    Tela.cabecalho("Inventario");
                    status.inventario.mostrar();
                    Tela.pausar(leitor);
                    break;

                case 4:
                    Save.salvar(personagem, status);
                    Tela.pausar(leitor);
                    break;

                case 9:
                    System.out.println("Saindo do jogo...\033[0m");
                    return;

                default:
                    break;
            }
        }
    }
}
