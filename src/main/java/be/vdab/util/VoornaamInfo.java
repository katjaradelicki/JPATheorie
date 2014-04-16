package be.vdab.util;



public class VoornaamInfo {
  private final String voornaam;
  private final long aantal;
  public VoornaamInfo(String voornaam, long aantal) {
    this.voornaam = voornaam;
    this.aantal = aantal;
  }
  // je maakt zelf getters voor deze variabelen, geen setters
  @Override
  public String toString() {
    return voornaam + ":" + aantal;
  }
} 
