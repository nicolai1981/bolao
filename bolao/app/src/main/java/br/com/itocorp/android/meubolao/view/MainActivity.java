package br.com.itocorp.android.meubolao.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import br.com.itocorp.android.meubolao.R;
import br.com.itocorp.android.meubolao.databinding.NavHeaderMainBinding;
import br.com.itocorp.android.meubolao.viewmodel.AppVM;

import static br.com.itocorp.android.meubolao.model.AppModel.Log;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
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
        return true;
    }
}
