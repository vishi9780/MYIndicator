package app.com.myprogressbar.vy.exception;

/**
 * Created by Vishal Yadav :- 173020181303HRS
 */

public class InvalidNumberOfPulseException extends Exception {

  @Override
  public String getMessage() {
    return "The number of pulse must be between 2 and 6";
  }
}
