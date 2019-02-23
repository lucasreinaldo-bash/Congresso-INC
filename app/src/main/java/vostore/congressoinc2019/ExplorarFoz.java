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
import vostore.congressoinc2019.Firebase.Passeio;

public class ExplorarFoz extends AppCompatActivity {


    private Button btnBuscar;
    private Button expertsNacionais,expertsInternacionais,btnVoltar;
    private LinearLayout linearBuscarPalestrante;
    private EditText buscarPalestrante;
    private Button buscar;
    private RecyclerView mResultList;
    private DatabaseReference reference;
    RecyclerView recyclerView;
    final int ITEM_LOAD_COUNT = 21;
    int total_item = 0, last_visible_item;

    ArrayList<ExpertsNacionais> list;
    ArrayList<ExpertsNacionais>list2;
    MyAdapterNacionais adapter;
    MyAdapterNacionais adapter2;
    boolean isLoading = false, isMaxData = false;

    String last_node="",last_key="";
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_foz);

        recyclerView = (RecyclerView) findViewById(R.id.id_recycler3);

        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        //Fazendo cast dos botões Experts

        btnVoltar = findViewById(R.id.btn_voltar_mapa_congresso);







        reference = FirebaseDatabase.getInstance().getReference().child("Passeio");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<ExpertsNacionais>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    ExpertsNacionais p = dataSnapshot1.getValue(ExpertsNacionais.class);
                    list.add(p);
                }
                adapter = new MyAdapterNacionais(ExplorarFoz.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ExplorarFoz.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });



        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            onBackPressed();
            }
        });
    }


    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ExplorarFoz.this, Menu.class);
        startActivity(intent);
        finish();


    }
}
