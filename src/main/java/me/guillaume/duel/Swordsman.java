package me.guillaume.duel;

public class Swordsman extends Player{
  public final String VISCOUS_KEY = "Vicious";
  private boolean vicious = false;
  private Integer viscousHits = 2;

  public Swordsman(String vicious) {
    super();
    this.name = "Swordsman";
    setWeapon(Weapon.SWORD);;
    setHitPoints(100);
    if(VISCOUS_KEY.equals(vicious)){
      this.vicious = true;
    }
  }

  public Swordsman() {
    setWeapon(Weapon.SWORD);
    this.name = "Swordsman";
    setHitPoints(100);
  }

  public Swordsman equip(String equipment) {
    return (Swordsman) super.equip(equipment);
  }

  @Override
  public void attack(Player player) {
    if(vicious && viscousHits > 0){
      viscousHits--;
      player.takeDamageWithBonus(this, 20L);
    }else{
      player.takeDamage(this);
    }
  }
}
