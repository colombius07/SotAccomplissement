package nro.sot.accomplissement;

public class InfoItem {
    private String titre;
    private String description;
    private String astuce;

    public InfoItem(String titre, String description, String astuce) {
        this.titre = titre;
        this.description = description;
        this.astuce = astuce;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAstuce() {
        return astuce;
    }

    public void setAstuce(String astuce) {
        this.astuce = astuce;
    }
}
