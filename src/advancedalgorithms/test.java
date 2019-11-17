/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedalgorithms;

import java.util.ArrayList;



public class test {

	static int M = 6;
	static String[] line = "aaa bb cc ddd dd".split(" "); 
	static int[] wordLenArr = new int[line.length + 1];
	static int[][] cost = new int[line.length + 1][line.length + 1];
	static int[] DP = new int[line.length + 1];
	static int[] track = new int[line.length + 1];
        static ArrayList<String> words= new ArrayList<>();

	static void createCostTable() {
		for (int i = 1; i < cost.length; i++) {
			for (int j = i; j < cost.length; j++) {
				int val = M - calcSubstringLength(i, j);
                                 System.out.println(val+"="+M+" - "+calcSubstringLength(i, j));
				if (val >= 0) {
					cost[i][j] = val * val * val;

				} else {
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}

	static int calcSubstringLength(int i, int j) {
		int len = 0;
		for (int k = i; k <= j; k++) {
			len += wordLenArr[k];
		}
		return len;
	}

	static void findWordLengths() {
		int index = 1;
		for (String s : line) {
                        words.add(s);
			wordLenArr[index] = s.length();
			index++;
		}
	}

	static void JustifyText() {
		DP[0] = 0;
		for (int i = 1; i< DP.length; i++) {
			DP[i] = Integer.MAX_VALUE;
			for (int j = 1; j <=i; j++) {
				if (DP[j - 1] + cost[j][i] < DP[i]) {
					DP[i] = DP[j - 1] + cost[j][i];
					track[i] = j;
				}
			}
		}

	}
        
        static void printText(){
            System.out.print("wordLenArr= ");
            for (int i = 1; i< wordLenArr.length; i++) {
                        System.out.print(wordLenArr[i]+" ");
            }
            System.out.println();
            System.out.print("DP= ");
            for (int i = 1; i< DP.length; i++) {
                        System.out.print(DP[i]+" ");
            }
            System.out.println();
            System.out.println("COST TABLE= ");
            for (int i = 1; i < cost.length; i++) {
			for (int j = i; j < cost.length; j++) {
                            System.out.print(cost[i][j]+" ");
                        }
                        System.out.println();
            }
            //for (int i = 0; i< DP.length; i++) {
	//		System.out.print("DP= ");
         //               System.out.print(DP[i]+" ");
          //  }
                    
        }
        
        static void printText2(){
            int numLine = 1;
            for (int i = 1; i< track.length; i++) {
                if (track[i]==numLine){
			System.out.print(words.get(i-1)+" ");
                }
                else{
                    System.out.println();
                    numLine++;
                    i--;
                }
                }
                
            }
        
	
	

	public static void main(String[] args) {
		findWordLengths();
		createCostTable();
		JustifyText();
                printText2();
		for (int i = 1; i < track.length; i++) {
			System.out.println(track[i]);
		}

	}

}