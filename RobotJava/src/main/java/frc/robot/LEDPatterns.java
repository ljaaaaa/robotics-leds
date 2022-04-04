package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;

public class LEDPatterns {
    AddressableLEDBuffer buffer;
    AddressableLED led;

    int position;
    boolean goingUp;
    int pos;

  public LEDPatterns(AddressableLEDBuffer buffer, AddressableLED led){
    this.buffer = buffer;
    this.led = led;
  }   
    
  public void paintRed(){
    for (int x = 0; x < buffer.getLength(); x++){
      setColor(x, Constants.green);
      setData();
    }
  }

  public void move_array(){
    Color[] array = new Color[buffer.getLength()];

    for (int x = 0; x < array.length; x++){
      array[x] = buffer.getLED(x);
    }

    move_colors(array);
  }

  public void faded_rainbow(){
    int num_colors = 6; //red, orange, yellow, green, blue, purple
    int num_segments = buffer.getLength()/num_colors; //segments of each color
  
    int r = 255;
    int g = 0;
    int b = 255;

    //Pink to purple
    for (int x = 0; x < num_segments; x++){
      b -= 255/num_segments;
      paintLED(r, g, b);
    }
    
    //Red to yellow
    for (int x = 0; x < num_segments; x++){
      g += 255/num_segments;
      paintLED(r, g, b);
    }

    //Yellow to green
    for (int x = 0; x < num_segments; x++){
      r -= 255/num_segments;
      paintLED(r, g, b);
    }

    //Green to light blue
    for (int x = 0; x < num_segments; x++){
      b += 255/num_segments;
      paintLED(r, g, b);
    }

    //Light green to blue
    for (int x = 0; x < num_segments; x++){
      g -= 255/num_segments;
      paintLED(r, g, b);
    }

    //Blue to pink
    for (int x = 0; x < num_segments; x++){
      r += 255/num_segments;
      paintLED(r, g, b);
    }
    pos = 0;
  }

  public void paintLED(int r, int g, int b){
    setColor(pos, new MyColor(r, g, b));
    pos++;
    setData();
  }

  //Move a rainbow
  public void movingRainbow(MyColor[] array){
    MyColor[] new_array = array;

    for (int x = 0; x < array.length; x++){ //move each color one index
      if (x < array.length-1){ //Move backwards - give next color of array
        new_array[x] = array[x+1]; 

        } else { //Loop back and get last color of array
          new_array[x] = array[0];
        }
      }
    array = new_array;
    paintArray(array); //paint array with new pattern
    setData();
  }

  //Move a block across strip
  public void moveBlock(MyColor color){
    if (position == buffer.getLength()-1){
        goingUp = false;

    } else if (position == 0){
        goingUp = true;
    }

    if (goingUp){
        setColor(position, color);
        position++;

    } else {
        setColor(position, Constants.black);
        position--;
    }
  }

  //Move single block
  public void moveSingleBlock(MyColor color){
    for (int x = 0; x < buffer.getLength(); x++){
      setColor(x, color);
    
      if (x-1 == -1){
        setColor(buffer.getLength()-1, Constants.black);
      } else {
        setColor(x-1, Constants.black);
      }

      try {
        Thread.sleep(10);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  //Paints whatever pattern an array has
  public void paintArray(MyColor[] array){
    for (int x = 0; x < buffer.getLength(); x++){
      setColor(x, array[x%array.length]); 
    }
  }

  //Make a still MVRT (purple/gold) pattern
  public void MVRTPattern(){
    for (int x = 0; x < buffer.getLength(); x++){
        if (x%2 == 0){ //set to purple
            setColor(x, Constants.mvrtPurple);
        
        } else { //set to gold
            setColor(x, Constants.mvrtGold);
        }
    }
  }
 
  //Move an array of colors up one pixel
  public void move_colors(Color[] colors){
    Color old[] = colors;
    
    for (int x = 0; x < old.length; x++){
      if (x == old.length-1){
        colors[x] = old[0];
        
      } else {
        colors[x] = old[x+1]; 
      }
    }
  }

  //Sets color of one square
  public void setColor(int index, MyColor color){
    buffer.setRGB(index, color.red, color.green, color.blue);
    setData();
  }

  //Set the data for leds
  public void setData(){
    led.setData(buffer);
  }
}