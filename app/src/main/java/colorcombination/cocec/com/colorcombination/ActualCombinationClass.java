package colorcombination.cocec.com.colorcombination;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Vineela on 5/20/2016.
 */
public class ActualCombinationClass {

    public ArrayList<String> init() {
        ArrayList<String> SuccessCombinationList=new ArrayList<>();
        SuccessCombinationList.add("blue yellow");
        SuccessCombinationList.add("yellow red");
        SuccessCombinationList.add("red black");
        SuccessCombinationList.add("black green");


        return SuccessCombinationList;
    }

    public ArrayList<String> SelectedOptions(ArrayList<String> SelectedList) {
        return SelectedList;
    }

}
