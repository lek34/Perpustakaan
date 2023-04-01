package com.example.library.Crud;

import android.util.Log;

import com.example.library.Model.Book;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class bookCrud {
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
                                         }
                                         catch (RealmPrimaryKeyConstraintException e){
                                             Log.d("Tag","Primary Key Sudah Ada + " + e.getMessage().toString());
                                         }

                                     }
                                 }
        );
        realm.close();
    }
    public void updateDataBuku(String id, String buku, String pengarang, String penerbit, String tahun){
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data
        realm.executeTransaction(new Realm.Transaction() {
                                     @Override
                                     public void execute(Realm realm) {
                                         try {
                                             Book book = realm.where(Book.class).equalTo("id",id).findFirst();
                                             book.setTitle(buku);
                                             book.setAuthor(pengarang);
                                             book.setPublisher(penerbit);
                                             book.setYear(tahun);
                                         }
                                         catch (RealmPrimaryKeyConstraintException e){
                                             Log.d("Tag","Primary Key Sudah Ada + " + e.getMessage().toString());
                                         }

                                     }
                                 }
        );
        realm.close();
    }
    public void deleteDataBuku(String id){
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data
        realm.executeTransaction(new Realm.Transaction() {
                                     @Override
                                     public void execute(Realm realm) {
                                         try {
                                             Book book = realm.where(Book.class).equalTo("id",id).findFirst();
                                             book.deleteFromRealm();
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
