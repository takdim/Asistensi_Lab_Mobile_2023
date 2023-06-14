package com.example.protobootlegig;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private final List<String[]> items;
    private final Context context;

    public PostAdapter(Context context, List<String[]> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position){

        Uri uriImage =  Uri.parse(items.get(position)[0]);
        String caption = items.get(position)[1];
        Intent intent = new Intent(context,ProfileActivity.class);

        Glide.with(context)
                .load(uriImage)
                .centerCrop()
                .into(holder.image);

        holder.caption.setText(caption);
        holder.profile.setOnClickListener(v -> context.startActivity(intent));
        holder.userName.setOnClickListener(v -> context.startActivity(intent));
    }

    @Override
    public int getItemCount(){
        return (items != null) ? items.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView caption;
        ShapeableImageView profile;
        LinearLayout userName;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.image);
            caption = itemView.findViewById(R.id.caption);
            profile = itemView.findViewById(R.id.profileUser);
            userName = itemView.findViewById(R.id.NameUserName);
        }
    }
}
