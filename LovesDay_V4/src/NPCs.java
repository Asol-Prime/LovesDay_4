import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class NPCs {
    protected String nomeNPC;
    protected String acaoNPC;
    protected String generoNPC;
    protected String estiloNPC;
    protected int pontos;
    protected String generoJogador;

    public NPCs(String nomeNPC, String estiloNPC, String generoNPC, String acaoNPC, int pontos) {
        this.nomeNPC = nomeNPC;
        this.estiloNPC = estiloNPC;
        this.generoNPC = generoNPC;
        this.acaoNPC = acaoNPC;
        this.pontos = pontos;
    }

    public static NPCs criar(String localAtual, String generoJogador, String sexualidade) {
        String[] nomesFemininos = {"Maria", "Ana", "Sofia", "Isabela", "Beatriz", "Camila", "Larissa", "Juliana", "Fernanda", "Gabriela", "Amanda", "Carolina", "Letícia", "Mariana", "Rafaela", "Natália", "Bruna", "Patrícia", "Aline", "Jéssica"};
        String[] nomesMasculinos = {"João", "Gabriel", "Lucas", "Matheus", "Pedro", "Rafael", "Guilherme", "Felipe", "Bruno", "Thiago", "Vitor", "Diego", "Leonardo", "André", "Caio", "Vinícius", "Murilo", "Eduardo", "Daniel", "Rodrigo"};
        String[] estilos = {"EMO", "NERD", "PATRICINHA", "PLAYBOY", "PLAYBOY GAY", "AGROBOY", "PAIDEPET", "TWINK", "GYMRATS", "HIPPIE", "NOIA", "TIKTOKER", "KPOPERS", "GAMER", "FUNKEIRO", "COACH"};
        String[] generos = {"FEMININO", "MASCULINO"};
        String[] acoes = {"está sentada", "está parada", "está correndo", "está dançando", "está irritada", "está fazendo seu HotYoga", "está comendo", "está dormindo", "está estudando", "está lendo um livro"};
        Random random = new Random();
        
        // -------------------------------------------------------------
        // AÇÃO PARA SORTEAR OS ESTILOS DO NPC, ENT SE O NPC SLA É EMO, NERD, PATRICINHA, NOIA E ESSAS COISAS
        // -------------------------------------------------------------

        String nome = nomesFemininos[random.nextInt(nomesFemininos.length)];
        String genero = generos[random.nextInt(generos.length)];

        // 80% DAS VEZES O NPC É DO GÊNERO DE INTERESSE DO JOGADOR, 20% DO OUTRO (BI = 50/50)
        String interesse = generoDeInteresse(generoJogador, sexualidade);
        if (interesse != null) {
            genero = random.nextInt(100) < 80 ? interesse : (interesse.equals("MASCULINO") ? "FEMININO" : "MASCULINO");
        }

        if (genero.equals("MASCULINO")) {
            nome = nomesMasculinos[random.nextInt(nomesMasculinos.length)];
        } else {
            nome = nomesFemininos[random.nextInt(nomesFemininos.length)];
        }

        String acao = acoes[random.nextInt(acoes.length)];
        String estilo;

        // SORTEIA O ESTILO DE NOVO SE ELE NÃO EXISTIR NESSE GÊNERO (EX.: PATRICINHA HOMEM, AGROBOY MULHER)
        List<String> soHomens = Arrays.asList("PLAYBOY", "PLAYBOY GAY", "TWINK", "AGROBOY", "PAIDEPET", "NOIA");
        do {
            estilo = estilos[random.nextInt(estilos.length)];
        } while ((genero.equals("MASCULINO") && estilo.equals("PATRICINHA")) || (genero.equals("FEMININO") && soHomens.contains(estilo)));

        // -------------------------------------------------------------
        // AÇÃO PARA SORTEAR O GÊNERO DO NPC, ENT SE O NPC É MASCULINO OU FEMININO
        // -------------------------------------------------------------

        if (estilo.equals("PATRICINHA")) {
            genero = "FEMININO";
            nome = nomesFemininos[random.nextInt(nomesFemininos.length)];
        }
        if (estilo.equals("PLAYBOY")) {
            genero = "MASCULINO";
            nome =nomesMasculinos[random.nextInt(nomesMasculinos.length)];
        }
        if (estilo.equals("PLAYBOY GAY")) {
            genero = "MASCULINO";
            nome =nomesMasculinos[random.nextInt(nomesMasculinos.length)];
        }
        if (estilo.equals("TWINK")) {
            genero = "MASCULINO";
            nome =nomesMasculinos[random.nextInt(nomesMasculinos.length)];
        }
        if (estilo.equals("AGROBOY")) {
            genero = "MASCULINO";
            nome =nomesMasculinos[random.nextInt(nomesMasculinos.length)];
        }
        if (estilo.equals("PAIDEPET")) {
            genero = "MASCULINO";
            nome =nomesMasculinos[random.nextInt(nomesMasculinos.length)];
        }
        if (estilo.equals("NOIA")) {
            genero = "MASCULINO";
            nome =nomesMasculinos[random.nextInt(nomesMasculinos.length)];
        }


        // -------------------------------------------------------------
        // SÓ COLOQUEI ESSE AQ PARA FECHAR O CÓDIGO DE CIMA E NINGUEM SE PERDER NA HORA DA EXPLICAÇÃO (dafne)
        // -------------------------------------------------------------
        
        NPCs npc = null;
        switch (estilo) {
            case "EMO":
                npc = new NPCEmo(nome, genero, acao);
                break;
            case "NERD":
                npc = new NPCNerd(nome, genero, acao);
                break;
            case "PATRICINHA":
                npc = new NPCPatricinha(nome, genero, acao);
                break;
            case "PLAYBOY":
                npc = new NPCPlayboy(nome, genero, acao);
                break;
            case "PLAYBOY GAY":
                npc = new NPCPlayboyGay(nome, genero, acao);
                break;
            case "AGROBOY":
                npc = new NPCAgroboy(nome, genero, acao);
                break;
            case "PAIDEPET":
                npc = new NPCPaidepet(nome, genero, acao);
                break;
            case "TWINK":
                npc = new NPCTwink(nome, genero, acao);
                break;
            case "GYMRATS":
                npc = new NPCGymRats(nome, genero, acao);
                break;
            case "HIPPIE":
                npc = new NPCHippie(nome, genero, acao);
                break;
            case "NOIA":
                npc = new NPCNoia(nome, genero, acao);
                break;
            case "TIKTOKER":
                npc = new NPCTikToker(nome, genero, acao);
                break;
            case "KPOPERS":
                npc = new NPCKpopers(nome, genero, acao);
                break;
            case "GAMER":
                npc = new NPCGamer(nome, genero, acao);
                break;
            case "FUNKEIRO":
                npc = new NPCFunkeiro(nome, genero, acao);
                break;
            case "COACH":
                npc = new NPCCoach(nome, genero, acao);
                break;
            default:
                npc = new NPCEmo(nome, genero, acao);
                break;
        }
        npc.generoJogador = generoJogador;
        return npc;
    }

    // -------------------------------------------------------------
    // DIZ SE O NPC É DO INTERESSE DO JOGADOR (SE PULAR ALGUEM DO SEU INTERESSE PERDE VIDA)
    // -------------------------------------------------------------
    public static boolean interessa(String generoNPC, String generoJogador, String sexualidade) {
        String interesse = generoDeInteresse(generoJogador, sexualidade);
        return interesse == null || generoNPC.equals(interesse);
    }

    // RETORNA O GÊNERO QUE O JOGADOR SE INTERESSA, OU null SE FOR QUALQUER UM (BI / NÃO INFORMADO)
    public static String generoDeInteresse(String generoJogador, String sexualidade) {
        if (!generoJogador.equals("MASCULINO") && !generoJogador.equals("FEMININO")) {
            return null;
        }
        if (sexualidade.equals("HETEROSEXUAL")) {
            return generoJogador.equals("MASCULINO") ? "FEMININO" : "MASCULINO";
        }
        if (sexualidade.equals("HOMOSSEXUAL")) {
            return generoJogador;
        }
        if (sexualidade.equals("LESBICA")) {
            return "FEMININO";
        }
        return null; // BISEXUAL / PADRAO
    }

    public abstract void apresentar(String localAtual);
    public abstract int conversa(Scanner Leitor, String estiloJogador, int bonus, Status status);
}