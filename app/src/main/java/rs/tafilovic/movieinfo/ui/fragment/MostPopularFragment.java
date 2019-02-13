package rs.tafilovic.movieinfo.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import rs.tafilovic.movieinfo.R;
import rs.tafilovic.movieinfo.ui.fragment.adapter.MoviesListAdapter;
import rs.tafilovic.movieinfo.viewmodel.PopularViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostPopularFragment extends Fragment {

    private static final String TAG=MostPopularFragment.class.getSimpleName();

    private PopularViewModel popularViewModel;
    private MoviesListAdapter adapter;

    public static MostPopularFragment getInstance(Bundle bundle) {
        MostPopularFragment mostPopularFragment = new MostPopularFragment();
        if (bundle != null)
            mostPopularFragment.setArguments(bundle);
        return mostPopularFragment;
    }


    public MostPopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_rated, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());

        adapter = new MoviesListAdapter();

        popularViewModel= ViewModelProviders.of(this).get(PopularViewModel.class);
        popularViewModel.getPopularLiveData().observe(this, results -> adapter.submitList(results));
        popularViewModel.getNetworkLoadStatus().observe(this, state -> {
            // update progress or something
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
