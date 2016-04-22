/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rule30;

/**
 *
 * @author rub account
 */
import java.util.ArrayList;
import java.util.List;

public class Rule30 {
	public static void main(String[] args){
		String initialGeneration = "0000000000000001000000000000000";//input tape, the length of the tape will determine the length of all the generations
		int generations=15;//number of generations
		System.out.println(initialGeneration);
		for(int i=0;i<generations;i++){//outer lop to keep track of every generation
			String newGeneration="";
			for(int j=0;j<initialGeneration.length();j++){//inner loop to read per cell/character in the tape
				String parents;
				if(j-1<0)//if the cell being read is the rightmost
					parents="0"+initialGeneration.substring(j, j+2);
				else if(j+2>=initialGeneration.length())//if the cell being read is the leftmost
					parents=initialGeneration.substring(j-1, j+1)+"0";
				else
					parents=initialGeneration.substring(j-1, j+2);//take a length 3 substring as parents for the cell below and translate to integer (e.g. "110" -> 6)
				if(Integer.parseInt(parents, 2)==7||Integer.parseInt(parents, 2)==6||Integer.parseInt(parents, 2)==5||Integer.parseInt(parents, 2)==0)//rule 30 rules are in this condition 
					newGeneration+="0";
				else
					newGeneration+="1";
			}
			System.out.println(newGeneration);
			initialGeneration=newGeneration;
		}
	}
}