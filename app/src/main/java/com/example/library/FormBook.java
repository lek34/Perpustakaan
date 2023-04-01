package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.library.Model.Book;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class FormBook extends AppCompatActivity {
    EditText edtid , edtbuku , edtpengarang , edtpenerbit, edttahun;
    Button btnsimpan;
    String id,buku,pengarang,penerbit,tahun;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_book);
        edtid = (EditText) findViewById(R.id.edtid);
        edtbuku = (EditText) findViewById(R.id.edtbuku);
        edtpengarang = (EditText) findViewById(R.id.edtpengarang);
        edtpenerbit = (EditText) findViewById(R.id.edtpenerbit);
        edttahun = (EditText) findViewById(R.id.edttahun);

        btnsimpan = findViewById(R.id.updt);

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = edtid.getText().toString();
                buku = edtbuku.getText().toString();
                pengarang = edtpengarang.getText().toString();
                penerbit = edtpenerbit.getText().toString();
                tahun = edttahun.getText().toString();
                Log.d("TAG","id"+id+"buku"+buku+"pengarang"+pengarang+"penerbot"+pengarang+"tahun"+tahun);
                tambahDataBuku(id,buku,pengarang,penerbit,tahun);
            }
        });

    }
    public void tambahDataBuku(String id, String buku, String pengarang, String penerbit, String tahun){
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data
        realm.executeTransaction(new Realm.Transaction() {
                                     @Override
                                     public void execute(Realm realm) {
                                         try {
                                             Book book = realm.createObject(Book.class,id);
                                             book.setTitle(buku);
                                             book.setAuthor(pengarang);
                                             book.setPublisher(penerbit);
                                             book.setYear(tahun);
                                             finish();
                                         }
                                         catch (RealmPrimaryKeyConstraintException e){
                                             Log.d("Tag","Primary Key Sudah Ada + " + e.getMessage().toString());
                                         }

                                     }
                                 }
        );
        realm.close();
    }

}