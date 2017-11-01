package com.smartamigos.signuppage;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CircleImageView googleProfilePhoto, genderMale, genderFemale;
    TextView joinCommunity;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        googleProfilePhoto = (CircleImageView) findViewById(R.id.googleProfileImage);
        genderMale = (CircleImageView) findViewById(R.id.genderMale);
        genderFemale = (CircleImageView) findViewById(R.id.genderFemale);
        joinCommunity = (TextView) findViewById(R.id.join_the_comm);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/"+"Roboto.ttf");
        joinCommunity.setTypeface(tf);

        genderMale.setOnClickListener(this);
        genderFemale.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.genderMale : genderMale.setBorderColor(Color.GREEN);
                genderFemale.setBorderColor(Color.TRANSPARENT);
                break;
            case R.id.genderFemale : genderFemale.setBorderColor(Color.GREEN);
                genderMale.setBorderColor(Color.TRANSPARENT);
                break;
            case  R.id.signUpButton :
                Intent intent = new Intent(this,SecondSignUp.class);
                startActivity(intent);
                break;
        }
    }
}
