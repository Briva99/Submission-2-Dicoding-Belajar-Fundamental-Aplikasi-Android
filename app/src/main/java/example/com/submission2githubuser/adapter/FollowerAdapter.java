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

import example.com.submission2githubuser.R;
import example.com.submission2githubuser.model.FollowerModel;

public class FollowerAdapter extends RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder> {

    private Context context;
    private ArrayList<FollowerModel> data = new ArrayList<>();

    public FollowerAdapter(Context context, ArrayList<FollowerModel> listFollower) {
        this.context = context;
        this.data = listFollower;
    }

    //1. Method yang menyambungkan layout item
    @NonNull
    @Override
    public FollowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.follower_items, parent, false);
        return new FollowerViewHolder(itemview);
    }

    //2. Set data
    @Override
    public void onBindViewHolder(@NonNull FollowerViewHolder holder, int position) {
        holder.tvUsernameFollower.setText(data.get(position).getLogin());
        Glide.with(context)
                .load(data.get(position).getAvatarUrl())
                .into(holder.ivAvatarFollower);
    }

    //3. Jumlah data
    @Override
    public int getItemCount() {
        return data.size();
    }

    //4. mengenalkan komponen item
    public class FollowerViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsernameFollower;
        ImageView ivAvatarFollower;

        public FollowerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsernameFollower = itemView.findViewById(R.id.tv_username_follower);
            ivAvatarFollower = itemView.findViewById(R.id.iv_avatar_follower);

        }
    }
}
