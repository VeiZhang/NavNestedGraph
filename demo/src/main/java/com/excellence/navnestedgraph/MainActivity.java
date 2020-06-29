package com.excellence.navnestedgraph;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        Navigation.findNavController(this, R.id.nav_host_fragment)
                .setGraph(R.navigation.main_nav_graph);
    }
}