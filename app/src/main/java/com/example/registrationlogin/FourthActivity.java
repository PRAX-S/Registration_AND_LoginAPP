package com.example.registrationlogin;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity
{
    private TextView Username;
    private TextView Email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);
        Username = findViewById(R.id.signupusername);
        Email = findViewById(R.id.signupemail);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String emailText = bundle.getString("email");
            String userText = bundle.getString("username");

            Username.setText(userText);
            Email.setText(emailText);
        }

    }
}
