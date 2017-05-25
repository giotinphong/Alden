package com.project.sonnguyen.alden.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.sonnguyen.alden.R;
import com.project.sonnguyen.alden.data.ClassStatic;
import com.project.sonnguyen.alden.data.StudentInformation;

import java.util.ArrayList;
import java.util.List;

import ernestoyaquello.com.verticalstepperform.VerticalStepperFormLayout;
import ernestoyaquello.com.verticalstepperform.interfaces.VerticalStepperForm;
import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;

import static android.R.attr.data;
import static com.project.sonnguyen.alden.LoginActivity.code;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudentResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentResultFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RoundCornerProgressBar pbStated,pbRightStated,pbHomework,pbStar;
    private TextView txtStated,txtRightStated,txtHomework,txtStar,txtWeek;
    private OnFragmentInteractionListener mListener;
    private String ClassName;
    private ColumnChartView chartView;
    private ColumnChartData chartData;

    public StudentResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentResultFragment newInstance(String param1, String param2) {
        StudentResultFragment fragment = new StudentResultFragment();
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
        View v  =  inflater.inflate(R.layout.fragment_student_result, container, false);
        pbHomework = (RoundCornerProgressBar)v.findViewById(R.id.frag_student_result_process_homework);
        pbRightStated = (RoundCornerProgressBar)v.findViewById(R.id.frag_student_result_process_rightstated);
        pbStar = (RoundCornerProgressBar)v.findViewById(R.id.frag_student_result_process_star);
        pbStated = (RoundCornerProgressBar)v.findViewById(R.id.frag_student_result_process_stated);
        txtHomework = (TextView)v.findViewById(R.id.frag_student_result_txt_homework);
        txtRightStated = (TextView)v.findViewById(R.id.frag_student_result_txt_rightstated);
        txtStar = (TextView)v.findViewById(R.id.frag_student_result_txt_star);
        txtStated = (TextView)v.findViewById(R.id.frag_student_result_txt_stated);
        txtWeek = (TextView)v.findViewById(R.id.frag_student_result_txt_week);
         chartView = (ColumnChartView)v.findViewById(R.id.chart);
         chartData = new ColumnChartData();
        //generateDefaultData();
        final ArrayList<Integer> classStaticArrayList = new ArrayList<>();
        for(int i = 1;i<=12;i++)
            classStaticArrayList.add(i);

        final ArrayList<ClassStatic> staticArrayList = new ArrayList<>();
        final DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
         ClassName = "";
        mRef.child("StudentInformation").child(code).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                StudentInformation studentInformation = dataSnapshot.getValue(StudentInformation.class);
                ClassName = studentInformation.getClassname();
                for(final int classWeek : classStaticArrayList)
                mRef.child("Class").child(ClassName).child("Tuan"+classWeek).child(code).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ClassStatic classStatic = dataSnapshot.getValue(ClassStatic.class);
                        //classStatic.setStudentcode(code);
                        if(classStatic!=null) {
                            classStatic.setWeeks(classWeek);
                            staticArrayList.add(classStatic);
                            pbStated.setProgress(classStatic.getNumstated());
                            pbStar.setProgress(classStatic.getStar());
                            pbRightStated.setProgress(classStatic.getNumofrightstated());
                            pbHomework.setProgress(classStatic.getHomework());
                            txtStated.setText(classStatic.getNumstated() + " lần ");
                            txtStar.setText(classStatic.getStar() + " sao");
                            txtRightStated.setText(classStatic.getNumofrightstated() + " lần");
                            txtHomework.setText(classStatic.getHomework() + " lần");
                            generateDefaultData(staticArrayList);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
    private void generateDefaultData(final ArrayList<ClassStatic> classStatic) {
        int numSubcolumns = 1;
        int numColumns = 12;
        // Column can have many subcolumns, here by default I use 1 subcolumn in each of 8 columns.
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        values = new ArrayList<SubcolumnValue>();
        Column column = new Column(values);
        column.setHasLabels(true);
        column.setHasLabelsOnlyForSelected(false);
        columns.add(column);
        float value = 0f;
        for (int i = 1; i <= numColumns; i++) {
            values = new ArrayList<SubcolumnValue>();
            try {
                value = classStatic.get(i-1).getStar();
            }
            catch (Exception e ){
                value = 0f;
            }
            values.add(new SubcolumnValue(value, ChartUtils.pickColor()));

             column = new Column(values);
            column.setHasLabels(true);
            column.setHasLabelsOnlyForSelected(false);
            columns.add(column);
        }

        chartData = new ColumnChartData(columns);
            Axis axisX = new Axis();
            Axis axisY = new Axis().setHasLines(true);
                axisX.setName("Tuần");
                axisY.setName("Số sao");
            chartData.setAxisXBottom(axisX);
            chartData.setAxisYLeft(axisY);

//            chartData.setAxisXBottom(null);
//            chartData.setAxisYLeft(null);


        chartView.setColumnChartData(chartData);
        chartView.setZoomEnabled(false);
        chartView.setOnValueTouchListener(new ColumnChartOnValueSelectListener() {
            @Override
            public void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value) {
                if(value.getValue()>0){
                    ClassStatic Static = classStatic.get(columnIndex-1);
                    txtWeek.setText("Tổng kết tuần "+Static.getWeeks());
                    pbStated.setProgress(Static.getNumstated());
                    pbStar.setProgress(Static.getStar());
                    pbRightStated.setProgress(Static.getNumofrightstated());
                    pbHomework.setProgress(Static.getHomework());
                    txtStated.setText(Static.getNumstated() + " lần ");
                    txtStar.setText(Static.getStar() + " sao");
                    txtRightStated.setText(Static.getNumofrightstated() + " lần");
                    txtHomework.setText(Static.getHomework() + " lần");
                }
            }

            @Override
            public void onValueDeselected() {

            }
        });
    }
}
