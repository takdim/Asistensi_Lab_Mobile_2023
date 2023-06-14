package com.example.tugaspraktek8;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Student student = studentList.get(position);
        holder.setData(student, context);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView nimTextView;
        TextView descTextView;

        public StudentViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_name);
            nimTextView = itemView.findViewById(R.id.tv_nim);
            descTextView = itemView.findViewById(R.id.tv_desc);
        }
        public void setData(Student student, Context context) {
            String title = student.getName();
            String year = student.getNim();
            String desc = student.getDescription();
            nameTextView.setText(title);
            nimTextView.setText(year);
            descTextView.setText(desc);
            itemView.setOnClickListener(view ->  {
                Intent intent = new Intent(itemView.getContext(), FormActivity.class);
                intent.putExtra("student", student);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
