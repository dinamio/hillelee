package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by eugen on 7/27/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple {

    String color;

    Integer weight;

    public boolean isRedAndHeavy() {
        return color.equals("red") && weight >250;
    }
}
