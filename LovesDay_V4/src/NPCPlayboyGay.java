import java.util.Random;
import java.util.Scanner;

public class NPCPlayboyGay extends NPCs {

    public NPCPlayboyGay(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "PLAYBOY GAY", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {
        // -------------------------------------------------------------
        // AÇÃO QUE DEFINE O QUE O PERSONAGEM -- PLAYBOY GAY -- VAI FALAR QUANDO O JOGADOR O ENCONTRAR
        // -------------------------------------------------------------

        String[] acoes = {
            "está conferindo se o cartão black sem limites está na carteira de couro da Jacquemus enquanto ajeita os óculos escuros de grife.",
            "dá um gole delicado no seu iced latte de amêndoas com essência de baunilha e suspira: \"Ninguém merece o calor dessa cidade sem ar condicionado central!\"",
            "está checando passagens de primeira classe para Mykonos e Trancoso enquanto reclama que o euro subiu essa semana.",
            "borrifa um perfume francês caríssimo de nicho no ar e passa por baixo da névoa fechando os olhos em êxtase.",
            "analisa o seu look de cima a baixo com um olhar clínico e murmura: \"Tem potencial, meu bem, mas falta uma alfaiataria de respeito\".",

        };

        // -------------------------------------------------------------
        // NA PARTE DE CIMA, APENAS ADICIONE NOVAS AÇÕES A PLAYBOY GAY (CASO PRECISE)
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
                // PLAYBOYGAY É GAY
                // --------------------------------------------------------------

                if ("FEMININO".equals(generoJogador)) {
                    Tela.fala(nomeNPC + " faz um sinal com a mão:");
                    Tela.fala("\"Amiga, você é linda, mas meu negócio são os rapazes! Zero chances aqui.\"");
                    status.perderVida();
                    Tela.rejeitado();
                    return 1;
                }

                
                // PERGUNTA 1
                if (estiloNPC.equals("PLAYBOY GAY")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "Qual é o destino indispensável para passar as férias de verão?",
                            "Mochilão acampando na mata.",
                            "Beach Club exclusivo em mykonos com dj internacional.",
                            "Pousada boutique de charme em trancoso.",
                            "Excursão de ônibus bate-e-volta pra praia grande.");
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
                        Tela.fala(nomeNPC + " abre um sorriso radiante e brinda com a taça: \"Champanhe na beira da piscina em Mykonos é o padrão mínimo que a gente merece, amor! Chiquérrimo!\"");
                    } else if (opcao == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " acena com a cabeça concordando: \"Trancoso tem aquele rústico-chique com alta gastronomia que eu adoro no réveillon.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " torce o nariz e ajeita os óculos de sol: \"Pelo amor de Deus, reia grudada e perrengue não combinam com a minha pele tratada a laser.\"");
                    }

                    // PERGUNTA 2

                    Tela.pergunta(nomeNPC, "Qual é o drink perfeito para pedir no rooftop mais badalado?",
                            "Corote de morango morno.",
                            "Gin tônica com infusão de zimbro e pepino em taça de cristal.",
                            "Aperol spritz com fatia de laranja fresca.",
                            "Cerveja de latinha.");
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

                    if (opcao2 == 2) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " dá uma piscadinha elegante: \"Sofisticado, botânico e não dá ressaca no dia seguinte. Você tem muito bom gosto, querido!\"");
                    } else if (opcao2 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " sorri descontraído: \"Um Aperol no fim de tarde é clássico, refrescante e fotografa super bem pro feed!\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " empurra o copo imaginário com desdém: \"Credo, bicha! Isso aí ataca o meu estômago só de sentir o cheiro... melhora essa cartela de opções!\"");
                    }

                    //PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Qual peça de roupa traduz poder e elegância no visual?",
                            "Regata de algodão de brinde promocional.",
                            "Calça de linho italiano sob medida com mocassim sem meia.",
                            "Camisa de seda estampada aberta até a metade do peito.",
                            "Bermuda de moletom furada de ficar em casa.");
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

                    if (opcao3 == 2) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " estala os dedos empolgado: \"Old money puro! O caimento do linho é impecável, parece que você acabou de desembarcar em Capri!\"");
                    } else if (opcao3 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " analisa e dá um sorriso malicioso: \"Ousado na medida certa! Mostra o bronzeado e entrega muita presença na festa.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " fecha os olhos como se estivesse sentindo dor física: \"Chama o socorro fashion agora mesmo! Quem te deixou sair de casa vestido como um mendigo de shopping?\"");
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