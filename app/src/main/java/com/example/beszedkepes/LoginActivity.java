package com.example.beszedkepes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class LoginActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private Button btn_login;
    private TextView TV_link_signup;
    private TextInputLayout login_input_layout_username, login_input_layout_password;
    private DatabaseHelper db;
    private Handler handler = new Handler();

    String kulsofelhasznalonev = "";
    String kulsojelszo = "";
    String belsofhnev = "";
    String belsojelszo = "";
    boolean belepes = false;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*handler.postDelayed(runnable, 2000);*/

        init();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginLekeres();
                if (belepes)
                {
                    Intent belepes = new Intent(LoginActivity.this, Main2Activity.class);
                    startActivity(belepes);
                    finish();
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.clear();
                    editor.commit();

                }
            }
        });

        TV_link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register_activity= new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(register_activity);
                finish();
            }
        });

    }

    public void loginLekeres()
    {
        kulsofelhasznalonev = login_input_layout_username.getEditText().getText().toString();
        kulsojelszo = login_input_layout_password.getEditText().getText().toString();


        if (kulsofelhasznalonev.equals(""))
        {
            login_input_layout_username.setError("Mező nem lehet üres!");
        }else if (kulsojelszo.equals(""))
        {
            login_input_layout_password.setError("Mező nem lehet üres!");
        }
        else
        {
            Cursor cursor = db.chkuser(login_input_layout_username.getEditText().getText().toString());

            if (cursor != null && cursor.getCount() > 0)
            {

                while (cursor.moveToNext())
                {
                    belsofhnev = cursor.getString(0);
                    belsojelszo = cursor.getString(1);
                }

                if (kulsofelhasznalonev.equals(belsofhnev) && kulsojelszo.equals(belsojelszo))
                {
                    belepes = true;
                    /*lottieAnimation1.setAnimation("checked_done.json");
                    lottieAnimation1.playAnimation();*/
                    final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setMessage("Belépés...");
                    progressDialog.show();
                }
                else
                {
                    login_input_layout_username.setError("Hibás felhasználónév vagy jelszó!");
                    login_input_layout_password.setError("Hibás felhasználónév vagy jelszó!");
                }
            }
            else
            {
                login_input_layout_username.setError("Nincs ilyen felhasználó!");
            }
        }

    }

    private void init() {
        btn_login = (Button) findViewById(R.id.btn_login);
        TV_link_signup = (TextView) findViewById(R.id.TV_link_signup);
        login_input_layout_password = (TextInputLayout) findViewById(R.id.login_input_layout_password);
        login_input_layout_username = (TextInputLayout) findViewById(R.id.login_input_layout_username);
        db = new DatabaseHelper(LoginActivity.this);

        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
    }

    /*Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };*/
}
