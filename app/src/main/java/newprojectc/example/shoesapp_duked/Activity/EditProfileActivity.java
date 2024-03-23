package newprojectc.example.shoesapp_duked.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import newprojectc.example.shoesapp_duked.Application;
import newprojectc.example.shoesapp_duked.R;

public class EditProfileActivity extends AppCompatActivity {

    private EditText etEmail, etPhone, etUsername, etAddress;
    private ImageView imageBack, imageAvatar;
    private Button btnSave;

    QuanLyGiay quanLyGiay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        etEmail = findViewById(R.id.email);
        etEmail.setText(Application.accountCurrent.getEmail());

        etAddress = findViewById(R.id.address);
        etAddress.setText(Application.accountCurrent.getAddress());

        etUsername = findViewById(R.id.username);
        etUsername.setText(Application.accountCurrent.getUserName());

        etPhone = findViewById(R.id.phone);
        etPhone.setText(Application.accountCurrent.getPhone());

        imageBack = findViewById(R.id.btnBack);
        btnSave = findViewById(R.id.btnADD);
        imageBack.setOnClickListener(view -> finish());


        btnSave.setOnClickListener(view -> {
            String phone = etPhone.getText().toString();
            String username = etUsername.getText().toString();
            String address = etAddress.getText().toString();

            if (phone.isEmpty() || username.isEmpty() || address.isEmpty()) {
                Toast.makeText(EditProfileActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            Application.accountCurrent.setAddress(address);
            Application.accountCurrent.setUserName(username);
            Application.accountCurrent.setPhone(phone);

            quanLyGiay = new QuanLyGiay(getApplicationContext());
            quanLyGiay.updateUser(Application.accountCurrent);
            finish();
        });
    }
}