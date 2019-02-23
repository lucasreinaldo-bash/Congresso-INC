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


public class PatrocinadoresExpositores extends AppCompatActivity {

    private Button btn_site_inc, btn_site_abnc, btn_site_rd;

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patrocinadores_expositores);

        // android.support.v7.app.ActionBar bar = getSupportActionBar();
        // bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF8F00")));
        Bundle extras = getIntent().getExtras();

        mWebView = (WebView) findViewById(R.id.site);
        btn_site_inc =  findViewById(R.id.btn_site_inc);
        btn_site_abnc =  findViewById(R.id.btn_site_abnc);
        btn_site_rd =  findViewById(R.id.btn_site_rd);

        btn_site_rd.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               Intent intent = new Intent(PatrocinadoresExpositores.this, Site.class);
                                               intent.putExtra("site", "http://eventosrd.com.br/");
                                               startActivity(intent);
                                               finish();
                                           }   });

            btn_site_abnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatrocinadoresExpositores.this, Site.class);
                intent.putExtra("site","https://www.abnc.org.br/");
                startActivity(intent);
                finish();
            }
        });
        btn_site_inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatrocinadoresExpositores.this, Site.class);
                intent.putExtra("site","http://site.hospitalinc.com.br/");
                startActivity(intent);
                finish();
            }
        });

        }

        @Override
        public void onBackPressed () {

            Intent intent = new Intent(PatrocinadoresExpositores.this, Menu.class);
            startActivity(intent);
            finish();

        }


    }
