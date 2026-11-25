import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NPCGamer extends NPCs {
    public NPCGamer(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "GAMER", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES GAMER
        // -------------------------------------------------------------

        String[] acoes = {
            "está com um headset gigante de LED gritando \"BOA, TIME!\"",
            "está jogando no celular com o brilho no máximo e 3% de bateria, sem piscar.",
            "está reclamando que perdeu a ranqueada por culpa do lag do Wi-Fi.",
            "está mostrando pra todo mundo a foto do setup novo com teclado mecânico RGB.",
            "está com olheiras profundas depois de virar a noite fazendo raid com a guilda.",
        };

        // -------------------------------------------------------------
        // AÇÕES GAMER
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

                if (estiloJogador.equals(estiloNPC)) {
                    pontos += 14;
                }

                // -------------------------------------------------------------
                // PERGUNTAS SORTEADAS: SÃO 6, MAS SÓ 3 APARECEM POR ENCONTRO
                // -------------------------------------------------------------

                List<Integer> ordem = Arrays.asList(1, 2, 3, 4, 5, 6);
                Collections.shuffle(ordem);

                for (int i = 0; i < 3; i++) {
                    int opcao;
                    switch (ordem.get(i)) {
                        case 1:
                            Tela.pergunta(nomeNPC, "Qual desses jogos você levaria para uma ilha deserta?",
                                    "Minecraft, porque dá pra construir a ilha inteira de novo.",
                                    "Paciência do Windows.",
                                    "League of Legends, mesmo sabendo que vou passar raiva.",
                                    "Nenhum, eu levaria um livro.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " arregala os olhos: \"Escolha de mestre! Com uma picareta de diamante a gente faz até uma casa na árvore!\"");
                            } else if (opcao == 3) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " ri de nervoso: \"Corajoso... ou maluco. Mas eu respeito quem aguenta o chat de lá.\"");
                            } else {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " tira o headset devagar: \"Você... não joga nada, né? Tudo bem, ninguém é perfeito.\"");
                            }
                            break;

                        case 2:
                            Tela.pergunta(nomeNPC, "O que você faz quando perde 5 partidas seguidas?",
                                    "Quebro o controle e xingo a família inteira do adversário.",
                                    "Respiro fundo, bebo uma água e volto pra ranqueada.",
                                    "Desinstalo o jogo pra sempre (até amanhã).",
                                    "Coloco a culpa no time e no lag.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 2) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " bate palmas: \"Mentalidade de pro player! Você tem um controle emocional que eu não tenho.\"");
                            } else if (opcao == 3 || opcao == 4) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " concorda balançando a cabeça: \"Clássico. Todo gamer já fez isso pelo menos umas mil vezes.\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " se afasta um pouco: \"Opa, controle custa caro hein... e eu não quero ser o próximo a ser xingado.\"");
                            }
                            break;

                        case 3:
                            Tela.pergunta(nomeNPC, "Qual seria o nosso primeiro encontro perfeito?",
                                    "Jantar caro num restaurante chique.",
                                    "Maratona de jogo cooperativo com pizza e refrigerante.",
                                    "Ir na Lan House jogar contra a gente mesmo.",
                                    "Caminhada às 6 da manhã no parque.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 2) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " sorri de orelha a orelha: \"Player 2 encontrado! Eu já tenho até o segundo controle carregado.\"");
                            } else if (opcao == 3) {
                                pontos += 15;
                                Tela.fala(nomeNPC + " estala os dedos: \"Aceito o desafio. Mas já aviso que eu não deixo ninguém ganhar.\"");
                            } else if (opcao == 1) {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " olha pra carteira: \"Esse dinheiro dava pra comprar uns três jogos na promoção...\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " quase desmaia: \"6 DA MANHÃ? Esse é o horário que eu vou DORMIR!\"");
                            }
                            break;

                        case 4:
                            Tela.pergunta(nomeNPC, "PC, console ou celular?",
                                    "PC, com certeza. Mouse e teclado é outro nível.",
                                    "Console, sofá e controle na mão.",
                                    "Celular, jogo no ônibus mesmo.",
                                    "Prefiro jogo de tabuleiro.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1) {
                                pontos += 20;
                                Tela.fala(nomeNPC + " bate no peito: \"PC MASTER RACE! A gente já tem muito em comum.\"");
                            } else if (opcao == 2) {
                                pontos += 15;
                                Tela.fala(nomeNPC + " acena: \"Console também é raiz. Sofá confortável vale muito.\"");
                            } else if (opcao == 3) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " dá de ombros: \"Mobile conta, vai... mas joga com o som ligado não, por favor.\"");
                            } else {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " coça a cabeça: \"Tabuleiro? Aquele que não tem nem gráfico?\"");
                            }
                            break;

                        case 5:
                            Tela.pergunta(nomeNPC, "São 3 da manhã e seu amigo chama no Discord pra jogar. O que você faz?",
                                    "Entro na call na hora, sono é pra fraco.",
                                    "Ignoro, amanhã tenho compromisso cedo.",
                                    "Jogo só mais uma partida (que vira dez).",
                                    "Bloqueio o amigo por mandar mensagem nesse horário.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1 || opcao == 3) {
                                pontos += 20;
                                Tela.fala(nomeNPC + " ri alto: \"Essa é a hora sagrada! Às 3 da manhã a gente joga melhor, é ciência.\"");
                            } else if (opcao == 2) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " concorda: \"Responsável... às vezes eu queria ser assim também.\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " quase derruba o celular: \"Bloquear o duo? Isso é crime de guerra no mundo gamer!\"");
                            }
                            break;

                        case 6:
                            Tela.pergunta(nomeNPC, "Qual personagem de jogo você seria?",
                                    "O Mario, salvando a princesa pela milésima vez.",
                                    "O Kratos, bravo com tudo e com todos.",
                                    "Um NPC que só fala \"Bom dia, viajante\".",
                                    "A Lara Croft, explorando tumbas pelo mundo.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 4 || opcao == 1) {
                                pontos += 20;
                                Tela.fala(nomeNPC + " sorri: \"Clássico e com estilo! Você tem ótimo gosto pra personagem.\"");
                            } else if (opcao == 3) {
                                pontos += 15;
                                Tela.fala(nomeNPC + " cai na gargalhada: \"Bom dia, viajante! Essa foi a melhor resposta que eu já ouvi.\"");
                            } else {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " dá um passo pra trás: \"Hmm... vou tomar cuidado pra não te deixar bravo então.\"");
                            }
                            break;
                    }
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
                    Tela.fala("Você usou o Trufilho! Esta é sua última tentativa do dia.");
                }
                break;

            case 2:
                Tela.fala("Você decidiu deixar passar e seguir em frente.");
                break;

            case 9:
                Tela.fala("Você abandonou o dia...");
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        return escolha;
    }

    // LÊ UMA RESPOSTA DE 1 A 4 DAS PERGUNTAS
    private int lerOpcao(Scanner leitor) {
        while (true) {
            try {
                int opcao = Integer.parseInt(leitor.nextLine());
                if (opcao >= 1 && opcao <= 4) {
                    return opcao;
                }
            } catch (NumberFormatException erro) {
            }

            System.out.println("Digite um número válido!");
            System.out.print("Selecione uma opção: ");
        }
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
