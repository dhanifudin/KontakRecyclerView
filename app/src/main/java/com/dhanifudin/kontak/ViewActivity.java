package com.dhanifudin.kontak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    private TextView namaText;
    private TextView genderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        namaText = (TextView) findViewById(R.id.nama_text);
        genderText = (TextView) findViewById(R.id.gender_text);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            Kontak kontak = bundle.getParcelable(MainActivity.KONTAK);
            namaText.setText(kontak.getNama());
            genderText.setText(kontak.getGender());
        }
    }
}
