package com.ram.umonitor.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ram.umonitor.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FollowUp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FollowUp extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FollowUp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Assessment.
     */
    // TODO: Rename and change types and number of parameters
    public static FollowUp newInstance(String param1, String param2) {
        FollowUp fragment = new FollowUp();
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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_follow_up, container, false);

        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction(Uri.parse("Follow Up"));
        }

        // Here we will can create click listners etc for all the gui elements on the fragment.
        // For eg: Button btn1= (Button) view.findViewById(R.id.frag1_btn1);
        // btn1.setOnclickListener(...
        Button btnDis = (Button) view.findViewById(R.id.dischargeButton);
        btnDis.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity().getApplicationContext(),
                        "Patient Discharged",
                        Toast.LENGTH_LONG).show();


            }
        });
        Button btnAdmit= (Button) view.findViewById(R.id.admitButton);
        btnAdmit.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity().getApplicationContext(),
                        "Patient Admitted",
                        Toast.LENGTH_LONG).show();



            }
        });
        Button btnLeave= (Button) view.findViewById(R.id.leaveButton);
        btnLeave.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity().getApplicationContext(),
                        "Patient Left Against",
                        Toast.LENGTH_LONG).show();



            }
        });
        Button btnTransfer= (Button) view.findViewById(R.id.transferButton);
        btnTransfer.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity().getApplicationContext(),
                        "Patient Transfered",
                        Toast.LENGTH_LONG).show();



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
}
