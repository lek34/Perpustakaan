package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.library.Crud.bookCrud;

public class EditBook extends AppCompatActivity {
    EditText  edtbuku , edtpengarang , edtpenerbit, edttahun;
    TextView txvid;
    Button btnsimpan;
    String id,buku,pengarang,penerbit,tahun;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        txvid = (TextView) findViewById(R.id.txvedite);
        edtbuku = (EditText) findViewById(R.id.edtbuku);
        edtpengarang = (EditText) findViewById(R.id.edtpengarang);
        edtpenerbit = (EditText) findViewById(R.id.edtpenerbit);
        edttahun = (EditText) findViewById(R.id.edttahun);

        txvid.setText(getIntent().getStringExtra("id"));
        edtbuku.setText(getIntent().getStringExtra("buku"));
        edtpengarang.setText(getIntent().getStringExtra("pengarang"));
        edtpenerbit.setText(getIntent().getStringExtra("penerbit"));
        edttahun.setText(getIntent().getStringExtra("tahun"));


        btnsimpan = findViewById(R.id.updt);

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = txvid.getText().toString();
                buku = edtbuku.getText().toString();
                pengarang = edtpengarang.getText().toString();
                penerbit = edtpenerbit.getText().toString();
                tahun = edttahun.getText().toString();
                Log.d("TAG","id"+id+"buku"+buku+"pengarang"+pengarang+"penerbot"+pengarang+"tahun"+tahun);
                bookCrud bookcrud = new bookCrud();
                bookcrud.updateDataBuku(id,buku,pengarang,penerbit,tahun);
                finish();
            }
        });
    }
}