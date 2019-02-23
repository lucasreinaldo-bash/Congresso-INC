package vostore.congressoinc2019;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;


/**
 * Essa classe é utilizada como tela inicial. Possui uma animação e faz transição após 3 segundos para a MainActivity
 */
public class ProgramaSocial extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_programa_social);



    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ProgramaSocial.this, Menu.class);
        startActivity(intent);
        finish();


    }


}