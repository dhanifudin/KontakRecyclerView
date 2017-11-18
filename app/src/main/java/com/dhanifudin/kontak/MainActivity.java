package com.dhanifudin.kontak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements KontakAdapter.KontakClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String KONTAK = "kontak";

    private RecyclerView kontakView;
    private KontakAdapter kontakAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kontakView = (RecyclerView) findViewById(R.id.kontak_view);
        LinearLayoutManager layoutManager =
            new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        kontakView.setLayoutManager(layoutManager);
        kontakView.setHasFixedSize(true);

        ArrayList<Kontak> data = KontakUtil.getKontak();
        kontakAdapter = new KontakAdapter(data, this);
        kontakView.setAdapter(kontakAdapter);

        kontakAdapter.notifyDataSetChanged();
    }

    @Override
    public void onKontakClick(Kontak kontak) {
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra(KONTAK, kontak);
        startActivity(intent);
    }
}
