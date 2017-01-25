import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;


/* BufferedImageStack
 * Name: Shuyang Wu
 * [CSE 373, Autumn 2016, Assignment 1.]
 * This part of the application mimic a stack which has all functions a stack can perform
 */


public class BufferedImageStack {
	BufferedImage[] myArray;
	int idx = -1;
	
	public BufferedImageStack() {
		myArray = new BufferedImage[100];
	}

	public BufferedImageStack(int size) {
		myArray = new BufferedImage[size];
	}
	
	public void clear() {
		idx = -1;
	}
	
	//enters the buffered image onto the stack and returns nothing
	public void push(BufferedImage someBufferedImage){
		idx = idx + 1;
		WritableRaster raster = someBufferedImage.copyData(null);
		myArray[idx] = new BufferedImage(someBufferedImage.getColorModel(), raster,
										 someBufferedImage.isAlphaPremultiplied(), null);
	}
	
	//throws an exception if the stack is empty; 
	//otherwise returns the top buffered image, removing it from the stack.
	public BufferedImage pop() throws Exception {
		if (myArray.length == 0) {
			throw new Exception("Empty stack");
		} 
		BufferedImage temp = myArray[idx + 1];
		myArray[idx + 1] = null;
		return temp;
	}
	
	//returns true if there are no items in the stack
	public boolean isEmpty(){
		return idx == -1;
	}
	
	//returns the buffered image at the position given by the index
	public BufferedImage get(int index){
		return myArray[index];
	}
	
	//returns the number elements currently in the stack
	public int getSize() {
		return idx + 1;
	}
	
	//returns the current size of the array being used to hold the stack elements.
	public int getArraySize(){
		return myArray.length;
	}

}