package com.example.myapplication;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText edName,edEmail,edPassword;
    Button bSave, bRetrieve, bClear;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String Password = "passKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName=(EditText)findViewById(R.id.editText);
        edEmail=(EditText)findViewById(R.id.editText2);
        edPassword=(EditText)findViewById(R.id.editText3);

        bSave=(Button)findViewById(R.id.button_save);
        bRetrieve=(Button)findViewById(R.id.button_retrieve);
        bClear=(Button)findViewById(R.id.button_clear);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = edName.getText().toString();
                String email  = edEmail.getText().toString();
                String pass  = edPassword.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, name);
                editor.putString(Email, email);
                editor.putString(Password, pass);
                editor.commit();
                Toast.makeText(MainActivity.this,"Data saved.",Toast.LENGTH_LONG).show();
            }
        });

        bRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = sharedpreferences.getString(Name , null);
                String email = sharedpreferences.getString(Email, null);
                String pass = sharedpreferences.getString(Password, null);

                edName.setText(name);
                edEmail.setText(email);
                edPassword.setText(pass);

                Toast.makeText(getApplicationContext(), "Data retrieved",Toast.LENGTH_SHORT).show();

        }
        });

        bClear.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edName.setText("");
                edEmail.setText("");
                edPassword.setText("");
                Toast.makeText(MainActivity.this,"Field cleared.",Toast.LENGTH_LONG).show();
            }
        }));
    }

}
