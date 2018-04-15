package com.example.axbx.hideactionbar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SesionesVivo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SesionesVivo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SesionesVivo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public  SesionesVivo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *interprepeter
     * parameter
     * =12.5
     * =566.7
     * =23.2
     * =22.2
     * System.input.out
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SesionesVivo.
     */
    // TODO: Rename and change types and number of parameters
    public static SesionesVivo newInstance(String param1, String param2) {
        SesionesVivo fragment = new SesionesVivo();
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
    public WebView mWebView;
    public WebView mWebView2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View v= inflater.inflate(R.layout.fragment_sesiones_vivo, container, false);


        mWebView = (WebView) v.findViewById(R.id.webview);
        mWebView2 = (WebView) v.findViewById(R.id.webview2);

        https://www.youtube.com/embed/VTyzzclMqWQ
       mWebView.loadUrl("https://www.ustream.tv/embed/23465661?html5ui");
        //mWebView.loadUrl("https://www.youtube.com/embed/71P_dDnv-p4");


        mWebView2.loadUrl("http://www.ustream.tv/socialstream/23465661");


        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Enable Javascript
        WebSettings webSettings2 = mWebView2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        mWebView2.setWebViewClient(new WebViewClient());
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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

    /**
     *
     *
     *
     *
     * Vamos a hablar sin mentiras, somos esclavos verdad, a quien tratamos de engañar con esta farsa
¿la democracia realmente existe?,la liberta de pensamiento, la igualdad de genero o la disminucion de la pobreza?
     francamente son casos aislados donde se han visto este tipo de cosas?, es que acaso son quimeras,
     o quiza leyendas urbanas.

     Yo fui de aquellos defensores de la libertad, escribia con voracidad y violencia tratando de despertar
     conciencias, hoy
     */


}
