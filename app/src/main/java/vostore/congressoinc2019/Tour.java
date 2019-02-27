package vostore.congressoinc2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import vostore.congressoinc2019.Firebase.Experts;
import vostore.congressoinc2019.Firebase.ExpertsNacionais;

public class Tour extends AppCompatActivity {


    private Button btnBuscar;
    private Button expertsNacionais,expertsInternacionais,btnVoltar;
    private LinearLayout linearBuscarPalestrante;
    private EditText buscarPalestrante;
    private Button buscar,btn_site_agencia;
    private RecyclerView mResultList;
    private DatabaseReference reference,reference2;
    RecyclerView recyclerView,recyclerView2;
    final int ITEM_LOAD_COUNT = 21;
    int total_item = 0, last_visible_item;

    Button btn_home,btn_voltar;
    ArrayList<TourClass> list;
    ArrayList<TourClass>list2;
    MyAdapter adapter;
    MyAdapterTour adapter2;
    boolean isLoading = false, isMaxData = false;

    String last_node="",last_key="";
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palestrantes_nacionais);

        btn_home = findViewById(R.id.btn_home);
        btn_voltar = findViewById(R.id.btn_voltar);
        recyclerView2 = (RecyclerView) findViewById(R.id.id_recycler2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        //Fazendo cast dos botões Experts


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Tour.this, Menu.class);
                startActivity(intent);
                finish();

            }
        });
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Tour.this, ProgramaSocial.class);
                startActivity(intent);
                finish();

            }
        });
        reference2 = FirebaseDatabase.getInstance().getReference().child("Tour");
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<TourClass>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    TourClass p = dataSnapshot1.getValue(TourClass.class);
                    list2.add(p);

                }

                adapter2 = new MyAdapterTour(Tour.this, list2);
                recyclerView2.setAdapter(adapter2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Tour.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }


    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Tour.this, Palestrante.class);
        startActivity(intent);
        finish();


    }
}
