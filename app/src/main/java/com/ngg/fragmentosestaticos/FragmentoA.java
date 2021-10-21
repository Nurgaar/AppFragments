package com.ngg.fragmentosestaticos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ngg.fragmentosestaticos.EnviarMensaje;
import com.ngg.fragmentosestaticos.R;

public class FragmentoA extends Fragment {

    private EnviarMensaje mensaje;

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragmento_a,container,false);
       //asociar el boton con el onclick

    view.findViewById(R.id.enviar).setOnClickListener(v -> {
        TextView tv = view.findViewById(R.id.Texto);
        String msg = tv.getText().toString();
        mensaje.enviarDato(msg);
       });

       return view;
   }

   @Override
    public void onAttach(@NonNull Context context) {
       super.onAttach(context);
       mensaje = (EnviarMensaje) context;
   }


   public void onClick(View vista){
       EditText textoA = (EditText) vista.findViewById(R.id.Texto);
       CharSequence currentText = textoA.getText();

   }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText tv = getActivity().findViewById(R.id.Texto);
        String texto = tv.getText().toString();
        outState.putString("MENSAJE", texto);
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            String mensaje = savedInstanceState.getString("MENSAJE");
            EditText tv = getActivity().findViewById(R.id.Texto);
            tv.setText(tv.getText());
        }
    }


}
