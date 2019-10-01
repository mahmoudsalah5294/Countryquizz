package com.mahmoudsalah.countryquizzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView questionText;
    Spinner spinner;
    Button startButton,nextButton;

    //    String[] countries={"egypt","usa","france","senegal"};
    String[] cou = {"egypt","usa","france","senegal"};
    List<String> countries = Arrays.asList("egypt","usa","france","senegal");
    String[] capitals={"cairo","ws","paris","dakkar"};
    byte score,i,n,s;

    ArrayList<String> items=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = findViewById(R.id.questionText);
        spinner = findViewById(R.id.spinner);
        startButton = findViewById(R.id.startButton);
        nextButton = findViewById(R.id.nextButton);

        spinner.setVisibility(View.INVISIBLE);
        questionText.setVisibility(View.INVISIBLE);




    }

    public void start(View view) {
        spinner.setVisibility(View.VISIBLE);
        questionText.setVisibility(View.VISIBLE);
        s++;
        if(s==3){
            finish();
        }
        items.clear();
        Collections.addAll(items, "please select", "cairo", "damascus", "tripoli", "ws", "berlin", "london",
                "tokyo",
                "paris",
                "dakkar");


        //fill spinner
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
        spinner.setAdapter(adapter);
        i=0;
        score=0;
        nextButton.setEnabled(true);

//        Collections.shuffle(countries);
        questionText.setText("what is the capital of "+countries.get(0));


    }

    public void next(View view) {

        if (spinner.getSelectedItem().toString().equals("please select")){
            Toast.makeText(this, "please select", Toast.LENGTH_SHORT).show();
            if (n<3){
                n++;
                return;
            }
            score--;
        }

        if (spinner.getSelectedItem().toString().equals(capitals[i])) {
            score++;
            items.remove(spinner.getSelectedItem().toString());
        }

        i++;

        if (i<4){
            questionText.setText("what is the capital of "+countries.get(i));
        }
        else{
            nextButton.setEnabled(false);
            spinner.setVisibility(View.INVISIBLE);
            questionText.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "score is "+score, Toast.LENGTH_SHORT).show();
            s=0;
        }

        spinner.setSelection(0);
//        sloution1
//        Collections.shuffle(items);
//        int index=items.indexOf("please select");
//        Collections.swap(items,0,index);

        //sloution2
//        items.remove("please select");
//        Collections.shuffle(items);
//        items.add(0,"please select");

        //solution3
//        Collections.shuffle(items.subList(1,items.size()));

    }
}
//finish()