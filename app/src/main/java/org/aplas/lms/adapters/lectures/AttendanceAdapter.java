package org.aplas.lms.adapters.lectures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.aplas.lms.ItemClickListener;
import org.aplas.lms.R;
import org.aplas.lms.models.AttendanceModel;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder>{
    Context context;

    private ArrayList<AttendanceModel> listAttendance;

    public AttendanceAdapter(Context context,ArrayList<AttendanceModel> listAttendance) {
        this.listAttendance = listAttendance;
        this.context = context;
    }

    @NonNull
    @Override
    public AttendanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_attendance, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_Status.setText(listAttendance.get(position).getStatus());
        holder.tv_created_at.setText(listAttendance.get(position).getCreated_at().toString());
    }

    @Override
    public int getItemCount() {
        return (listAttendance != null)? listAttendance.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_Status, tv_created_at;
        private ItemClickListener itemClickListener;

        public ViewHolder (View view){
            super(view);

            tv_Status = view.findViewById(R.id.tv_Status);
            tv_created_at = view.findViewById(R.id.tv_created_at);
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
