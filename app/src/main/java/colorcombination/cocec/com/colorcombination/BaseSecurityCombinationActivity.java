package colorcombination.cocec.com.colorcombination;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
/**
 * The Base activity holding the fragment**/
public class BaseSecurityCombinationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_combination);
        addFragment();

    }
    public void addFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //add a fragment
        BaseSecurityCombinationActivityFragment myFragment = new BaseSecurityCombinationActivityFragment();
        fragmentTransaction.add(R.id.fragmentlayout, myFragment);
        fragmentTransaction.commit();
    }

}
