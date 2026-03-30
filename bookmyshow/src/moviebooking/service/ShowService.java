package service;

import model.Show;
import java.util.*;

public class ShowService {
    private List<Show> shows = new ArrayList<>();

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShowsByMovie(String movieId) {
        List<Show> res = new ArrayList<>();
        for (Show s : shows) {
            if (s.getMovie().getId().equals(movieId)) {
                res.add(s);
            }
        }
        return res;
    }
}
