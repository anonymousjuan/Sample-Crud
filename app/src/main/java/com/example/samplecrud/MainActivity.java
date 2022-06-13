package com.example.samplecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText etName,etAddress;
Button btnAdd, btnView;
ListView lvData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        btnAdd =findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        lvData = findViewById(R.id.lvData);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                DataModel dataModel = new DataModel(null,name,address);
               // Toast.makeText(MainActivity.this, dataModel.toString(), Toast.LENGTH_SHORT).show();
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean success = databaseHelper.AddOne(dataModel);
                Toast.makeText(MainActivity.this, "success"+ success, Toast.LENGTH_SHORT).show();


            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                List<DataModel> everyone =databaseHelper.Read();
                ArrayAdapter arrayAdapter = new ArrayAdapter<DataModel>(MainActivity.this,android.R.layout.simple_list_item_1,databaseHelper.Read());
                lvData.setAdapter(arrayAdapter);

            }
        });
    }
}