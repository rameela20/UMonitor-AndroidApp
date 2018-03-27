package com.ram.umonitor.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ram.umonitor.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_multiple_choice;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Examination.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Examination#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Examination extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    DatabaseReference mExRef;

    private OnFragmentInteractionListener mListener;
    List<String> list=new ArrayList<String>();

    public Examination() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment History.
     */
    // TODO: Rename and change types and number of parameters
    public static Examination newInstance(String param1, String param2) {
        Examination fragment = new Examination();
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
        mExRef= FirebaseDatabase.getInstance().getReference("examinations");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_examination, container, false);

        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction(Uri.parse("Examination"));
        }

        // Here we will can create click listners etc for all the gui elements on the fragment.
        // For eg: Button btn1= (Button) view.findViewById(R.id.frag1_btn1);
        // btn1.setOnclickListener(...
        Button btnAdd= (Button) view.findViewById(R.id.addBtn);
        btnAdd.setOnClickListener(new Button.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {
                String spinText=((Spinner)view.findViewById(R.id.typeSpinner)).getSelectedItem().toString();
                String editText=((EditText)view.findViewById(R.id.descEdit)).getText().toString();
                String item=spinText+"-"+editText;
                list.add(item);
                ListView lv= (ListView) view.findViewById(R.id.examinationlistView);
                ListAdapter adapter=new ArrayAdapter<String>(getActivity().getApplicationContext(),simple_list_item_multiple_choice,list);
                lv.setAdapter(adapter);


            }
        });
        ListView showList= (ListView) view.findViewById(R.id.examinationlistView);
        showList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // change the checkbox state
                CheckedTextView checkedTextView = ((CheckedTextView)view);
                checkedTextView.setChecked(!checkedTextView.isChecked());
            }
        });
        Button btnDelete= (Button) view.findViewById(R.id.removeSelectedBtn);
        btnDelete.setOnClickListener(new Button.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity().getApplicationContext(),
                        "Patient Examined",
                        Toast.LENGTH_LONG).show();

                ListView lv= (ListView) view.findViewById(R.id.examinationlistView);
                int itemCount = lv.getCount();

                for(int i=itemCount-1; i >= 0; i--){

                    list.clear();

                }


                ListAdapter adapter=new ArrayAdapter<String>(getActivity().getApplicationContext(),simple_list_item_multiple_choice,list);
                lv.setAdapter(adapter);

                EditText descText= (EditText) view.findViewById(R.id.descEdit);
                descText.setText("");

            }
        });
        Button btnSave= (Button) view.findViewById(R.id.saveBtn);

        btnSave.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity().getApplicationContext(),
                        "Examinations saved",
                        Toast.LENGTH_LONG).show();
                ListView lv= (ListView) view.findViewById(R.id.examinationlistView);
                int itemCount = lv.getCount();
                ArrayAdapter<String> adapter=((ArrayAdapter<String>)lv.getAdapter());

                for(int i=0; i < adapter.getCount(); i++){
                    com.ram.umonitor.model.Examination examination=new com.ram.umonitor.model.Examination();
                    examination.setExDesc(adapter.getItem(i).toString());
                    examination.setBedNo(9);
                    examination.setBedStatus("Current");
                    examination.setExType(examination.getExDesc());

                    String key=mExRef.push().getKey();
                    mExRef.child(key).setValue(examination);



                }
                adapter.clear();

                ListAdapter adapter1=new ArrayAdapter<String>(getActivity().getApplicationContext(),simple_list_item_multiple_choice,list);
                lv.setAdapter(adapter1);

                EditText descText= (EditText) view.findViewById(R.id.descEdit);
                descText.setText("");




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
