package nro.sot.accomplissement;

// Classe pour les détails d'une promotion
public class PromotionDetail {

    private String description;
    private String full_name;
    private String name;
    private String promotion_group;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPromotionGroup() {
        return promotion_group;
    }

    public void setPromotionGroup(String promotion_group) {
        this.promotion_group = promotion_group;
    }
}
