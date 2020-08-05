package com.example.moringaplantation3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonViewHolder> {

      ArrayList<GetterSetter>data;
      Context context;
    public RecyclerViewAdapter(Context context,ArrayList<GetterSetter>data){
        this.context = context;
        this.data = data;
    }


      @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(   ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.card_list_item,viewGroup,false);
          final PersonViewHolder personViewHolder = new PersonViewHolder(view);
          return personViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int i) {
          holder.UC.setText(data.get(i).Getuc());
        holder.VM.setText(data.get(i).GetVillageMohalla());
    }

    @Override
    public int getItemCount() {
       return data.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{
        TextView UC,VM;
    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        UC = itemView.findViewById(R.id.UC);
        VM = itemView.findViewById(R.id.VM);
    }


    }

}
