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
public class MainEnquete extends AppCompatActivity {


    Button btn_portugues_enquete,btn_ingles_enquete,btn_espanhol_enquete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_enquete);


        btn_portugues_enquete = findViewById(R.id.btn_portugues_enquete);
        btn_ingles_enquete = findViewById(R.id.btn_ingles_enquete);
        btn_espanhol_enquete = findViewById(R.id.btn_espanhol_enquete);



        btn_portugues_enquete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainEnquete.this, EnqueteFormulario.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(MainEnquete.this, Menu.class);
        startActivity(intent);
        finish();


    }


}