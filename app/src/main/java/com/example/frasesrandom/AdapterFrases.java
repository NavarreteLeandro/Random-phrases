package com.example.frasesrandom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frasesrandom.Data.Frase;

import java.util.List;

public class AdapterFrases extends RecyclerView.Adapter<AdapterFrases.ViewHolderFrases> {

    private List<Frase> frases;
    private final LayoutInflater mInflater;

    public AdapterFrases(Context context) {

        mInflater = LayoutInflater.from(context);
    }

    public class ViewHolderFrases extends RecyclerView.ViewHolder {

        private final TextView frase;

        public ViewHolderFrases(@NonNull View itemView) {
            super(itemView);
            frase = (TextView) itemView.findViewById(R.id.item_frase);
        }
    }

    @NonNull
    @Override
    public ViewHolderFrases onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_frase_list, null, false);

        return new ViewHolderFrases(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFrases holder, int position) {

        if (frases != null) {
            Frase current = frases.get(position);
            holder.frase.setText(current.getFrase());
        }
    }

    void setFrases(List<Frase> frases) {
        this.frases = frases;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (frases != null) {
            return frases.size();
        } else return 0;
    }
}
