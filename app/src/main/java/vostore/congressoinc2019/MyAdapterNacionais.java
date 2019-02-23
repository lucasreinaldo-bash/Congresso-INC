package vostore.congressoinc2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.abdularis.civ.AvatarImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vostore.congressoinc2019.Firebase.Experts;
import vostore.congressoinc2019.Firebase.ExpertsNacionais;

public class MyAdapterNacionais extends RecyclerView.Adapter<MyAdapterNacionais.MyViewHolder> {

    Context context;
    ArrayList<ExpertsNacionais> Experts;

    public MyAdapterNacionais(Context c , ArrayList<ExpertsNacionais> p)
    {
        context = c;
        Experts = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.lista_palestrante_internacional,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(Experts.get(position).getNome());
        holder.nacionalidade.setText(Experts.get(position).getNacionalidade());
        Picasso.get().load(Experts.get(position).getImage()).into(holder.profilePic);


    }

    @Override
    public int getItemCount() {
        return Experts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,nacionalidade;
        AvatarImageView profilePic;
        Button btn;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.profile_nome);
            nacionalidade = (TextView) itemView.findViewById(R.id.profile_pais);
            profilePic =(AvatarImageView) itemView.findViewById(R.id.profile_image);
           // btn = (Button) itemView.findViewById(R.id.checkDetails);
        }

        }
    }

