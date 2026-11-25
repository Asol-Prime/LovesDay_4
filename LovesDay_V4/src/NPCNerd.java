import java.util.Random;
import java.util.Scanner;

public class NPCNerd extends NPCs {
    public NPCNerd(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "NERD", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÃO QUE DEFINE O QUE O PERSONAGEM -- NERD -- VAI FALAR QUANDO O JOGADOR O ENCONTRAR
        // -------------------------------------------------------------

        String[] acoes = {
            "está invadindo o \"firewall\" de algum bot do Discord enquanto reclama da latência da rede.",
            "está assistindo ao show holográfico da Hatsune Miku no YouTube com fones profissionais.",
            "acabou de gritar \"SASAGEYO!\" batendo a mão no peito e anda acelerado em sua direção.",
            "está corrigindo uma inconsistência na cronologia do multiverso mesmo sem ninguém ter perguntado.",
            "puxa o notebook do absoluto nada de dentro da bolsa, e começa a compilar código freneticamente.",
        };

        // -------------------------------------------------------------
        // NA PARTE DE CIMA, APENAS ADICIONE NOVAS AÇÕES AO NERD (CASO PRECISE)
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
                // NERD É HETERO
                // --------------------------------------------------------------

                if ("MASCULINO".equals(generoJogador) && "MASCULINO".equals(generoNPC)) {
                    Tela.fala(nomeNPC + " ajeita os óculos e te olha com cara de desdém");
                    Tela.fala("\"Segundo meus cálculos, eu só me relaciono com garotas. Rejeição com 100% de probabilidade.\"");
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

                // PERGUNTA 1
                if (estiloNPC.equals("NERD")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "Qual gênero de filme você mais gosta?",
                            "Ação genérica sem história.",
                            "Ficção científica com paradoxos.",
                            "Animação / anime clássico.",
                            "Reality show de subcelebridades.");
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
                        Tela.fala(nomeNPC + " ajeita os óculos animado: \"Brilhante! Viagens temporais e paradoxos quânticos são o ápice do cinema!\"");
                    } else if (opcao == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " acena com a cabeça: \"Excelente! Muitas animações dão uma surra de narrativa e roteiro em live-actions.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " coloca a mão na testa em desespero: \"Meus neurônios entram em combustão espontânea só de imaginar assistir a isso...\"");
                    }
                    
                //PERGUNTA 2
                    Tela.fala(nomeNPC + " se empolga e ajeita os óculos.");
                    Tela.fala("\"Qual saga épica merece o título de obra-prima absoluta?\"");
                    Tela.pergunta(nomeNPC, "E qual dessas sagas é a sua favorita?",
                            "Velozes e furiosos.",
                            "Universo cinematográfico marvel.",
                            "O Senhor dos anéis & star wars clássico.",
                            "Novelas da tarde.");
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
                        Tela.fala(nomeNPC + " faz uma reverência respeitosa: \"Você citou os pilares sagrados de toda a cultura nerd contemporânea! Respeito eterno!\"");
                    } else if (opcao2 == 2) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " concorda positivamente: \"A Saga do Infinito foi muito bem construída e marcou época no cinema geek.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " torce o nariz indignado: \"Carros quebrando as leis da física ou drama barato sem nexo? Passo longe!\"");
                    }

                    //PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Qual é a melhor programação para uma noite de sexta-feira?",
                            "Sessão épica de rpg de mesa com pizza.",
                            "Maratona de gameplays e speedruns.",
                            "Balada lotada e barulhenta.",
                            "Dormir às 20:00h");
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
                        Tela.fala(nomeNPC + " abre um sorrisão e pega os dados: \"Role um d20 com vantagem! Derrotar dragões com a guilda é insuperável!\"");
                    } else if (opcao3 == 2) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " dá um joinha: \"Aprender técnicas de otimização de speedrun frame a frame é pura arte.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " se arrepia de pavor: \"Sair de casa pra ficar num lugar barulhento? Minha bateria social zera em 30 segundos!\"");
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