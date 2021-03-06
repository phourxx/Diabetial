package com.hayroyal.tom.diabetial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


//Created by Folalu Timothy

public class RegisterActivityAdmin extends AppCompatActivity {

    EditText editText1, editText2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();

                if (text1.equals("") || text2.equals("")){
//                    password not entered
                    Toast.makeText(RegisterActivityAdmin.this, "No password entered", Toast.LENGTH_SHORT).show();
                }else {
//                    create passord in sharedpreferences
                    if (text1.equals(text2)){
                        SharedPreferences settings  = getSharedPreferences("PREFSS", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("passwords", text1);
                        editor.apply();

//                        login to the app
                        Intent intent = new Intent(getApplicationContext(), HomePage.class);
                        startActivity(intent);
                        finish();

                    }else {
                        Toast.makeText(RegisterActivityAdmin.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}