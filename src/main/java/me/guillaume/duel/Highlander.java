package me.guillaume.duel;

public class Highlander extends Player{
  public Highlander(String veteran) {
  }

  public Highlander() {

  }

  public Highlander equip(String equipment){
    return (Highlander) super.equip(equipment);
  }
}
