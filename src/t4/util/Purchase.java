package t4.util;

public enum Purchase {
    SAVE(new ActivityInfo(
            "Aucun",
            0,
            1,
            -1
        )
    ),
    PLEASURE(new ActivityInfo(
                    "Petit plaisir",
                    0,
                    1,
                    -1
        )
    ),
    INVESTMENT(new ActivityInfo(
            "Gros investissement",
            0,
            2,
            -2
    )
    )
    ;

    private final ActivityInfo info;

    Purchase(ActivityInfo info){
        this.info = info;
    }

    public ActivityInfo getInfo() {
        return info;
    }

    public static Purchase getByName(String name){
        for (int i = 0; i < values().length; i++) {
            Purchase value = Purchase.values()[i];
            if(value.getInfo().getName().equals(name))
                return value;
        }
        return null;
    }
}
