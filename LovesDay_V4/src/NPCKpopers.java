import java.util.Random;
import java.util.Scanner;

public class NPCKpopers extends NPCs {
    public NPCKpopers(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "KPOPERS", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES KPOPERS
        // -------------------------------------------------------------

        String[] acoes = {
            "está ensaiando a coreografia frenética do refrão de um grupo novo no meio do corredor.",
            "está abrindo um álbum importado da Coreia e quase desmaia de emoção ao ver que tirou o photocard raro do bias.",
            "está votando em 5 contas simultâneas para garantir que o seu grupo favorito vença o programa musical da semana.",
            "segura um lightstick oficial brilhante e colorido como se fosse um cetro de poder mágico.",
            "está defendendo seu fandom contra os haters com unhas, dentes e um arsenal de fancams em 4K.",
        };

        // -------------------------------------------------------------
        // AÇÕES KPOPERS
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


                // PERGUNTA 1
                if (estiloNPC.equals("KPOPERS")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.fala(nomeNPC + " começa a fazer a dancinha de 'Chk Chk Boom' e te desafia:");
                    Tela.pergunta(nomeNPC, "Rápido! Qual dessas verdades absolutas você defende com unhas e dentes?",
                            "O Bang Chan é o maior líder da história e ninguém supera o abdômen dele.",
                            "A Lisa é a maior dançarina de toda a Coreia do Sul.",
                            "O Jungkook só consome refrigerante se for zero açúcar.",
                            "O juiz de futebol errou no último jogo do meu time.");
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

                    if (opcao== 1) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " surta completamente: \"STRAY KIDS EVERYWHERE ALL AROUND THE WORLD! O Chan cuida do grupo como ninguém, ele é perfeito! Nosso paizão!\"");
                    } else if (opcao== 2) {
                        pontos += 20;
                        Tela.fala(nomeNPC + " faz o sinal de 'L' com os dedos: \"Fatos apenas! A presença de palco da Lisa é hipnotizante, ninguém chega perto do nível dela!\"");
                    } else if (opcao== 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " dá uma risada: \"Olha, o Jungkook é fitness, mas você prestou atenção demais nos hábitos dele! Adorei o detalhe de fã stalker!\"");
                    } else {
                        pontos -= 25;
                        Tela.fala(nomeNPC + " para de dançar imediatamente e te olha feio: \"Futebol de novo? Garoto, eu estou falando de deuses do K-pop e você me vem com falta de juiz? Errou feio!\"");
                    }

                    // PERGUNTA 2

                    Tela.pergunta(nomeNPC, "O que você faz se tocar um refrão marcante de K-Pop em público?",
                            "Finjo que não ouvi e ando mais rápido.",
                            "Critico dizendo que é tudo igual.",
                            "Canto o refrão em coreano.",
                            "Puxo o random play dance e faço a coreografia.");
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

                    if (opcao2 == 4) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " bate palmas empolgadíssimo: \"DAEBAK! Você cravou cada passo da coreografia! Já pode debutar amanhã mesmo!\"");
                    } else if (opcao2 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " acha super fofo: \"A pronúncia foi meio enrolada, mas a animação e o amor foram contagiantes!\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " cruza os braços fazendo bico: \"Que traição ao fandom! Você não tem ideia do treino pesado que os idols passam pra estrear!\"");
                    }

                    // PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Qual item precioso está protegido com a própria vida na sua bolsa?",
                            "Photocard raro no toploader e lightstick.",
                            "Apenas carteira e chaves.",
                            "Snacks coreanos picantes e gloss.",
                            "Uma chave de fenda enferrujada.");
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
                        Tela.fala(nomeNPC + " mostra o chaveirinho combinando: \"Patrimônio blindado contra riscos e luz solar! Você tem bom gosto nível master!\"");
                    } else if (opcao3 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " faz sinal de aprovação: \"Muito estético e gostoso! Tá sempre preparado para qualquer evento com estilo.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " dá um passo para trás assustado: \"Eca! Tira essa poeira de perto dos meus cards importados impecáveis!\"");
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

