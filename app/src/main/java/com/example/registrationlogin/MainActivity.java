package com.example.registrationlogin;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    private EditText usernameEditText;
    private EditText passwordEditText;
    private UserDatabaseManager dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dbhelper = new UserDatabaseManager(this);
        dbhelper.open();

        TextView registerlink = findViewById(R.id.registerlink);
        Button loginbutton = findViewById(R.id.loginbutton);



         usernameEditText = findViewById(R.id.username);
         passwordEditText = findViewById(R.id.passwordtogle);


        registerlink.setOnClickListener(v ->
        {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);
        });

        loginbutton.setOnClickListener(v ->
        {
                String usernameText = usernameEditText.getText().toString();
                String passwordText = passwordEditText.getText().toString();
                String dbPassword = dbhelper.getPassword(usernameText);
                if(passwordText.equals(dbPassword))
                {
                    Toast.makeText(this, "LOGIN SUCCESFULL", Toast.LENGTH_SHORT).show();
                    Intent button = new Intent(MainActivity.this, FourthActivity.class);
                    startActivity(button);
                }
                else if (dbPassword==null) {
                    Toast.makeText(this, "PLEASE REGISTER", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(i);
                }
                else
                {
                Toast.makeText(this, "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
                }

        });
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        dbhelper.close();
    }
}