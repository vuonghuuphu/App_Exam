package huuphu.aprotrain.app_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ed_Name,ed_Des,ed_Salary;
    Button btn_add,btn_delete,btn_update;
    AppDatabase database;
    RecyclerView List_item ;
//    Intent intent = getIntent();
//    int id =  intent.getIntExtra("id_select",0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_Name = findViewById(R.id.ed_name);
        ed_Des = findViewById(R.id.ed_des);
        ed_Salary = findViewById(R.id.ed_salary);
        List_item = findViewById(R.id.rcv_list);
        btn_add = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_Update);
        btn_delete = findViewById(R.id.btn_delete);

        database = AppDatabase.getAppDatabase(this);

        List<Employee> list = database.employeeDao().getAll_employee();
        EmlpyeeAdapter adapter = new EmlpyeeAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAdd();
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

//        if (id> 0 ){
//            Employee employee = database.employeeDao().find_employee(id);
//            ed_Name.setText(employee.name);
//            ed_Salary.setText(employee.salary);
//            ed_Des.setText(employee.salary);
//        }


        Log.e("TAG", "onCreate: " + list.size());
        List_item.setLayoutManager(layoutManager);
        List_item.setAdapter(adapter);

    }

    private void onAdd(){
//        if (!validate()){
//            return;
//        }
        Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show();
        Employee employee = new Employee();
        employee.name = ed_Name.getText().toString();
        employee.designation = ed_Des.getText().toString();
        employee.salary = ed_Salary.getText().toString();
        long id = database.employeeDao().insert_employee(employee);
        if (id>0){
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
        }
    }

    private void Update(){
        Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show();
        Employee employee = new Employee();
        employee.name = ed_Name.getText().toString();
        employee.designation = ed_Des.getText().toString();
        employee.salary =ed_Salary.getText().toString();
        long id = database.employeeDao().insert_employee(employee);
        if (id>0){
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
        }
    }

    private void delete(){
        Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show();
        Employee employee = new Employee();
        employee.name = ed_Name.getText().toString();
        employee.designation = ed_Des.getText().toString();
        employee.salary = ed_Salary.getText().toString();
        long id = database.employeeDao().insert_employee(employee);
        if (id>0){
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
        }
    }


}