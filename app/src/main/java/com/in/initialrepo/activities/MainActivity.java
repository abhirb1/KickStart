package com.in.initialrepo.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.in.initialrepo.BaseApplication;
import com.in.initialrepo.R;
import com.in.initialrepo.utils.Logger;
import com.in.initialrepo.utils.WebServiceInterface;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Abhishek on 21/6/2015.
 */
public class MainActivity extends BaseActivity {

    // This is just an example to show you can inject webserviceinterface here too
    // as we have already implemented it in baseactivity so you can get it from there
    @Inject
    WebServiceInterface webServiceInterface;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication)getApplication()).getComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initUi();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initUi() {
        if(webServiceInterface != null) {
            Logger.i(TAG,"Inject successful");
        }
    }

}
