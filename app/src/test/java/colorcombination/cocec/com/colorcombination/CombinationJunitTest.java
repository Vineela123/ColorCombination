package colorcombination.codechallenge.com.codechallenge;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

import colorcombination.cocec.com.colorcombination.ActualCombinationClass;

/**
 * Created by Vineela on 5/20/2016.
 */
public class CombinationJunitTest {
    ActualCombinationClass acc;

    @Before
    public void Setup() {
        acc = new ActualCombinationClass();
    }

/*The method is used to validate if the given combination matches the actal combinations*/
    public boolean ValidateCombinationTest(ArrayList<String> randomCombinationList) {
        boolean isVlaid=false;
       Iterator<String> listIterator = acc.init().iterator();
        while (listIterator.hasNext()) {
            if (randomCombinationList.contains(listIterator.next())) {
              isVlaid=true;
            }
            else{
                isVlaid=false;
                break;
            }
        }
        return isVlaid;
}
    @Test
    public void RandomCombination(){
        ArrayList<String> randomCombination=new ArrayList<>();
        randomCombination.add("blue yellow");
        randomCombination.add("yellow red");
        randomCombination.add("red orange");
        randomCombination.add("orange black");
        randomCombination.add("blue green");
        randomCombination.add("yellow green");
        randomCombination.add("black green");
        randomCombination.add("red black");
        assertThat(ValidateCombinationTest(randomCombination), is(true));
    }
    @Test
    public void CorrectCombination(){
        ArrayList<String> randomCombination=new ArrayList<>();
        randomCombination.add("blue yellow");
        randomCombination.add("yellow red");
        randomCombination.add("red black");
        randomCombination.add("black green");
        ValidateCombinationTest(randomCombination);
        assertThat(ValidateCombinationTest(randomCombination), is(true));
    }
    @Test
    public void InCorrectCombination(){
        ArrayList<String> randomCombination=new ArrayList<>();
        randomCombination.add("blue yellow");
        randomCombination.add("yellow red");
        randomCombination.add("red orange");
        randomCombination.add("orange black");
        randomCombination.add("green yellow");
        ValidateCombinationTest(randomCombination);
        assertThat(ValidateCombinationTest(randomCombination), is(false));
    }
}
