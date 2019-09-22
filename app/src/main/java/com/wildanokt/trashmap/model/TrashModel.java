package com.wildanokt.trashmap.model;

public class TrashModel {
    private String title, snippet;
    private double lat, lng;

    public TrashModel(String title, String snippet, double lat, double lng) {
        this.title = title;
        this.snippet = snippet;
        this.lat = lat;
        this.lng = lng;
    }

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
