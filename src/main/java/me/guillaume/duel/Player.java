package me.guillaume.duel;

import java.util.HashMap;

public abstract class Player {
  public String name = "";
  private static final Integer DEFAULT_BUCKLER_COUNT = 3;
  private long hitPoints;
  private HashMap<String, Integer> equipments = null;
  private final String BUCKLER_KEY = "buckler";
  private final String ARMOR_KEY = "armor";
  private boolean bucklerUsedLastHit ;
  private int consecutiveHits = 0 ;
  private int restingHits = 0;
  public long hitPoints() {
    return hitPoints;
  }
  private Weapon weapon;
  public void setHitPoints(long hitPoints) {
    this.hitPoints = hitPoints;
  }

  public void engage(Player player) {
    while(this.hitPoints > 0 && player.hitPoints > 0){
      boolean playerHasBuckler = player.useBuckler(this.weapon);
      if(!playerHasBuckler){
        this.attack(player);
        if(player.hitPoints <= 0){
          player.hitPoints = 0;
          break;
        }
      }
      boolean hasBuckler = useBuckler(player.weapon);
      if(!hasBuckler) {
        player.attack(this);
        if(this.hitPoints <= 0){
          this.hitPoints = 0;
          break;
        }
      }
    }
  }


  private boolean useBuckler(Weapon weapon) {
    if(equipments!=null && equipments.get(BUCKLER_KEY)!=null && equipments.get(BUCKLER_KEY) > 0){
      if(bucklerUsedLastHit){
        bucklerUsedLastHit = false;
        return false;
      }
      if(weapon.equals(Weapon.AXE)) {
        equipments.put(BUCKLER_KEY, equipments.get(BUCKLER_KEY) - 1);
      }
//      System.out.println(name+" has used buckler");
      bucklerUsedLastHit = true;
      return true;
    }
    return false;
  }

  protected Player equip(String equipment) {
    if(equipments==null){
      equipments = new HashMap();
      equipments.put(BUCKLER_KEY,0);
      equipments.put(ARMOR_KEY , 0);
    }
    switch (equipment){
      case BUCKLER_KEY :
        equipments.put(BUCKLER_KEY, equipments.get(BUCKLER_KEY)+DEFAULT_BUCKLER_COUNT);
        break;
      case ARMOR_KEY :
        equipments.put(ARMOR_KEY, 1);
        break;
      case "axe":
        weapon = Weapon.AXE;
        break;
      case "sword":
        weapon = Weapon.SWORD;
        break;
      case "great sword":
        weapon = Weapon.GREAT_SWORD;
        break;
    }
    return this;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public void takeDamage(Player player){
    if(player.shouldHit()){
      int refundedPoints = 0;
      if(isArmored()){
        refundedPoints += 3;
//        System.out.println("Armor added three points");
      }
      if(player.isArmored()){
        refundedPoints+=1;
//        System.out.println("Armor reduced damage by 1 point");
      }
      this.hitPoints = this.hitPoints - player.weapon.getHitpoints() + refundedPoints;
//      System.out.println(name+" has recieved "+(player.weapon.getHitpoints() - refundedPoints)+" damage , hitpoints now :"+this.hitPoints);
    }
  }

  private boolean isArmored() {
    return equipments!=null && equipments.get(ARMOR_KEY) > 0;
  }

  public void takeDamageWithBonus(Player player , Long bonus){
    if(player.shouldHit()){
      int refundedPoints = 0;
      if(isArmored()){
        refundedPoints += 3;
      }
      if(player.isArmored()){
        refundedPoints+=1;
      }
      this.hitPoints = this.hitPoints - player.weapon.getHitpoints() + refundedPoints;
      this.hitPoints = this.hitPoints - bonus;
    }
  }

  private boolean shouldHit(){
    if(weapon.getHitsToSkip()<0) {
      return true;
    }
    if(consecutiveHits < weapon.getConsecutiveHits()){
      consecutiveHits++;
      return true;
    }else if(restingHits < weapon.getHitsToSkip()){
      restingHits++;
      return false;
    }else{
      consecutiveHits = 1;
      restingHits = 0 ;
      return true;
    }
  }

  public abstract void attack(Player player);
}
