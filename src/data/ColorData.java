package data;

public enum ColorData {
    BLACK("черный"),
    WHITE("совсем белый"),
    RED("рыжий"),
    BROWN("коричневый"),
    GRAY("серый"),
    MIX("смешанный"),
    TRICOLOR("трёхцветный окрас");

    private String name;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
