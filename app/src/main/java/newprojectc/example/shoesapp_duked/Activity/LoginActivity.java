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

public class LoginActivity extends AppCompatActivity {
    private Button signin;
    private EditText email;
    private EditText passw;
    private TextView tvSignUp;

    QuanLyGiay quanLyGiay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        quanLyGiay= new QuanLyGiay(LoginActivity.this);

        signin = findViewById(R.id.btnLogIn);
        email = findViewById(R.id.loginEmail);
        passw = findViewById(R.id.loginPassword);
        tvSignUp = findViewById(R.id.txtRegister);
        signin.setOnClickListener(v -> {
            userLogin();
           // adminLogin();
        });
        tvSignUp.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
        });
    }

    private void userLogin() {
        String e_mai = email.getText().toString().trim();
        String p_assw = passw.getText().toString().trim();
        //  Admin admin = new Admin();

        if (TextUtils.isEmpty(e_mai)) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(p_assw)) {
            Toast.makeText(this, "Enter pass", Toast.LENGTH_SHORT).show();
            return;
        }
        UserLogin user = quanLyGiay.Authenticate(new UserLogin(e_mai, p_assw));
        if (user != null) {
            Application.accountCurrent = user;
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Tài khoản và mật khẩu không đúng", Toast.LENGTH_SHORT).show();
        }
        //
        // String TenDangNhap = email.getText().toString();
        //                String MatKhau = passw.getText().toString();
        //4
        //                if(TenDangNhap.equals("") || MatKhau.equals("")){
        //                    Toast.makeText(LoginActivity.this, "Vui lòng nhập nhập đầy đủ thông tin!!", Toast.LENGTH_SHORT).show();
        //                }
        //                else{
        //                    boolean checkusername = quanLyGiay.checkusername(TenDangNhap);
        //                    boolean checkpassword = quanLyGiay.checkpassword(MatKhau);
        //                    if(checkusername && checkpassword){
        //                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        //                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        //                        startActivity(intent);
        //                    }else{
        //                        Toast.makeText(LoginActivity.this, "Tên đăng nhập hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
        //                    }
        //              }
        //
        //
        //    }
    }
        private void adminLogin() {
            String email1 = email.getText().toString().trim();
            String password = passw.getText().toString().trim();

            if (TextUtils.isEmpty(email1)) {
                Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
                return;
            }

            Admin admin = quanLyGiay.isAdmin(new Admin(email1, password));
            if (admin != null) {
                // Admin login successful
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            } else {
                // Admin login failed
                Toast.makeText(this, "Invalid admin credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }

