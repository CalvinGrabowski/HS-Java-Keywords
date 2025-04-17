//Java Keywords

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class KeyWords {           //strictfp would slow down the run time for a more accurate calculator but now it is automatically done by java

   public static void main(String[] args) throws Exception {
   
      Scanner sc = new Scanner(System.in);
      
      Person personA = new Person(23);          //old enough to vote so it doesn't throw an assertion error
      Person personB = new Person(11);          //not old enough to vote so it throws an assertion error
      Person personC = personA;
      Person personD = personB;
       
      personA.vote();                           //I can only assert someone that is old enough to vote otherwise the code will end
      
      Sheep sheep = Sheep.JOB;
     
      System.out.println(sheep.getColor());     //grabs out of a enum class out of a set path
      
      personA.math();                           //would use strictfp but it automatically does that now of java 17
      
      personA.setName("john");
         
      System.out.println(personA.getName());
         
      
      try {
         
         FileOutputStream fs = new FileOutputStream("people.stuff");
         ObjectOutputStream os = new ObjectOutputStream(fs);
         
         os.writeObject(personA);
         os.writeObject(personB);
         
         os.close();
         fs.close();
      }
      catch(Exception e) {
         System.out.println(e);
      }
      finally {                  //finally keyword jumps in afterwards even if an exception occures
         System.out.println("jumping in to clean up");
      }
      System.out.println("it still runs");
      
      try(FileInputStream fi = new FileInputStream("people.stuff")) {
         ObjectInputStream os = new ObjectInputStream(fi);
         personC = (Person)os.readObject();
         personD = (Person)os.readObject();                   //sterializes the people
         os.close();
         
      }
      catch(FileNotFoundException e) {
         e.printStackTrace();
      }
      catch(IOException e) {
         e.printStackTrace();                               //stops the code from breaking
      }
      catch(ClassNotFoundException e) {
         e.printStackTrace();
      }
      
      
      System.out.println(personA);
      System.out.println(personC);                          //even though a and c are the same and b and d are the same 
      System.out.println(personB);                          //because the name and the height are transient they are reset to null and zero depending if they are a string or a int
      System.out.println(personD);
     
      System.out.println("Counter method:");
      
      Counter c = new Counter();
      
      Thread t1 = new Thread(
         new Runnable() {
         
            public void run() {
               for(int i = 0; i < 10000; i++) {
                  c.increment();
               }
            }
                                                //runs multiple threads to run more cpu
         });
      Thread t2 = new Thread(
         new Runnable() {
         
            public void run() {
               for(int i = 0; i < 10000; i++) {
                  c.increment();                //since increment is synchronized it can't run 
               }
            }
            
         });
         
      t1.start();
      t2.start();                               //this starts the counting of two 
      
      t1.join();
      t2.join();
      System.out.println(c);
      
      personB.vote();                           //this makes the assert run and fail on purpose
   }
   
  
}