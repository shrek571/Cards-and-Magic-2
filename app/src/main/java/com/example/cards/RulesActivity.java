package com.example.cards;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        TextView textViewRules = findViewById(R.id.textViewRules);
        String rules = "\tУ каждого игрока есть 4 действия\n" +
                "\tЗа 1 действие игрок может продать карту за её стоимость или сыграть карту за её стоимость\n" +
                "\tТекущая карта, которую можно продать или купить отображена по центру\n" +
                "\tСыграв карту, она нанесёт определённый урон противнику, вылечит определённое кол-во здоровья вам или сделает что-то иное\n" +
                "\tНапример, опустошение высасывает ману из противника\n" +
                "\tПосле 4 действий ходит другой игрок\n" +
                "\tПервый игрок начинает с 18 здоровьем, второй - с 20\n" +
                "\tПервый игрок начинает с 0 маной, как и второй\n" +
                "\tСуществует 4 класса, каждый со своими параметрами и особенностями:\n" +
                "\t - Люди сбалансированы и хороши во всём, хоть и понемногу\n" +
                "\t - Роботы способны эффективно высасывать энергию с помощью своих технологий\n" +
                "\t - Растения получают вдвое больше энергии, но их заклинания слабы\n" +
                "\t - Высшие существа обладают сильными заклинаниями, но получают только 1 ману за каждую продажу";
        textViewRules.setText(rules);

        Button btnToMenuActivity2 = findViewById(R.id.btnToMenuActivity2);
        btnToMenuActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMenuActivity = new Intent(RulesActivity.this, MenuActivity.class);
                startActivity(toMenuActivity);
            }
        });
    }
}