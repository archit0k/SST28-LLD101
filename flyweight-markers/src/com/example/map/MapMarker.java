package com.example.map;

public class MapMarker {

    private final double lat;
    private final double lng;
    private final String label;
    private final MarkerStyle style;

    public MapMarker(double lat, double lng, String lbl, MarkerStyle st) {
        this.lat = lat;
        this.lng = lng;
        this.label = lbl;
        this.style = st;
    }

    public double getLat() { return lat; }
    public double getLng() { return lng; }
    public String getLabel() { return label; }
    public MarkerStyle getStyle() { return style; }
}