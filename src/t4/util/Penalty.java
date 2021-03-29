package t4.util;

public enum Penalty {
    PENALTY1(new ActivityInfo(
            "Un mois satisfaisant. J'ai hâte de reprendre !",
            -2,
            -6,
            0
        )
    ),
    PENALTY2(new ActivityInfo(
            "Un mois de plus terminé. Il faut désormais continuer.",
            -3,
            -7,
            0
        )
    ),
    PENALTY3(new ActivityInfo(
            "Un mois enfin fini. Il va falloir être fort pour la suite.",
            -4,
            -8,
            0
        )
    );

    private final ActivityInfo info;

    Penalty(ActivityInfo info){
        this.info = info;
    }

    public ActivityInfo getInfo() {
        return info;
    }

    public static Penalty getByName(String name){
        for (int i = 0; i < values().length; i++) {
            Penalty value = Penalty.values()[i];
            if(value.getInfo().getName().equals(name))
                return value;
        }
        return null;
    }
}
