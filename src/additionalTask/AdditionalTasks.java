package additionalTask;

public class AdditionalTasks {

	// #3
	public static boolean isAnagram(String sourceWord, String targetWord) {
		int[] helper = new int[Short.MAX_VALUE];
		int index = 0;
		char[] sourceWordArr = sourceWord.toLowerCase().toCharArray();
		char[] targetWordArr = targetWord.toLowerCase().toCharArray();
		for (int i = 0; i < sourceWordArr.length; i++) {
			if (sourceWordArr[i] < 97 || sourceWordArr[i] > 122 && targetWordArr[i] < 97 || targetWordArr[i] > 122) {
				return false;
			}
			helper[sourceWordArr[i]] += 1;
			helper[targetWordArr[i]] -= 1;
		}
		while (index < helper.length && helper[index] == '\u0000') {
			index++;
		}
		return index == helper.length ? true : false;
	}
	// #4
	public static boolean hasValidBrackets(String text) {
		char[] array = text.toCharArray();
		char[] openBrecket = new char[array.length];
		char[] closeBrecket = new char[array.length];
//		char[] brecketCheackArr = new char[array.length];
		int indexOpen = 0;
		int indexClose = 0;
//		int countOfBreckets = 0;
//		int j = 0;
//		for (int i = 0; i < brecketCheackArr.length; i++) {
//			if (checkBrecket(array, i) != 0) {
//				brecketCheackArr[j] = array[i];
//				j++;
//				countOfBreckets += 1;
//			}
//		}
		for (int i = 0; i < array.length; i++) {
//			if (array.length % 2 != 0) {
//				return false;
//			}
			if (checkBrecket(array, i) < 0 && indexOpen == 0) {
				return false;
			} else if (checkBrecket(array, i) > 0) {
				openBrecket[indexOpen] = array[i];
				indexOpen++;
			}
			if (checkBrecket(array, i) < 0 && indexOpen > 0) {
				closeBrecket[indexClose] = array[i];
				if (checkBrecket(openBrecket, indexOpen - 1) + checkBrecket(closeBrecket, indexClose) == 0) {
					indexOpen--;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	private static int checkBrecket(char[] helper, int index) {
		int res = 0;
		char[] breket = { '(', '[', '{', ')', ']', '}' };
		for (int i = 0; i < breket.length; i++) {
			if (breket[i] == helper[index] && i > 2) {
				res = -i - 1 + 3;
			}
			if (breket[i] == helper[index] && i <= 2) {
				res = i + 1;
			}
		}
		return res;
	}
}
