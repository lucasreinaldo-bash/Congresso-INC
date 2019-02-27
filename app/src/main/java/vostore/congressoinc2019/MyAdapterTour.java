package vostore.congressoinc2019;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vostore.congressoinc2019.Firebase.Experts;

public class MyAdapterTour extends RecyclerView.Adapter<MyAdapterTour.MyViewHolder> {

    Context context;
    ArrayList<TourClass> Experts;

    public MyAdapterTour(Context c , ArrayList<TourClass> p)
    {
        context = c;
        Experts = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.lista_programa_social,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nome.setText(Experts.get(position).getNome());
        holder.data.setText(Experts.get(position).getData());
        holder.valor.setText(Experts.get(position).getValor());
        Picasso.get().load(Experts.get(position).getImage()).into(holder.profilePic);


    }

    @Override
    public int getItemCount() {
        return Experts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView nome,valor,data;
        ImageView profilePic;
        Button btn;
        public MyViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.profile_nome);
            data = (TextView) itemView.findViewById(R.id.profile_data);
            valor = (TextView) itemView.findViewById(R.id.profile_rs);
            profilePic = itemView.findViewById(R.id.profile_image);



        }

        }
    }

