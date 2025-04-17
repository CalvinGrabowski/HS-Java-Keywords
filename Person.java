
//person
import java.io.Serializable;

public class Person implements Serializable {

   private int age;
   private transient String name; // since it is transient it will be lost if it is converted to bytt and back to
                                  // an object
   private transient int height; // in feet
   protected boolean happiness = true;

   Person(int age) {
      this.age = age;
      name = "bro";
      height = 6;
   }

   Person(int age, String name) { // constructors make the variables set
      this.age = age;
      this.name = name;
      height = 6;
   }

   public int getAge() {
      return age;
   }

   public String getName() { // getters
      return name;
   }

   public int getHeight() {
      return height;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public void setName(String name) { // setters
      this.name = name;
   }

   public void setHeight(int num) {
      height = num;
   }

   public void math() { // I would have used strictfp but as of java release 17 all methods are
                        // evalyated stricly and strictfp is not required

      float a = 1.0f;
      float b = 2.0f;
      float c = a + b;
      System.out.println(c); // this does math with float variables and strictfp is supposed to make the
                             // variable more accurate but it isn't necessary
   }

   public void vote() {
      assert age >= 18 : "You are not old enough to vote.";
      System.out.println("You are old enough to vote.");
   } // this checks to see if the person is of voting ages

   public String toString() {
      return name + " is " + age + " years old and is " + height + " foot tall";
   } // this is what is written if the user tries to print this object
}
