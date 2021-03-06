package com.example.axbx.hideactionbar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SesionesPasadas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SesionesPasadas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SesionesPasadas extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static ListView list;
    public static String[] sistemas;
    public static ArrayAdapter<String> adaptador;
    public static WebView mWebView;



    private OnFragmentInteractionListener mListener;

    public SesionesPasadas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SesionesPasadas.
     */
    // TODO: Rename and change types and number of parameters
    public static SesionesPasadas newInstance(String param1, String param2) {
        SesionesPasadas fragment = new SesionesPasadas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static String especialidad;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    private Spinner spinner1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sesiones_pasadas, container, false);



        spinner1=(Spinner) view.findViewById(R.id.spinner1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {

                //Toast.makeText(getApplicationContext(), "Ha pulsado el item " + arg0.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();

                 if(arg0.getSelectedItemPosition()==8){// Oftalmologia

                            especialidad="OFTALMOLOGIA";

                     HistoricoController controller = new HistoricoController();
                     controller.start();



                     //Carga el listView con los videos del historico

                     list = (ListView)view.findViewById(R.id.listview);

              mWebView = (WebView) view.findViewById(R.id.WebView1);

                  //  System.out.println("TAMAÑO"+sistemas.length);

                 /*  adaptador = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, sistemas);

                     list.setAdapter(adaptador);
                     list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                         @Override
                         public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                             // TODO Auto-generated method stub
                             Toast.makeText(getApplicationContext(), "Ha pulsado el item " + position, Toast.LENGTH_SHORT).show();

                             if(position==8){
                                 //Anestesiologia
                                 //Pasar parametros a un controlador




                             }

                         }

                     });*/


                 }

                if(arg0.getSelectedItemPosition()==0){// Oftalmologia

                    especialidad="ANESTESIOLOGIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }

                if(arg0.getSelectedItemPosition()==1){// Oftalmologia

                    especialidad="ONCOLOGIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }

                if(arg0.getSelectedItemPosition()==2){// Oftalmologia

                    especialidad="IMAGENEOLOGIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }

                if(arg0.getSelectedItemPosition()==3){// Oftalmologia

                    especialidad="PEDIATRIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }


                if(arg0.getSelectedItemPosition()==4){// Oftalmologia

                    especialidad="DERMATOLOGIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }

                if(arg0.getSelectedItemPosition()==5){// Oftalmologia

                    especialidad="GASTROENTEROLOGIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }

                if(arg0.getSelectedItemPosition()==6){// Oftalmologia

                    especialidad="DERMATOLOGIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }

                if(arg0.getSelectedItemPosition()==7){// Oftalmologia

                    especialidad="PSIQUIATRIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }

                                if(arg0.getSelectedItemPosition()==9){// Oftalmologia

                    especialidad="UROLOGIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }

                if(arg0.getSelectedItemPosition()==10){// Oftalmologia

                    especialidad="GINECOLOGIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }

                                if(arg0.getSelectedItemPosition()==11){// Oftalmologia

                    especialidad="CARDIOLOGIA";

                    HistoricoController controller = new HistoricoController();
                    controller.start();



                    //Carga el listView con los videos del historico

                    list = (ListView)view.findViewById(R.id.listview);

                    mWebView = (WebView) view.findViewById(R.id.WebView1);




                }




            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

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

}
