package rs.tafilovic.movieinfo.ui.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import rs.tafilovic.movieinfo.R;
import rs.tafilovic.movieinfo.model.Result;
import rs.tafilovic.movieinfo.ui.fragment.adapter.viewholder.MovieViewHolder;

public class MoviesListAdapter extends PagedListAdapter<Result, MovieViewHolder> {

    public MoviesListAdapter() {
        super(Result.RESULT_DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_preview_movie, parent, false);
        return MovieViewHolder.init(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
