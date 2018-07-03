package com.example.dell.webservices.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.webservices.R;
import com.example.dell.webservices.model.DataHandler;

import java.util.List;
import java.util.RandomAccess;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {


    Context context;
    List<DataHandler> data;
    ClickListener clickListener;

    public DataAdapter(Context context, List<DataHandler> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row,null);

        ViewHolder viewHolder = new ViewHolder(v);



        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText("Actor : "+data.get(position).getName());

        holder.character.setText("Character played : "+data.get(position).getCharacter());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(clickListener !=null){
                    clickListener.itemClicked(v,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name,character;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);

            character = (TextView)itemView.findViewById(R.id.character);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.rlayout);

        }
    }

    public interface ClickListener{
        void itemClicked(View v,int position);

    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
}