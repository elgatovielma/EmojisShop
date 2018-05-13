package com.example.android.emojishop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapterEmojies extends RecyclerView.Adapter<adapterEmojies.ViewHolderEmojies> {

    private final ArrayList<emojiesItems> listaEmojies;
    private LayoutInflater mInflater;

    public adapterEmojies(Context context, ArrayList<emojiesItems> listaEmojies) {
        mInflater = LayoutInflater.from(context);
        this.listaEmojies = listaEmojies;
    }



    @NonNull
    @Override
    public ViewHolderEmojies onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.emojilist_item, parent, false);
        return new ViewHolderEmojies(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEmojies holder, int position) {

        holder.etiNombre.setText(listaEmojies.get(position).getNombre());
        holder.etiInformacion.setText(listaEmojies.get(position).getNombre());
        holder.foto.setImageResource(listaEmojies.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listaEmojies.size();
    }



    public class ViewHolderEmojies extends RecyclerView.ViewHolder {

        TextView etiNombre;
        TextView etiInformacion;
        ImageView foto;
        final adapterEmojies mAdapter;

        public ViewHolderEmojies(View itemView,adapterEmojies Adapter) {
            super(itemView);

            this.mAdapter =Adapter;
            etiNombre = itemView.findViewById(R.id.idNombre);
            etiInformacion = itemView.findViewById(R.id.idInfo);
            foto =itemView.findViewById(R.id.idImagen);


        }
    }
}
