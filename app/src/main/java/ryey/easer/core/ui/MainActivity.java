/*
 * Copyright (c) 2016 - 2018 Rui Zhao <renyuneyun@gmail.com>
 *
 * This file is part of Easer.
 *
 * Easer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Easer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Easer.  If not, see <http://www.gnu.org/licenses/>.
 */

package ryey.easer.core.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.navigation.NavigationView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import ryey.easer.R;
import ryey.easer.core.data.storage.StorageHelper;
import ryey.easer.core.ui.data.ConditionListFragment;
import ryey.easer.core.ui.data.EventListFragment;
import ryey.easer.core.ui.data.ProfileListFragment;
import ryey.easer.core.ui.data.ScriptListFragment;
import ryey.easer.core.ui.setting.SettingsActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private static final String FRAGMENT_OUTLINE = "ryey.easer.FRAGMENT.OUTLINE";
    private static final String FRAGMENT_PROFILE = "ryey.easer.FRAGMENT.PROFILE";
    private static final String FRAGMENT_SCRIPT = "ryey.easer.FRAGMENT.SCRIPT";
    private static final String FRAGMENT_SCENARIO = "ryey.easer.FRAGMENT.SCENARIO";
    private static final String FRAGMENT_CONDITION = "ryey.easer.FRAGMENT.CONDITION";
    private static final String FRAGMENT_LOG = "ryey.easer.FRAGMENT.LOG";

    private static final NavTag navTag = new NavTag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null){
            navigationView.setCheckedItem(R.id.nav_outline);
            Fragment fragment = new OutlineFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_main, fragment, FRAGMENT_OUTLINE)
                    .commit();
        }

        // Show Welcome page at first launch
        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean(getString(R.string.key_pref_welcome), true)) {
            ((TextView) new AlertDialog.Builder(this)
                    .setTitle(R.string.title_welcome_message)
                    .setMessage(R.string.welcome_message)
                    .setPositiveButton(R.string.button_understand, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            PreferenceManager.getDefaultSharedPreferences(MainActivity.this)
                                    .edit()
                                    .putBoolean(getString(R.string.key_pref_welcome), false)
                                    .apply();
                        }
                    })
                    .setNegativeButton(R.string.button_read_next_time, null)
                    .show()
                    .findViewById(android.R.id.message))
                    .setMovementMethod(LinkMovementMethod.getInstance());
        }

        if (StorageHelper.hasOldData(this)) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.alert_update_storage_data_title)
                    .setMessage(R.string.alert_update_storage_data)
                    .setPositiveButton(R.string.button_understand, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        }

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            getSupportFragmentManager().popBackStack(0, 0); // The -1'st is the Outline. We rely on super.onBackPressed() to pop the 0th.
            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setCheckedItem(R.id.nav_outline);
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        changeUIView(id);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void changeUIView(@IdRes int id) {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment;
        String tag = navTag.findTag(id);
        String bs_tag = tag;

        if (id == R.id.nav_outline) {
            fragment = manager.findFragmentByTag(tag);
            if (fragment == null)
                fragment = new OutlineFragment();
            manager.beginTransaction()
                    .replace(R.id.content_main, fragment, tag)
                    .addToBackStack(bs_tag)
                    .commit();
        } else if (id == R.id.nav_profile) {
            fragment = manager.findFragmentByTag(tag);
            if (fragment == null)
                fragment = new ProfileListFragment();
            manager.beginTransaction()
                    .replace(R.id.content_main, fragment, tag)
                    .addToBackStack(bs_tag)
                    .commit();
        } else if (id == R.id.nav_script) {
            fragment = manager.findFragmentByTag(tag);
            if (fragment == null)
                fragment = new ScriptListFragment();
            manager.beginTransaction()
                    .replace(R.id.content_main, fragment, tag)
                    .addToBackStack(bs_tag)
                    .commit();
        } else if (id == R.id.nav_scenario) {
            fragment = manager.findFragmentByTag(tag);
            if (fragment == null)
                fragment = new EventListFragment();
            manager.beginTransaction()
                    .replace(R.id.content_main, fragment, tag)
                    .addToBackStack(bs_tag)
                    .commit();
        } else if (id == R.id.nav_condition) {
            fragment = manager.findFragmentByTag(tag);
            if (fragment == null)
                fragment = new ConditionListFragment();
            manager.beginTransaction()
                    .replace(R.id.content_main, fragment, tag)
                    .addToBackStack(bs_tag)
                    .commit();
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_log) {
            fragment = manager.findFragmentByTag(tag);
            if (fragment == null)
                fragment = ActivityLogFragment.full();
            manager.beginTransaction()
                    .replace(R.id.content_main, fragment, tag)
                    .addToBackStack(bs_tag)
                    .commit();
        }
    }

    private static class NavTag {
        private static final int[] nav_ids = {
                R.id.nav_outline,
                R.id.nav_script,
                R.id.nav_profile,
                R.id.nav_scenario,
                R.id.nav_condition,
                R.id.nav_log,
        };
        private static final String[] fragment_tags = {
                FRAGMENT_OUTLINE,
                FRAGMENT_SCRIPT,
                FRAGMENT_PROFILE,
                FRAGMENT_SCENARIO,
                FRAGMENT_CONDITION,
                FRAGMENT_LOG,
        };

        private @Nullable Integer findId(String tag) {
            for (int i = 0; i < nav_ids.length; i++) {
                if (tag.equals(fragment_tags[i]))
                    return nav_ids[i];
            }
            return null;
        }
        private @Nullable String findTag(int id) {
            for (int i = 0; i < fragment_tags.length; i++) {
                if (id == nav_ids[i])
                    return fragment_tags[i];
            }
            return null;
        }
    }
}
