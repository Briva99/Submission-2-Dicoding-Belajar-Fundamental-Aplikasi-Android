package example.com.submission2githubuser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

import example.com.submission2githubuser.R;
import example.com.submission2githubuser.model.FollowingModel;

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder> {

    private Context context;
    private ArrayList<FollowingModel> data = new ArrayList<>();

    public FollowingAdapter(Context context, ArrayList<FollowingModel> listFollowing) {
        this.context = context;
        this.data = listFollowing;
    }

    //1. Method yang menyambungkan layout item
    @NonNull
    @Override
    public FollowingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.following_items, parent, false);
        return new FollowingViewHolder(itemview);
    }

    //2. Set data
    @Override
    public void onBindViewHolder(@NonNull FollowingViewHolder holder, int position) {
        holder.tvUsernameFollowing.setText(data.get(position).getLogin());
        Glide.with(context)
                .load(data.get(position).getAvatarUrl())
                .into(holder.ivAvatarFollowing);
    }

    //3.Jumlah data
    @Override
    public int getItemCount() {
        return data.size();
    }

    //2. Mengenalkan Komponen
    public class FollowingViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsernameFollowing;
        ImageView ivAvatarFollowing;

        public FollowingViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUsernameFollowing = itemView.findViewById(R.id.tv_username_following);
            ivAvatarFollowing = itemView.findViewById(R.id.iv_avatar_following);
        }
    }
}
