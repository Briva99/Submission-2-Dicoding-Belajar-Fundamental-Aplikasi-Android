package example.com.submission2githubuser.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import example.com.submission2githubuser.DetailUserActivity;
import example.com.submission2githubuser.R;
import example.com.submission2githubuser.adapter.FollowingAdapter;
import example.com.submission2githubuser.adapter.UserAdapter;
import example.com.submission2githubuser.model.FollowingModel;
import example.com.submission2githubuser.model.UserModel;
import example.com.submission2githubuser.retrofit.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowingFragment extends Fragment {
    RecyclerView rvFollowing;
    UserModel dataUser;

    public FollowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_following, container, false);
    }

    @Override
    public void onViewCreated(@NotNull final View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //Mengambil data dari search user
        DetailUserActivity detailUserActivity = (DetailUserActivity) getActivity();
        Bundle bundle = detailUserActivity.getIntent().getBundleExtra(UserAdapter.DATA_EXTRA);
        dataUser = Parcels.unwrap(bundle.getParcelable(UserAdapter.DATA_USER));

        rvFollowing = view.findViewById(R.id.rv_following);
        rvFollowing.setLayoutManager(new LinearLayoutManager(view.getContext()));

        Call<List<FollowingModel>> request = ApiClient.getApiService().getFollowingUser(dataUser.getLogin());
        request.enqueue(new Callback<List<FollowingModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<FollowingModel>> call, @NotNull Response<List<FollowingModel>> response) {
                ArrayList<FollowingModel> listFollowing = new ArrayList<>();
                if (response.isSuccessful()){
                    if (response.body() != null){
                        listFollowing.addAll(response.body());
                        Log.d("TAG RESULT", "onResponse: " +listFollowing.size());
                        rvFollowing.setAdapter(new FollowingAdapter(getContext(), listFollowing));
                    }
                }
                else {
                    Toast.makeText(getContext(), "Request Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FollowingModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Request Failure"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
