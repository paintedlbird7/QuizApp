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


    int points;
    String toastMessage;
    private String sendEmail;
    private int quizScore;


    /**
     * Called when the activity is first created.
     */
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
        return (animalMonkey.isChecked());
    }

    public void getExhibitAnswers(View view) {
        if (isParisQuestionCorrect() == false) {
            toastMessage = "Sorry Wrong Answer";
            getToast();
        }
    }

    private boolean isParisQuestionCorrect() {
        RadioButton parisTrue = (RadioButton) findViewById(R.id.paris_true);
        return (parisTrue.isChecked());
    }

    public void getSayingAnswers(View view) {
        if (isSayingQuestionCorrect() == false) {
            toastMessage = "Sorry Wrong Answer";
            getToast();
        }
    }

    private boolean isSayingQuestionCorrect() {
        EditText sayingVolar = (EditText) findViewById(R.id.saying_volar);
        String userAnswer = sayingVolar.getText().toString().toLowerCase();
        return (userAnswer.contains("volar"));
    }

    public void getSpouseAnswers(View view) {
        if (isSpouseQuestionCorrect() == false) {
            toastMessage = " Answer not correct or complete.  Please try again. ";
            getToast();
        }
    }

    private boolean isSpouseQuestionCorrect() {
        CheckBox diegoAnswer = (CheckBox) findViewById(R.id.spouse_diego);
        boolean isDiego = diegoAnswer.isChecked();

        CheckBox paintingsAnswer = (CheckBox) findViewById(R.id.spouse_paintings);
        boolean isPaintings = paintingsAnswer.isChecked();

        CheckBox leonAnswer = (CheckBox) findViewById(R.id.spouse_leon);
        boolean isLeon = leonAnswer.isChecked();

        CheckBox tinaAnswer = (CheckBox) findViewById(R.id.spouse_tina);
        boolean isTina = tinaAnswer.isChecked();

        return (isDiego && isPaintings && !isTina && !isLeon);
    }

    //get Toast
    public void getToast() {
        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
        toast.show();
    }

    public void getAllPoints(View view) {
        points = 0;

        if (isMonkeyQuestionCorrect()) {
            points += 1;
        }

        if (isParisQuestionCorrect()) {
            points += 1;
        }

        if (isSpouseQuestionCorrect()) {
            points += 1;
        }

        if (isSayingQuestionCorrect()) {
            points += 1;
        }

        Context context = getApplicationContext();
        LayoutInflater inflater = getLayoutInflater();

        View customToastroot = inflater.inflate(R.layout.my_toast, null);
        Toast customToast = new Toast(context);

        customToast.setView(customToastroot);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.show();

        // if/else statement Gives a different message based on results
        if (points == 4) {
            String result = "Congrats!  You got a perfect score!";
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();

        } else {
            String result = "You scored " + points + " points out of a possible 4 points!";
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }

    }

    // To send a email HIGHLIGHTED CODE code I'm specifically proud of ability to get sent your score to your email
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


    public void resetQuizResults(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
    }

}
