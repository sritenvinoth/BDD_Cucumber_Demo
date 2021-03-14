import java.util.regex.Matcher
import java.util.regex.Pattern

import com.kms.katalon.core.annotation.Keyword


public class RegEx {
	@Keyword
	public static boolean onlyDigits(String str) {
		String regex = "[0-9]+";
		Pattern p = Pattern.compile(regex);
		if (str == null) {
			return false;
		}
		Matcher m = p.matcher(str);
		return m.matches();
	}
}
