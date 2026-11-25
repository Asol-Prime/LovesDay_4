import java.util.Random;
import java.util.Scanner;

public class NPCAgroboy extends NPCs {

    public NPCAgroboy(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "AGROBOY", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES AGROBOY
        // -------------------------------------------------------------

        String[] acoes = {
            "está limpando a bota texana de couro com uma flanela enquanto ajeita a fivela gigante de touro no cinto.",
            "está ouvindo modão sertanejo no talo enquanto toma um tereré trincando de gelado na guampa de chifre.",
            "masca um pedaço de capim, ajeita o chapéu de feltro e solta um sonoro: \"Aooow potência!\"",
            "está conferindo a cotação da arroba do boi gordo e a previsão do tempo para a safra no celular.",
            "está contando vantagem sobre quantos hectares de terra e quantas cabeças de gado a família tem no interior.",
        };

        // -------------------------------------------------------------
        // AÇÕES AGROBOY
        // -------------------------------------------------------------

        Random random = new Random();

        String acao = acoes[random.nextInt(acoes.length)];
        String artigo = generoNPC.equals("FEMININO") ? "a" : "o";
        String pronome = generoNPC.equals("FEMININO") ? "Ela" : "Ele";
        Tela.encontro(localAtual, artigo, nomeNPC, estiloNPC, pronome + " " + acao);
    }

