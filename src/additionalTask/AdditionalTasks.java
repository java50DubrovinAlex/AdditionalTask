package additionalTask;

public class AdditionalTasks {
	
	
	// #3
	public static boolean isAnagram(String sourceWord, String targetWord) {
		int [] helper = new int [Short.MAX_VALUE];
		int index = 0;
		char[] sourceWordArr = sourceWord.toLowerCase().toCharArray();
		char[] targetWordArr = targetWord.toLowerCase().toCharArray();
		for(int i = 0; i < sourceWordArr.length;i++) {
			if(sourceWordArr[i] < 97 || sourceWordArr[i] > 122 && targetWordArr[i] < 97 || targetWordArr[i] > 122) {
				return false;
			}
			helper[sourceWordArr[i]] += 1;
			helper[targetWordArr[i]] -= 1;
		}
		while(index < helper.length && helper[index] == '\u0000') {
			index++;
		}
		 return index == helper.length ? true : false;
	}
	
	
	
	
	
	
	
	//#4
	public static boolean hasValidBrackets(String text) {
		char[] helper = text.toCharArray();
		int [] brecketArray = new int [helper.length];
		int index = 0;
		int checkIndex = 0;
		boolean res = true;
		while(index >= 0 && checkIndex >= 0 && index < helper.length) {
			if(index == 0 && checkCloseBrecket(helper, index) < 0) {
				res = false;
			}else 
				if(checkOpenBrecket(helper, index) > 0) {
					brecketArray[checkIndex] = checkOpenBrecket(helper, index);
				}
			if(checkIndex > 0 && brecketArray[checkIndex - 1] + checkCloseBrecket(helper, index) == 0) {
				brecketArray[checkIndex - 1] += checkCloseBrecket(helper, index);
				checkIndex -= 3;
			}else 
			if(checkIndex == 0 && brecketArray[checkIndex ] + checkCloseBrecket(helper, index) == 0) {
				brecketArray[0] += checkCloseBrecket(helper, index);
			}
			
			checkIndex++;
			index++;
			
		}
		
		return brecketArray[0] == 0 && res? true : false;
		
		
	}

	private static int checkCloseBrecket(char[] helper, int index) {
		int res = 0;
		char[] breket = { ')', ']', '}' };
		for (int i = 0; i < breket.length; i++) {
			if (breket[i] == helper[index]) {
				res = -i - 1;
			}
		}
		return res;
	}

	private static int checkOpenBrecket(char[] helper, int index) {
		int res = 0;
		char[] breket = { '(', '[', '{' };
		for (int i = 0; i < breket.length; i++) {
			if (breket[i] == helper[index]) {
				res = i + 1;
			}
		}

		return res;
	}
	
	
}
