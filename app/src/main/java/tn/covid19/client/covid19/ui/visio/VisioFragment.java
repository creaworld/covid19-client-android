package tn.covid19.client.covid19.ui.visio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import tn.covid19.client.R;

public class VisioFragment extends Fragment {

  public VisioFragment() {
    // Required empty public constructor
  }

  public static String CHANNEL_ID = "channelName";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.visio_fragment, container, false);
    final EditText editText = view.findViewById(R.id.channelNameEditText);
    Button button = view.findViewById(R.id.conferenceButton);
    button.setOnClickListener( v -> {
      Intent intent = new Intent(getActivity(), VisoActivity.class);
      intent.putExtra(CHANNEL_ID, editText.getText().toString());
      startActivity(intent);
    });
    return view;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
  }
}
