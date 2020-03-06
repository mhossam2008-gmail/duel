package me.guillaume.duel;

public class Highlander extends Player{
  private boolean isVeteran = false;
  public Highlander(String veteran) {
    super();
    setHitPoints(150l);
    setWeapon(Weapon.GREAT_SWORD);
    this.name="Highlander";
    if(veteran.equals("Veteran")){
      isVeteran = true;
    }
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

  @Override
  public void attack(Player player) {
    if(isVeteran && (hitPoints()/150.0) < (30.0/100)){
      player.takeDamageWithBonus(this, getWeapon().getHitpoints());
    }else{
      player.takeDamage(this);
    }

  }
}