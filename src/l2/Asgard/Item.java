package l2.Asgard;

public class Item {
    //equipado / não equipado não é propriedade do objeto;
    //objetos são equipados ou não do ponto de vista do inventário;
    //por isso não está aqui; colocar isso aqui poderia até facilitar a resolução da questão
    //mas seria não certo do ponto de vista de separation of concerns

    private String name;
    private String description;
    private int id;

    private boolean working;
    private boolean magic;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWorking() {
        return this.working;
    }

    public void setWorking(boolean working) {
        this.working = working;

        if (!this.working) {
            this.magic = false;
        }
    }

    public boolean isMagic() {
        return this.magic;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + "\n" +
            "Funcionando: " + ((this.working) ? "sim" : "não") +
            "\nDescrição: " + this.description +
            "\nMágico: " + ((this.magic) ? "sim" : "não") + "\n\n";
    }
}
