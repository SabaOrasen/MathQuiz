package com.example.saba.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view){
        int points=0;

        ArrayList answer = getAnswer();
        ArrayList solution = getSolution();
        for (int i = 0; i < solution.size(); i++){
            if (answer.get(i).equals(solution.get(i))){
                points++;
            }
        }
        String feedback = "Sie sind ein HELD! \nSie haben "+points+" erreicht." ;
        if (points<4){
            feedback = "Sie sind ein LOSER! \nSie haben "+points+" Punkte erreicht.";
        }
        Toast.makeText(this,feedback,Toast.LENGTH_LONG).show();
        System.out.println(answer.toString());
    }

    private ArrayList getAnswer(){
        ArrayList answer = new ArrayList();
        String a="";
        for (int i = 1; i<=6; i++){
        String viewId = "Q" + i;
        EditText userInput = (EditText) findViewById(getResources().getIdentifier(viewId, "id", getPackageName()));
         //   EditText userInput = (EditText) findViewById(R.id.Q1);
            answer.add(userInput.getText().toString());}
        return answer;
    }

    private ArrayList getSolution(){
        ArrayList solution = new ArrayList(Arrays.asList("75","555","699","1020","768","1665"));
        return solution;
    }


}
