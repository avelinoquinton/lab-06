import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Joseph
 * @version 2019-02-23
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		// TODO: complete this...
		ShapeSorter sorterNew = new ShapeSorter();

		//Shapes to test
		Shape rect1 = new Rectangle("A", 8.0, 5.0);
		Shape rect2 = new Rectangle("B", 8.0, 2.0);
		Shape rect3 = new Rectangle("C", 6.0, 8.0);
		sorterNew.addShape(rect1);
		sorterNew.addShape(rect2);
		sorterNew.addShape(rect3);
		sorterNew.sortShapes();
		String expectedToString = "Rectangle	 ID = B	 area = 16.000	 perimeter = 20.000\n" + 
				"Rectangle	 ID = A	 area = 40.000	 perimeter = 26.000\n" + 
				"Rectangle	 ID = C	 area = 48.000	 perimeter = 28.000\n";
		
		Assert.assertEquals(expectedToString, sorterNew.toString());
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		// TODO: complete this...
		ShapeSorter sorterNew = new ShapeSorter();

		//Shapes to test
		Shape rect1 = new Rectangle("A", 5.0, 6.0);
		Shape rect2 = new Rectangle("B", 15.0, 2.0);
		Shape rect3 = new Rectangle("C", 20.0, 9.0);
		sorterNew.addShape(rect1);
		sorterNew.addShape(rect2);
		sorterNew.addShape(rect3);
		sorterNew.sortShapes(new ShapeAreaComparator());
		String expectedToString = "Rectangle	 ID = A	 area = 30.000	 perimeter = 22.000\n" + 
				"Rectangle	 ID = B	 area = 30.000	 perimeter = 34.000\n" + 
				"Rectangle	 ID = C	 area = 180.000	 perimeter = 58.000\n";
		
		Assert.assertEquals("Shapes sorted incorrectly", expectedToString, sorterNew.toString());
}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		// TODO: complete this...
		ShapeSorter sorterNew = new ShapeSorter();

		//Shapes to test
		Shape rect1 = new Rectangle("A", 6.0, 4.0);
		Shape rect2 = new Rectangle("B", 2.0, 11.0);
		Shape rect3 = new Rectangle("C", 7.0, 3.0);
		sorterNew.addShape(rect1);
		sorterNew.addShape(rect2);
		sorterNew.addShape(rect3);
		sorterNew.sortShapes(new ShapePerimeterComparator());
		String expectedToString = "Rectangle	 ID = C	 area = 21.000	 perimeter = 20.000\n" + 
				"Rectangle	 ID = A	 area = 24.000	 perimeter = 20.000\n" + 
				"Rectangle	 ID = B	 area = 22.000	 perimeter = 26.000\n";
		
		Assert.assertEquals("Shapes sorted incorrectly", expectedToString, sorterNew.toString());
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		// TODO: complete this...
		ShapeSorter sorterNew = new ShapeSorter();

		//Shapes to test
		Shape rect1 = new Rectangle("A", 8.0, 5.0);
		Shape rect2 = new Rectangle("B", 8.0, 2.0);
		Shape rect3 = new Rectangle("C", 6.0, 8.0);
		sorterNew.addShape(rect1);
		sorterNew.addShape(rect2);
		sorterNew.addShape(rect3);
		sorterNew.sortShapes();
		String expectedToString = "Rectangle	 ID = B	 area = 16.000	 perimeter = 20.000\n" + 
				"Rectangle	 ID = A	 area = 40.000	 perimeter = 26.000\n" + 
				"Rectangle	 ID = C	 area = 48.000	 perimeter = 28.000\n";
		
		Assert.assertEquals(expectedToString, sorterNew.toString());
	}
}
