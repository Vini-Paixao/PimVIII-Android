package com.example.pimviiiandroidconsumer;

import java.util.List; // Import necessário
import retrofit2.Call; // Import necessário
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    // Endpoint para buscar TODAS as playlists
    // (Ex: https://...marcuspaixao.com.br/api/Playlists)
    @GET("api/Playlists")
    Call<List<Playlist>> getPlaylists();

    // Endpoint para buscar UMA playlist específica pelo ID
    // (Ex: https://...marcuspaixao.com.br/api/Playlists/5)
    @GET("api/Playlists/{id}")
    Call<Playlist> getPlaylistById(@Path("id") int playlistId);
}
