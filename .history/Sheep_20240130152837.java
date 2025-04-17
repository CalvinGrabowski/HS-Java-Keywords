//enum class

public enum Sheep {
   JOB(3,"black",true), LILY(2,"white",false), PLUM(1,"purple",true);      //basic preset sheep
   
   private int speed;
   private String color;
   private boolean happy;
   
   private Sheep(int speed, String color, boolean happy) {     //this is privated so only preset sheep can use. No creating your own sheep
      this.speed = speed;
      this.color = color;                                       //constructs a sheep
      this.happy = happy;
   }
   
   public int getSpeed() {
      return this.speed;
   }
   public String getColor() {                                  //gets the specific variables
      return color;
   }
   public boolean getHappiness() {
      return happy;
   }
}