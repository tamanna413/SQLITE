package com.example.user.sqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mymail,mypswd;
    Button login,button2,button3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mymail = findViewById(R.id.mymail);
        mypswd = findViewById(R.id.mypswd);
        login = findViewById(R.id.login);
        button2 = findViewById(R.id.button2);
        button3 =findViewById(R.id.button3);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(MainActivity.this, "log in successful", Toast.LENGTH_SHORT).show();


//              Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//                      startActivity(intent);
//
                if (TextUtils.isEmpty(mymail.getText().toString())){
                    mymail.setError("field is failed");
                    return;
                }


                if (TextUtils.isEmpty(mypswd.getText().toString())){
                    mypswd.setError("field is failed");
                }
                AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("submit continue");
                builder.setMessage("are u shure to continue");

                Toast.makeText(MainActivity.this, "login successfull", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
////
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {




                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);
            }
        });








    }
}