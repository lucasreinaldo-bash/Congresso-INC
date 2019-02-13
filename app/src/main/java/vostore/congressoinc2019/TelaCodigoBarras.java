package vostore.congressoinc2019;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


/**
 * Essa classe é utilizada como tela inicial. Possui uma animação e faz transição após 3 segundos para a MainActivity
 */
public class TelaCodigoBarras extends AppCompatActivity {



    ImageView top;
    Animation fromlogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);



    }


}