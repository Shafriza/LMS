package org.aplas.lms.adapters.lectures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.aplas.lms.R;
import org.aplas.lms.responses.courses.CourseResponse;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{
    Context context;

    private ArrayList<CourseResponse> listCourse;

    public CourseAdapter(Context context, ArrayList<CourseResponse> listCourse) {
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
        holder.tv_id.setText(String.valueOf(position+1));
        holder.tv_title.setText(listCourse.get(position).getName());
        holder.tv_lecture.setText(listCourse.get(position).getUser().getName());
    }

    @Override
    public int getItemCount() {
        return (listCourse != null)? listCourse.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_id, tv_title, tv_lecture;

        public ViewHolder (View view){
            super(view);

            tv_id = view.findViewById(R.id.tv_id);
            tv_title = view.findViewById(R.id.tv_title);
            tv_lecture = view.findViewById(R.id.tv_lecture);

        }
    }
}
