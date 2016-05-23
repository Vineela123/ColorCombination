package colorcombination.cocec.com.colorcombination;


import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class BaseSecurityCombinationActivityFragment extends Fragment {
Activity activity;
    ArrayList<String> SelectedArray;
    Integer[] IDS=new Integer[]{R.id.image_1,R.id.image_2,R.id.image_3,R.id.image_4,R.id.image_5,R.id.image_6,R.id.image_7,R.id.image_8};
    int[] colors= new int[]{Color.BLUE,Color.YELLOW,Color.YELLOW,Color.RED,Color.RED,Color.BLACK,Color.BLACK,Color.parseColor("#228B22")};
    public BaseSecurityCombinationActivityFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_security_combination, container, false);
        Button colorButton= (Button) view.findViewById(R.id.selectColorCode);

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                SelectedArray = new ArrayList<String>();
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                String[] colorsOptions = new String[]{
                        "blue yellow", "blue red",
                        "red yellow", "Purple green",
                        "yellow red","black green",
                        "red black", "orange black",
                };
                final boolean[] checkedColors = new boolean[]{
                        false, false,false,false, false,false,false,false};

                final List<String> colorsList = Arrays.asList(colorsOptions);
                builder.setMultiChoiceItems(colorsOptions, checkedColors, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedColors[which] = isChecked;
                        String currentItem = colorsList.get(which);
                    }
                });
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedColors.length; i++) {
                            boolean checked = checkedColors[i];
                            if (checked) {
                                SelectedArray.add(colorsList.get(i));
                            }
                        }
                        boolean valid=ValidateCombinationTest(SelectedArray);
                        if (valid) {
                            Toast.makeText(activity, "Correct Combination " + Arrays.toString(new ActualCombinationClass().init().toArray()), Toast.LENGTH_LONG).show();

changeUI(valid,view);
                        } else {
                            Toast.makeText(activity, "Unable to unlock the system", Toast.LENGTH_LONG).show();
                            changeUI(valid, view);
                        }
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return view;
    }
    public void changeUI(boolean isValid,View view){
        for (int i = 0; i < IDS.length; i++) {
            if(isValid) {
                view.findViewById(IDS[i]).setBackgroundColor(colors[i]);
            }
            else{
                view.findViewById(IDS[i]).setBackgroundColor(android.R.color.transparent);
            }
        }
    }
    public boolean ValidateCombinationTest(ArrayList<String> randomCombinationList) {
boolean isValid=false;
        Iterator<String> listIterator = new ActualCombinationClass().init().iterator();
        while (listIterator.hasNext()) {
            if (randomCombinationList.contains(listIterator.next())) {
               isValid=true;
            }
            else{
             isValid=false;
                break;
            }
        }
        return isValid;
    }
}
