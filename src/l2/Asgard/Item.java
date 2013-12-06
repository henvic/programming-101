package l2.Asgard;

public class Item {
    //equipado / não equipado não é propriedade do objeto;
    //objetos são equipados ou não do ponto de vista do inventário;
    //por isso não está aqui; colocar isso aqui poderia até facilitar a resolução da questão
    //mas seria não certo do ponto de vista de separation of concerns

    private String name;
    private int id;

    private boolean working;
    private boolean magic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;

        if (!this.working) {
            magic = false;
        }
    }

    public boolean isMagic() {
        return magic;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + "\n" +
            "Funcionando: " + ((this.working) ? "sim" : "não") +
            "\nMágico: " + ((this.magic) ? "sim" : "não") + "\n\n";
    }
}
