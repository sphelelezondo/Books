package com.example.books;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder>{
    ArrayList<Book> books;
    public BooksAdapter(ArrayList<Book> books){
        this.books = books;
    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.book_list_item, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bind(book);
    }

    public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle;
        TextView tvAuthors;
        TextView tvDate;
        TextView tvPublisher;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthors = itemView.findViewById(R.id.tvAuthors);
            tvDate = itemView.findViewById(R.id.tvPublishedDate);
            tvPublisher = itemView.findViewById(R.id.tvPublisher);
            itemView.setOnClickListener(this);
        }

        public void bind(Book book){
            tvTitle.setText(book.title);
            tvDate.setText(book.publishedDate);
            tvPublisher.setText(book.publishers);
            tvAuthors.setText(book.authors);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Book selectedBook = books.get(position);
            Intent intent = new Intent(view.getContext(), BookDetail.class);
            intent.putExtra("Book", selectedBook);
            view.getContext().startActivity(intent);
        }
    }
}
