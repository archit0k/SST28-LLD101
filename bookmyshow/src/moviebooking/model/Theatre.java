package model;

import java.util.*;

public class Theatre {
    private String id;
    private String name;
    private String city;
    private List<Screen> screens = new ArrayList<>();

    public Theatre(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getCity() { return city; }
    public List<Screen> getScreens() { return screens; }
}
