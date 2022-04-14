package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;

public class LEDPatterns {
    AddressableLEDBuffer buffer;
    AddressableLED led;
    MyColor[] led_array;

  public LEDPatterns(AddressableLEDBuffer buffer, AddressableLED led){
    this.buffer = buffer;
    this.led = led;
    led_array = new MyColor[buffer.getLength()];
  }  

  //Create gradient from one color to another
  public void gradient(int startPos, int endPos, MyColor color1, MyColor color2){
    int len = endPos-startPos;
    
    //Changes in color to get to new color
    int changeR = (color2.r - color1.r)/(len-1);
    int changeG = (color2.g - color1.g)/(len-1);
    int changeB = (color2.b - color1.b)/(len-1);
  
    for (int x = 0; startPos+x < endPos; x++){
        led_array[startPos+x] = new MyColor(color1.r + changeR*x, color1.g + changeG*x, color1.b + changeB*x);
        setColor(startPos+x, new MyColor(color1.r + changeR*x, color1.g + changeG*x, color1.b + changeB*x));
    }
    setData();
  }

  //Move current buffer
  public void move_leds(){
    MyColor old_array[] = new MyColor[led_array.length];

    for (int x = 0; x < old_array.length; x++){
      old_array[x] = new MyColor(led_array[x].r, led_array[x].g, led_array[x].b);
    }

    for (int x = 0; x < buffer.getLength(); x++){
      if (x == buffer.getLength()-1){
        setColor(x, old_array[0]);
        
      } else {
        setColor(x, old_array[x+1]);
      }
    }

    setData();
  }

  //MVRT in morse code
  public void morse_code(){
    MyColor MyPurple = new MyColor(117, 0, 255);

    MyColor morse_colors[] = new MyColor[] {
      /*M*/MyPurple, MyPurple, Constants.black, MyPurple, MyPurple,
      /*Space */Constants.black, Constants.black, Constants.black,
      /*V*/MyPurple, Constants.black, MyPurple, Constants.black, MyPurple, Constants.black, MyPurple, MyPurple,
      /*Space*/ Constants.black, Constants.black, Constants.black,
      /*R*/MyPurple, Constants.black, MyPurple, MyPurple, Constants.black, MyPurple,
      /*Space*/Constants.black, Constants.black, Constants.black,
      /*T*/MyPurple, MyPurple
    };

    for (int x = 0; x < morse_colors.length; x++){
      setColor(x, morse_colors[x]);
    }
  }


  //MVRT checkered pattern
  public void mvrt_pattern(){
    for (int x = 0; x < buffer.getLength(); x++){
     if (x%2 == 0){
       setColor(x, new MyColor(255, 196, 16)); //Gold
     } else {
      setColor(x, new MyColor(38, 2, 53)); //Purple
     }
   }
 }

  //Rainbow gradient
  public void fading_rainbow(){
    int x = buffer.getLength()/6; //For each section of color
    gradient(0, x, Constants.red, Constants.orange);
    gradient(x, x*2, Constants.orange, Constants.yellow);
    gradient(x*2, x*3, Constants.yellow, Constants.green);
    gradient(x*3, x*4, Constants.green, Constants.blue);
    gradient(x*4, x*5, Constants.blue, Constants.purple);
    gradient(x*5, x*6, Constants.purple, Constants.red);
  }

  //Clap pattern
  public void clap(){
    flash(Constants.yellow, 240);
    flash(Constants.yellow, 240);
  
    flash(Constants.yellow, 100);
    flash(Constants.yellow, 100);
    flash(Constants.yellow, 100);
  }

  //Flash a color for certain time
  public void flash(MyColor color, int time){
    fill_all(color);
    Timer.delay(time);
  
    fill_all(Constants.black);
    Timer.delay(time);
  }

  public void fill_all(MyColor color){
    for(int x = 0; x < buffer.getLength(); x++){
      setColor(x, color);
    }
  }

  //Sets color of one square
  public void setColor(int index, MyColor color){
    led_array[index] = color;
    buffer.setRGB(index, color.r, color.g, color.b);
  }

  //Set the data for leds
  public void setData(){
    led.setData(buffer);
  }
}