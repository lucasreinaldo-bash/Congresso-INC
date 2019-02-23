package vostore.congressoinc2019;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * Essa classe é utilizada como tela inicial. Possui uma animação e faz transição após 3 segundos para a MainActivity
 */
public class PDFView4 extends AppCompatActivity {


    com.github.barteksc.pdfviewer.PDFView pdfView;
    ImageView top;
    Animation fromlogo;
    String nomeDocumento;
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pdf_view4);



        pdfView = findViewById(R.id.pdfView);
        btnVoltar = findViewById(R.id.btn_voltar_pdf);

        pdfView.fromAsset("documento4.pdf").load();


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(PDFView4.this, ProgramaCientifico.class);
        startActivity(intent);
        finish();


    }


}