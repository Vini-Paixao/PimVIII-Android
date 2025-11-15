package com.example.pimviiiandroidconsumer;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;
    private TextView textViewTitle;
    private Button buttonShare;
    private ProgressBar progressBar;

    private String videoUrl; // URL (mockada) que recebemos
    private String videoTitle; // Título que recebemos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // 1. Mapeia os componentes do XML
        videoView = findViewById(R.id.videoViewPlayer);
        textViewTitle = findViewById(R.id.textViewVideoTitle);
        buttonShare = findViewById(R.id.buttonShare);
        progressBar = findViewById(R.id.progressBar);

        // 2. Pega os dados enviados pela DetailsActivity
        videoUrl = getIntent().getStringExtra("CONTEUDO_URL");
        videoTitle = getIntent().getStringExtra("CONTEUDO_TITULO");

        // 3. Atualiza a UI
        textViewTitle.setText(videoTitle);

        // 4. Configura o Player (Consumo de Conteúdo)
        setupVideoPlayer();

        // 5. Configura o clique do botão (Interação Social)
        setupShareButton();
    }

    private void setupVideoPlayer() {
        // Mostra o "Carregando..."
        progressBar.setVisibility(View.VISIBLE);

        // Adiciona os controles (play, pause, etc.)
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Define a URL do vídeo
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);

        // Listener para quando o vídeo está pronto
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // Esconde o "Carregando..."
                progressBar.setVisibility(View.GONE);
                // Inicia o vídeo
                videoView.start();
            }
        });
    }

    private void setupShareButton() {
        // Este é o requisito de "Interação Social"
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma Intent (intenção) de COMPARTILHAR
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);

                // Define o conteúdo a ser compartilhado
                String shareText = "Veja este conteúdo incrível do PIM VIII: " +
                        videoTitle + " \nLink: " + videoUrl;
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);

                // Define o tipo de conteúdo (texto plano)
                sendIntent.setType("text/plain");

                // Mostra o menu de compartilhamento do Android (WhatsApp, Email, etc.)
                Intent shareIntent = Intent.createChooser(sendIntent, "Compartilhar via");
                startActivity(shareIntent);
            }
        });
    }
}