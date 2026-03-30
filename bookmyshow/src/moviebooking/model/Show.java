package model;

import java.time.LocalDateTime;
import java.util.*;

public class Show {
    private String id;
    private Movie movie;
    private Screen screen;
    private LocalDateTime startTime;
    private Map<String, ShowSeat> showSeats = new HashMap<>();

    public Show(String id, Movie movie, Screen screen, LocalDateTime startTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
    }

    public Map<String, ShowSeat> getShowSeats() { return showSeats; }
    public Movie getMovie() { return movie; }
}
