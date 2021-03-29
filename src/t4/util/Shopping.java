package t4.util;

public enum Shopping {
    MINIMUM(new ActivityInfo(
                    "Strict minimum",
                    0,
                    1,
                    -1
        )
    ),
    NORMAL(new ActivityInfo(
            "Quelques provisions",
            1,
            1,
            -2
        )
    ),
    LARGE(new ActivityInfo(
            "Large provisions",
            1,
            2,
            -3
        )
    )
    ;

    private final ActivityInfo info;

    Shopping(ActivityInfo info){
        this.info = info;
    }

    public ActivityInfo getInfo() {
        return info;
    }

    public static Shopping getByName(String name){
        for (int i = 0; i < values().length; i++) {
            Shopping value = Shopping.values()[i];
            if(value.getInfo().getName().equals(name))
                return value;
        }
        return null;
    }
}
