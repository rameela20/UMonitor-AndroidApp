package com.ram.umonitor;

import android.content.Intent;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ram.umonitor.fragments.Allergy;
import com.ram.umonitor.fragments.Assessment;
import com.ram.umonitor.fragments.ConsultantFeedback;
import com.ram.umonitor.fragments.Examination;
import com.ram.umonitor.fragments.FollowUp;
import com.ram.umonitor.fragments.History;
import com.ram.umonitor.fragments.Home;
import com.ram.umonitor.fragments.InitialAssessment;
import com.ram.umonitor.fragments.Investigation;
import com.ram.umonitor.fragments.InvestigationRequest;
import com.ram.umonitor.fragments.NotificationFragment;
import com.ram.umonitor.fragments.PeriodicalAssessment;
import com.ram.umonitor.fragments.TestResults;
import com.ram.umonitor.fragments.Treatment;
import com.ram.umonitor.fragments.TreatmentManagement;
import com.ram.umonitor.fragments.ViewPeriodChart;
import com.ram.umonitor.service.NotificationService;

public class MOActivity extends AppCompatActivity
        implements
        Home.OnFragmentInteractionListener,
        Assessment.OnFragmentInteractionListener,
        InitialAssessment.OnFragmentInteractionListener,
        PeriodicalAssessment.OnFragmentInteractionListener,
        History.OnFragmentInteractionListener,
        Allergy.OnFragmentInteractionListener,
        Examination.OnFragmentInteractionListener,
        Investigation.OnFragmentInteractionListener,
        InvestigationRequest.OnFragmentInteractionListener,
        TestResults.OnFragmentInteractionListener,
        ConsultantFeedback.OnFragmentInteractionListener,
        Treatment.OnFragmentInteractionListener,
        FollowUp.OnFragmentInteractionListener,
        ViewPeriodChart.OnFragmentInteractionListener,
        TreatmentManagement.OnFragmentInteractionListener,
        NotificationFragment.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.nav_home);

        //NOTE:  Open fragment1 initially.
       getPatients();
        Intent intent = new Intent(this, NotificationService.class);
        startService(intent);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
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
        if (id == R.id.nav_home) {
            // Handle the camera action
            getPatients();

        } else if (id == R.id.nav_assessment) {
            fragment=new Assessment();

        } else if (id == R.id.nav_history) {
            fragment=new History();
        } else if (id == R.id.nav_allergies) {
            fragment=new Allergy();
        } else if (id == R.id.nav_examination) {
            fragment=new Examination();
        } else if (id == R.id.nav_investigation) {
            fragment=Investigation.newInstance();
        }else if(id==R.id.nav_testresults){
            fragment=new TestResults();
        }else if(id==R.id.nav_feedback){
            fragment=NotificationFragment.newInstance();
        }else if(id==R.id.nav_treatment){
            fragment=new Treatment();
        }else if(id==R.id.nav_followup){
            fragment=new FollowUp();
        }else if(id==R.id.nav_summary){
            fragment= TreatmentManagement.newInstance();
        }
        //NOTE: Fragment changing code
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new InitialAssessment());
            ft.commit();
        }catch (Exception er){
            er.printStackTrace();
        }
    }

    public void getPatients(){
        Log.w(" called ","getPatients()");


               Fragment frag = Home.newInstance();


                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainFrame, frag);//have to select the first fragment
                transaction.commitAllowingStateLoss();





    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, NotificationService.class));
        super.onDestroy();
    }
}
