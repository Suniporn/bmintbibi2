package com.example.bmintbibi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmintbibi.Model.Auth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toast t = Toast.makeText(MainActivity.this,"Welcome to My ToDo application!",Toast.LENGTH_SHORT);
        t.show();

        Button loginbutton = findViewById(R.id.login_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText emailedittext = findViewById(R.id.email_edit_text);
                EditText passwordedittext = findViewById(R.id.password_edit_text);
                Checkable remember = findViewById(R.id.remem);
                String inputemail = emailedittext.getText().toString();
                String inputpassword = passwordedittext.getText().toString();
                Auth auth = new Auth(inputemail,inputpassword);
                boolean result =auth.check();
                if(result==true){
                    Toast.makeText(MainActivity.this,R.string.login_success,Toast.LENGTH_SHORT).show();
                    if(remember.isChecked()){
                        Toast.makeText(MainActivity.this,"คุณเลือกจำรหัสผ่าน",Toast.LENGTH_SHORT).show();
                    }
                  else {
                        Toast.makeText(MainActivity.this,"คุณเลือกไม่จำรหัสผ่าน",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.login_fail,Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("ERROR");
                    dialog.setMessage("Invalid email or password");
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }

                    });
                    dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                         dialog.show();
                }
            }
        });

    }

}
