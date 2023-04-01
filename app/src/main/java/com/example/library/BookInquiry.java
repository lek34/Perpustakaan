package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.library.Adapter.BookAdapter;
import com.example.library.Model.Book;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class BookInquiry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_inquiry);
        //tarik data
        Realm realm = Realm.getDefaultInstance();
        //penarikan data
        RealmResults<Book> book =
                realm.where(Book.class).findAll();
        //menampilkan data
//        for(User user : users){
//            Log.d("TAG","Nama :"+user.getNama()
//                    + ", Nomor Telp"+ user.getNotlp());
//        }
        ArrayList<Book> arrayofuser = new ArrayList<Book>();
        arrayofuser.addAll(realm.copyFromRealm(book));
        realm.close();

        BookAdapter bookAdapter = new BookAdapter(this,arrayofuser);
        ListView listView = (ListView) findViewById(R.id.listviewbuku);
        listView.setAdapter(bookAdapter);
    }
}