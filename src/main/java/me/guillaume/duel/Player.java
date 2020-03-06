package me.guillaume.duel;

import java.util.HashMap;

public class Player {
  private static final Integer DEFAULT_BUCKLER_COUNT = 6;
  private long hitPoints;
  private HashMap<String, Integer> equipments = null;
  private final String BUCKLER_KEY = "buckler";
  private boolean bucklerUsedLastHit ;
  public long hitPoints() {
    return hitPoints;
  }
  private Weapon weapon;
  public void setHitPoints(long hitPoints) {
    this.hitPoints = hitPoints;
  }

  public void engage(Player player) {
    while(this.hitPoints > 0 && player.hitPoints>0){
      boolean playerHasBuckler = player.useBuckler(this.weapon);
      if(!playerHasBuckler){
        long playerHitpoints = player.hitPoints - this.weapon.getHitpoints();
        if(playerHitpoints <= 0){
          player.hitPoints = 0;
          break;
        }
        player.hitPoints = playerHitpoints;
      }

      boolean hasBuckler = useBuckler(player.weapon);
      if(!hasBuckler) {
        long currentHitPoints = this.hitPoints - player.weapon.getHitpoints();
        if(currentHitPoints <= 0){
          this.hitPoints = 0;
          break;
        }
        this.hitPoints = currentHitPoints;
      }


    }
  }

  private boolean useBuckler(Weapon weapon) {
    if(equipments!=null && equipments.get(BUCKLER_KEY)!=null && equipments.get(BUCKLER_KEY)> 0){
      if(weapon.equals(Weapon.AXE)) {
        equipments.put(BUCKLER_KEY, equipments.get(BUCKLER_KEY) - 1);
      }
      if(bucklerUsedLastHit){
        bucklerUsedLastHit = false;
        return false;
      }
      bucklerUsedLastHit = true;
      return true;
    }
    return false;
  }

  protected Player equip(String equipment) {
    if(equipments==null){
      equipments = new HashMap<String, Integer>();
      equipments.put(BUCKLER_KEY,DEFAULT_BUCKLER_COUNT);
    }
    return this;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }
}
