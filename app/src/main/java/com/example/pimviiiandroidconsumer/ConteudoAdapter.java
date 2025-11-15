package com.example.pimviiiandroidconsumer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ConteudoAdapter extends RecyclerView.Adapter<ConteudoAdapter.ConteudoViewHolder> {

    private List<Conteudo> conteudoList;

    // Interface para o clique
    public interface OnConteudoClickListener {
        void onConteudoClick(Conteudo conteudo);
    }
    private OnConteudoClickListener clickListener;

    // Construtor
    public ConteudoAdapter(List<Conteudo> conteudoList, OnConteudoClickListener listener) {
        this.conteudoList = conteudoList;
        this.clickListener = listener;
    }

    // 1. ViewHolder (Mapeia o item_conteudo.xml)
    public static class ConteudoViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitulo;

        public ConteudoViewHolder(View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.textViewConteudoTitulo);
        }

        public void bind(final Conteudo conteudo, final OnConteudoClickListener listener) {
            itemView.setOnClickListener(v -> listener.onConteudoClick(conteudo));
        }
    }

    // 2. onCreateViewHolder (Infla o XML)
    @NonNull
    @Override
    public ConteudoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_conteudo, parent, false);
        return new ConteudoViewHolder(v);
    }

    // 3. onBindViewHolder (Insere os dados)
    @Override
    public void onBindViewHolder(@NonNull ConteudoViewHolder holder, int position) {
        Conteudo currentItem = conteudoList.get(position);
        holder.textViewTitulo.setText(currentItem.getTitulo());
        holder.bind(currentItem, clickListener);
    }

    // 4. getItemCount
    @Override
    public int getItemCount() {
        return conteudoList.size();
    }
}
