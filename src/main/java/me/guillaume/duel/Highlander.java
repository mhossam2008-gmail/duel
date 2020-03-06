package me.guillaume.duel;

public class Highlander extends Player{
  public Highlander(String veteran) {
    super();
    setHitPoints(150l);
    setWeapon(Weapon.GREAT_SWORD);
    this.name="Highlander";
  }

  public Highlander() {
    super();
    this.name="Highlander";
    setHitPoints(150l);
    setWeapon(Weapon.GREAT_SWORD);
  }

  public Highlander equip(String equipment){
    return (Highlander) super.equip(equipment);
  }
}
