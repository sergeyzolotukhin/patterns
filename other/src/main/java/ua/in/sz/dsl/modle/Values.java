package ua.in.sz.dsl.modle;

public class Values {
    public static Value values(String type, String ... values) {
        return Value.builder(type).values(values).build();
    }
}
