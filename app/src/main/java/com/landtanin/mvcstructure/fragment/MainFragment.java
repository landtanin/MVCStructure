package com.landtanin.mvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.landtanin.mvcstructure.R;

/**
 * Created by landtanin on 11/6/2016 AD.
 */

public class MainFragment extends Fragment {

    int someVar;

    TextView tvHello;

    public static MainFragment newInstance(int someVar) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("someVar", someVar);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstance(rootView);

        return rootView;

//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initInstance(View rootView) {

        tvHello = (TextView) rootView.findViewById(R.id.tvHello);

    }

    public void setHelloText(String text) {

        tvHello.setText(text);

    }
}
