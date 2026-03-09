package com.example.map;

import java.util.HashMap;
import java.util.Map;

public class MarkerStyleFactory {

    private final Map<String, MarkerStyle> styles = new HashMap<>();

    public MarkerStyle get(String s, String c, int sz, boolean f) {
        String k = s + "|" + c + "|" + sz + "|" + (f ? "F" : "O");
        
        if (!styles.containsKey(k)) {
            styles.put(k, new MarkerStyle(s, c, sz, f));
        }
        
        return styles.get(k);
    }

    public int cacheSize() {
        return styles.size();
    }
}