package com.example.pimviiiandroidconsumer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {

    private List<Playlist> playlistList;

    // Interface para o clique (para sabermos qual item foi clicado na Activity)
    public interface OnPlaylistClickListener {
        void onPlaylistClick(Playlist playlist);
    }
    private OnPlaylistClickListener clickListener;

    // Construtor
    public PlaylistAdapter(List<Playlist> playlistList, OnPlaylistClickListener listener) {
        this.playlistList = playlistList;
        this.clickListener = listener;
    }

    // 1. "ViewHolder" - Mapeia as Views do XML (item_playlist.xml)
    public static class PlaylistViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewDescription;

        public PlaylistViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewPlaylistName);
            textViewDescription = itemView.findViewById(R.id.textViewPlaylistDescription);
        }

        // Método para vincular os dados ao clique
        public void bind(final Playlist playlist, final OnPlaylistClickListener listener) {
            itemView.setOnClickListener(v -> listener.onPlaylistClick(playlist));
        }
    }

    // 2. "onCreateViewHolder" - Infla (cria) o layout do item (item_playlist.xml)
    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_playlist, parent, false);
        return new PlaylistViewHolder(v);
    }

    // 3. "onBindViewHolder" - Pega os dados da posição X e insere no layout
    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        Playlist currentItem = playlistList.get(position);

        holder.textViewName.setText(currentItem.getNome());
        holder.textViewDescription.setText(currentItem.getDescricao());

        // Vincula o clique
        holder.bind(currentItem, clickListener);
    }

    // 4. "getItemCount" - Informa ao RecyclerView quantos itens existem na lista
    @Override
    public int getItemCount() {
        return playlistList.size();
    }
}