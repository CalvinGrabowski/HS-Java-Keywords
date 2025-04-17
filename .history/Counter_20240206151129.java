
public class Counter {

   private volatile int count = 0;              //this makes sure that whenever count is updated it updates it for all threads
   
   public synchronized void increment() {       //because this is synchronized it restricts only one method to call this at a time
      count++;
   }
   public String toString() {
      return "Count: " + count;
   }
}