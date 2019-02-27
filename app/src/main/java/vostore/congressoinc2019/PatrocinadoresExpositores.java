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

    private Button btn_site_inc, btn_site_abnc, btn_site_rd, btn_home,btn_voltar;

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patrocinadores_expositores);

        // android.support.v7.app.ActionBar bar = getSupportActionBar();
        // bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF8F00")));


        btn_home =  findViewById(R.id.btn_home);
        btn_voltar =  findViewById(R.id.btn_voltar);


        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              onBackPressed();
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatrocinadoresExpositores.this, Menu.class);
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
