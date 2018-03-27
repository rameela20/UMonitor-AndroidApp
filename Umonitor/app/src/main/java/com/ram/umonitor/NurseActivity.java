package com.ram.umonitor;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ram.umonitor.fragments.AssessmentNurse;
import com.ram.umonitor.fragments.Home;
import com.ram.umonitor.fragments.InitialAssessment;
import com.ram.umonitor.fragments.PeriodicalAssessment;
import com.ram.umonitor.fragments.TreatmentHistory;
import com.ram.umonitor.fragments.TreatmentManagement;
import com.ram.umonitor.fragments.TreatmentManagementNurse;

public class NurseActivity extends AppCompatActivity
        implements
        Home.OnFragmentInteractionListener,
        AssessmentNurse.OnFragmentInteractionListener,
        InitialAssessment.OnFragmentInteractionListener,
        PeriodicalAssessment.OnFragmentInteractionListener,
        TreatmentManagement.OnFragmentInteractionListener,
        TreatmentHistory.OnFragmentInteractionListener,
        TreatmentManagementNurse.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_nurse);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_nurse);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_nurse);
        navigationView.setNavigationItemSelectedListener(this);
        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.nav_home_nurse);

        //NOTE:  Open fragment1 initially.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrameNurse, new Home());
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_nurse);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nurse, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_nurse) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //NOTE: creating fragment object
        Fragment fragment = null;
        if (id == R.id.nav_home_nurse) {
            // Handle the camera action
            fragment=new Home();

        } else if (id == R.id.nav_assessment_nurse) {
            try {
                fragment = new AssessmentNurse();
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (id == R.id.nav_treatment_nurse) {
            fragment=TreatmentManagementNurse.newInstance();

        }else if(id==R.id.nav_summary_nurse){
            fragment=TreatmentManagement.newInstance();
        }
        //NOTE: Fragment changing code
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrameNurse, fragment);
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_nurse);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // NOTE:  Code to replace the toolbar title based current visible fragment
        getSupportActionBar().setTitle(uri.toString());
    }

    public void showInitAssess()
    {
        try {
            /*FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrameNurse, new InitialAssessment());
            ft.commit();*/
        }catch (Exception er){
            er.printStackTrace();
        }
    }

}
