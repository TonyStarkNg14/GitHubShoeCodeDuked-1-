package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import newprojectc.example.shoesapp_duked.Application;
import newprojectc.example.shoesapp_duked.R;
import newprojectc.example.shoesapp_duked.model.UserLogin;

public class RegisterActivity extends AppCompatActivity {
    private Button register;
    private EditText phone,edUsername;
    private EditText email,address, gioitinh;
    private EditText pass, passold;

    private TextView tvLogin;

    QuanLyGiay quanLyGiay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        quanLyGiay= new QuanLyGiay(RegisterActivity.this);

        register = findViewById(R.id.btnSignUp);
        email = findViewById(R.id.edEmail);
        edUsername = findViewById(R.id.edUsername);
        address = findViewById(R.id.edAdrress);
        gioitinh = findViewById(R.id.edGioiTinh);
        pass = findViewById(R.id.edPassword);
        phone = findViewById(R.id.edPhone);
        passold = findViewById(R.id.edPasswordConfirm);
        tvLogin = findViewById(R.id.txtSignIn);

        tvLogin.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplication(),LoginActivity.class));
        });
        register.setOnClickListener(v -> registerUser());
    }


    private void registerUser(){
        String username = edUsername.getText().toString();
        String addresstmp = address.getText().toString();
        String gioitinhtmp = gioitinh.getText().toString();
        String email_tv = email.getText().toString().trim();
        String password = pass.getText().toString().trim();
        String passwordcf = passold.getText().toString().trim();
        String phonenumber = phone.getText().toString().trim();


        if(TextUtils.isEmpty(username))
        {
            Toast.makeText(this,"Enter username",Toast.LENGTH_SHORT).show();
            //finish();
            //startActivity(new Intent(getApplication(),Dashboard.class));
            return;
        }

        if(TextUtils.isEmpty(addresstmp))
        {
            Toast.makeText(this,"Enter address",Toast.LENGTH_SHORT).show();
            //finish();
            //startActivity(new Intent(getApplication(),Dashboard.class));
            return;
        }

        if(TextUtils.isEmpty(gioitinhtmp))
        {
            Toast.makeText(this,"Enter giới tính",Toast.LENGTH_SHORT).show();
            //finish();
            //startActivity(new Intent(getApplication(),Dashboard.class));
            return;
        }

        if(TextUtils.isEmpty(email_tv))
        {
            Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show();
            //finish();
            //startActivity(new Intent(getApplication(),Dashboard.class));
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT).show();
            return;
        }


        if(TextUtils.isEmpty(phonenumber))
        {
            Toast.makeText(this,"Enter phone number",Toast.LENGTH_SHORT).show();
            return;
        }


        if(!passwordcf.equals(password)) {
            Toast.makeText(this,"Enter password confirm incorrect",Toast.LENGTH_SHORT).show();
            return;
        }

        if(quanLyGiay.isEmailExists(email_tv)) {
            Toast.makeText(this,"Email đã tồn tại",Toast.LENGTH_SHORT).show();
            return;
        }


        quanLyGiay.addUser(new UserLogin(username,email_tv,password, phonenumber, addresstmp,gioitinhtmp.equals("Nam") ? 1 : 0));
        Application.accountCurrent = new UserLogin(username,email_tv,password, phonenumber, addresstmp,gioitinhtmp.equals("Nam") ? 1 : 0);
        Toast.makeText(RegisterActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}