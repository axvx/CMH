package com.example.axbx.hideactionbar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Temario.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Temario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Temario extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static TextView txt00,txt01,txt02,txt03,txt04,txt05,txt06,txt07,txt08,txt09,txt10,txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18,txt19,txt20,txt21,txt22,txt23,txt24;

    public static CalendarView calendario;

    public static Date c ;
    public static SimpleDateFormat df ;
    public static String formattedDate;

    private OnFragmentInteractionListener mListener;

    public Temario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Temario.
     */
    // TODO: Rename and change types and number of parameters
    public static Temario newInstance(String param1, String param2) {
        Temario fragment = new Temario();
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

        View view=inflater.inflate(R.layout.fragment_temario, container, false);

        calendario=(CalendarView)view.findViewById(R.id.calendarView);

        txt00 = (TextView)view.findViewById(R.id.txtslot0);
        txt01 = (TextView)view.findViewById(R.id.txtslot1);
        txt02 = (TextView)view.findViewById(R.id.txtslot2);
        txt03 = (TextView)view.findViewById(R.id.txtslot3);
        txt04 = (TextView)view.findViewById(R.id.txtslot4);
        txt05 = (TextView)view.findViewById(R.id.txtslot5);
        txt06 = (TextView)view.findViewById(R.id.txtslot6);
        txt07 = (TextView)view.findViewById(R.id.txtslot7);
        txt08 = (TextView)view.findViewById(R.id.txtslot8);
        txt09 = (TextView)view.findViewById(R.id.txtslot9);
        txt10 = (TextView)view.findViewById(R.id.txtslot10);
        txt11 = (TextView)view.findViewById(R.id.txtslot11);
        txt12 = (TextView)view.findViewById(R.id.txtslot12);
        txt13 = (TextView)view.findViewById(R.id.txtslot13);
        txt14 = (TextView)view.findViewById(R.id.txtslot14);
        txt15 = (TextView)view.findViewById(R.id.txtslot15);
        txt16 = (TextView)view.findViewById(R.id.txtslot16);
        txt17 = (TextView)view.findViewById(R.id.txtslot17);
        txt18 = (TextView)view.findViewById(R.id.txtslot18);
        txt19 = (TextView)view.findViewById(R.id.txtslot19);
        txt20 = (TextView)view.findViewById(R.id.txtslot20);
        txt21 = (TextView)view.findViewById(R.id.txtslot21);
        txt22 = (TextView)view.findViewById(R.id.txtslot22);
        txt23 = (TextView)view.findViewById(R.id.txtslot23);
        txt24 = (TextView)view.findViewById(R.id.txtslot24);


 c = Calendar.getInstance().getTime();
  df = new SimpleDateFormat("yyyy-MM-dd");
  formattedDate = df.format(c);


        EventoController controller = new EventoController();
        controller.start();

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {



                i1=i1+1;
                System.out.println("Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + i1 + "\n" + "Year = " + i);

                if(i1>=10 || i2>=10){
                formattedDate=i+"-0"+i1+"-0"+i2;}
                else{

                    formattedDate=i+"-"+i1+"-"+i2;
                }

                EventoController controller = new EventoController();
                controller.start();

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
/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

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
    public static void ResetCajas(){

        txt00.setText("00:00 hrs");
        txt01.setText("01:00 hrs");
        txt02.setText("02:00 hrs");
        txt03.setText("03:00 hrs");
        txt04.setText("04:00 hrs");
        txt05.setText("05:00 hrs");
        txt06.setText("06:00 hrs");
        txt07.setText("07:00 hrs");
        txt08.setText("08:00 hrs");
        txt09.setText("09:00 hrs");
        txt10.setText("10:00 hrs");
        txt11.setText("11:00 hrs");
        txt12.setText("12:00 hrs");
        txt13.setText("13:00 hrs");
        txt14.setText("14:00 hrs");
        txt15.setText("15:00 hrs");
        txt16.setText("16:00 hrs");
        txt17.setText("17:00 hrs");
        txt18.setText("18:00 hrs");
        txt19.setText("19:00 hrs");
        txt20.setText("20:00 hrs");
        txt21.setText("21:00 hrs");
        txt22.setText("22:00 hrs");
        txt23.setText("23:00 hrs");
        txt24.setText("24:00 hrs");




    }
}
