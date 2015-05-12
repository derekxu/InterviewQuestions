package linkedIn;

public class SumGame {
	/* In "the 100 game," two players take turns adding, to a running 
	total, any integer from 1..10. The player who first causes the running 
	total to reach or exceed 100 wins. 
	What if we change the game so that players cannot re-use integers? 
	For example, if two players might take turns drawing from a common pool of 
	numbers 
	of 1..15 without replacement until they reach a total >= 100. This problem 
	is 
	to write a program that determines which player would win with ideal play. 

	Write a procedure, "Boolean canIWin(int maxChoosableInteger, int 
	desiredTotal)", 
	which returns true if the first player to move can force a win with optimal 
	play. 

	Your priority should be programmer efficiency; don't focus on minimizing 
	either space or time complexity. 
	*/ 

	Boolean canIWinDFS(int maxChoosableInteger, int desiredTotal) { 
	// Implementation here. Write yours 
		if(maxChoosableInteger==0) return false;
		int[] numbers = new int[maxChoosableInteger];
		int sum=0;
		for(int i=0;i<maxChoosableInteger;i++){
			numbers[i]=maxChoosableInteger-i;
			sum+=numbers[i];
		}
		if(sum<desiredTotal) return false;
		
		return helper(numbers, new boolean[maxChoosableInteger], desiredTotal,true);
	}
	boolean helper(int[] numbers, boolean[] used, int desiredTotal, boolean isMyTurn){
		if(desiredTotal<=0){
			return !isMyTurn;
		}
		

		for(int i=0;i<numbers.length;i++){
			if(!used[i]){
				used[i]=true;
				if(!helper(numbers,used,desiredTotal-numbers[i],!isMyTurn)){
					return false;
				}
				used[i]=false;
			}
		}

		return true;
	}

}
