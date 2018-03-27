package com.ram.umonitor.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ram.umonitor.R;
import com.ram.umonitor.model.InitAssessment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InitialAssessment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InitialAssessment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    DatabaseReference mRef;
    /*Handler hand = new Handler();
    Button clickme;
    TextView timer;*/


    //Read more: http://mrbool.com/how-to-implement-multi-threading-in-android-with-handler-class/28175#ixzz4fLJJRmLo


    public InitialAssessment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InitialAssessment.
     */
    // TODO: Rename and change types and number of parameters
    public static InitialAssessment newInstance(String param1, String param2) {
        InitialAssessment fragment = new InitialAssessment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mRef= FirebaseDatabase.getInstance().getReference("initAssess");


        //Read more: http://mrbool.com/how-to-implement-multi-threading-in-android-with-handler-class/28175#ixzz4fLJTTmVb



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_initial_assessment, container, false);

        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction(Uri.parse("Initial Assessment"));
        }

       /* timer = (TextView) getActivity().findViewById(R.id.temperatureText);
        clickme = (Button) getActivity().findViewById(R.id.saveButton);
        hand.postDelayed(run, 1000); */

        // Here we will can create click listners etc for all the gui elements on the fragment.
        // For eg: Button btn1= (Button) view.findViewById(R.id.frag1_btn1);
        // btn1.setOnclickListener(...

        View.OnKeyListener keyListener = new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    //do something here
                    TextView textView=(TextView)view.findViewById(R.id.gcsValueText);
                    textView.setText("");
                    textView.setText(Double.parseDouble(((EditText)view.findViewById(R.id.eyeText)).getText().toString())+
                            Double.parseDouble(((EditText)view.findViewById(R.id.verbalText)).getText().toString())+
                            Double.parseDouble(((EditText)view.findViewById(R.id.motorText)).getText().toString())+"/15");
                }
                return false;
            }
        };

        EditText textGCS=(EditText)view.findViewById(R.id.motorText);
        textGCS.setOnKeyListener(keyListener);
        Button btnSave= (Button) view.findViewById(R.id.saveButton);
        btnSave.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                InitAssessment initAssessment=new InitAssessment();

                double eye= Double.parseDouble(((EditText)view.findViewById(R.id.eyeText)).getText().toString());
                double verbal= Double.parseDouble(((EditText)view.findViewById(R.id.verbalText)).getText().toString());
                double motor= Double.parseDouble(((EditText)view.findViewById(R.id.motorText)).getText().toString());
                String hydration=((Spinner)view.findViewById(R.id.hydrationSpinner)).getSelectedItem().toString();
                String key=mRef.push().getKey();
                initAssessment.setInAsID(key);
                initAssessment.setEye(eye);
                initAssessment.setVerbal(verbal);
                initAssessment.setMotor(motor);
                initAssessment.setHydration(hydration);
                mRef.child(key).setValue(initAssessment);

                Toast.makeText(getActivity().getApplicationContext(),
                        "Patient Assessed",
                        Toast.LENGTH_LONG).show();



            }
        });
        Button btnBack= (Button) view.findViewById(R.id.cancelButton);
        btnBack.setOnClickListener(new Button.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFrame, new Home());
                ft.commit();
            }
        });
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

  /*  Runnable run = new Runnable() {
        @Override
        public void run() {
            updateTime();

        }
    };

    public void updateTime() {
        timer.setText("" + (Integer.parseInt(timer.getText().toString()) - 1));
        if (Integer.parseInt(timer.getText().toString()) == 0) {
            clickme.setVisibility(0);
        } else {
            hand.postDelayed(run, 1000);
        }
    }*/


   // Read more: http://mrbool.com/how-to-implement-multi-threading-in-android-with-handler-class/28175#ixzz4fLGt4dMN

}
