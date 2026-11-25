import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Save {
    static String ARQUIVO = "save.txt";

    public static void salvar(Personagem personagem, Status status) {
        Properties save = new Properties();
        save.setProperty("nome", personagem.nome);
        save.setProperty("cabelo", personagem.cabelo);
        save.setProperty("estilos", personagem.estilos);
        save.setProperty("genero", personagem.genero);
        save.setProperty("altura", personagem.altura);
        save.setProperty("sexualidade", personagem.sexualidade);
        save.setProperty("vidas", "" + status.vidas);
        save.setProperty("matchs", "" + status.matchs);
        save.setProperty("renascimentos", "" + status.renascimentos);
        save.setProperty("cash", "" + status.cash);
        save.setProperty("diaAtual", "" + status.diaAtual);
        for (Item item : status.inventario.itens) {
            save.setProperty("item." + item.id, "" + item.nivel);
        }

        try (FileOutputStream arquivo = new FileOutputStream(ARQUIVO)) {
            save.store(arquivo, "LOVES DAY SAVE");
            Tela.caixa("SAVE", "Jogo salvo com sucesso!");
        } catch (Exception erro) {
            Tela.caixa("SAVE", "Erro ao salvar o jogo.");
        }
    }

    // RETORNA {personagem, status} OU null SE NÃO TIVER SAVE
    public static Object[] carregar() {
        Properties save = new Properties();
        try (FileInputStream arquivo = new FileInputStream(ARQUIVO)) {
            save.load(arquivo);
        } catch (Exception erro) {
            return null;
        }

        // SE FALTAR ALGUM CAMPO OU TIVER NÚMERO INVÁLIDO, O SAVE É IGNORADO EM VEZ DE FECHAR O JOGO
        for (String campo : new String[] {"nome", "cabelo", "genero", "estilos", "altura", "sexualidade"}) {
            if (save.getProperty(campo) == null) {
                return null;
            }
        }

        try {
            Personagem personagem = new Personagem(save.getProperty("nome"), save.getProperty("cabelo"), save.getProperty("genero"),
                    save.getProperty("estilos"), save.getProperty("altura"), save.getProperty("sexualidade"));

            Status status = new Status();
            status.vidas = Integer.parseInt(save.getProperty("vidas"));
            status.matchs = Integer.parseInt(save.getProperty("matchs"));
            status.renascimentos = Integer.parseInt(save.getProperty("renascimentos"));
            status.cash = Integer.parseInt(save.getProperty("cash"));
            status.diaAtual = Integer.parseInt(save.getProperty("diaAtual"));
            for (Item item : status.inventario.itens) {
                item.nivel = Integer.parseInt(save.getProperty("item." + item.id, "0"));
            }

            return new Object[] {personagem, status};
        } catch (NumberFormatException erro) {
            return null;
        }
    }
}
