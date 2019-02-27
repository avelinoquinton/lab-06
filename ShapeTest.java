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
		Assert.assertEquals("Shape type incorrect", "Equilateral Triangle", tri.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Triangle1", tri.getId());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		// TODO: complete this...
		double c = 10.0;
		double d = 10.0;
		double a = 20.0;
		double b = 25.0;

		// Use intermediate variables:
		double e = (a + b) / 2;
		double f = Math.pow(b - a, 2) + Math.pow(c, 2) - Math.pow(d, 2);
		double g = 2 * c * (b - a);

		// Calculate:
		Double trapArea = e * c * Math.sqrt(1 - Math.pow(f/g, 2));
		
		Shape trap = new Trapezoid("Trapezoid1", 10.0, 10.0, 20.0, 25.0);
		Assert.assertEquals("Trapezoid area incorrect", trapArea, trap.getArea(), 0.0001 );
		Assert.assertEquals("Trapezoid perimeter incorrect.", 65.0, trap.getPerimeter(), 0.0001);
		Assert.assertEquals("Shape type incorrect", "Trapezoid", trap.getShapeType());
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
		Assert.assertEquals("Circle area incorrect.", Math.PI*3.0*3.0, circ.getArea(), 0.0001);
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
		// Test equals:
		Shape rectOne = new Rectangle("R1", 3.0, 9.0);
		Shape rectTwo = new Rectangle("R2", 3.0, 9.0);
		ShapePerimeterComparator sc = new ShapePerimeterComparator();
		Assert.assertEquals("ComparePerimeterTest gave incorrect ordering", 0, sc.compare(rectOne, rectTwo));
		Assert.assertTrue("ComparePerimeterTest should find shapes equal", sc.equals(rectOne, rectTwo));
		
		// Test equal area, different perimeter:
		Shape rectThree = new Rectangle("R3", 6.0, 2.0);
		Shape rectFour = new Rectangle("R4", 3.0, 4.0);
		Assert.assertEquals("ShapePerimeterComparitor gave incorrect ordering", -1, sc.compare(rectFour, rectThree));
		Assert.assertEquals("ShapePerimeterComparitor gave incorrect ordering", 1, sc.compare(rectThree, rectFour));
		Assert.assertFalse("ShapePerimeterComparitor incorrectly finds shape equal", sc.equals(rectThree, rectFour));
		
		// Test unequal perimeter and area:
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering", 1, sc.compare(rectOne, rectThree));
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering", 1, sc.compare(rectOne, rectThree));
		Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal", sc.equals(rectThree, rectOne));
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		// TODO: complete this...
		// Test equals
		Shape rect = new Rectangle("R1", 5.0,5.0);
		Shape sqr = new Square("S1", 5.0);
		Assert.assertEquals("NaturalComparator should find shapes equal.", 0, rect.compareTo(sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("NaturalComparator gave incorrect ordering.", -1, rect2.compareTo(sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sqr2.compareTo(rect2));

        // Test unequal perimeter and area:
        Shape rect3 = new Rectangle("R3", 2.0, 9.0);
        Shape rect4 = new Rectangle("R4", 11.0, 5.0);
        Assert.assertEquals("NaturalComparator gave incorrect ordering.", 1, rect4.compareTo(rect3));
        Assert.assertEquals("NaturalComparator gave incorrect ordering.", -1, rect3.compareTo(rect4));
    }
}
