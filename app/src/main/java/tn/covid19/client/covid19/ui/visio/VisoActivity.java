package tn.covid19.client.covid19.ui.visio;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import tn.covid19.client.R;

import static org.jitsi.meet.sdk.JitsiMeet.setDefaultConferenceOptions;
import static tn.covid19.client.covid19.ui.home.HomeFragment.KEY_DEVICE;

public class VisoActivity extends AppCompatActivity {

  public static String URL = "https://meet.jit.si";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_viso);

    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    String channelName = "COVID-19" + sharedPreferences.getString(KEY_DEVICE, "no id");
    URL serverURL;
    try {
      serverURL = new URL(URL);
    } catch (MalformedURLException e) {
      e.printStackTrace();
      throw new RuntimeException("Invalid server URL!");
    }
    JitsiMeetConferenceOptions defaultOptions =
        new JitsiMeetConferenceOptions.Builder().setServerURL(serverURL)
            .setWelcomePageEnabled(false)
            .build();

    setDefaultConferenceOptions(defaultOptions);

    JitsiMeetConferenceOptions options =
        new JitsiMeetConferenceOptions.Builder().setRoom(channelName).build();
    // Launch the new activity with the given options. The launch() method takes care
    // of creating the required Intent and passing the options.
    JitsiMeetActivity.launch(this, options);
  }

  @Override
  protected void onResume() {
    super.onResume();
    finish();
  }
}
