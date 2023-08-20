/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.*;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.android.navigation.databinding.ActivityMainBinding;

public class MainActivity extends  AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentManager fm = getSupportFragmentManager();
        NavHostFragment mNavigation = (NavHostFragment) fm.findFragmentById(R.id.myNavHostFragment);
        NavController mNavController = mNavigation.getNavController();
        NavigationUI.setupActionBarWithNavController(this, mNavController);
        NavigationUI.setupWithNavController(binding.navView, mNavController);
        mDrawerLayout = binding.drawerLayout;
        NavigationUI.setupActionBarWithNavController(this, mNavController, mDrawerLayout);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController mNavController = Navigation.findNavController(this, R.id.myNavHostFragment);
        return NavigationUI.navigateUp(mNavController, mDrawerLayout);
    }
}
