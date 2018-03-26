// 1 TODO fix multiple choice right answer CheckBoxes
// decide on
// Outcome "Sorry wrong answer"  TODOs fix why it appears & stays should go away after clicking on another option
// or Checkbox is clicked checkbox is not clicked
// or toast "selected right answer, wrong answer"


// 2 TODO (4.) & TODO toast score


// 3 Rubic TODO add score sheet...............
//   TODO Submit Button App includes a button for the user to submit their answers and receive a score.

// 4 TODO grading button displays a toast....................................................

// 5 TODO The grading logic checks each answer correctly. The app accurately calculates
// the number of correct answers and does not include incorrect answers in the count.

// 6 TODO Note: When applicable, in the grading logic remember to check that the correct answers are checked
// AND the incorrect answers are not checked.........................................

// finishing touches, color, design, pic? theme subject of the quiz, add questions, add answers
// 7. TODO add color, red WRONG green CORRECT

package com.example.android.quizapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {



    RadioGroup answer1;
    Button select;
    RadioButton items;

    CheckBox android;
    CheckBox java;
    Button display;


    Map<String, String> questions = new HashMap<String, String>();
    int questionNo = 1;
    TextView outcome;
    TextView question;
    CheckBox answer11;
    CheckBox answer2;
    CheckBox answer3;
    Button display2;


    public void onAnswer11Click(View v) {
        if (v instanceof CheckBox){
            CheckBox c = (CheckBox) v;
            if (c.isChecked()){
                Toast.makeText(this, "Checkbox is checked!",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Checkbox is not checked!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onAnswer2Click(View v) {
        if (v.getTag() == "Correct") {
            outcome.setText("Well Done!");
            questionNo++;
            setQuestion();
        } else {
            outcome.setText("Sorry, wrong answer!");
        }

    }

    public void onAnswer3Click(View v) {
        if (v.getTag() == "Correct") {
            outcome.setText("Well Done!");
            questionNo++;
            setQuestion();
        } else {
            outcome.setText("Sorry, wrong answer!");
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


//<!-- (1.) & (2.)radio group with Toast of selected answer—>


        answer1 = (RadioGroup) findViewById(R.id.radiogroup);
        select = (Button) findViewById(R.id.select);

        android = (CheckBox) findViewById(R.id.android);
        java = (CheckBox) findViewById(R.id.java);
        display = (Button) findViewById(R.id.display);

        answer11 = (CheckBox) findViewById(R.id.Answer11);
        answer2 = (CheckBox) findViewById(R.id.Answer2);
        answer3 = (CheckBox) findViewById(R.id.Answer3);
        question = (TextView) findViewById(R.id.Question);
        outcome = (TextView) findViewById(R.id.Outcome);
        display2 = (Button) findViewById(R.id.display2);

        //outcome setText('');

        questions.put("Question1", "What is Kylo Ren's Real Name?");
        questions.put("Right1", "Ben Solo");
        questions.put("WrongA1", "Anakin Skywalker");
        questions.put("WrongB1", "Mr Cuddles");

        setQuestion();



        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectid = answer1.getCheckedRadioButtonId();
                items = (RadioButton) findViewById(selectid);
                String s1 = items.getText().toString();
                Toast.makeText(MainActivity.this, "Selected item is: " + s1, Toast.LENGTH_LONG).show();
            }




        });









        //...........................checked boxes as shown in video tutorial..............................
        // TODO T/F multiple choice questions only select one at a time


        display.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String s1;
                if (android.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Android is selected",Toast.LENGTH_LONG).show();
                }
                if (java.isChecked())

                {
                    Toast.makeText(MainActivity.this, "Java is selected",Toast.LENGTH_LONG).show();
                }
            }
        });







        display2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String s2;
                if (answer11.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Answer11 is selected",Toast.LENGTH_LONG).show();
                }
                if (answer2.isChecked())

                {
                    Toast.makeText(MainActivity.this, "Answer2 is selected",Toast.LENGTH_LONG).show();
                }
                if (answer3.isChecked())

                {
                    Toast.makeText(MainActivity.this, "Answer3 is selected",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setQuestion() {
    }

    private void findViewById(Button select) {
    }






    //......................makes radio buttons clickable.for (1.)....................................

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                    break;
        }

    }
}




//..........................Fill in the blank..........................



// TODO add score sheet...............Submit Button App includes a button for the user to
// submit their answers and receive a score.
// grading button displays a toast....................................................

//TODO The grading logic checks each answer correctly. The app accurately calculates
// the number of correct answers and does not include incorrect answers in the count.
//Note: When applicable, in the grading logic remember to check that the correct answers
// are checked AND the incorrect answers are not checked.........................................


//
//    public void quizScore (View view){
//        // Find the user's name
//        QuizScore nameField = (QuizScore) findViewById(R.id.name_field);
//        String name = nameField.quizScore().toString();




////        //Show an error message as a toast
////        Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
////        // Exit this method early because there's nothing left to do
////        return;




//
//public void onAndroidClick(View v) {
//        if (v.getTag() == "Correct") {
//        outcome.setText("Well Done!");
//        int questionNo = 0;
//        questionNo++;
//        setQuestion();
//        } else {
//        outcome.setText("Sorry, wrong answer!");
//        }
//
//        }
//