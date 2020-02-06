package tomi.tuntiharjoitusfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//implementoidaan Interface Fragmentista
public class MainActivity extends AppCompatActivity implements UusiFragment.IUusiFragment, FragmentKaksi.IFragmentKaksi {

    String value;
    UusiFragment fragment1;
    FragmentKaksi fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new UusiFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.frameleiska1, fragment1,fragment1.getTag())
                .commit();

        fragment2 = new FragmentKaksi();
        manager.beginTransaction()
                .replace(R.id.frameleiska2,fragment2,fragment2.getTag())
                .commit();


    }

    @Override
    public void setValue2(String editValue) {
        value = editValue;
        if(fragment1 != null){
            fragment1.setText(value);
        }else{
            Toast.makeText(getApplicationContext(), "fragment 1 is null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setValue(String editTextValue){
        value = editTextValue;
        if(fragment2 != null){
            fragment2.setText(value);
        }else{
            Toast.makeText(getApplicationContext(), "fragment 2 is null", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onButtonPressed(EditText editText, TextView textView) {
        Toast.makeText(getApplicationContext(), "mainactivi yea", Toast.LENGTH_SHORT).show();
        textView.setText(editText.getText());
    }

}
