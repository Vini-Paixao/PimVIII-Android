package com.example.pimviiiandroidconsumer;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Implementamos a interface de clique que criamos no Adapter
public class PlaylistActivity extends AppCompatActivity implements PlaylistAdapter.OnPlaylistClickListener {

    private RecyclerView recyclerView;
    private PlaylistAdapter adapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist); // Vincula ao XML da tela

        // 1. Configura o RecyclerView
        recyclerView = findViewById(R.id.recyclerViewPlaylists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 2. Pega a instância da API (que criamos no Passo 2)
        apiService = RetrofitClient.getApiService();

        // 3. Chama a função para buscar os dados
        fetchPlaylists();
    }

    private void fetchPlaylists() {
        // Chama o endpoint GET /api/Playlists
        Call<List<Playlist>> call = apiService.getPlaylists();

        call.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // 4. SUCESSO! Temos os dados.
                    List<Playlist> playlists = response.body();

                    // 5. Configura o Adapter com os dados e "this" (para o clique)
                    adapter = new PlaylistAdapter(playlists, PlaylistActivity.this);
                    recyclerView.setAdapter(adapter);

                } else {
                    // Erro (ex: 404, 500)
                    Toast.makeText(PlaylistActivity.this, "Falha ao buscar playlists.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                // Erro de rede (sem internet, etc)
                Log.e("PlaylistActivity", "Erro de rede: " + t.getMessage());
                Toast.makeText(PlaylistActivity.this, "Erro de rede. Verifique sua conexão.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 6. O que acontece quando um item é clicado (da Interface)
    @Override
    public void onPlaylistClick(Playlist playlist) {
        // Toast.makeText(this, "Clicou em: " + playlist.getNome(), Toast.LENGTH_SHORT).show();

        // (PASSO 5) - Vamos navegar para a tela de Detalhes
        Intent intent = new Intent(this, PlaylistDetailsActivity.class);
        intent.putExtra("PLAYLIST_ID", playlist.getId());
        startActivity(intent);
    }
}
