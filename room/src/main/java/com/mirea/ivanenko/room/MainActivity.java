package com.mirea.ivanenko.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.mirea.ivanenko.room.dao.App;
import com.mirea.ivanenko.room.dao.AppDatabase;
import com.mirea.ivanenko.room.dao.Employee;
import com.mirea.ivanenko.room.dao.EmployeeDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee = new Employee();
        employee.id = 1;
        employee.name = "Ivanenko Andrei";
        employee.salary = 30000;
        // запись сотрудников в базу
        employeeDao.insert(employee);
        // Загрузка всех работников
        List<Employee> employees = employeeDao.getAll();
        // Получение определенного работника с id = 1
        employee = employeeDao.getById(1);
        // Обновление полей объекта
        employee.salary = 40000;
        employeeDao.update(employee);
        Log.d(TAG, employee.name + " " + employee.salary);
    }
}