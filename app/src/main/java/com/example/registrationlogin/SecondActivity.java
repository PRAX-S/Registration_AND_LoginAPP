package com.example.registrationlogin;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity
{
    UserDatabaseManager dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        dbhelper = new UserDatabaseManager(this);
        dbhelper.open();

        TextView loginlink = findViewById(R.id.loginlink);
        Button registerbutton = findViewById(R.id.registerbutton);
        EditText username = findViewById(R.id.signupname);
        EditText email = findViewById(R.id.signupemail);
        EditText password = findViewById(R.id.signuppass);
        EditText confirmpassword = findViewById(R.id.signupconpass);
        RadioGroup rg = findViewById(R.id.rg);



        loginlink.setOnClickListener(v ->
        {

            Intent i = new Intent(SecondActivity.this,MainActivity.class);
            startActivity(i);

        });

        registerbutton.setOnClickListener(v -> {

            String User = username.getText().toString();
            String Email = email.getText().toString();
            String Pass = password.getText().toString();

            dbhelper.insertUser(User,Email,Pass);
            Intent button = new Intent(SecondActivity.this, MainActivity.class);
            button.putExtra("username",User);
            button.putExtra("email",Email);
            button.putExtra("password",Pass);
            startActivity(button);
        });
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        dbhelper.close();
    }
}