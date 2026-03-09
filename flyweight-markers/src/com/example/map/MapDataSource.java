package com.example.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapDataSource {

    private static final String[] SHAPES = {"PIN", "CIRCLE", "SQUARE"};
    private static final String[] COLORS = {"RED", "BLUE", "GREEN", "ORANGE"};
    private static final int[] SIZES = {10, 12, 14, 16};
    
    private final MarkerStyleFactory factory = new MarkerStyleFactory();

    public List<MapMarker> loadMarkers(int cnt) {
        Random rnd = new Random(7);
        List<MapMarker> out = new ArrayList<>(cnt);

        for (int i = 0; i < cnt; i++) {
            double lat = 12.9000 + rnd.nextDouble() * 0.2000;
            double lng = 77.5000 + rnd.nextDouble() * 0.2000;
            String lbl = "M-" + i;

            String s = SHAPES[rnd.nextInt(SHAPES.length)];
            String c = COLORS[rnd.nextInt(COLORS.length)];
            int sz = SIZES[rnd.nextInt(SIZES.length)];
            boolean f = rnd.nextBoolean();

            MarkerStyle st = factory.get(s, c, sz, f);

            out.add(new MapMarker(lat, lng, lbl, st));
        }
        return out;
    }
}