package org.aplas.lms.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.aplas.lms.ItemClickListener;
import org.aplas.lms.R;
import org.aplas.lms.models.CourseModel;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{
    Context context;

    private ArrayList<CourseModel> listCourse;

    public CourseAdapter(Context context,ArrayList<CourseModel> listCourse) {
        this.listCourse = listCourse;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_course, parent,false);
        return new CourseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        holder.tv_title.setText(listCourse.get(position).getName());
        holder.tv_lecture.setText(listCourse.get(position).getUser().getLecture().getName());
    }

    @Override
    public int getItemCount() {
        return (listCourse != null)? listCourse.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_title, tv_lecture;
        private ItemClickListener itemClickListener;

        public ViewHolder (View view){
            super(view);

            tv_title = view.findViewById(R.id.tv_title);
            tv_lecture = view.findViewById(R.id.tv_lecture);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClickListener(view,getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }
    }
}
