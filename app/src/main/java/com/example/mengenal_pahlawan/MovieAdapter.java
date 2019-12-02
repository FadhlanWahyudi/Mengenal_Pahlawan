package com.example.mengenal_pahlawan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> implements Filterable {

    private ArrayList<ModelMovie> listData;
    private ArrayList<ModelMovie> filterData;

    public  MovieAdapter(ArrayList<ModelMovie> datalist) {
        listData = datalist;
        filterData = datalist;
    }



    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.raw_list, viewGroup,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        movieHolder.bindView(filterData.get(i));


    }

    @Override
    public int getItemCount() {
        return filterData.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    filterData = listData;
                } else {
                    ArrayList<ModelMovie> filterlist = new ArrayList<>();
                    for (ModelMovie modelMovie : listData) {
                        if (modelMovie.getJudul().toLowerCase().contains(charString) | modelMovie.getSubjudul().toLowerCase().contains(charString)) {
                            filterlist.add(modelMovie);
                        }
                    }
                    filterData = filterlist;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterData;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filterData = (ArrayList<ModelMovie>) results.values;
                notifyDataSetChanged();

            }


        };
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        private TextView title,subtitle;
        private ImageView ivmain;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            title    = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
            ivmain   = itemView.findViewById(R.id.ivMain);
        }

        public void bindView(ModelMovie data) {
            title.setText(data.getJudul());
            subtitle.setText(data.getSubjudul());
            ivmain.setImageResource(data.getLogo());
            final String idmov = data.getId();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(),DetailMovie.class)
                            .putExtra(DetailMovie.KEY_MOVIE, idmov));
                }
            });

        }
    }
}
