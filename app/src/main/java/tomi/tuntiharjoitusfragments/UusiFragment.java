package tomi.tuntiharjoitusfragments;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class UusiFragment extends Fragment {




    //tää on interface
    private IUusiFragment mListener;

    Button b;
    EditText editText;
    TextView textView;

    public interface IUusiFragment {
        // TODO: Update argument type and name
        void onButtonPressed(EditText editText,TextView textView);
        public void setValue(String edittextvalue);
    }


    public UusiFragment() {
        //tän pitää olla tyhjä muuten ei toimi
    }

    //otetaan siksi newInstance, että jos useampi UI komponentti käytössä
    public static UusiFragment newInstance() {
        UusiFragment fragment = new UusiFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_uusi, container, false);

        editText = (EditText)v.findViewById(R.id.editText);
        textView = (TextView)v.findViewById(R.id.textView);

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b = (Button)getView().findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                mListener.setValue(s);
            }
        });

    }

    public void setText(String text){
        textView.setText(text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IUusiFragment) {
            mListener = (IUusiFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IUusiFragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    

}
