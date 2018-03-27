package com.example.android.quizapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity

{
    int points;
    String toastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void getFridaAnswers(View view)
    {
        RadioButton animalMonkey = (RadioButton) findViewById(R.id.animal_monkey);
        boolean monkeyIsChecked = animalMonkey.isChecked();

        if(monkeyIsChecked){
            points += 1;
        }
        else
        {
            toastMessage = "Sorry Wrong Song Answer";
            getToast();
        }
    }

    public void getExhibitParisAnswers(View v)
    {
        RadioButton exhibitParisOption = (RadioButton) findViewById(R.id.paris_true);
        boolean trueIsChecked = exhibitParisOption.isChecked();

        if(trueIsChecked){
            points += 1;
        }
        else
        {
            toastMessage = "Sorry Wrong Group Answer";
            getToast();
        }
    }


    public void getCheckBoxAnswers(View view)
    {
        CheckBox diegoAnswer = (CheckBox) findViewById(R.id.spouse_diego);
        boolean isDiego = diegoAnswer.isChecked();

        CheckBox paintingsAnswer = (CheckBox) findViewById(R.id.spouse_paintings);
        boolean isPaintings = paintingsAnswer.isChecked();

        if(isDiego && isPaintings)
        {
            points +=2;
        }
        else
        {
            toastMessage = " Answer not correct or complete.  Please try again. ";
            getToast();
        }
    }


    //--------------------------

    public void getTextAnswer()
    {
        EditText sayingAnswer = (EditText) findViewById(R.id.saying_volar);
        String sayingNamed = sayingAnswer.getText().toString();

        if (sayingNamed.toLowerCase().contains("volar"))
        {
            points +=1;
        }
        else
        {
            toastMessage = " Sorry the end of the saying isn't correct.  Try again.";
        }
    }

    public void getToast()
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.RIGHT, 0, 0);
        toast.show();
    }

    public void createQuizResults(View view)
    {
        getTextAnswer();
        toastMessage = " You scored " + points + " points out of a possible 5 points!";
        getToast();
    }

}












//TODO fix outcome/display button it opens in a new window with correct but empty checkboxes in app Quiz22

//TODO buttons are working EXCEPT multiple choice right answer CheckBoxes
//freezes (need to add code)

//    RadioGroup answer1;
//    Button select;
//    RadioButton items;
//
//    CheckBox android;
//    CheckBox java;
//    Button display;
//
//
//    Map<String, String> questions = new HashMap<String, String>();
//    int questionNo = 1;
//  TextView outcome;
//    TextView question;
//    CheckBox answer11;
//    CheckBox answer2;
//    CheckBox answer3;
//    Button display2;
//
//
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main_activity);
//
//
//        //final RadioButton answer1RadioButton = findViewById(R.id.radiogroup);
//
//
//        answer1 = (RadioGroup) findViewById(R.id.radiogroup);
//        //select = (Button) findViewById(R.id.select);
//
//        android = (CheckBox) findViewById(R.id.android);
//        java = (CheckBox) findViewById(R.id.java);
//        //display = (Button) findViewById(R.id.display);
//
//        answer11 = (CheckBox) findViewById(R.id.Answer11);
//        answer2 = (CheckBox) findViewById(R.id.Answer2);
//        answer3 = (CheckBox) findViewById(R.id.Answer3);
//        question = (TextView) findViewById(R.id.Question);
//        //outcome = (TextView) findViewById(R.id.Outcome);
//        //display2 = (Button) findViewById(R.id.display2);
//
//        //outcome setText('');
//
////        questions.put("Question1", "What is Kylo Ren's Real Name?");
////        questions.put("Right1", "Ben Solo");
////        questions.put("WrongA1", "Anakin Skywalker");
////        questions.put("WrongB1", "Mr Cuddles");
//
//        setQuestion()
//
//
//
//
//
////
////        select.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                int selectid = answer1.getCheckedRadioButtonId();
////                items = (RadioButton) findViewById(selectid);
////                String s1 = items.getText().toString();
////                Toast.makeText(MainActivity.this, "Selected item is: " + s1, Toast.LENGTH_LONG).show();
////            }
////
////
////            public void onAnswer11Click(View v) {
////                if (v.getTag() == "Correct") {
////                    outcome.setText("Well Done!");
////                    questionNo++;
////                    setQuestion();
////                } else {
////                    outcome.setText("Sorry, wrong answer!");
////                }
////
////            }
////
////            public void onAnswer2Click(View v) {
////                if (v.getTag() == "Correct") {
////                    outcome.setText("Well Done!");
////                    questionNo++;
////                    setQuestion();
////                } else {
////                    outcome.setText("Sorry, wrong answer!");
////                }
////
////            }
////
////            public void onAnswer3Click(View v) {
////                if (v.getTag() == "Correct") {
////                    outcome.setText("Well Done!");
////                    questionNo++;
////                    setQuestion();
////                } else {
////                    outcome.setText("Sorry, wrong answer!");
////                }
////
////            }
////
////
////        });
//
//
//
//
//
//
//
//
//
//        //...........................checked boxes as shown in video tutorial..............................
//        // TODO T/F multiple choice questions only select one at a time
//
//
////        display.setOnClickListener(new View.OnClickListener(){
////            @Override
////            public void onClick(View view){
////                String s1;
////                if (android.isChecked())
////                {
////                    Toast.makeText(MainActivity.this, "Android is selected",Toast.LENGTH_LONG).show();
////                }
////                if (java.isChecked())
////
////                {
////                    Toast.makeText(MainActivity.this, "Java is selected",Toast.LENGTH_LONG).show();
////                }
////            }
////        });
//
//
//
//
//
//
//
////    display2.setOnClickListener(new View.OnClickListener(){
////        @Override
////        public void onClick(View view){
////            String s2;
////            if (answer11.isChecked())
////            {
////                Toast.makeText(MainActivity.this, "Answer11 is selected",Toast.LENGTH_LONG).show();
////            }
////            if (answer2.isChecked())
////
////            {
////                Toast.makeText(MainActivity.this, "Answer2 is selected",Toast.LENGTH_LONG).show();
////            }
////        }
////    });
////}
//
//    private void setQuestion() {
//    }
//
//
//
//    private void findViewById(Button select) {
//    }
//
//
//
//
//
//
//    //......................makes radio buttons clickable....................................
//
//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio_pirates:
//                if (checked)
//                    // Pirates are the best
//                    break;
//            case R.id.radio_ninjas:
//                if (checked)
//                    // Ninjas rule
//                    break;
//        }
//
//    }
//}



//..........................Fill in the blank..........................



