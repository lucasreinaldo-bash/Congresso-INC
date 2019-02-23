package vostore.congressoinc2019;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.zxing.MultiFormatWriter;

import java.io.File;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.asset.CopyAsset;
import es.voghdev.pdfviewpager.library.asset.CopyAssetThreadImpl;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

public class ProgramaCientifico extends AppCompatActivity  {

    private ImageView qrCode;
    private    String tipoDoUsuario;
    private    String nomeUsuario;
    private   String emailUsuario;
    private   String informacoesParaQr;
    private LinearLayout linear28,linear27,linearTrabalho;
    private Button btnDia29,btnDia30,btnDia27,btnDia27_1,btnDia27_2,btnDia27_3,btnDia27_4,btnDia27_5,btnDia27_6,btnDia28,btnJoin,btnEncontro,btnTrabalhos,btn_trabalhos_1,btn_trabalhos_2,btn_trabalhos_3,btn_trabalhos_4,btn_trabalhos_5,btn_trabalhos_6;
    private PDFViewPager pdfViewPager;
    private RemotePDFViewPager remotePDFViewPager;
    PDFView pdfView;
    BasePDFPagerAdapter adapter;

    MultiFormatWriter multi = new MultiFormatWriter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa_cientifico);

        btnDia27 = findViewById(R.id.button_dia27);
        btnDia27_1 = findViewById(R.id.btn_dia27_1);
        btnDia27_2 = findViewById(R.id.btn_dia27_2);
        btnDia27_3 = findViewById(R.id.btn_dia27_3);
        btnDia27_4 = findViewById(R.id.btn_dia27_4);
        btnDia27_5 = findViewById(R.id.btn_dia27_5);
        btnDia27_6 = findViewById(R.id.btn_dia27_6);
        btnDia28 = findViewById(R.id.button_dia28);
        btnDia29 = findViewById(R.id.button_dia29);
        btnDia30 = findViewById(R.id.button_dia30);
        btn_trabalhos_1 = findViewById(R.id.btn_trabalhos_1);
        btn_trabalhos_2 = findViewById(R.id.btn_trabalhos_2);
        btn_trabalhos_3 = findViewById(R.id.btn_trabalhos_3);
        btn_trabalhos_4 = findViewById(R.id.btn_trabalhos_4);
        btn_trabalhos_5 = findViewById(R.id.btn_trabalhos_5);
        btnJoin = findViewById(R.id.button_join);
        btnTrabalhos = findViewById(R.id.button_trabalhos);
        linear28 = findViewById(R.id.linear_dia28);
        linear27 = findViewById(R.id.linear_dia27);
        linearTrabalho = findViewById(R.id.linear_trabalhos);
        btnEncontro = findViewById(R.id.button_encontro);


        linear28.setVisibility(View.GONE);
        linear27.setVisibility(View.GONE);

        //PDF 1
        pdfView = findViewById(R.id.pdfView);





        btnTrabalhos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linearTrabalho.getVisibility() == View.GONE){
                    linearTrabalho.setVisibility(View.VISIBLE);
                }
                else
                    linearTrabalho.setVisibility(View.GONE);
            }
        });
        btnDia28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linear28.getVisibility() == View.GONE){
                    linear28.setVisibility(View.VISIBLE);
                }
                else
                    linear28.setVisibility(View.GONE);
            }
        });
        btnDia27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linear27.getVisibility() == View.GONE){
                    linear27.setVisibility(View.VISIBLE);
                }
                else
                    linear27.setVisibility(View.GONE);
            }
        });
        btnDia27_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView.class);
                intent.putExtra("nomeDocumento","documento1.pdf");
               startActivity(intent);
            }
        });
        btnDia27_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView2.class);
                intent.putExtra("nomeDocumento","documento2.pdf");
               startActivity(intent);
            }
        });
        btnDia27_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView3.class);
                intent.putExtra("nomeDocumento","documento3.pdf");
               startActivity(intent);
            }
        });
        btnDia27_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView4.class);
                intent.putExtra("nomeDocumento","documento4.pdf");
               startActivity(intent);
            }
        });
        btnDia27_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView5.class);
                intent.putExtra("nomeDocumento","documento5.pdf");
               startActivity(intent);
            }
        });
        btnDia27_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView6.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
               startActivity(intent);
            }
        });
        btn_trabalhos_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView7.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
               startActivity(intent);
            }
        });
        btn_trabalhos_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView8.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
               startActivity(intent);
            }
        });
        btn_trabalhos_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView9.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
               startActivity(intent);
            }
        });
        btn_trabalhos_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView10.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
               startActivity(intent);
            }
        });
        btn_trabalhos_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProgramaCientifico.this, vostore.congressoinc2019.PDFView11.class);
                intent.putExtra("nomeDocumento","documento6.pdf");
               startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ProgramaCientifico.this, Menu.class);
        startActivity(intent);
        finish();


    }



}
