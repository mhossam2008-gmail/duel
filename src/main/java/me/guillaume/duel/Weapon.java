package me.guillaume.duel;

public enum Weapon {
  AXE("AXE", 6L),
  SWORD("SWORD", 5L);

  private String weapon;
  private Long hitpoints;
  Weapon(String weapon, Long hitpoints){
    this.weapon = weapon;
    this.hitpoints = hitpoints;
  }
  public String getWeapon() {
    return weapon;
  }

  public void setWeapon(String weapon) {
    this.weapon = weapon;
  }

  public Long getHitpoints() {
    return hitpoints;
  }

  public void setHitpoints(Long hitpoints) {
    this.hitpoints = hitpoints;
  }

  public boolean equals(Weapon weapon){
    return this.weapon.equals(weapon.weapon);
  }
}
