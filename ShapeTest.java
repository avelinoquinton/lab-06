import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Joseph
 * @version 2019-02-23
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Shape type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		// TODO: complete this...
		Shape rec = new Rectangle("Rectangle1", 4.0, 5.0);
		Assert.assertEquals("Rectangle area incorrect.", 20.0, rec.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 18.0, rec.getPerimeter(), 0.0001);
		Assert.assertEquals("Shape type incorrect.", "Rectangle", rec.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Rectangle1", rec.getId());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		// TODO: complete this...
		Shape tri = new EquilateralTriangle("Triangle1", 10.0);
		Assert.assertEquals("Triangle area incorrect", (10.0 * 10.0) * Math.sqrt(3)/4, tri.getArea(), 0.0001 );
		Assert.assertEquals("Triangle perimeter incorrect.", 30.0, tri.getPerimeter(), 0.0001);
		Assert.assertEquals("Shape type incorrect", "Equilateral Traingle", tri.getId());
		Assert.assertEquals("Shape ID incorrect.", "Traingle1", tri.getId());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		// TODO: complete this...
		double a = 10.0;
		double b = 10.0;
		double c = 20.0;
		double d = 25.0;

		// Use intermediate variables:
		double e = (a + b) / 2;
		double f = Math.pow(b - a, 2) + Math.pow(c, 2) - Math.pow(d, 2);
		double g = 2 * c * (b - a);

		// Calculate:
		Double trapArea = e * c * Math.sqrt(1 - Math.pow(f/g, 2));
		
		Shape trap = new Trapezoid("Trapezoid1", 10.0, 10.0, 20.0, 25.0);
		Assert.assertEquals("Trapezoid area incorrect", trapArea, trap.getArea(), 0.0001 );
		Assert.assertEquals("Trapezoid perimeter incorrect.", 65.0, trap.getPerimeter(), 0.0001);
		Assert.assertEquals("Shape type incorrect", "Trapezoid", trap.getId());
		Assert.assertEquals("Shape ID incorrect.", "Trapezoid1", trap.getId());
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		// TODO: complete this...
		Shape circ = new Circle("Circle1", 3.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI*4.0*4.0, circ.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 3.0, circ.getPerimeter(),0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Circle1", circ.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		// TODO: complete this...
		Shape rec = new Rectangle("Rectangle1", 4.0, 5.0);
		Assert.assertEquals("Rectangle	 ID = Rectangle1	 area = 20.000	 perimeter = 18.000", rec.toString());
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimeter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		// TODO: complete this...
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		// TODO: complete this...
    }
}
