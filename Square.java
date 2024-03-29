/**
 * Lab 6
 *
 * Class representing a Square.
 *
 * @author Joseph
 * @version 2019-02-24
 */
public class Square extends Rectangle{

	public Square(String id, double size) {
		super(id, size, size);
	}
	
	/**
	 * Gets the type of the shape.
	 *
	 * @return The string "Square".
	 */
	@Override
	public String getShapeType() {
		return "Square";
	}
}
