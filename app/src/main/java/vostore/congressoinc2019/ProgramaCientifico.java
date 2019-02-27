package vostore.congressoinc2019;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.MultiFormatWriter;

import java.io.File;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.asset.CopyAsset;
import es.voghdev.pdfviewpager.library.asset.CopyAssetThreadImpl;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import vostore.congressoinc2019.Firebase.ConfiguracaoFirebase;
import vostore.congressoinc2019.Firebase.Experts;

public class ProgramaCientifico extends AppCompatActivity  {

    private ImageView qrCode;
    private    String tipoDoUsuario;
    private    String nomeUsuario;
    private   String emailUsuario;
    private   String informacoesParaQr;
    private LinearLayout linear28,linear27,linearTrabalho;
    private Button btnDia29,btnDia30,btn_home,btn_voltar,btnDia27,btn_simposio,btnDia27_1,btnDia27_2,btnDia27_3,btnDia27_4,btnDia27_5,btnDia27_6,btnDia28,btnJoin,btnEncontro,btnTrabalhos,btn_trabalhos_1,btn_trabalhos_2,btn_trabalhos_3,btn_trabalhos_4,btn_trabalhos_5,btn_trabalhos_6;
    private PDFViewPager pdfViewPager;
    private RemotePDFViewPager remotePDFViewPager;
    PDFView pdfView;
    BasePDFPagerAdapter adapter;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private String dia28,dia29,dia30,diaJoin,diaEncontro,diaSimposio;
    MultiFormatWriter multi = new MultiFormatWriter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa_cientifico);
        //Firebase
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        databaseReference = database.getReference("PDF");

       // isAccountValid();
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
        btn_simposio = findViewById(R.id.btn_simposio);
        btn_home = findViewById(R.id.btn_home);
        btn_voltar= findViewById(R.id.btn_voltar);


        linear28.setVisibility(View.GONE);
        linear27.setVisibility(View.GONE);

        //PDF 1
        pdfView = findViewById(R.id.pdfView);




       // Toast.makeText(this, diaEncontro + ""+ dia28, Toast.LENGTH_SHORT).show();

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ProgramaCientifico.this, Menu.class);
                        startActivity(intent);
            }
        });
        btn_simposio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ProgramaCientifico.this, "O PDF ainda está indisponível", Toast.LENGTH_SHORT).show();
            }
        });
        btnTrabalhos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ProgramaCientifico.this, "O PDF ainda está indisponível", Toast.LENGTH_SHORT).show();
            }
        });btnJoin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ProgramaCientifico.this, "O PDF ainda está indisponível", Toast.LENGTH_SHORT).show();
            }
        });
        btnEncontro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ProgramaCientifico.this, "O PDF ainda está indisponível", Toast.LENGTH_SHORT).show();
            }
        });
        btnDia28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProgramaCientifico.this, "O PDF ainda está indisponível", Toast.LENGTH_SHORT).show();
            }
        }); btnDia29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProgramaCientifico.this, "O PDF ainda está indisponível", Toast.LENGTH_SHORT).show();
            }
        });btnDia30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProgramaCientifico.this, "O PDF ainda está indisponível", Toast.LENGTH_SHORT).show();
            }
        });
        btnDia27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramaCientifico.this, Tela27.class);
                intent.putExtra("nomeDocumento","documento1.pdf");
                startActivity(intent);
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



    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ProgramaCientifico.this, Menu.class);
        startActivity(intent);
        finish();


    }
    private void isAccountValid() {

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                     RecuperarPDF p = dataSnapshot.getValue(RecuperarPDF.class);
                     dia28 = p.getDia28();
                     dia29 = p.getDia29();
                     dia30 = p.getDia30();
                     diaJoin = p.getDiaJoin();
                     diaEncontro = p.getDiaEncontro();
                     diaSimposio = p.getDiaSimposio();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }



}
