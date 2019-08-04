package fr.docjyj.docservapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //private String url = "http://docjyj.ddns.net/";
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        WebView webView = new WebView(this);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient( new WebViewClient(){
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                System.out.println("Error: " + request + "; " + error);
            }
            /*public void onReceivedLoginRequest(WebView view, String realm, String account, String args){
                System.out.println("Login: " + realm + "; " + account + "; " + args);
            }
            public void onPageFinished(WebView view, String url){
                System.out.println("Succes: " + url);
                String url2 = new MainActivity().url;
                if(url.equals( url2 + "j_security_check")){
                    webView.loadUrl(url2);
                }
            }*/
        });
        //webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
        webView.loadUrl("http://docjyj.ddns.net/");
        setContentView(webView);
        /*try {
            String my_username = "admin";
            String my_password = "admin";
            String postData = "j_username=" + URLEncoder.encode(my_username, "UTF-8") + "&j_password=" + URLEncoder.encode(my_password, "UTF-8");
            webView.postUrl(url + "j_security_check",postData.getBytes());
            System.out.println("OK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        //setContentView(R.layout.activity_main);
    }
}
