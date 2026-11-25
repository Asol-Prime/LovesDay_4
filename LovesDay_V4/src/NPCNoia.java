import java.util.Random;
import java.util.Scanner;

public class NPCNoia extends NPCs {

    public NPCNoia(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "NOIA", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES NOIA
        // -------------------------------------------------------------

        String[] acoes = {
            "olha pros dois lados com desconfiança, ajeita a Juliet espelhada na testa e sussurra: \"Tá me manjando, zé?\"",
            "está arrastando o chinelo no asfalto enquanto conta uma história mirabolante que claramente nunca aconteceu.",
            "está convicto de que as pombas da praça são câmeras disfarçadas operadas por drones do governo.",
            "manda o passinho do funk do nada, estala os dedos e pergunta: \"Aí patrão, tem 2 conto pra inteirar o busão?\"",
            "tenta te negociar um relógio dourado que ele jura de pé junto que \"caiu do caminhão por acaso\".",
        };

        // -------------------------------------------------------------
        // AÇÕES NOIA
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
                // NOIA QUE ANDA DE 160START É HETERO
                // --------------------------------------------------------------

                if ("MASCULINO".equals(generoJogador) && "MASCULINO".equals(generoNPC)) {
                    Tela.fala(nomeNPC + " acende um fino e dá uma tragada profunda...");
                    Tela.fala("\"Truta, eu não gosto dessas coisas não, mas tenho maior respeito. Flw viu brother!\"");
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
                if (estiloNPC.equals("NOIA")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "O que fazer se a viatura da polícia dobrar a esquina devagarzinho?",
                            "Sair correndo pro mato.",
                            "Acenar com as duas mãos sorrindo.",
                            "Manter a postura de cria, andar devagar e fingir que tá no celular.",
                            "Pedir carona pro camburão.");
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

                    if (opcao == 3) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " manda um toque de mão ligeiro: \"Visão pura, zé! Postura de trabalhador na correria, passa batido sem estresse!\"");
                    } else if (opcao == 2) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " solta uma risadinha nervosa: \"Simpatia forçada às vezes cola, mas é arriscado demais, doidão!\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " olha pros lados apavorado: \"Tá maluco?! Desse jeito aí os home enquadra nós dois na hora, sai fora!\"");
                    }


                    // PERGUUNTA 2

                    Tela.pergunta(nomeNPC, "Qual é o kit mais chave para colar no baile e impor respeito?",
                            "Terno com gravata borboleta.",
                            "Bermuda da cyclone, camisa de time, kenner e juliet.",
                            "Calça jeans básica e tênis preto.",
                            "Roupa social engomada.");
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
                        Tela.fala(nomeNPC + " estala os dedos e ajeita a Juliet: \"Bagulho doido! Traje de gala da quebrada, respeito instantâneo em qualquer esquina!\"");
                    } else if (opcao2 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " acena com a cabeça: \"Disfarce suave, não chama a atenção nem do raio laser, tá safe.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " cospe no chão e faz careta: \"Vai casar no meio do fluxo? Cê vai virar comédia antes de pisar na festa!\"");
                    }

                    //PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Em qual dessas teorias do submundo você mais acredita?",
                            "As antenas e os pombos transmitem sinais secretos do governo.",
                            "Existem túneis subterrâneos escondidos pela cidade.",
                            "O mundo é exatamente como passa no jornal.",
                            "O sistema trabalha pelo nosso bem-estar.");
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
                        Tela.fala(nomeNPC + " arregala os olhos e cochicha: \"FINALMENTE ALGUÉM QUE ENXERGA! Eu sabia que não tava doido sozinho nessa cidade!\"");
                    } else if (opcao3 == 2) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " concorda compenetrado: \"Pode pá que tem! Uns canos misteriosos que ninguém sabe pra onde vão... tem mistério aí!\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " cai na gargalhada com deboche: \"Cê acredita em tudo que vê na televisão? Cê tá dormindo no ponto, acorda pra vida!\"");
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
