/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAC;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Divide_and_conquer {
    
    public  ArrayList<String> words= new ArrayList<>();
    public static String solGlo= new String();
    private int count=0;
    
    
    public Divide_and_conquer(ArrayList<String> words) {
        this.words  =words;
        count=this.words.size();
    }
    
    public int[] divide_and_conquer(String wordText)
    {
         int l=0; //current state of line size
         int m=10; //size of the line with
         int lc=0;
         int totalLineCost=0;//total cost
         int[] lineCostArray=new int[count]; //each line cost
         String solution= "";
         int lcac=0;//count variable to store line cost array
         int tempLenth=0;
         int stringLen=wordText.length();
         int loopCount=stringLen/m;
         int remindr=stringLen%m;
         if(remindr>0)
         {
          loopCount++;
         }
          String[] devided = new String[loopCount];
          int startingPos=0;
         for (int i = 0; i <= loopCount; i++) {
             devided[i] = wordText.substring(startingPos, m);
             startingPos +=m;
         }
         int countOfWordCurrent=0;
         String[] spilitedArray;
         int countOfWordsOfEachLine;
         String lastWord;
         String actualWord;

         //Logic
         for (int i = 0; i < 10; i++) {
            spilitedArray= devided[i].split("\\s+");//each line string wil be inserted to array
            countOfWordsOfEachLine= spilitedArray.length;
            lastWord=spilitedArray[countOfWordsOfEachLine-1]; //got the last word
            actualWord=words.get(countOfWordCurrent);//get actual comparing word
               //resizing the words by considering line space limit
            if(devided[i].length()>m)
            {
            //have to add the last from string from devided[i] to devided[i+1];
             devided[i+1]=addString(devided[i+1],lastWord,0); //we adding to next line if it is not fitting
            
            //have to remove the last from string from devided[i[;
             String original = devided[i+1];
             String newString = original.replace(" "+lastWord,"");
             devided[i]=newString;
             
           
             spilitedArray= devided[i].split("\\s+");//each line string wil be inserted to array
             countOfWordsOfEachLine= spilitedArray.length;//this is actually last word count of the line
             lastWord=spilitedArray[countOfWordsOfEachLine-1]; //got the last word
            }
            
            if(actualWord.length()!=lastWord.length())
            {
              devided[i+1]=addString(devided[i+1],lastWord,0);
              //have to remove the moved string from devided[i[;
              String original = devided[i+1];
              String newString = original.replace(" "+lastWord,"");
              devided[i]=newString;
            }
            countOfWordCurrent=countOfWordCurrent+countOfWordsOfEachLine; //storing word count to maintain its state
            
         }

         

//*********************************
         for (int k = 0; k < count; k++) {
             tempLenth=tempLenth +words.get(k).length();
             if (tempLenth <= m)
             {
               solution=solution+" "+words.get(k);// adding word to the line
               lc=m-tempLenth; //getting current line cost  
               tempLenth+=1; // adding space charactor
             }
             else
             {
                 lineCostArray[lcac]=lc;
                 totalLineCost=totalLineCost+lc;
                 solution=solution+"/n";
                 lc=0;
                 tempLenth=0;
             }
         }// end of loof
         
         System.out.println(solution );
         System.out.println(totalLineCost );
         
         return lineCostArray;
     }
    
    
    public String addString(String str, String ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        return sb.toString();
    }
        
}
