package vostore.congressoinc2019;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Essa classe é utilizada como tela inicial. Possui uma animação e faz transição após 3 segundos para a MainActivity
 */
public class ProgramaSocial extends AppCompatActivity {


    Button btn_home,btn_voltar,btn_tours;
    CardView card_dia30;
    LinearLayout card_dia27;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_programa_social);

        btn_home = findViewById(R.id.btn_home);
        btn_voltar = findViewById(R.id.btn_voltar);
        card_dia30 = findViewById(R.id.card_dia30);
        card_dia27 = findViewById(R.id.card_dia27);
        btn_tours = findViewById(R.id.btn_tours);


        btn_tours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramaSocial.this, Tour.class);
                startActivity(intent);
                finish();
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        card_dia30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramaSocial.this, Site.class);
                intent.putExtra("site","https://nw7travel.com.br/28Abnc.php");
                startActivity(intent);
                finish();
            }
        });
        card_dia27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramaSocial.this, Site.class);
                intent.putExtra("site","https://nw7travel.com.br/28Abnc.php");
                startActivity(intent);
                finish();
            }
        });
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ProgramaSocial.this, Menu.class);
        startActivity(intent);
        finish();


    }


}