package com.example.atry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atry.R;
import com.example.atry.Students;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentsViewHolder>{

    Context mContext;
    List<Students> studentsList;

    public StudentAdapter(List<Students> studentsList){
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_students, parent, false);
        return new StudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, final int position) {
        final Students student = studentsList.get(position);
        holder.tvName.setText(student.getName());
        holder.tvAge.setText(student.getAge());
        holder.tvAddress.setText(student.getAddress());
        holder.tvGender.setText(student.getGender());

        if (student.getGender().equals("Male")) {
            holder.imgProfile.setImageResource(R.drawable.male);
        } else if (student.getGender().equals("Female")) {
            holder.imgProfile.setImageResource(R.drawable.female);
        } else {
            holder.imgProfile.setImageResource(R.drawable.others);
        }

        holder.imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentsList.remove(student);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }


    public class StudentsViewHolder extends RecyclerView.ViewHolder{
        ImageView imgProfile;
        TextView tvName, tvAge, tvAddress, tvGender;
        ImageButton imgButton;


        public StudentsViewHolder(View itemView){
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvGender = itemView.findViewById(R.id.tvGender);
            imgButton = itemView.findViewById(R.id.imgButton);
        }
    }
}
