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
public class MapaCongresso extends AppCompatActivity {


    com.github.barteksc.pdfviewer.PDFView pdfView;
    ImageView top;
    Animation fromlogo;
    String nomeDocumento;
    Button btn_home,btn_voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mapa_congresso);



        pdfView = findViewById(R.id.pdfView);
        btn_voltar = findViewById(R.id.btn_voltar);
        btn_home = findViewById(R.id.btn_home);

        pdfView.fromAsset("documento12.pdf").load();


        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(MapaCongresso.this, Menu.class);
        startActivity(intent);
        finish();


    }


}