package org.aplas.lms.adapters.students;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.aplas.lms.ItemClickListener;
import org.aplas.lms.R;
import org.aplas.lms.activities.students.StudentAttendanceCheckActivity;
import org.aplas.lms.responses.courses.CourseResponse;

import java.util.ArrayList;

public class AttendanceCourseAdapter extends RecyclerView.Adapter<AttendanceCourseAdapter.ViewHolder>{
    Context context;

    private ArrayList<CourseResponse> listCourse;

    public AttendanceCourseAdapter(Context context, ArrayList<CourseResponse> listCourse) {
        this.listCourse = listCourse;
        this.context = context;
    }

    @NonNull
    @Override
    public AttendanceCourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_course, parent,false);
        return new AttendanceCourseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceCourseAdapter.ViewHolder holder, int position) {
        holder.tv_id.setText(String.valueOf(position+1));
        holder.tv_title.setText(listCourse.get(position).getName());
        holder.tv_lecture.setText(listCourse.get(position).getUser().getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                Intent intent = new Intent(context, StudentAttendanceCheckActivity.class);
                intent.putExtra("_id", listCourse.get(position).getId());
                intent.putExtra("iTitle",listCourse.get(position).getName());
                intent.putExtra("iLecture",listCourse.get(position).getUser().getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (listCourse != null)? listCourse.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ItemClickListener itemClickListener;
        private TextView tv_id, tv_title, tv_lecture;

        public ViewHolder (View view){
            super(view);

            tv_id = view.findViewById(R.id.tv_id);
            tv_title = view.findViewById(R.id.tv_title);
            tv_lecture = view.findViewById(R.id.tv_lecture);
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClickListener(view, getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }
    }
}
