package app.com.myprogressbar.vy.util;


import app.com.myprogressbar.vy.type.FishSpinner;
import app.com.myprogressbar.vy.type.PhoneWave;
import app.com.myprogressbar.vy.type.Radar;
import app.com.myprogressbar.vy.type.Sharingan;
import app.com.myprogressbar.vy.type.TwinFishesSpinner;
import app.com.myprogressbar.vy.type.Whirlpool;
import app.com.myprogressbar.vy.type.Worm;

public class LoaderGenerator {

  public static LoaderView generateLoaderView(int type) {
    switch (type) {
      case 1:
        return new Sharingan();
      case 2:
        return new PhoneWave();
      case 3:
        return new Radar();
      case 4:
        return new TwinFishesSpinner();
      case 5:
        return new Worm();
      case 6:
        return new Whirlpool();
      case 7:
        return new FishSpinner();
      default:
        return new FishSpinner();
    }
  }
}
