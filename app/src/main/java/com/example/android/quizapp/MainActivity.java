package com.example.android.quizapp;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void getFridaAnswers(View view) {
        RadioButton animalMonkey = (RadioButton) findViewById(R.id.animal_monkey);
        boolean monkeyIsChecked = animalMonkey.isChecked();

        if (monkeyIsChecked) {
            points += 1;
        } else {
            toastMessage = "Sorry Wrong Song Answer";
            getToast();
        }
    }

    public void getExhibitParisAnswers(View v) {
        RadioButton exhibitParisOption = (RadioButton) findViewById(R.id.paris_true);
        boolean trueIsChecked = exhibitParisOption.isChecked();

        if (trueIsChecked) {
            points += 1;
        } else {
            toastMessage = "Sorry Wrong Group Answer";
            getToast();
        }
    }


    public void getCheckBoxAnswers(View view) {
        CheckBox diegoAnswer = (CheckBox) findViewById(R.id.spouse_diego);
        boolean isDiego = diegoAnswer.isChecked();

        CheckBox paintingsAnswer = (CheckBox) findViewById(R.id.spouse_paintings);
        boolean isPaintings = paintingsAnswer.isChecked();

        if (isDiego && isPaintings) {
            points += 2;
        } else {
            toastMessage = " Answer not correct or complete.  Please try again. ";
            getToast();
        }
    }


    //--------------------------

    public void getTextAnswer() {
        EditText sayingAnswer = (EditText) findViewById(R.id.saying_volar);
        String sayingNamed = sayingAnswer.getText().toString();

        if (sayingNamed.toLowerCase().contains("volar")) {
            points += 1;
        } else {
            toastMessage = " Sorry the end of the saying isn't correct.  Try again.";
        }
    }

    public void getToast() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
        toast.show();
    }

    public void createQuizResults(View view) {
        getTextAnswer();
        toastMessage = " You scored " + points + " points out of a possible 5 points!";
        getToast();
    }


    // To send a email (blank rn)
    public void submitOrder(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "My total score ");
        intent.putExtra(Intent.EXTRA_TEXT, "You're total score .");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}











//    /**
//     * Create Summary of the Order
//     *
//     * @param name of customer
//     * @param score of the quiz
//     * @return text summary
//     */
//    private String createQuizResults(String name, int score) {
//        String submitOrder = "Name: " + name;
//        submitOrder += "\nAdd whipped cream? ";
////        priceMessage += "\nAdd chocolate? " + addChocolate;
////        priceMessage += "\nQuantity: " + quantity;
////        priceMessage += "\nTotal: = $" + price;
////        priceMessage += "\nThank you!";
//        return submitOrder;
//
//    }
//
//}










