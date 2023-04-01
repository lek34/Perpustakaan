package com.example.library.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.library.Crud.bookCrud;
import com.example.library.EditBook;
import com.example.library.FormBook;
import com.example.library.Model.Book;
import com.example.library.R;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, List<Book> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Book book =getItem(position);
        if (convertView==null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.layout_listviewbuku,parent,false);
        }
        TextView txvId = (TextView) convertView.findViewById(R.id.id);
        TextView txvBuku = (TextView) convertView.findViewById(R.id.buku);
        TextView txvPengarang = (TextView) convertView.findViewById(R.id.pengarang);
        TextView txvPenerbit = (TextView) convertView.findViewById(R.id.penerbit);
        TextView txvTahun = (TextView) convertView.findViewById(R.id.tahun);
        txvId.setText(book.getId());
        txvBuku.setText(book.getTitle());
        txvPengarang.setText(book.getAuthor());
        txvPenerbit.setText(book.getPublisher());
        txvTahun.setText(book.getYear());

        ImageButton btnEdit = (ImageButton) convertView.findViewById(R.id.edit);
        ImageButton btnDelete = (ImageButton) convertView.findViewById(R.id.delete);

        btnEdit.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                            Intent intent = new Intent(getContext(), EditBook.class);
                             intent.putExtra("id",book.getId());
                             intent.putExtra("buku",book.getTitle());
                             intent.putExtra("pengarang",book.getAuthor());
                             intent.putExtra("penerbit",book.getPublisher());
                             intent.putExtra("tahun",book.getYear());
                             getContext().startActivity(intent);
                         }
                     }

        );

        btnDelete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                bookCrud bookcrud = new bookCrud();
                bookcrud.deleteDataBuku(book.getId());
                notifyDataSetChanged();
           }
       }

        );


        return convertView;
    }
}
