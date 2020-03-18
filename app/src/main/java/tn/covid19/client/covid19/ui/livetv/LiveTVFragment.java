package tn.covid19.client.covid19.ui.livetv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import tn.covid19.client.R;

public class LiveTVFragment extends Fragment {

  public static final String LIVETV_URL = "http://help.covid19.tn/page/live";

  private LiveTVViewModel liveTVViewModel;
  private WebView mWebView ;

  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    liveTVViewModel = ViewModelProviders.of(this).get(LiveTVViewModel.class);
    View root = inflater.inflate(R.layout.fragment_livetv, container, false);
    /*
    final TextView textView = root.findViewById(R.id.text_notifications);
    liveTVViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    */

    mWebView = root.findViewById(R.id.webView);
    mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
    mWebView.setScrollbarFadingEnabled(true);
    WebSettings webViewSettings = mWebView.getSettings();
    webViewSettings.setJavaScriptEnabled(true);
    webViewSettings.setUseWideViewPort(true);
    webViewSettings.setBuiltInZoomControls(true);
    webViewSettings.setLoadWithOverviewMode(true);
    webViewSettings.setDomStorageEnabled(true);
    mWebView.setWebViewClient(new WebViewClient());
    mWebView.setWebChromeClient(new WebChromeClient());
    mWebView.loadUrl(LIVETV_URL);
    return root;
  }
}
