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

    for (int x = 0; x < led_array.length; x++){
      led_array[x] = Constants.black;
    }
  }  

  //A dot that moves from one side of LED strip to other, accelerating as it continues
  public void accelerating_dot(){
    double delay_time = 0.5;

    for (int x = 0; x < buffer.getLength(); x++){
      fill_all(Constants.black);
      setColor(x, Constants.white);
      setData();
      Timer.delay(delay_time);
      
      if (x%3 == 0){
        delay_time /= 1.3;
      }
    }
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

  public void mv_gradient(){
    gradient(0, buffer.getLength()/2, Constants.purple, Constants.yellow);
    gradient(buffer.getLength()/2, buffer.getLength(), Constants.yellow, Constants.purple);
  }

  public void neon_gradient(){
    MyColor red = new MyColor(255, 0, 0);
    MyColor orange = new MyColor(255, 134, 0);
    MyColor yellow = new MyColor(243, 255, 0);
    MyColor pink = new MyColor(255, 0, 143);
    MyColor purple = new MyColor(255, 0, 243);

    int x = buffer.getLength()/5; //For each section of color
    gradient(0, x, red, orange);
    gradient(x, x*2, orange, yellow);
    gradient(x*2, x*3, yellow, pink);
    gradient(x*3, x*4, pink, purple);
    gradient(x*4, x*5, purple, red);
  }

  //Clap pattern
  public void clap(){
    System.out.println("clapping");
    flash(Constants.yellow, .22);
    flash(Constants.yellow, .22);
  
    flash(Constants.yellow, .13);
    flash(Constants.yellow, .13);
    flash(Constants.yellow, .13);
  }

  //Flash a color for certain time
  public void flash(MyColor color, double time){
    fill_all(color);
    setData();
    Timer.delay(time);
  
    fill_all(Constants.black);
    setData();
    Timer.delay(time);
  }

  //Fill entire LED strip to one color
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