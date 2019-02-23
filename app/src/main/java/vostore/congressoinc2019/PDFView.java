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
public class PDFView extends AppCompatActivity {


    com.github.barteksc.pdfviewer.PDFView pdfView;
    ImageView top;
    Animation fromlogo;
    String nomeDocumento;
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pdf_view);



        pdfView = findViewById(R.id.pdfView);
        btnVoltar = findViewById(R.id.btn_voltar_pdf);

        pdfView.fromAsset("documento1.pdf").load();


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(PDFView.this, ProgramaCientifico.class);
        startActivity(intent);
        finish();


    }


}