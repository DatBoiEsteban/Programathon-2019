package com.stardust.programathon2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Patterns;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;



public class LoginActivity extends AppCompatActivity {
    private TextInputLayout id_entry;
    private TextInputLayout password_entry;
    private Button login_button;
    private static final Pattern ID_PATTERN =
            Pattern.compile("^[0-9]{9,10}$");
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^.{8,10}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_entry = findViewById(R.id.text_input_username);
        password_entry = findViewById(R.id.text_input_password);
        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmInput(view);
            }
        });
    }

    private boolean validateID() {
        String dni = id_entry.getEditText().getText().toString().trim();

        if (dni.isEmpty()) {
            id_entry.setError("Field can't be empty");
            return false;
        } else if (!ID_PATTERN.matcher(dni).matches()) {
            id_entry.setError("se mamo perro");
            return false;
        } else {
            id_entry.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = password_entry.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            password_entry.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password_entry.setError("Password too weak");
            return false;
        } else {
            password_entry.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateID() | !validatePassword()) {
            return;
        }

        String input = "Email: " + id_entry.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + password_entry.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}
