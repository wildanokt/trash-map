package com.wildanokt.trashmap.model;

public class Trash {

    private String Anorganik;
    private String Organik;
    private String Logam;
    private Double lat;
    private Double lng;
    private String Lokasi;

    public Trash(String anorganik, String organik, String logam, Double lat, Double lng, String lokasi) {
        Anorganik = anorganik;
        Organik = organik;
        Logam = logam;
        this.lat = lat;
        this.lng = lng;
        Lokasi = lokasi;
    }

    public String getAnorganik() {
        return Anorganik;
    }

    public String getOrganik() {
        return Organik;
    }

    public String getLogam() {
        return Logam;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public String getLokasi() {
        return Lokasi;
    }
}
