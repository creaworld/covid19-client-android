package tn.covid19.client.covid19.ui;

import android.os.Bundle;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import tn.covid19.client.R;

public class CovidActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_covid);
    BottomNavigationView navView = findViewById(R.id.nav_view);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    AppBarConfiguration appBarConfiguration =
        new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard,
            R.id.navigation_notifications, R.id.navigation_visio, R.id.navigation_help).build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(navView, navController);
    initStatusBarColor();
  }

  private void initStatusBarColor(){
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.accent));
    getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.accent));
  }

}
