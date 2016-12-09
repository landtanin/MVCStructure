package com.landtanin.mvcstructure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.landtanin.mvcstructure.R;
import com.landtanin.mvcstructure.fragment.MainFragment;
import com.landtanin.mvcstructure.fragment.SecondFragment;
import com.landtanin.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        Toast.makeText(this, "Width = " + screenWidth, Toast.LENGTH_LONG).show();

        if (savedInstanceState == null) {
            // First Created
            // Place Fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,
                            MainFragment.newInstance(123),
                            "MainFragment")
                    .commit();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_second_fragment:

                Fragment fragment = getSupportFragmentManager()
                        .findFragmentById(R.id.contentContainer);

                if (fragment instanceof SecondFragment == false) {

                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right)
                            .replace(R.id.contentContainer, SecondFragment.newInstance())
                            .addToBackStack(null)
                            .commit();

                }

                Toast.makeText(this, "Second Fragment", Toast.LENGTH_SHORT).show();
                return true;

        }

        // Not handled
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (savedInstanceState == null) {

            MainFragment fragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setHelloText("Woooo");

        }
    }
}
