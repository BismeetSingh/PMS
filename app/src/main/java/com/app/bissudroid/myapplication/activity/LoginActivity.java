package com.app.bissudroid.myapplication.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.app.bissudroid.myapplication.R;
import com.app.bissudroid.myapplication.databinding.ActivityLoginBinding;
import com.app.bissudroid.myapplication.factory.LoginFactory;
import com.app.bissudroid.myapplication.utils.SessionManager;
import com.app.bissudroid.myapplication.viewmodel.LoginViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import timber.log.Timber;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding activityLoginBinding;
    int a;

    @Inject
    SessionManager sessionManager;
    @Inject
    LoginFactory loginFactory;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, loginFactory).get(LoginViewModel.class);

        activityLoginBinding.btnLogin.setOnClickListener((view -> {
            String email = activityLoginBinding.inputEmail.getText().toString();
            String password = activityLoginBinding.inputPassword.getText().toString();
            loginViewModel.login(email, password).observe(this, s -> {
//                Timber.d(s);
                if (s!=null && s == 1) {
                    sessionManager.saveLoggedInState(true);
                    startActivity(new Intent(LoginActivity.this, NavigationActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Error while logging in" + s, Toast.LENGTH_SHORT).show();
                }
            });
        }));


    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d(getIntent().toString());
        Timber.d(String.valueOf(sessionManager.isLoggedIn()));
        if (getIntent().getExtras() == null && sessionManager.isLoggedIn()) {
            startActivity(new Intent(LoginActivity.this, NavigationActivity.class));
            finish();
        } else if (getIntent() != null && sessionManager.isLoggedIn()) {

            sessionManager.saveLoggedInState(false);


        }


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}






