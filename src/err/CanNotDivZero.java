package err;

/**
 * Created by jukzhang on 10/7/16.
 */
public class CanNotDivZero extends Exception {
    public CanNotDivZero(){}

    public CanNotDivZero(String message){
        super(message);
    }
}
