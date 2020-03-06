package me.guillaume.duel;

public class Swordsman extends Player{

  public Swordsman(String vicious) {
    super();
    setWeaponHitPoints(5);
    setHitPoints(100);
  }

  public Swordsman() {
    setWeaponHitPoints(5);
    setHitPoints(100);
  }

  public Swordsman equip(String equipment) {
    return (Swordsman) super.equip(equipment);
  }
}
