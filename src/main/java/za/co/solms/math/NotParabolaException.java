package za.co.solms.math;

public class NotParabolaException extends Exception 
{

	public NotParabolaException() {
		super();
	}

	public NotParabolaException(String msg, Throwable source) {
		super(msg, source);
	}

	public NotParabolaException(String msg) {
		super(msg);
	}

	public NotParabolaException(Throwable source) {
		super(source);
	}
}
