package me.guillaume.duel;

public class Viking extends Player{

  public Viking(){
    setWeapon(Weapon.AXE);
    setHitPoints(120);
  }

  public Viking equip(String equipment) {
    return (Viking) super.equip(equipment);
  }
}
