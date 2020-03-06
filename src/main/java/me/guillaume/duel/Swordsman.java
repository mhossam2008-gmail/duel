package me.guillaume.duel;

public class Swordsman extends Player{

  public Swordsman(String vicious) {
    super();
    setWeapon(Weapon.SWORD);;
    setHitPoints(100);
  }

  public Swordsman() {
    setWeapon(Weapon.SWORD);
    setHitPoints(100);
  }

  public Swordsman equip(String equipment) {
    return (Swordsman) super.equip(equipment);
  }
}
