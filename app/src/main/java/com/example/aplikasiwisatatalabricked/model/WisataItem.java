package com.example.aplikasiwisatatalabricked.model;

import com.google.gson.annotations.SerializedName;

public class WisataItem{

    @SerializedName("nama")
    private String nama;

    @SerializedName("gambar_url")
    private String gambarUrl;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("id")
    private Integer id;

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setGambarUrl(String gambarUrl){
        this.gambarUrl = gambarUrl;
    }

    public String getGambarUrl(){
        return gambarUrl;
    }

    public void setKategori(String kategori){
        this.kategori = kategori;
    }

    public String getKategori(){
        return kategori;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
}