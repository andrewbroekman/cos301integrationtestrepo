package za.co.solms.math;

public class Parabola 
{
	public Parabola(double c_0, double c_1, double c_2) throws NotParabolaException 
	{
		super();
		if (c_2 == 0)
			throw new NotParabolaException();
		this.c_0 = c_0;
		this.c_1 = c_1;
		this.c_2 = c_2;
	}
	
	public double getValue(double x)
	{
		return c_0 + c_1*x + c_2*x*x;
	}

	/**
	 * 
	 * @return set of roots (either 2, 1 or zero length array)
	 */
	public double[] getRoots()
	{
		double d = c_1*c_1 - 4*c_2*c_0;
		double[] roots;
		if (d < 0)
			roots = new double[0];
		else if (d == 0)
		{
			double tp = getTurningPoint();
			roots = new double[1];
			roots[0] = tp;
		}
		else
		{
			roots = new double[2];
			roots[0] = (-c_1 - Math.sqrt(d))/(2*c_2);
			roots[1] = (-c_1 + Math.sqrt(d))/(2*c_2);
		}
		return roots;
	}
	
	public double getTurningPoint()
	{
		return -c_1/(2*c_2);
	}

	private double c_0, c_1, c_2;
}
