package com.landtanin.mvcstructure.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.landtanin.mvcstructure.R;
import com.landtanin.mvcstructure.fragment.MainFragment;
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
                    .add(R.id.contentContainer, new MainFragment())
                    .commit();


        }

    }
}
