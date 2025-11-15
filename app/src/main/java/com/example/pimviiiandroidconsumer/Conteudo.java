package com.example.pimviiiandroidconsumer;

import com.google.gson.annotations.SerializedName;

public class Conteudo {
    @SerializedName("id")
    private int id;

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("url")
    private String url;

    // (Opcional: Getters) - Embora o Retrofit não precise deles, é uma boa prática
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }
}
