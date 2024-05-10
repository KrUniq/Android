package ru.mirea.kharitonovakm.employeedb;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDataBase database = App.getInstance().getDatabase();
        final EmployeeDao employeeDao = database.employeeDao();

        employeeDao.insert(new Employee(1,"SuperCat", 10100));
        employeeDao.insert(new Employee(2,"CarMan", 4200));
        employeeDao.insert(new Employee(3,"IvanDorn", 5600));
        // Retrieving employee data from the database
        List<Employee> employees = employeeDao.getAll();

        // Displaying employee information in TextView
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = findViewById(R.id.textView);
        StringBuilder stringBuilder = new StringBuilder();

        for (Employee employee : employees) {
            stringBuilder.append("ID: ").append(employee.getId())
                    .append(", Name: ").append(employee.getName())
                    .append(", Salary: ").append(employee.getSalary())
                    .append("\n");
        }

        textView.setText(stringBuilder.toString());
    }
}