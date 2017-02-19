package com.rakaadinugroho.bookmvpsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rakaadinugroho.bookmvpsample.R;
import com.rakaadinugroho.bookmvpsample.model.Item;

import java.util.List;

/**
 * Created by Raka Adi Nugroho on 2/18/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Item> books;
    private int rowLayout;
    private Context context;

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        try {
            holder.title.setText(books.get(position).getVolumeInfo().getTitle());
            holder.author.setText(String.format("Ditulis oleh %s", books.get(position).getVolumeInfo().getAuthors().get(0)));
            Glide.with(context)
                    .load(books.get(position).getVolumeInfo().getImageLinks().getThumbnail())
                    .into(holder.thumbnail);
            holder.rating.setRating(books.get(position).getVolumeInfo().getAverageRating().floatValue());
        }catch (NullPointerException e){
            holder.rating.setRating(0);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView author;
        ImageView thumbnail;
        RatingBar rating;

        public BookViewHolder(View itemView) {
            super(itemView);
            title   = (TextView) itemView.findViewById(R.id.texttitle);
            author  = (TextView) itemView.findViewById(R.id.author);
            thumbnail   = (ImageView) itemView.findViewById(R.id.thumbnail);
            rating  = (RatingBar) itemView.findViewById(R.id.rating);
        }
    }

    public BookAdapter(List<Item> books, int rowLayout, Context context) {
        this.books = books;
        this.rowLayout = rowLayout;
        this.context = context;
    }
}
