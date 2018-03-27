package com.ram.umonitor.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ram.umonitor.R;
import com.ram.umonitor.adapters.NotificationFragmentAdapter;
import com.ram.umonitor.model.Notification;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PeriodicalAssessment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PeriodicalAssessment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    RecyclerView periodAssessView ;
    List<Notification> periodAssessList;
    private NotificationFragmentAdapter mAssessAdapter;
    private DatabaseReference mDatabaseRef;
    private DatabaseReference childRef;




    private OnFragmentInteractionListener mListener;



    public NotificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PeriodicalAssessment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationFragment newInstance() {
        NotificationFragment fragment=new NotificationFragment();
        Bundle args = new Bundle();
        //fragment.setPeriodAssessList(periodAssessList);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.notification, container, false);

        if (mListener != null) {
            mListener.onFragmentInteraction(Uri.parse("Notifications"));
        }

        // Here we will can create click listners etc for all the gui elements on the fragment.
        // For eg: Button btn1= (Button) view.findViewById(R.id.frag1_btn1);
        // btn1.setOnclickListener(...
        periodAssessView = (RecyclerView) view.findViewById(R.id.rv_notify);
        periodAssessView.setLayoutManager(new LinearLayoutManager(getContext()));
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        childRef = mDatabaseRef.child("notifications");
        mAssessAdapter = new NotificationFragmentAdapter(Notification.class, R.layout.notification_row, childRef, getContext());
        periodAssessView.setAdapter(mAssessAdapter);
        periodAssessView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
