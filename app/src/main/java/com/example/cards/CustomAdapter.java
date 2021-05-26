package com.example.cards;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    public static ArrayList<SavedGame> gamesList = new ArrayList<>();
    private Context context;
    static String versus = "";

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_savedgames_structure, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.getTextView().setText(gamesList.get(position).dateAndTimeS);

        switch (gamesList.get(position).p1classS) {
            case "1":
                versus = versus.concat("Люди VS ");
                break;
            case "2":
                versus = versus.concat("Роботы VS ");
                break;
            case "3":
                versus = versus.concat("Растения VS ");
                break;
            case "4":
                versus = versus.concat("Высшие существа VS ");
                break;
        }
        switch (gamesList.get(position).p2classS) {
            case "1":
                versus = versus.concat("Люди");
                break;
            case "2":
                versus = versus.concat("Роботы");
                break;
            case "3":
                versus = versus.concat("Растения");
                break;
            case "4":
                versus = versus.concat("Высшие существа");
                break;
        }
        holder.getTextViewVS().setText(versus);
        versus = "";

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SavedGame loadGame;
                loadGame = gamesList.get(position);
                System.out.println(loadGame.dateAndTimeS);
                Intent loadGameIntent = new Intent(view.getContext(), GameActivity.class);

                loadGameIntent.putExtra("player", loadGame.playerS);//
                loadGameIntent.putExtra("turns", loadGame.turnsS);//
                loadGameIntent.putExtra("currentCard", loadGame.currentCardS);
                loadGameIntent.putExtra("p1class", loadGame.p1classS);
                loadGameIntent.putExtra("p2class", loadGame.p2classS);
                loadGameIntent.putExtra("yourHp", loadGame.yourHpS);//
                loadGameIntent.putExtra("enemyHp", loadGame.enemyHpS);//
                loadGameIntent.putExtra("yourMana", loadGame.yourManaS);//
                loadGameIntent.putExtra("enemyMana", loadGame.enemyManaS);//
                loadGameIntent.putExtra("dateAndTime", loadGame.dateAndTimeS);//-----

                String act = "Co";
                loadGameIntent.putExtra("act", act);

                view.getContext().startActivity(loadGameIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView dateAndTime;
        public final TextView classVsClass;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateAndTime = (TextView) itemView.findViewById(R.id.dateAndTime);
            classVsClass = (TextView) itemView.findViewById(R.id.classVsClass);
        }

        public TextView getTextView() {
            return dateAndTime;
        }

        public TextView getTextViewVS() {
            return classVsClass;
        }
    }
}