package com.crawljax.condition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.crawljax.browser.EmbeddedBrowser;

/**
 * Condition that returns true iff experssion occurs in the dom.
 * 
 * @author dannyroest@gmail.com (Danny Roest)
 * @version $Id: RegexCondition.java 6301 2009-12-24 16:36:24Z mesbah $
 */
public class RegexCondition extends AbstractCondition {

	private final String expression;

	/**
	 * @param expression
	 *            the regular expression.
	 */
	public RegexCondition(String expression) {
		this.expression = expression;
	}

	@Override
	public boolean check(EmbeddedBrowser browser) {
		try {
			String dom = browser.getDom();
			Pattern p = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(dom);
			return m.find();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}