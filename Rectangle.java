/**
 * Lab 6
 *
 * Class representing a Rectangle.
 *
 * @author Joseph
 * @version 2019-02-24
 */
public class Rectangle extends Polygon{
	
	/**
	 * These variables stores the lengths of the height and width of a rectangle/square
	 */
	private double height, width;
	
	/**
     * The rectangle constructor. Store the side and base information and store in the sideLengths array.
     *
     * @param id The created shape's name id.
     * @param height the height of the rectangle
     * @param width the width of the width
     */
	public Rectangle(String id, double height, double width) {
		super(id);
		
		// Initialized here for local use
		this.height = height;
		this.width = width;
		
		// Adds these variables to the array "sideLengths" 
		this.sideLengths.add(height);
		this.sideLengths.add(height);
		this.sideLengths.add(width);
		this.sideLengths.add(width);
	}
	
	/**
	 * Gets the area of a Rectangle.
	 *
	 * @return The area of the triangle (width * height)
	 */
	@Override
	public double getArea() {
		return height * width;
	}
	
	/**
	 * Gets the type of the shape.
	 *
	 * @return The string "Rectangle".
	 */
	@Override
	public String getShapeType() {
		return "Rectangle";
	}

}
