package br.com.itocorp.android.meubolao.view;

<<<<<<< HEAD
import android.databinding.DataBindingUtil;
=======
>>>>>>> 11b940205fc7f0a6ca4da186e3ec643b75af07a1
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
<<<<<<< HEAD
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
=======
>>>>>>> 11b940205fc7f0a6ca4da186e3ec643b75af07a1
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import br.com.itocorp.android.meubolao.R;
<<<<<<< HEAD
import br.com.itocorp.android.meubolao.databinding.NavHeaderMainBinding;
import br.com.itocorp.android.meubolao.viewmodel.AppVM;

import static br.com.itocorp.android.meubolao.model.AppModel.Log;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private FragmentManager mFragmentManager;
=======

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
>>>>>>> 11b940205fc7f0a6ca4da186e3ec643b75af07a1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        mFragmentManager = getSupportFragmentManager();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        NavHeaderMainBinding binding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_main, navigationView, false);
        binding.setUser(AppVM.getInstance().getUser());
        navigationView.addHeaderView(binding.getRoot());
        navigationView.removeHeaderView(navigationView.getHeaderView(0));

=======
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

>>>>>>> 11b940205fc7f0a6ca4da186e3ec643b75af07a1
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
<<<<<<< HEAD
=======

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
>>>>>>> 11b940205fc7f0a6ca4da186e3ec643b75af07a1
    }

    @Override
    public void onBackPressed() {
<<<<<<< HEAD
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
=======
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
>>>>>>> 11b940205fc7f0a6ca4da186e3ec643b75af07a1
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
<<<<<<< HEAD
        FragmentTransaction ft;

        switch (item.getItemId()) {
            case R.id.nav_camera:
                ft = mFragmentManager.beginTransaction();
                ft.replace(R.id.fragment_container, new BetFragment());
                ft.commit();
                break;
            case R.id.nav_gallery:
                ft = mFragmentManager.beginTransaction();
                ft.replace(R.id.fragment_container, new GroupFragment());
                ft.commit();
                break;
            case R.id.nav_slideshow:
                ft = mFragmentManager.beginTransaction();
                ft.replace(R.id.fragment_container, new TournamentFragment());
                ft.commit();
                break;
            case R.id.nav_logout:
                AppVM.getInstance().logout();
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
=======
        switch (item.getItemId()) {
            case R.id.nav_logout:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
>>>>>>> 11b940205fc7f0a6ca4da186e3ec643b75af07a1
        return true;
    }
}
