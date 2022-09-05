
public class Box {

	//for lab 8,9
  public double length;
  public double width;
  public double height;

  public Box() {

  }

  public Box(double length, double width, double height) {
    this.length = length;
    this.width = width;
    this.height = height;
  }

  public double getVolume() { 
    return length * width * height;
  }
}


	//for lab 3
	
// 	// Convert the public variables to private
// 	private double length;
// 	private double width;
// 	private double height;
	
// 	//Complete the bellow constructors
// 	public Box() {
		
// 	}
// 	public Box(double length, double width, double height) {
// 		this.length = length;
// 		this.width = width;
// 		this.height = height;
// 	}
	
// 	// Write down the set and get methods for all the variables
	
// 	public void setLength(double length) {
// 		this.length = length;
// 	}
// 	public void setWidth(double width) {
// 		this.width = width;
// 	}
// 	public void setHeight(double height) {
// 		this.height = height;
// 	}
	
	
// 	public double getLength() {
// 		return length;
// 	}
// 	public double getWidth() {
		
// 		return width;
// 	}
// 	public double getHeight() {
// 		return height;
// 	}
	
// 	// Complete the get volume method
// 	public double getVolume(){
		
// 		return length*width*height;
// 	}
// }