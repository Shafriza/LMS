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
import org.aplas.lms.models.TaskModel;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{
    Context context;

    private ArrayList<TaskModel> listTask;

    public TaskAdapter(Context context,ArrayList<TaskModel> listTask) {
        this.listTask = listTask;
        this.context = context;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_task, parent,false);
        return new TaskAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        holder.tv_title.setText(listTask.get(position).getTitle());
        holder.tv_description.setText(listTask.get(position).getDescription());
        holder.tv_deadline.setText(listTask.get(position).getDeadline().toString());

    }

    @Override
    public int getItemCount() {
        return (listTask != null)? listTask.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_title, tv_description, tv_deadline;
        private ItemClickListener itemClickListener;

        public ViewHolder (View view){
            super(view);

            tv_title = view.findViewById(R.id.tv_title);
            tv_description = view.findViewById(R.id.tv_description);
            tv_deadline = view.findViewById(R.id.tv_deadline);

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
