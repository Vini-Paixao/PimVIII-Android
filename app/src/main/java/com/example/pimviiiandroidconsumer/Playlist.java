package com.example.pimviiiandroidconsumer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Playlist {

    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("descricao")
    private String descricao;

    // Mapeia a lista de conteúdos dentro do JSON da playlist
    @SerializedName("conteudos")
    private List<Conteudo> conteudos;

    // (Opcional: Getters)
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Conteudo> getConteudos() {
        return conteudos;
    }
}
