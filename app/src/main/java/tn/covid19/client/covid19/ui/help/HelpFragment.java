package tn.covid19.client.covid19.ui.help;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import tn.covid19.client.R;

public class HelpFragment extends Fragment {

  public static final String HELP_URL = "https://help.covid19.tn/";

  WebView mWebView ;

  public HelpFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View root = inflater.inflate(R.layout.fragment_help, container, false);
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
    mWebView.loadUrl(HELP_URL);
    return root;
  }
}
