import java.util.*;
import java.io.*;

public class PowerBallStats{
   public static void main(String[] args) throws FileNotFoundException{
      double totaldrawings = 0.0;
      double totalpairs = 0.0;
      int abovefifty = 0;
      File f = new File("winnums.txt");
      Scanner numbers = new Scanner(f);
      TreeMap<Integer,Integer> wb = new TreeMap<Integer,Integer>();
      TreeMap<Integer,Integer> pb = new TreeMap<Integer,Integer>();
      ArrayList<Integer> maxwb = new ArrayList<Integer>();
      ArrayList<Integer> maxpb = new ArrayList<Integer>();
      TreeMap<Integer, Integer> pair = new TreeMap<Integer, Integer>();
      ArrayList<Integer> pairs = new ArrayList<Integer>();
      ArrayList<Integer> maxpair = new ArrayList<Integer>();
      for(int x = 1;x<69;x++){
         int z = x;
         int y = x+1;
         pair.put((x+y),0);
      }
      for(int x = 1;x<70;x++){
         wb.put(x,0);
      }
      for(int x = 1;x<43;x++){
         pb.put(x,0);
      }
      String line = numbers.nextLine();
      while(numbers.hasNext()){
         line = numbers.nextLine();
         totaldrawings += 1;
         String[] d = line.split("  ");
         String[] data = Arrays.copyOfRange(d, 1, d.length);
         if(data.length>6){
            data = Arrays.copyOf(data, data.length-1);
         }
         if(data.length>5){
            pairs = new ArrayList<Integer>();
            for(int x = 0;x<data.length-1;x++){
               int i = Integer.parseInt(data[x]);
               if(i>50){
                  abovefifty += 1;
               }
               pairs.add(i);
               int total = wb.get(i);
               wb.put(i,total+1);
            }
            for(int x = 0;x<pairs.size()-1;x++){
               if(pairs.get(x)-pairs.get(x+1)<=1&&pairs.get(x)-pairs.get(x+1)>=-1){
                  int z = pairs.get(x)+pairs.get(x+1);
                  int pairtotal = pair.get(z);
                  pair.put(z,pairtotal+1);
                  totalpairs+=1;
                  
               }
            }
            int i = Integer.parseInt(data[5]);
            int total = pb.get(i);
            pb.put(i,total+1); 
            
         }
      }
      TreeMap<Integer,Integer> temp = wb;
      int max1 = maxNumbers(temp, maxwb);
      int max2 = maxNumbers(temp,maxwb);
      int max3 = maxNumbers(temp, maxwb);
      int max4 = maxNumbers(temp,maxwb);
      int max5 = maxNumbers(temp,maxwb);
      int maxpair1 = maxPairs(pair,maxpair);
      int maxpair2 = maxPairs(pair,maxpair);
      int maxpair3 = maxPairs(pair,maxpair);
      int maxpfin1 = maxpair1/2;
      int maxpfin2 = maxpair2/2;
      int maxpfin3 = maxpair3/2;

      double percentpair = totalpairs/totaldrawings;   
      System.out.println("Number of total drawings: " + totaldrawings);
      System.out.println("Frequencies of White Balls: " + wb);
      System.out.println("Frequencies of Power Balls: " + pb);
      System.out.println("Best ticket is: " + maxwb + " " + maxNumbers(pb,maxpb));
      System.out.println("% of pairs: " + percentpair);
      System.out.println("Top three pairs: ");
      System.out.println("("+maxpfin1+","+(maxpfin1+1)+")"); 
      System.out.println("("+maxpfin2+","+(maxpfin2+1)+")");
      System.out.println("("+maxpfin3+","+(maxpfin3+1)+")");
      System.out.println("% of White balls above 50: " + abovefifty/(totaldrawings*5)*100+ "%");
   }
   public static int maxNumbers(TreeMap<Integer,Integer> temp, ArrayList<Integer> max){
      int wb1 = 0;
      int wb1occurence = 0;
      for(int x = 1;x<temp.size();x++){
         if(wb1occurence<temp.get(x)&&!max.contains(x)){
            wb1 = x;
            wb1occurence = temp.get(x);
         }
      }
      max.add(wb1);
      return wb1;
   }
   public static int maxPairs(TreeMap<Integer,Integer> temp, ArrayList<Integer> max){
      int wb1 = 0;
      int wb1occurence = 0;
      for(int x = 3;x<137;x+=2){
         if(wb1occurence<temp.get(x)&&!max.contains(x)){
         wb1 = x;
         wb1occurence = temp.get(x);
            }
         }
      max.add(wb1);
      return wb1;

      }
   }
