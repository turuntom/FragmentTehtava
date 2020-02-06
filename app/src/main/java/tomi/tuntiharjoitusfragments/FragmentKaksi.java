package tomi.tuntiharjoitusfragments;

import android.content.Context;
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


public class FragmentKaksi extends Fragment {


    public interface IFragmentKaksi {
        void setValue2(String value);
    }

    EditText editText2;
    TextView textView2;
    Button b2;

    private IFragmentKaksi mCallback;

    public FragmentKaksi() {
        // Required empty public constructor
    }


    public void setText(String text){
        textView2.setText(text);
    }

    public static FragmentKaksi newInstance() {
        FragmentKaksi fragment = new FragmentKaksi();
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
        View v = inflater.inflate(R.layout.fragment_fragment_kaksi, container, false);


        editText2 = v.findViewById(R.id.editText2);
        textView2 = v.findViewById(R.id.textView2);

        return v;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IFragmentKaksi) {
            mCallback = (IFragmentKaksi) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b2 = (Button)getView().findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText2.getText().toString();
                mCallback.setValue2(s);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

}
