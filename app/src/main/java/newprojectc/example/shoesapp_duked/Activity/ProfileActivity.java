package newprojectc.example.shoesapp_duked.Activity;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.HashMap;
import java.util.Map;

import newprojectc.example.shoesapp_duked.Application;
import newprojectc.example.shoesapp_duked.R;
import newprojectc.example.shoesapp_duked.model.UserLogin;

public class ProfileActivity extends AppCompatActivity {
    private ImageView imageAvatar,btnEditProfile,imgLogout;
    private TextView tvEmail, tvPhone , btnChangePass, tvNameUser,tvMap,tvGioiTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageAvatar = findViewById(R.id.imageView2);
        imgLogout = findViewById(R.id.imgLogout);
        tvEmail = findViewById(R.id.tvEmail);
        tvMap = findViewById(R.id.tvMap);
        tvGioiTinh = findViewById(R.id.tvGioiTinh);
        tvNameUser = findViewById(R.id.tvNameUser);
        tvPhone = findViewById(R.id.tvNumberPhone);
        btnEditProfile = findViewById(R.id.btnEdit);
        btnChangePass = findViewById(R.id.btnChangePass);

        Glide
                .with(this)
                .load("https://sm.ign.com/ign_nordic/cover/a/avatar-gen/avatar-generations_prsz.jpg")
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(imageAvatar);
        tvNameUser.setText(Application.accountCurrent.getUserName());
        tvEmail.setText(Application.accountCurrent.getEmail());
        tvPhone.setText(Application.accountCurrent.getPhone());
        tvMap.setText(Application.accountCurrent.getAddress());
        tvGioiTinh.setText(Application.accountCurrent.getGioiTinh() == 1 ? " Nam" : "Nữ");


        btnEditProfile.setOnClickListener(view1 -> {
            startActivity(new Intent(getApplicationContext(), EditProfileActivity.class));
        });


        btnChangePass.setOnClickListener(view->{
            showCustomDialog();
        });


        imgLogout.setOnClickListener(view->{

            startActivity(new Intent(getApplicationContext(), LoginActivity.class)); //Go back to home page
            finish();
        });
    }

    void showCustomDialog() {
        final Dialog dialog = new Dialog(ProfileActivity.this);
        //We have added a title in the custom layout. So let's disable the default title.

        //The user will be able to cancel the dialog bu clicking anywhere outside the dialog.
        dialog.setCancelable(true);
        //Mention the name of the layout of your custom dialog.
        dialog.setContentView(R.layout.dialog_changepassword);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;

        dialog.getWindow().setAttributes(lp);

        //Initializing the views of the dialog.
        final EditText etPassword = dialog.findViewById(R.id.etPassword);
        final EditText etPasswordold = dialog.findViewById(R.id.etPasswordold);
        Button submitButton = dialog.findViewById(R.id.submit_button);
        Button cancleButton = dialog.findViewById(R.id.cancle_button);




        submitButton.setOnClickListener(v -> {
            String password = etPassword.getText().toString();
            String passwordold = etPasswordold.getText().toString();
            if(!passwordold.equals(Application.accountCurrent.getPassword())) {
                Toast.makeText(getApplicationContext(),"Mật khẩu cũ không đúng",Toast.LENGTH_SHORT).show();
                return;
            }

            if(password.isEmpty()) {
                Toast.makeText(getApplicationContext(),"Vui lòng không được bỏ trống thông tin.",Toast.LENGTH_SHORT).show();
                return;
            }


            QuanLyGiay quanLyGiay = new QuanLyGiay(getApplicationContext());
            Application.accountCurrent.setPassword(passwordold);
            quanLyGiay.updateUser(Application.accountCurrent);
            dialog.dismiss();
        });


        cancleButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvNameUser.setText(Application.accountCurrent.getUserName());
        tvEmail.setText(Application.accountCurrent.getEmail());
        tvPhone.setText(Application.accountCurrent.getPhone());
        tvMap.setText(Application.accountCurrent.getAddress());
        tvGioiTinh.setText(Application.accountCurrent.getGioiTinh() == 1 ? " Nam" : "Nữ");
    }
}