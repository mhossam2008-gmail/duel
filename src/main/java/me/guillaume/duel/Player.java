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
    long hitsToFinishOponent = player.hitPoints/this.weaponHitPoints;
    long hitsToTakeFromOponent = this.hitPoints/player.weaponHitPoints;

    if(hitsToFinishOponent > hitsToTakeFromOponent){
      this.setHitPoints(0);
      //Added 1 hit because of the player who started the engagement
      player.setHitPoints(player.hitPoints - ((hitsToTakeFromOponent+1)*this.weaponHitPoints));
    } else if(hitsToFinishOponent < hitsToTakeFromOponent){
      player.setHitPoints(0);
      this.setHitPoints(this.hitPoints - (hitsToFinishOponent*player.hitPoints));
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
