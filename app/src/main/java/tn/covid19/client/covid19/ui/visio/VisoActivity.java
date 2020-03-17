package tn.covid19.client.covid19.ui.visio;

import android.os.Bundle;
import java.net.MalformedURLException;
import java.net.URL;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import tn.covid19.client.R;

import static org.jitsi.meet.sdk.JitsiMeet.setDefaultConferenceOptions;

public class VisoActivity extends JitsiMeetActivity {

  public static String URL = "https://meet.jit.si";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_viso);

    String channelName = getIntent().getStringExtra("channelName");
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
    launch(this, options);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
  }
}
