package com.app.bissudroid.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.bissudroid.myapplication.R;
import com.app.bissudroid.myapplication.utils.SessionManager;

import javax.inject.Inject;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import dagger.android.AndroidInjection;
import timber.log.Timber;

//import android.support.design.widget.NavigationView;

public class NavigationActivity extends AppCompatActivity  {

    NavController navController;
    @Inject
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        navController = Navigation.findNavController(this, R.id.nav_fragment);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        navController=Navigation.findNavController()

        NavigationView navigationView = findViewById(R.id.nav_view);

        NavigationUI.setupWithNavController(navigationView,navController);
        Navigation.findNavController(this, R.id.nav_fragment).addOnNavigatedListener((controller, destination) -> {

            switch (destination.getId()) {
                case R.id.home:
                    toolbar.setTitle("Home");
                    break;
                case R.id.salesReports:
                    toolbar.setTitle("Sales Reports");
                    break;
                case R.id.previousOrderFragment:
                    toolbar.setTitle("Previous Orders");
                    break;
                case R.id.submitIssueFragment:
                    toolbar.setTitle("Submit Issue");
                    break;
                case R.id.aboutDevelopersFragment:
                    toolbar.setTitle("About Developers");
                    break;
                    




            }
        });
//        NavigationUI.setupWithNavController(toolbar,navController);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);


        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            if (Navigation.findNavController(this, R.id.nav_fragment).getCurrentDestination().getId() == R.id.home) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NavigationActivity.this);
                builder.setMessage("Exit?").setTitle("Are you sure").setPositiveButton("Yes", (dialogInterface, i) -> NavigationActivity.super.onBackPressed()).setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss());
                AlertDialog dialog = builder.create();
                dialog.show();

            } else {
                super.onBackPressed();
            }
        }

    }


    @Override
    public boolean onSupportNavigateUp() {

        return Navigation.findNavController(this, R.id.nav_fragment).navigateUp();
    }


}
