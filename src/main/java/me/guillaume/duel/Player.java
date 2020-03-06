package me.guillaume.duel;

import java.util.HashMap;

public class Player {
  private long hitPoints;
  private long weaponHitPoints;
  private HashMap<String, Integer> equipments = null;
  private final String BUCKLER_KEY = "buckler";

  public long hitPoints() {
    return hitPoints;
  }

  public void setHitPoints(long hitPoints) {
    this.hitPoints = hitPoints;
  }

  public void engage(Player player) {
    while(this.hitPoints > 0 && player.hitPoints>0){
      long playerHitpoints = player.hitPoints - this.weaponHitPoints;
      if(playerHitpoints <= 0){
        player.hitPoints = 0;
        break;
      }
      player.hitPoints = playerHitpoints;

      long currentHitPoints = this.hitPoints - player.weaponHitPoints;
      if(currentHitPoints <= 0){
        this.hitPoints = 0;
        break;
      }
      this.hitPoints = currentHitPoints;

    }
  }

  protected Player equip(String equipment) {
    if(equipments==null){
      equipments = new HashMap<String, Integer>();
      equipments.put("buckler",0);
    }
    switch (equipment){
      case BUCKLER_KEY :
        equipments.put(BUCKLER_KEY, equipments.get(BUCKLER_KEY)+3);
        break;
      case "" :
        break;
    }
    return this;
  }

  public long getWeaponHitPoints() {
    return weaponHitPoints;
  }

  public void setWeaponHitPoints(long weaponHitPoints) {
    this.weaponHitPoints = weaponHitPoints;
  }
}
