package com.example.android.quizapp;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    EditText uname;

    int points = 0;
    String toastMessage;
    private String sendEmail;
    private int quizScore;


    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


    }

    public void getAnimalAnswers(View view) {
        if (isMonkeyQuestionCorrect() == false) {
            toastMessage = "Sorry Wrong Answer";
            getToast();
        }
    }

    private boolean isMonkeyQuestionCorrect() {
        RadioButton animalMonkey = (RadioButton) findViewById(R.id.animal_monkey);
        return(animalMonkey.isChecked());
    }



    public void getExhibitAnswers(View view) {
        if (isParisQuestionCorrect() == false) {
            toastMessage = "Sorry Wrong Answer";
            getToast();
        }
    }

    private boolean isParisQuestionCorrect  () {
        RadioButton parisTrue = (RadioButton) findViewById(R.id.paris_true);
        return(parisTrue.isChecked());
    }




    public void getSayingAnswers(View view) {
        if (isSayingQuestionCorrect() == false) {
            toastMessage = "Sorry Wrong Answer";
            getToast();
        }
    }

    private boolean isSayingQuestionCorrect  () {
        EditText sayingVolar = (EditText) findViewById(R.id.saying_volar);
        return(sayingVolar. isShown());
    }



    public void getSpouseAnswers(View view) {
        if (isSpouseQuestionCorrect()  == false) {
            toastMessage = " Answer not correct or complete.  Please try again. ";
            getToast();
        }
    }

    private boolean isSpouseQuestionCorrect() {
        CheckBox diegoAnswer = (CheckBox) findViewById(R.id.spouse_diego);
        boolean isDiego = diegoAnswer.isChecked();

        CheckBox paintingsAnswer = (CheckBox) findViewById(R.id.spouse_paintings);
        boolean isPaintings = paintingsAnswer.isChecked();

        return(isDiego && isPaintings);
    }



//get Toast
    public void getToast() {
        Context context = getApplicationContext();

            int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
        toast.show();
    }

// Quiz results
// Method custom toast working
    //public void getAllPoints(View view) {

        private void getAllPoints() {
            points = 0;

            if (isMonkeyQuestionCorrect()) {
                points += 1;
            }

            if (isParisQuestionCorrect()) {
                points += 1;
            }

            if (isSpouseQuestionCorrect()) {
                points += 2;
            }

            if (isSayingQuestionCorrect()) {
                points += 1;
            }

        }

    public void getAllPoints(View view) {

    Context context = getApplicationContext();
        LayoutInflater inflater = getLayoutInflater();

        View customToastroot = inflater.inflate(R.layout.my_toast, null);
        Toast customToast = new Toast(context);

        customToast.setView (customToastroot);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.show();

        //getTextAnswer();
        toastMessage = " You scored " + points + " points out of a possible 5 points!";
        getToast();
    }


    // To send a email
    public void sendEmail(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "My total score ");
        intent.putExtra(Intent.EXTRA_TEXT, "Your score is " + points);


        String message = "Your score is " + points;
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }




    /**
     * reset_score restores the submit button after clearing the score.
     *
     * @param view
     */


    public void resetQuizResults(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
    }

}
















//    public void getFridaAnswers(View view) {
//        RadioButton animalMonkey = (RadioButton) findViewById(R.id.animal_monkey);
//        boolean monkeyIsChecked = animalMonkey.isChecked();
//
//        if (monkeyIsChecked) {
//            points += 1;
//        } else {
//            toastMessage = "Sorry Wrong Answer";
//            getToast();
//        }
//    }

//    public void getExhibitParisAnswers(View v) {
//        RadioButton exhibitParisOption = (RadioButton) findViewById(R.id.paris_true);
//        boolean trueIsChecked = exhibitParisOption.isChecked();
//
//        if (trueIsChecked) {
//            points += 1;
//        } else {
//            toastMessage = "Sorry Wrong Answer";
//            getToast();
//        }
//    }

//Volar EditText
//    public void getTextAnswer() {
//        EditText sayingAnswer = (EditText) findViewById(R.id.saying_volar);
//        String sayingNamed = sayingAnswer.getText().toString();
//
//        if (sayingNamed.toLowerCase().contains("volar")) {
//            points += 1;
//        } else {
//            toastMessage = " Sorry the end of the saying isn't correct.  Try again.";
//        }
//    }
