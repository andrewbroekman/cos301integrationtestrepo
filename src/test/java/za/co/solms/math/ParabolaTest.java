package za.co.solms.math;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import za.co.solms.math.NotParabolaException;
import za.co.solms.math.Parabola;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
 

public class ParabolaTest
{
	@Before
	public void preTestInitialization()
	{
		try
		{
			testData  = new LinkedList<ParabolaTest.TestParabola>();
			testData.add(new TestParabola("normal2PositiveRoots", new Parabola(1, -3, 2), new double[] {1,2}));
			testData.add(new TestParabola("normalPositiveNegativeRoot", new Parabola(1, 1, -2), new double[] {1,-2}));
			testData.add(new TestParabola("invertedNegativeRoots", new Parabola(-1, -1, 2), new double[] {1,2}));
			testData.add(new TestParabola("singleRealRoot", new Parabola(1, -2, 1), new double[] {1}));
			testData.add(new TestParabola("noRealRoots", new Parabola(2, 1, 2), new double[] {}));
		}
		catch (NotParabolaException e)
		{
			fail("Constructor claimed not parabola, but is");
		}	
	}
	
	@After
	public void postTestCleanup()
	{
		testData.clear();
	}
	
	@Test(expected = NotParabolaException.class)
	public void constructor_notAParabola() throws NotParabolaException
	{
		new Parabola(2,1,0);
	}

	@Test
	public void getRoots_functionValueIsZero()
	{
		for (TestParabola testParabola: testData)
		{
			Parabola p = testParabola.getParabola();
			double[] roots = p.getRoots();
			for (double root:roots)
				assertEquals("function value at roots for " + testParabola.getIdentifier() 
					+ " not zero.", 0, p.getValue(root), eps);
		}
	}
	
	@Test
	public void getRoots_rootValues()
	{
		for (TestParabola testParabola: testData)
		{
			Parabola p = testParabola.getParabola();
			double[] roots = testParabola.getRoots();
			assertEquals (testParabola.getRoots().length, roots.length);
			for (double root:roots)
				assertEquals("Roots for " + testParabola.getIdentifier(), 
						true, contains(testParabola.getRoots(), root, eps));
		}	
	}
	
	private static boolean contains(double[] array, double value, double eps)
	{
		for (double v : array)
		  if (Math.abs(v-value) < eps)
			  return true;
		
		return false;
	}
  
  private static class TestParabola 
  {
	  
	  public TestParabola(String identifier, Parabola parabola, double[] roots) {
		super();
		this.identifier = identifier;
		this.parabola = parabola;
		this.roots = roots;
	}
	  
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public Parabola getParabola() {
		return parabola;
	}
	public void setParabola(Parabola parabola) {
		this.parabola = parabola;
	}
	public double[] getRoots() {
		return roots;
	}
	public void setRoots(double[] roots) {
		this.roots = roots;
	}

	private String identifier;
	  private Parabola parabola;
	  private double[] roots;
  }
  
	
  private double eps = 1e-7;	
  private List<TestParabola> testData;
}
