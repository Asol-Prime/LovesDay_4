import java.util.Random;
import java.util.Scanner;

public class NPCTwink extends NPCs {

    public NPCTwink(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "TWINK", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES TWINK
        // -------------------------------------------------------------

        String[] acoes = {
            "está balançando um copo grande de iced coffee com canudo biodegradável enquanto cantarola baixinho o novo hit da Charli XCX.",
            "está aplicando protetor solar coreano com efeito glow e conferindo a pele impecável na câmera frontal do celular.",
            "solta um estalo com a língua, ajeita o cropped oversized e exclama: \"Amiga, a energia desse lugar tá super flopada hoje!\"",
            "está retocando o lip oil de cereja nos lábios enquanto debate apaixonadamente qual era da Lady Gaga foi a mais revolucionária.",
            "dá um passo dramático para trás, coloca as mãos no queixo e diz: \"Você serviu muito conceito com essa presença, babado puro!\"",
        };

        // -------------------------------------------------------------
        // AÇÕES TWINK
        // -------------------------------------------------------------

        Random random = new Random();

        String acao = acoes[random.nextInt(acoes.length)];
        String artigo = generoNPC.equals("FEMININO") ? "a" : "o";
        String pronome = generoNPC.equals("FEMININO") ? "Ela" : "Ele";
        Tela.encontro(localAtual, artigo, nomeNPC, estiloNPC, pronome + " " + acao);
    }

    @Override
    public int conversa(Scanner leitor, String estiloJogador, int bonus, Status status) {

        String pronome = generoNPC.equals("FEMININO") ? "Ela" : "Ele";
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
                // TWINK ESTA DENOMINADA COMO GAY
                // --------------------------------------------------------------

                if ("FEMININO".equals(generoJogador)) {
                    Tela.fala(nomeNPC + " faz um sinal com a mão:");
                    Tela.fala("\"Mona, olha pra minha cara. Você acha que eu gosto dessa fruta? Deus me livre!\"");
                    status.perderVida();
                    Tela.rejeitado();
                    return 1;
                }

                // --------------------------------------------------------------
                // TWINK ESTA DENOMINADA COMO GAY
                // --------------------------------------------------------------
                

                // PERGUNTA 1
                if (estiloNPC.equals("TWINK")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "Qual diva pop soberana é a verdadeira dona da cultura musical?",
                            "Charli xcx ou lady gaga no auge do eletropop.",
                            "Dupla sertaneja masculina.",
                            "Lana del rey.",
                            "Banda de rock de tiozão.");
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

                    if (opcao == 1) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " solta um berro animado e bate cabelo: \"MOTHER IS MOTHERING! Bicha, você entende o que é ser artista de verdade! É o puro suco do pop gay!\"");
                    } else if (opcao == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " suspira dramático com a mão no peito: \"Nossa mãe da tristeza poética... me dá vontade de fumar um cigarro imaginário na Califórnia.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " tampa os ouvidos com cara de desespero: \"Pelo amor de Deus, apaga isso agora! Energia hetero demais pro meu gosto, meus chakras fecharam todinhos!\"");
                    }

                    // PERGUNTA 2

                    Tela.pergunta(nomeNPC, "Qual é a bebida que toma de manhã?",
                            "Iced latte de baunilha com leite de aveia trincando de gelo.",
                            "Chá quente amargo de boldo.",
                            "Energético zero açúcar em lata ultra estética.",
                            "Caldo de mocotó servido na cumbuca.");
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

                    if (opcao2 == 1) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " chacoalha as pedras de gelo do copo sorrindo: \"SIM! É a poção mágica que me mantém acordado e glamuroso o dia inteiro!\"");
                    } else if (opcao2 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " dá uma risadinha: \"Super estético, zero caloria e me deixa elétrico pra dançar na balada até de manhã!\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " dá um passo atrás com nojinho: \"Gente, que horror! Isso aí é pesado demais pro meu estômago sensível de passarinho!\"");
                    }

                    //PERGUNTA 3

                    Tela.fala(nomeNPC + " passa um gloss brilhante nos lábios e te olha de cima a baixo...");
                    Tela.pergunta(nomeNPC, "Menina, qual é o seu segredo indispensável de autocuidado e estética no dia a dia?",
                            "Uma rotina de skincare de 7 passos com muito protetor e gloss.",
                            "Lavar o rosto apenas com sabonete em barra de corpo e sair.",
                            "Passar duas horas escolhendo um look oversized de grife bem estiloso.",
                            "Tomar banho de sol sem filtro solar pra ficar bronzeado.");
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
                        Tela.fala(nomeNPC + " passa a mão no próprio rosto: \"Pele de porcelana sim! Hidratação é tudo nesse mundo, você tem muito bom gosto!\"");
                    } else if (opcao3== 3) {
                        pontos += 15;
                        Tela.fala(nomeNPC + " dá um sorrisinho aprovação: \"Look é tudo! Servir conceito visual na rua é o nosso maior talento.\"");
                    } else {
                        pontos -= 25;
                        Tela.fala(nomeNPC + " finge desmaiar de horror: \"Sabonete de corpo no rosto?! Sem filtro solar?! Minha nossa, a minha pele até envelheceu dez anos só de ouvir isso!\"");
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
