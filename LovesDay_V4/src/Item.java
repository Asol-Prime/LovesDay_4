public class Item {
    String id;          // ITENS DE ESTILO USAM O PRÓPRIO ESTILO DO NPC COMO ID (EX: "EMO")
    String nome;
    int precoBase;
    String descricao;
    int maximo;         // ITEM ÚNICO = MÁXIMO 1
    int nivel = 0;      // 0 = AINDA NÃO COMPRADO

    public Item(String id, String nome, int precoBase, String descricao, int maximo) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
        this.descricao = descricao;
        this.maximo = maximo;
    }

    // O PREÇO DOBRA A CADA LVL: BASE x 2^NIVEL
    public int preco() {
        return precoBase * (int) Math.pow(2, nivel);
    }

    public boolean unico() {
        return maximo == 1;
    }

    public boolean noMaximo() {
        return nivel >= maximo;
    }
}
