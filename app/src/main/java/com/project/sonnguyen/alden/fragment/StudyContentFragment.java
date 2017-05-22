package com.project.sonnguyen.alden.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.project.sonnguyen.alden.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudyContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudyContentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StudyContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudyContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudyContentFragment newInstance(String param1, String param2) {
        StudyContentFragment fragment = new StudyContentFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_study_content, container, false);
        ListView listView = (ListView) v.findViewById(R.id.frag_study_content_listview);
        ArrayList<String> weekList = new ArrayList<>();
        ArrayList<String> ContentList = new ArrayList<>();
        weekList.add("Tuần 1(từ 1/6/2017 - 7/6/2017)");

        weekList.add("Tuần 2(từ 8/6/2017 - 14/6/2017)");

        weekList.add("Tuần 3(từ 15/6/2017 - 21/6/2017)");

        weekList.add("Tuần 4(từ 22/6/2017 - 28/6/2017)");
        weekList.add("Tuần 5(từ 29/6/2017 - 4/7/2017)");
        weekList.add("Tuần 6(từ 5/7/2017 - 11/7/2017)");
        weekList.add("Tuần 7(từ 12/7/2017 - 18/7/2017)");
        weekList.add("Tuần 8(từ 19/7/2017 - 25/7/2017)");
        weekList.add("Tuần 9(từ 26/7/2017 - 2/8/2017)");
        weekList.add("Tuần 10(từ 3/8/2017 - 9/8/2017)");
        weekList.add("Tuần 11(từ 10/8/2017 - 16/8/2017)");
        weekList.add("Tuần 12(từ 17/8/2017 - 23/8/2017)");
//        for(int i = 1;i<=12;i++){
//            weekList.add("Tuần "+ i);
//        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,weekList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                builder1.setMessage("Làm quen với trẻ.");
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

        return v;
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
