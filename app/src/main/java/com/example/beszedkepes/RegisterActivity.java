package com.example.beszedkepes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    private TextInputLayout signup_input_layout_name, signup_input_layout_username,
            signup_input_layout_password, signup_input_layout_password1, signup_input_layout_age;
    private Button btn_signup;
    private EditText edit_name, edit_username, edit_passw, edit_passw1;
    private TextView gender_textview;
    private RadioButton male_radio_btn, female_radio_btn;
    private RadioGroup gender_radio_group;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        db = new DatabaseHelper(this);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edit_username.getText().toString();
                String name = edit_name.getText().toString();
                String password = edit_passw.getText().toString();
                if (!registerName()|!registerUserName()|!registerPassword())
                {
                    return;
                }
                else
                {
                    Boolean insertUser=db.insertUser(name,username,password);
                    if(insertUser==true) {
                        signup();
                    }
                }
            }
        });
    }
    private boolean registerName(){
        String name = signup_input_layout_name.getEditText().getText().toString().trim();

        if(name.isEmpty()){
            signup_input_layout_name.setError("Mező nem lehet üres");
            return false;
        }else {
            signup_input_layout_name.setError(null);
            return true;
        }
    }

    private boolean registerUserName(){
        String username = signup_input_layout_username.getEditText().getText().toString().trim();

        if(username.isEmpty()){
            signup_input_layout_username.setError("Mező nem lehet üres");
            return false;
        }else if (username.length() > 20) {
            signup_input_layout_username.setError("Felhasználónév túl hosszú!");
            return false;
        }else {
            signup_input_layout_username.setError(null);
            return true;
        }
    }

    private boolean registerPassword(){
        String password = signup_input_layout_password.getEditText().getText().toString().trim();

        if(password.isEmpty()){
            signup_input_layout_password.setError("Mező nem lehet üres!");
            return false;
        }else {
            signup_input_layout_password.setError(null);
            return true;
        }
    }

   /*private boolean registerAge(){
        String szuldatum = signup_input_layout_age.getEditText().getText().toString().trim();

        if(szuldatum.isEmpty()){
            signup_input_layout_age.setError("Mező nem lehet üres!");
            return false;
        }else {
            signup_input_layout_age.setError(null);
            return true;
        }
    }*/

    private void init() {
        signup_input_layout_age = (TextInputLayout) findViewById(R.id.signup_input_layout_age);
        signup_input_layout_name = findViewById(R.id.signup_input_layout_name);
        signup_input_layout_username = findViewById(R.id.signup_input_layout_username);
        signup_input_layout_password = findViewById(R.id.signup_input_layout_password);
        btn_signup = findViewById(R.id.btn_signup);
        edit_name = findViewById(R.id.edit_name);
        edit_username = findViewById(R.id.edit_username);
        edit_passw = findViewById(R.id.edit_passw);
    }

    public void signup() {
        Log.d(TAG, "Signup");

        btn_signup.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Felhasználó létrehozása...");
        progressDialog.show();

        String name = signup_input_layout_name.getEditText().getText().toString();
        String username = signup_input_layout_username.getEditText().getText().toString();
        String password = signup_input_layout_password.getEditText().getText().toString();


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        onSignupSuccess();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        btn_signup.setEnabled(true);
        setResult(RESULT_OK, null);
        Intent register_activity = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(register_activity);
        finish();
    }
}
