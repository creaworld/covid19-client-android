package tn.covid19.client.covid19.ui.dashboard;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import tn.covid19.client.R;

public class DashboardFragment extends Fragment {

//  private DashboardViewModel dashboardViewModel;
  WebView mWebView ;

  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  //  dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
    View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

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
    mWebView.loadUrl("http://covid-19.tn/");
    return root;
  }
}
