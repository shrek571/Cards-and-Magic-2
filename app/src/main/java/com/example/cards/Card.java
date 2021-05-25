package com.example.cards;

public class Card {
    Integer id;
    int cost;
    int dmg;
    int heal;
    int drain;


    public Card(int id, int cost, int dmg, int heal, int drain) {
        this.id = id;
        this.cost = cost;
        this.dmg = dmg;
        this.heal = heal;
        this.drain = drain;
    }

    public String writeCard() {
        String text;
        text = "Стоимость: " + this.cost;
        if (this.dmg != 0) {
            text = text.concat("\nУрон: " + this.dmg);
        }
        if (this.heal != 0) {
            text = text.concat("\nЛечение: " + this.heal);
        }
        if (this.drain != 0) {
            {
                text = text.concat("\nОпустошение: " + this.drain);
            }
        }
        return text;
    }

}
