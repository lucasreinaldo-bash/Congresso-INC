package vostore.congressoinc2019;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


/**
 * Essa classe é utilizada como tela inicial. Possui uma animação e faz transição após 3 segundos para a MainActivity
 */
public class Splash extends AppCompatActivity implements Runnable {


    private Button btnInsta, btnFace,btnLinke;

    ImageView top;
    Animation fromlogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        //fAZENDO cAST
        btnInsta = findViewById(R.id.btn_insta);
        btnFace = findViewById(R.id.btn_face);
        btnLinke = findViewById(R.id.btn_in);
        //Determinando o tempo de 3 segundos para entrar na próxima activity

        Handler handler = new Handler();
        handler.postDelayed(this, 3000);

        //Ações dos buttons

        btnInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, Registro.class));
                finish();
            }
        });
        btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, Registro.class));
                finish();
            }
        });
        btnLinke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, Registro.class));
                finish();
            }
        });
    }



    //Usando intent no método run
    public void run(){
        startActivity(new Intent(this, Registro.class));
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}