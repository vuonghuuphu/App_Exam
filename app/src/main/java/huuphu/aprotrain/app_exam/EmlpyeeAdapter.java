package huuphu.aprotrain.app_exam;

import android.app.Activity;
        import android.content.Intent;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.List;

public class EmlpyeeAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<Employee> employeeList;

    public EmlpyeeAdapter(Activity activity, List<Employee> employeeList) {
        this.activity = activity;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = activity.getLayoutInflater().inflate(R.layout.item_list,parent,false);
        EmployeeHoder hoder = new EmployeeHoder(itemview);
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHoder employeeHoder = (EmployeeHoder) holder;
        Employee model = employeeList.get(position);
        employeeHoder.tvName.setText(model.name);
        employeeHoder.tvDes.setText(model.designation);
        employeeHoder.tvSalary.setText(model.salary);
        employeeHoder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                intent.putExtra("id_select",employeeList.get(position).id);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeHoder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private ItemClickListener itemClickListener;
        TextView tvName;
        TextView tvDes;
        TextView tvSalary;


        public EmployeeHoder (@NonNull View itemview){
            super(itemview);
            tvName = itemview.findViewById(R.id.item_name);
            tvDes = itemview.findViewById(R.id.item_des);
            tvSalary = itemview.findViewById(R.id.item_salary);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),true); // Gọi interface , true là vì đây là onLongClick
            return true;
        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
    }
}
