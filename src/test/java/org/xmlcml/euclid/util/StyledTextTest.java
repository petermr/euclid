package org.xmlcml.euclid.util;

import org.junit.Test;
import org.xmlcml.euclid.util.StyledText.SysoutStyle;

public class StyledTextTest {
	
	@Test
	public void testStyledText() {
		System.out.println("This is styled: "+StyledText.wrapBold("bold text")+"; followed by normal");
		System.out.println("This is styled: "+StyledText.wrap("underline", SysoutStyle.UNDERLINE)+"; followed by normal");
		System.out.println("This is styled: "+StyledText.wrap("blue", SysoutStyle.BLUE)+"; followed by normal");
//		System.out.println("This is styled: "+StyledText.wrap(StyledText.wrap("underline blue", SysoutStyle.BLUE), SysoutStyle.UNDERLINE)+"; followed by normal");
	}

}
