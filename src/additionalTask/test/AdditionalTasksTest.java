package additionalTask.test;

import static org.junit.jupiter.api.Assertions.*;
import static additionalTask.AdditionalTasks.*;

import org.junit.jupiter.api.Test;

class AdditionalTasksTest {

	@Test
	void hasValidBracketsTest() {
		String str = "{qq[]}";
		assertTrue(hasValidBrackets(str));
		
		String str1 = "{[w]}(){[]}";
		assertTrue(hasValidBrackets(str1));
		
		String str2 = "q}{[]}(q){[]}{";
		assertFalse(hasValidBrackets(str2));
		
		String str3 = "qqq({)[]e}(){[]}eee";
		assertFalse(hasValidBrackets(str3));
		
		String str4 = "{[]}{(q}){[]}";
		assertFalse(hasValidBrackets(str4));
	}
	@Test
	void isAnagramTest() {
		String str1 = "lolo";
		String str2 = "olol";
		String str3 = "dabalol";
		String str4 = "looabda";
		assertTrue(isAnagram(str1, str2));
		assertFalse(isAnagram(str3, str4));
	}

}
