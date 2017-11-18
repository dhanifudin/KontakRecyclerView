package com.dhanifudin.kontak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dhanifudin on 11/18/17.
 */

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.Holder> {

    private ArrayList<Kontak> data;

    final private KontakClickListener listener;

    public interface KontakClickListener {
        void onKontakClick(Kontak kontak);
    }

    public KontakAdapter(ArrayList<Kontak> data, KontakClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_kontak_list, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Kontak kontak = data.get(position);
        holder.bind(kontak);
    }

    @Override
    public int getItemCount() {
        return (data == null) ? 0 : data.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView namaText;
        TextView genderText;

        public Holder(View itemView) {
            super(itemView);
            namaText = itemView.findViewById(R.id.nama_text);
            genderText = itemView.findViewById(R.id.gender_text);
            itemView.setOnClickListener(this);
        }

        void bind(Kontak kontak) {
            namaText.setText(kontak.getNama());
            genderText.setText(kontak.getGender());
        }

        @Override
        public void onClick(View view) {
            Kontak kontak = data.get(getAdapterPosition());
            listener.onKontakClick(kontak);
        }
    }
}
