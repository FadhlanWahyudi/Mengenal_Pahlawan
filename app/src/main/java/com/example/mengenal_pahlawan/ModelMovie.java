package com.example.mengenal_pahlawan;

public class ModelMovie {


    private String id;
    private String judul;
    private String subjudul;
    private String gambar;
    private int logo;

    public ModelMovie(String id, String judul, String subjudul, String gambar, int logo) {
        this.id = id;
        this.judul = judul;
        this.subjudul = subjudul;
        this.gambar = gambar;
        this.logo = logo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSubjudul() {
        return subjudul;
    }

    public void setSubjudul(String subjudul) {
        this.subjudul = subjudul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}