package com.example.frasesrandom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFrases extends RecyclerView.Adapter<AdapterFrases.ViewHolderFrases> {

    List<String> frases;

    public AdapterFrases(List<String> frases) {
        this.frases = frases;
    }

    public class ViewHolderFrases extends RecyclerView.ViewHolder {

        TextView frase;

        public ViewHolderFrases(@NonNull View itemView) {
            super(itemView);
            frase = (TextView) itemView.findViewById(R.id.item_frase);
        }

        public void asignarDatos(String frases) {
            frase.setText(frases);
        }
    }

    @NonNull
    @Override
    public ViewHolderFrases onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_frase_list,null,false);

        return new ViewHolderFrases(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFrases holder, int position) {

        holder.asignarDatos(frases.get(position));

    }

    @Override
    public int getItemCount() {
        return frases.size();
    }
}
