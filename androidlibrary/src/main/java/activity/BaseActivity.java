package activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public abstract  class BaseActivity extends Activity {
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        initVariables();
        initViews(savedInstanceState);
        loadData();
    }

    protected abstract void loadData() ;

    protected abstract void initVariables() ;

    protected abstract void initViews(Bundle saveInstanceState);


}
