package vostore.congressoinc2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.zxing.MultiFormatWriter;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;

public class TelaTrabalhos extends AppCompatActivity  {

    private ImageView qrCode;
    private    String tipoDoUsuario;
    private    String nomeUsuario;
    private   String emailUsuario;
    private   String informacoesParaQr;
    private LinearLayout linear28,linear27,linearTrabalho;
    private Button btnDia27_3,btnDia27_4,btn_home,btn_voltar,btnDia27_5,btnDia27_6,btnDia28,btnJoin,btnEncontro,btnTrabalhos,btn_trabalhos_1,btn_trabalhos_2,btn_trabalhos_3,btn_trabalhos_4,btn_trabalhos_5,btn_trabalhos_6;
    private PDFViewPager pdfViewPager;
    private RemotePDFViewPager remotePDFViewPager;
    PDFView pdfView;
    BasePDFPagerAdapter adapter;

    MultiFormatWriter multi = new MultiFormatWriter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa_cientifico_trabalhos);

        btn_trabalhos_1 = findViewById(R.id.btn_trabalhos_1);
        btn_trabalhos_2 = findViewById(R.id.btn_trabalhos_2);
        btn_trabalhos_3 = findViewById(R.id.btn_trabalhos_3);
        btn_trabalhos_4 = findViewById(R.id.btn_trabalhos_4);
        btn_trabalhos_5 = findViewById(R.id.btn_trabalhos_5);
        btn_home = findViewById(R.id.btn_home);
        btn_voltar = findViewById(R.id.btn_voltar);
        //PDF 1
        pdfView = findViewById(R.id.pdfView);




        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });  btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TelaTrabalhos.this, Menu.class);
                startActivity(intent);
                finish();

            }
        });

        btn_trabalhos_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaTrabalhos.this, vostore.congressoinc2019.PDFView7.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
                startActivity(intent);
            }
        });
        btn_trabalhos_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaTrabalhos.this, vostore.congressoinc2019.PDFView8.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
                startActivity(intent);
            }
        });
        btn_trabalhos_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaTrabalhos.this, vostore.congressoinc2019.PDFView9.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
                startActivity(intent);
            }
        });
        btn_trabalhos_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaTrabalhos.this, vostore.congressoinc2019.PDFView10.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
                startActivity(intent);
            }
        });
        btn_trabalhos_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaTrabalhos.this, vostore.congressoinc2019.PDFView11.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(TelaTrabalhos.this, ProgramaCientifico.class);
        startActivity(intent);
        finish();


    }



}
