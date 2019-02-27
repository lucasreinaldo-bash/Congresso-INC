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
import vostore.congressoinc2019.Firebase.Passeio;

public class MyAdapterPasseio extends RecyclerView.Adapter<MyAdapterPasseio.MyViewHolder> {

    Context context;
    ArrayList<Passeio> Experts;

    public MyAdapterPasseio(Context c , ArrayList<Passeio> p)
    {
        context = c;
        Experts = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.lista_passeio,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(Experts.get(position).getNome());
        holder.endereco.setText(Experts.get(position).getEndereco());
        holder.telefone.setText(Experts.get(position).getTelefone());
        Picasso.get().load(Experts.get(position).getImage()).into(holder.profilePic);


    }

    @Override
    public int getItemCount() {
        return Experts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,endereco,telefone;
        AvatarImageView profilePic;
        Button btn;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.profile_nome);
            endereco = (TextView) itemView.findViewById(R.id.profile_pais);
            telefone = (TextView) itemView.findViewById(R.id.profile_telefone);
            profilePic =(AvatarImageView) itemView.findViewById(R.id.profile_image);
           // btn = (Button) itemView.findViewById(R.id.checkDetails);
        }

        }
    }

