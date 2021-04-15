package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeeproject.R;

import java.util.List;

public class EmployeeList extends RecyclerView.Adapter<EmployeeList.GetViewHolder> {


    Context context;
    List<Model.EmployeeList> list;

    public EmployeeList(Context context, List<Model.EmployeeList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EmployeeList.GetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dialog_employeelist, parent, false);
        return new GetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeList.GetViewHolder holder, int position) {


        Model.EmployeeList data = list.get(position);

        holder.tv_lastname.setText(data.getLastname());
        holder.tv_firstname.setText(data.getFirstname());
        holder.tv_id.setText(data.getID());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GetViewHolder extends RecyclerView.ViewHolder {

        TextView tv_id;
        TextView tv_firstname;
        TextView tv_lastname;

        public GetViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_firstname = itemView.findViewById(R.id.tv_firstname);
            tv_lastname = itemView.findViewById(R.id.tv_lastname);

        }
    }
}
