package com.example.pimviiiandroidconsumer;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Implementamos a interface de clique do ConteudoAdapter
public class PlaylistDetailsActivity extends AppCompatActivity implements ConteudoAdapter.OnConteudoClickListener {

    private RecyclerView recyclerView;
    private ConteudoAdapter adapter;
    private ApiService apiService;
    private TextView textViewPlaylistName;
    private int playlistId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_details);

        // 1. Pega o ID enviado pela PlaylistActivity
        playlistId = getIntent().getIntExtra("PLAYLIST_ID", -1);

        if (playlistId == -1) {
            // Se não recebeu o ID, fecha a tela
            Toast.makeText(this, "Erro: ID da Playlist não encontrado.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // 2. Mapeia os componentes do XML
        textViewPlaylistName = findViewById(R.id.textViewPlaylistNameDetails);
        recyclerView = findViewById(R.id.recyclerViewConteudos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. Configura a API
        apiService = RetrofitClient.getApiService();

        // 4. Busca os dados
        fetchPlaylistDetails();
    }

    private void fetchPlaylistDetails() {
        // Chama o endpoint GET /api/Playlists/{id}
        Call<Playlist> call = apiService.getPlaylistById(playlistId);

        call.enqueue(new Callback<Playlist>() {
            @Override
            public void onResponse(Call<Playlist> call, Response<Playlist> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // 5. SUCESSO!
                    Playlist playlist = response.body();

                    // 6. Atualiza a UI
                    textViewPlaylistName.setText(playlist.getNome()); // Põe o nome no título

                    // 7. Configura o Adapter com a lista de conteúdos da playlist
                    adapter = new ConteudoAdapter(playlist.getConteudos(), PlaylistDetailsActivity.this);
                    recyclerView.setAdapter(adapter);

                } else {
                    Toast.makeText(PlaylistDetailsActivity.this, "Falha ao buscar detalhes.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Playlist> call, Throwable t) {
                Log.e("DetailsActivity", "Erro de rede: " + t.getMessage());
                Toast.makeText(PlaylistDetailsActivity.this, "Erro de rede.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 8. O que acontece quando clicamos em um conteúdo (vídeo)
    @Override
    public void onConteudoClick(Conteudo conteudo) {
        Toast.makeText(this, "Abrindo: " + conteudo.getTitulo(), Toast.LENGTH_SHORT).show();

        // --- SOLUÇÃO DE MOCK (PROTÓTIPO) ---
        // Como a nossa API não fornece uma URL (conforme o manual),
        // vamos usar uma URL de teste estática para o player.
        String urlDeTeste = "https://www.pexels.com/download/video/1721303/";
        // (Esta é uma URL .mp4 de exemplo, disponível publicamente)

        // (PASSO 6) - Vamos navegar para a tela do Player
        Intent intent = new Intent(this, PlayerActivity.class);

        // Passamos a URL DE TESTE em vez de "conteudo.getUrl()"
        intent.putExtra("CONTEUDO_URL", urlDeTeste);

        // Ainda passamos o título real
        intent.putExtra("CONTEUDO_TITULO", conteudo.getTitulo());

        startActivity(intent);
    }
}