    @Override
    public int conversa(Scanner leitor, String estiloJogador, int bonus, Status status) {

        String pronome = generoNPC.equals("FEMININO") ? "ela" : "ele";
        System.out.println();
        Tela.caixa("O QUE VOCÊ FAZ?", "[1] - Puxar assunto", "[2] - Deixar passar", "[9] - Abandonar o dia (-1 vida por encontro restante)");
        System.out.print("\nSelecione uma opção: ");
        int escolha;
        while (true) {
            try {
                escolha = Integer.parseInt(leitor.nextLine());
                if (escolha == 1 || escolha == 2 || escolha == 9) {
                    break;
                }
            } catch (NumberFormatException erro) {
            }

            System.out.println("Digite um número válido!");
            System.out.print("Selecione uma opção: ");
        }

        switch (escolha) {
            case 1:

                // --------------------------------------------------------------
                // AGROBOY ESTA DENOMINADA COMO HETERO
                // --------------------------------------------------------------

                if ("MASCULINO".equals(generoJogador) && "MASCULINO".equals(generoNPC)) {
                    Tela.fala(nomeNPC + " coloca o chapéu e ajeita a fivela...");
                    Tela.fala("\"Uai so, uce não faz o meu tipo não. Gosto é das muié braba e arretada\"");
                    status.perderVida();
                    Tela.rejeitado();
                    return 1;
                }
                if ("FEMININO".equals(generoJogador) && "FEMININO".equals(generoNPC)) {
                    Tela.fala(nomeNPC + " ajeita os óculos e te olha com cara de desdém");
                    Tela.fala("\"Segundo meus cálculos, eu só me relaciono com garotos. Rejeição com 100% de probabilidade.\"");
                    status.perderVida();
                    Tela.rejeitado();
                    return 1;
                }

                // --------------------------------------------------------------
                // AGROBOY ESTA DENOMINADA COMO HETERO
                // --------------------------------------------------------------
                

                // PERGUNTA 1
                if (estiloNPC.equals("AGROBOY")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "Qual é o carro perfeito para andar no barro?",
                            "Carro esportivo rebaixado.",
                            "Hilux 4x4 levantada com som na caçamba.",
                            "Carro elétrico econômico.",
                            "Moto de trilha 250cc.");
                    System.out.print("\nSelecione uma opção: ");
                    int opcao;
                    while (true) {
                        try {
                            opcao = Integer.parseInt(leitor.nextLine());
                            if (opcao >= 1 && opcao <= 4) {
                                break;
                            }
                        } catch (NumberFormatException erro) {
                        }

                        System.out.println("Digite um número válido!");
                        System.out.print("Selecione uma opção: ");
                    }

                    if (opcao == 2) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " solta um sonoro 'Aooow potência!' e bate na fivela: \"Máquina bruta de verdade que não atola em lugar nenhum!\"");
                    } else if (opcao == 4) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " acena com a cabeça: \"Boa demais pra tocar a boiada e andar nos pastos fundos.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " torce o nariz e cospe o capim: \"Isso aí não aguenta nem a primeira valeta da estrada de chão!\"");
                    }

                    // PERGUNTA 2

                    Tela.pergunta(nomeNPC, "O que não pode faltar de jeito nenhum no seu fim de semana?",
                            "Balada de música eletrônica.",
                            "Feirinha vegana no parque.",
                            "Churrasco com costela de chão e viola caipira.",
                            "Pescaria no rio com os amigos.");
                    System.out.print("\nSelecione uma opção: ");
                    int opcao2;
                    while (true) {
                        try {
                            opcao2 = Integer.parseInt(leitor.nextLine());
                            if (opcao2 >= 1 && opcao2 <= 4) {
                                break;
                            }
                        } catch (NumberFormatException erro) {
                        }
                        System.out.println("Digite um número válido!");
                        System.out.print("Selecione uma opção: ");
                    }

                    if (opcao2 == 3) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " abre um sorrisão largo: \"Aí cê falou a minha língua! Carne gorda no braseiro e modão xonado!\"");
                    } else if (opcao2 == 4) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " concorda rindo: \"Uma pescaria tomando uma gelada também tem o seu valor, sossego puro.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " faz cara de tédio: \"Que programinha sem sal... faltou uma viola caipira e carne de verdade!\"");
                    }

                    // PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Qual é a bebida indispensável para aguentar o calor da lida?",
                            "Tereré trincando com hortelã.",
                            "Cappuccino com leite vegetal.",
                            "Cerveja puro malte bem gelada.",
                            "Energético sabor melancia.");
                    System.out.print("\nSelecione uma opção: ");
                    int opcao3;
                    while (true) {
                        try {
                            opcao3 = Integer.parseInt(leitor.nextLine());
                            if (opcao3 >= 1 && opcao3 <= 4) {
                                break;
                            }
                        } catch (NumberFormatException erro) {
                        }
                        System.out.println("Digite um número válido!");
                        System.out.print("Selecione uma opção: ");
                    }

                    if (opcao3 == 1) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " oferece a guampa feliz da vida: \"Gelado e na bomba de inox! Hidrata e dá força pra aguentar a lida!\"");
                    } else if (opcao3 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " dá um tapinha no seu ombro: \"No final da tarde depois do trabalho, desce que é uma beleza!\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " olha desconfiado: \"Que frescura é essa? Café lá na roça é coado no pano e forte, isso aí faz mal pro bucho!\"");
                    }


                    // Cálculo da probabilidade (executado uma única vez ao final das escolhas)
                    int pTotal = bonus + pontos + status.getBonusCompra(estiloNPC);
                    int probabilidade = Math.min(Math.max(pTotal, 0), 100);
                    System.out.println();
                    Tela.caixa("CONVERSA", "Pontos da conversa: " + pontos, "Chance de match: " + probabilidade + "%");

                    while (true) {
                        Random random = new Random();
                        int sorteio = random.nextInt(100) + 1;

                        if (sorteio <= probabilidade) {
                            status.adicionarMatch();
                            Tela.match();
                            break;
                        }

                        status.perderVida();
                        Tela.rejeitado();

                        if (!status.podeUsarTrufilho()) {
                            break;
                        }

                        System.out.println();
                        Tela.caixa("TRUFILHO", "Usar o Trufilho para tentar de novo?", "[1] - SIM", "[2] - NÃO");
                        System.out.print("\nSelecione uma opção: ");
                        int usarTrufilho = lerOpcaoTrufilho(leitor);

                        if (usarTrufilho == 2) {
                            break;
                        }

                        status.usarTrufilho();
                        System.out.println("\nVocê usou o Trufilho! Esta é sua última tentativa do dia.");
                    }
                }
                break;

            case 2:
                System.out.println("\nVocê decidiu deixar passar e seguir em frente.");
                break;

            case 9:
                System.out.println("\nVocê abandonou o dia...");
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        return escolha;
    }

    private int lerOpcaoTrufilho(Scanner leitor) {
        while (true) {
            try {
                int opcao = Integer.parseInt(leitor.nextLine());
                if (opcao == 1 || opcao == 2) {
                    return opcao;
                }
            } catch (NumberFormatException erro) {
            }

            System.out.println("Digite um número válido!");
            System.out.print("Selecione uma opção: ");
        }
    }

}
