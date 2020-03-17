package tn.covid19.client.covid19.ui.home;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import tn.covid19.client.R;
import tn.covid19.client.legacy.TrackingService;

public class HomeFragment extends Fragment {

  private SharedPreferences sharedPreferences;
  public static final String KEY_DEVICE = "id";
  public static final String KEY_STATUS = "status";
  TextView idTextView;
  Switch serviceSwitch;

  private static final int PERMISSIONS_REQUEST_LOCATION = 2;

  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_home, container, false);
    setHasOptionsMenu(true);
    idTextView = root.findViewById(R.id.patientTextView);
    serviceSwitch = root.findViewById(R.id.serviceSwitch);
    serviceSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        serviceSwitch.setChecked(isChecked);
        sharedPreferences.edit().putBoolean(KEY_STATUS, isChecked).apply();
        if (isChecked) {
          startTrackingService(true, false);
        }else{
          stopTrackingService();
        }
      }
    });
    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
    if (!sharedPreferences.contains(KEY_DEVICE)) {
      String id = String.valueOf(new Random().nextInt(900000) + 100000);
      sharedPreferences.edit().putString(KEY_DEVICE, id).apply();
      idTextView.setText(id);
    } else {
      idTextView.setText(sharedPreferences.getString(KEY_DEVICE, "no id"));
    }
    if (sharedPreferences.getBoolean(KEY_STATUS, false)) {
      serviceSwitch.setChecked(true);
      startTrackingService(true, false);
    } else {
      stopTrackingService();
    }
    return root;
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    if (requestCode == PERMISSIONS_REQUEST_LOCATION) {
      boolean granted = true;
      for (int result : grantResults) {
        if (result != PackageManager.PERMISSION_GRANTED) {
          granted = false;
          break;
        }
      }
      startTrackingService(false, granted);
    }
  }

  private void startTrackingService(boolean checkPermission, boolean permission) {
    if (checkPermission) {
      Set<String> requiredPermissions = new HashSet<>();
      if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
          != PackageManager.PERMISSION_GRANTED) {
        requiredPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
      }
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
          && ContextCompat.checkSelfPermission(getContext(),
          Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        requiredPermissions.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
      }
      permission = requiredPermissions.isEmpty();
      if (!permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
          requestPermissions(requiredPermissions.toArray(new String[requiredPermissions.size()]),
              PERMISSIONS_REQUEST_LOCATION);
        }
        return;
      }
    }

    if (permission) {
      ContextCompat.startForegroundService(getContext(),
          new Intent(getActivity(), TrackingService.class));
    } else {
      sharedPreferences.edit().putBoolean(KEY_STATUS, false).apply();
    }
  }

  private void stopTrackingService() {
    getActivity().stopService(new Intent(getActivity(), TrackingService.class));
  }
}
