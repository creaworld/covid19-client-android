package tn.covid19.client.covid19.ui;

import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.core.content.ContextCompat;
import tn.covid19.client.R;

public class SplashActivity extends AppCompatActivity {
    Handler handler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initStatusBarColor();
        handler=new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(SplashActivity.this,CovidActivity.class);
            startActivity(intent);
            finish();
        },3000);
    }

    private void initStatusBarColor(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.accent));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.accent));
    }
}
