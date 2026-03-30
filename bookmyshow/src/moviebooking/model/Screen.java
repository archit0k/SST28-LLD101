package model;

import enums.ScreenType;
import java.util.*;

public class Screen {
    private String id;
    private ScreenType type;
    private List<Seat> seats = new ArrayList<>();

    public Screen(String id, ScreenType type) {
        this.id = id;
        this.type = type;
    }

    public List<Seat> getSeats() { return seats; }
}
