package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class LEDPatterns {
    
    AddressableLEDBuffer buffer;
    AddressableLED led;

    int position;
    boolean goingUp;

    public LEDPatterns(AddressableLEDBuffer buffer, AddressableLED led){
        this.buffer = buffer;
        this.led = led;
    }   
    
  public void paintRed(){
    for (int x = 0; x < buffer.getLength(); x++){
      setColor(x, Constants.blue);
      setData();
    }
  }

  public void movingRainbow(MyColor[] array){
    MyColor[] new_array = array;

        //Move each color in array by one index
        for (int x = 0; x < array.length; x++){
          if (x < array.length-1){ //Move backwards - give next color of array
            new_array[x] = array[x+1]; 

          } else { //Loop back and get last color of array
            new_array[x] = array[0];
          }
        }
        array = new_array;

        //Print array with new pattern
        paintArray(array);
        setData();
  }

  public void moveBlock(MyColor color){
    if (position == buffer.getLength()-1){
        goingUp = false;

    } else if (position == 0){
        goingUp = true;
    }

    if (goingUp){
        position++;
        setColor(position, color);

    } else {
        position--;
        setColor(position, Constants.black);
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

      setData();

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  //Paints whatever pattern an array has
  public void paintArray(MyColor[] array){
    for (int x = 0; x < buffer.getLength(); x++){
      //Set color for LED
      setColor(x, array[x%array.length]);
      setData();
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
 
  //Sets color of one square
  public void setColor(int index, MyColor color){
    buffer.setRGB(index, color.red, color.green, color.blue);
    setData();
  }

  public void setData(){
    led.setData(buffer);
  }
}
