package com.project.sonnguyen.alden.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.sonnguyen.alden.R;
import com.project.sonnguyen.alden.data.StudentInformation;

import static com.project.sonnguyen.alden.activity.LoginActivity.code;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudentInforFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentInforFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView txtName, txtBithday, txtClassName, txtTeacherName, txtParentName, txtParentNumber, txtNumOfClass;
    private FloatingActionButton fabCall;
    private ImageView imgAvatar;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private StudentInformation studentInformation;

    public StudentInforFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentInforFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentInforFragment newInstance(String param1, String param2) {
        StudentInforFragment fragment = new StudentInforFragment();
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
        View v = inflater.inflate(R.layout.fragment_student_infor, container, false);
        //create component
        txtBithday = (TextView) v.findViewById(R.id.frag_student_infor_txt_bithday);
        txtClassName = (TextView) v.findViewById(R.id.frag_student_infor_txt_classname);
        txtName = (TextView) v.findViewById(R.id.frag_student_infor_txt_studentname);
        txtNumOfClass = (TextView) v.findViewById(R.id.frag_student_infor_txt_num_of_class);
        txtParentName = (TextView) v.findViewById(R.id.frag_student_infor_txt_parentname);
        txtParentNumber = (TextView) v.findViewById(R.id.frag_student_infor_txt_parentnumber);
        txtTeacherName = (TextView) v.findViewById(R.id.frag_student_infor_txt_teachername);
        fabCall = (FloatingActionButton) v.findViewById(R.id.frag_student_infor_fab_call);
        imgAvatar = (ImageView) v.findViewById(R.id.frag_student_infor_img_avatar);
        //get data
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        //get student information
        studentInformation = new StudentInformation();
        mRef.child("StudentInformation").child(code).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                studentInformation = dataSnapshot.getValue(StudentInformation.class);
                studentInformation.setStudentcode(dataSnapshot.getKey());
                txtTeacherName.setText(studentInformation.getTeacher());
                txtParentNumber.setText(studentInformation.getParentnumber());
                txtParentName.setText(studentInformation.getParentname());
                txtNumOfClass.setText("" + studentInformation.getNumofclass());
                txtBithday.setText(studentInformation.getBithday());
                txtName.setText(studentInformation.getName());
                txtClassName.setText(studentInformation.getClassname());
                Glide.with(getContext()).load(studentInformation.getAvatarurl()).into(imgAvatar);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        fabCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + studentInformation.getTeachernumber()));
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                getContext().startActivity(intent);
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
