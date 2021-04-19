package com.digitas.gsk.trgr.TrgrValidation;

public class myAssertionException extends Throwable {

	private static final long serialVersionUID = 1L;

	boolean enableSuppression = false;
	boolean writableStackTrace = false;

	public myAssertionException() {
	}

	//static String[] emoji = { "¯\\_(ツ)_/¯", "(/•-•)/", "¯\\(°_o)/¯", "o_O", "(⊙_☉)" };

	static int i = 0 + (int) (Math.random() * ((4 - 0) + 1));
	public myAssertionException(String message) {
		super(message, null, false, false);
		//super(message + "\n\n" + emoji[i], null, false, false);
		//i = 0 + (int) (Math.random() * ((4 - 0) + 1));
	}
}