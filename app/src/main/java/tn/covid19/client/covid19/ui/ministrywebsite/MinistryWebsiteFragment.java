package tn.covid19.client.covid19.ui.ministrywebsite;

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

import tn.covid19.client.R;

public class MinistryWebsiteFragment extends Fragment {

  private static final String MINISTRYWEB_URL = "http://covid-19.tn/" ;

//  private DashboardViewModel dashboardViewModel;
  private WebView mWebView ;

  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  //  dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
    View root = inflater.inflate(R.layout.fragment_ministrywebsite, container, false);

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
    mWebView.loadUrl(MINISTRYWEB_URL);
    return root;
  }
}
