package com.example.bkath;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.gson.Gson;

public class MainActivity extends Activity {

    private Button buttonCheckOut,viewPaer;
    private EditText amount;


    private WebView mWebView;
    private ProgressBar progressBar;
    private String request = "";

    AlertDialog dialogBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.checkout_amount);


        viewPaer = findViewById(R.id.pager);

        viewPaer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewPagerDemo.class);
                startActivity(intent);
            }
        });



        buttonCheckOut = (Button) findViewById(R.id.buttonUrlCheckout);

        buttonCheckOut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!amount.getText().toString().isEmpty()) {
                    loadCardView(amount.getText().toString());

                } else {
                    Toast.makeText(getApplicationContext(), "Please enter the field values", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }

    public void loadCardView(String amount) {
        dialogBuilder = new AlertDialog.Builder(MainActivity.this).create();

        View dialogView = LayoutInflater.from(MainActivity.this)
                .inflate(R.layout.activity_web_view_checkout, null);

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(amount);
        paymentRequest.setIntent("sale");
        paymentRequest.setOrderId("14 number");

        Gson gson = new Gson();
        request = gson.toJson(paymentRequest);

        mWebView = dialogView.findViewById(R.id.activity_checkout_webview);
        progressBar = dialogView.findViewById(R.id.progressBar);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        /*
         * Below part is for enabling webview settings for using javascript and accessing html files and other assets
         */
        mWebView.setClickable(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setAppCacheEnabled(false);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.clearCache(true);
        mWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        mWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);

        /*
         * To control any kind of interaction from html file
         */
        mWebView.addJavascriptInterface(new JavaScriptInterface(this), "AndroidNative");
        mWebView.loadUrl("file:///android_asset/www/checkout_120.html");


        mWebView.setWebChromeClient(new MainActivity.CheckoutWebViewClient());

        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }

    class CheckoutWebViewClient extends WebChromeClient {

        int done = -1;

        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }

        //        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            if (url.equals("https://www.bkash.com/terms-and-conditions")) {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                startActivity(myIntent);
//                return true;
//            }
//            return super.shouldOverrideUrlLoading(view, url);
//        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);

            if (newProgress == 100 && done == -1) {
                done = 100;
                String paymentRequest = "{paymentRequest:" + request + "}";
                mWebView.loadUrl("javascript:callReconfigure(" + paymentRequest + " )");
                mWebView.loadUrl("javascript:clickPayButton()");
                progressBar.setVisibility(view.GONE);
            }

        }


//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            progressBar.setVisibility(view.VISIBLE);
//        }

//        @Override
//        public void onPageFinished(WebView view, String url) {
//
//
//        }

    }


    class JavaScriptInterface {

        Context mContext;

        /**
         * Instantiate the interface and set the context
         */
        public JavaScriptInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void createToast(String str) {
            Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
            dialogBuilder.dismiss();
        }


    }

}
