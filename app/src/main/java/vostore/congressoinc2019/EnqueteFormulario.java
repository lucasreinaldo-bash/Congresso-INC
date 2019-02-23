package vostore.congressoinc2019;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;


public class EnqueteFormulario extends AppCompatActivity {

    private Button voltar;

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquete_formulario);

        // android.support.v7.app.ActionBar bar = getSupportActionBar();
        // bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF8F00")));
        Bundle extras = getIntent().getExtras();
        voltar = findViewById(R.id.voltarapp);
        mWebView = (WebView) findViewById(R.id.site);
        //Recebendo informação de outra Activity
        if (null != getIntent()) {
            /** Pegamos o VALOR_1**/
            final String site = getIntent().getStringExtra("site");


            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setSupportZoom(false);
            mWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdk_qlY54Bt7R2o8mq4t5etw5GCj29eGM7gncO49enQe9BjVg/viewform");
            mWebView.setWebViewClient(new HelloWebViewClient());


            voltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(EnqueteFormulario.this, Menu.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        }
        @Override
        public void onBackPressed () {

            Intent intent = new Intent(EnqueteFormulario.this, Menu.class);
            startActivity(intent);
            finish();

        }

        private class HelloWebViewClient extends WebViewClient {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                webView.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO Auto-generated method stub
                super.onPageFinished(view, url);

                //progressBar.setVisibility(view.GONE);
            }

        }


        @Override
        public boolean onKeyDown ( int keyCode, KeyEvent event)
        { //if back key is pressed
            if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;

            }

            return super.onKeyDown(keyCode, event);

        }
    }
