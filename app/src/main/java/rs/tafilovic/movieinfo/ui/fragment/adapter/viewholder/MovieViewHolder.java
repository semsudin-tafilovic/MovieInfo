package rs.tafilovic.movieinfo.ui.fragment.adapter.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import rs.tafilovic.movieinfo.R;
import rs.tafilovic.movieinfo.model.Result;
import rs.tafilovic.movieinfo.rest.GlideApp;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG= MovieViewHolder.class.getSimpleName();

    private TextView tvTitle, tvGenre, tvRating;
    private ImageView ivPoster;
    private String baseImagePath = "https://image.tmdb.org/t/p/w500";

    public static MovieViewHolder init(View view) {
        return new MovieViewHolder(view);
    }

    public void bind(Result result) {
        Log.d(TAG,result.toString());
        tvTitle.setText(result.getTitle());
        tvGenre.setText(result.getGenreIds().toString());
        tvRating.setText(String.valueOf(result.getVoteAverage()));
        String fullImagePath = baseImagePath + result.getPosterPath();
        GlideApp.with(ivPoster)
            .load(fullImagePath)
            .into(ivPoster);
    }

    private MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvRating = itemView.findViewById(R.id.tvRating);
        tvGenre = itemView.findViewById(R.id.tvGenre);
        ivPoster = itemView.findViewById(R.id.ivPoster);
    }
}
