package rs.tafilovic.movieinfo.ui.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import rs.tafilovic.movieinfo.R;
import rs.tafilovic.movieinfo.ui.fragment.adapter.MoviesListAdapter;
import rs.tafilovic.movieinfo.viewmodel.TopRatedViewModel;

/**
 * Class to present list of Top rated movies
 */
public class TopRatedFragment extends Fragment {

    private static final String TAG=TopRatedFragment.class.getSimpleName();

    private TopRatedViewModel topRatedViewModel;
    private MoviesListAdapter adapter;

    public static TopRatedFragment getInstance(Bundle bundle) {
        TopRatedFragment topRatedFragment = new TopRatedFragment();
        if (bundle != null)
            topRatedFragment.setArguments(bundle);
        return topRatedFragment;
    }

    public TopRatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_rated, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        adapter = new MoviesListAdapter();

        topRatedViewModel=ViewModelProviders.of(this).get(TopRatedViewModel.class);
        topRatedViewModel.getTopRatedLiveData().observe(this, results -> adapter.submitList(results));
        topRatedViewModel.getNetworkLoadStatus().observe(this, state -> {
            // update progress or something
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
