package me.guillaume.duel;

public enum Weapon {
  AXE("AXE", 6L, 1, -1),
  SWORD("SWORD", 5L, 1, -1),
  GREAT_SWORD("GREAT_SWORD", 12L, 2, 1);

  private String weapon;
  private Long hitpoints;
  private Integer consecutiveHits;
  private Integer hitsToSkip;

  Weapon(String weapon, Long hitpoints, Integer consecutiveHits, Integer hitsToSkip){
    this.weapon = weapon;
    this.hitpoints = hitpoints;
    this.consecutiveHits = consecutiveHits;
    this.hitsToSkip = hitsToSkip;
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

  public Integer getConsecutiveHits() {
    return consecutiveHits;
  }

  public void setConsecutiveHits(Integer consecutiveHits) {
    this.consecutiveHits = consecutiveHits;
  }

  public Integer getHitsToSkip() {
    return hitsToSkip;
  }

  public void setHitsToSkip(Integer hitsToSkip) {
    this.hitsToSkip = hitsToSkip;
  }
}
