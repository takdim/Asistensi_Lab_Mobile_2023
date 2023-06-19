package com.example.tuprak_5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    Context context;
    ArrayList<PostModel> posts;

    public PostAdapter(Context context, ArrayList<PostModel> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.caption.setText(posts.get(position).getCaption());
        holder.photoPosted.setImageURI(posts.get(position).getImage());
        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.profile.getContext(), ProfileActivity.class);
                holder.profile.getContext().startActivity(intent);
            }
        });

        holder.username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.username.getContext(), ProfileActivity.class);
                holder.username.getContext().startActivity(intent);
            }
        });

        holder.fullname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.fullname.getContext(), ProfileActivity.class);
                holder.fullname.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView caption, username, fullname;
        ImageView profile, photoPosted;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            caption = itemView.findViewById(R.id.caption);
            profile = itemView.findViewById(R.id.profil);
            photoPosted = itemView.findViewById(R.id.photoPosted);
            username = itemView.findViewById(R.id.username);
            fullname = itemView.findViewById(R.id.fullname);



        }
    }
}
