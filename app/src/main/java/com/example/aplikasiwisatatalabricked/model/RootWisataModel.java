package com.example.aplikasiwisatatalabricked.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RootWisataModel{

    @SerializedName("wisata")
    private ArrayList<WisataItem> wisata;

    public void setWisata(ArrayList<WisataItem> wisata){
        this.wisata = wisata;
    }

    public ArrayList<WisataItem> getWisata(){
        return wisata;
    }
}