import java.util.Random;
import java.util.Scanner;

public class NPCPaidepet extends NPCs {

        public NPCPaidepet(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "PAIDEPET", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÃO QUE DEFINE O QUE O PERSONAGEM -- PAIDEPET -- VAI FALAR QUANDO O JOGADOR O ENCONTRAR
        // -------------------------------------------------------------

        String[] acoes = {
            "está em chamada de vídeo com seu \"Cachorro Ted\".",
            "carrega com você um saco de ração de marca clandestina, aparenta ser apetitosa até mesmo para você.",
            "deixa sua carteira cair no chão, e por mais estranho que pareça, todos os documentos aparentam ser de algum animal.",
        };

        // -------------------------------------------------------------
        // NA PARTE DE CIMA, APENAS ADICIONE NOVAS AÇÕES AO PAIDEPET (CASO PRECISE)
        // -------------------------------------------------------------

        Random random = new Random();

        String acao = acoes[random.nextInt(acoes.length)];
        String artigo = generoNPC.equals("FEMININO") ? "a" : "o";
        String pronome = generoNPC.equals("FEMININO") ? "Ela" : "Ele";
        Tela.encontro(localAtual, artigo, nomeNPC, estiloNPC, pronome + " " + acao);
    }

    @Override
    public int conversa(Scanner leitor, String estiloJogador, int bonus, Status status) {

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
                // PAIDEPET É BISSEXUAL
                // --------------------------------------------------------------
                
                // PERGUNTA 1
                if (estiloNPC.equals("PAIDEPET")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "Gosta de animais?",
                            "Sim, principalmente cachorro.",
                            "Costumo cuidar de plantas, isso conta como um pet?",
                            "Não tenho pets, tenho alergia a pelos.",
                            "Sim, acho gato muito legal também.");
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
                        Tela.fala(nomeNPC + " fica muito feliz: \"Eu AMO cachorros!\"");
                    } else if (opcao == 4) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " acena com a cabeça: \"Gatos não são minha praia, mas eu amo eles!\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " fica insatisfeito com sua resposta: \"Hmm... Você não tem pets? Isso é uma pena.\"");
                    }

                    // PERGUUNTA 2

                    Tela.pergunta(nomeNPC, "Você já teve algum pet?",
                            "Já tive um leão de pelúcia, isso conta como um animal de estimação?",
                            "Já, quando era criança.",
                            "Acabei cuidando do pet de alguns amigos e parentes nas férias.",
                            "Já tive um cachorro, mas ele mijava por toda a casa, acabei doando.");
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
                        Tela.fala(nomeNPC + " fica emotivo: \"MEU DEUS!! Isso é muito legal! Já tive um cachorro quando era pequeno, mas ele acabou morrendo em um acidente de carros...\"");
                    } else if (opcao2 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " acena com a cabeça: \"Então você se considera como uma pessoa cuidadosa? Eu trato animais como filhos.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " fica insatisfeito com sua resposta: \"Bom, acredito que deve ter um motivo para isso, não é?\"");
                    }
                    
                    // PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Se você tivesse um pet, qual teria?",
                            "Teria um cachorro.",
                            "Acho que teria um morcego, gosto deles.",
                            "Gosto muito de cobras! Me encanta o jeito que se movem.",
                            "Provavelmente teria um peixe, dá menos trabalho e não me irritaria com latidos.");
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
                        Tela.fala(nomeNPC + " fica emotivo: \"Me conforta ver que ainda existem pessoas que gostam de cães.\"");
                    } else if (opcao3 == 3 || opcao3 == 2) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " acena com a cabeça: \"Cada um com seus gostos, né? Eu em particular teria medo de ter um \"Pet Conforto\" como esse.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " fica insatisfeito com sua resposta: \"Você fere os direitos dos animais!\"");
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
