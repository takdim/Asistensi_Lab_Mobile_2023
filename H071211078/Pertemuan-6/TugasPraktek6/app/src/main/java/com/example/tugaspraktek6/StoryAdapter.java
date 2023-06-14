package com.example.tugaspraktek6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private final ArrayList<Post> posts;

    private ClickListener clickListener;

    public StoryAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_story_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Post post = posts.get(position);
        holder.setData(post, context);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final CircleImageView civ_story;
        private final TextView tv_username_story;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            civ_story = itemView.findViewById(R.id.civ_story);
            tv_username_story = itemView.findViewById(R.id.tv_username_story);
        }

        public void setData(Post post, Context context) {
            String username = post.getUsername();
            String postProfile = post.getProfilePicture();

            tv_username_story.setText(username);

            if (postProfile != null){
                Glide.with(context)
                        .load(postProfile)
                        .into(civ_story);
            }
            else {
                Glide.with(context)
                        .load(R.drawable.img)
                        .into(civ_story);
            }

            itemView.setOnClickListener(view -> {
                clickListener.onItemClicked(post);
            });
        }
    }

    interface ClickListener {

        void onItemClicked(Post post);

    }
}
