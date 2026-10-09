package com.example.nowyquiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

abstract class Question{
    protected String questionContent;
    protected int imageId;
    protected boolean isAnswerCorrect = false;

    public Question(String questionContent, int imageID){
        this.questionContent = questionContent;
        this.imageId= imageID;
        this.isAnswerCorrect = false;
    }

    public abstract boolean checkAnswer(String userAnswer);
}

class MultipleChoiceQuestion extends Question{
    private String answerA;
    private String answerB;
    private String answerC;
    private String correctAnswer;

    public MultipleChoiceQuestion(String questionContent, int imageID, String answerA, String answerB, String answerC, String correctAnswer){
        super(questionContent,imageID);
        this.answerA = answerA; // self.answerA from python
        this.answerB = answerB;
        this.answerC = answerC;
        this.correctAnswer = correctAnswer;
        this.imageId = imageID;
    }
    public String getAnswerA(){return answerA;} // so displayQuestion() can grab the class fields
    public String getAnswerB(){return answerB;}
    public String getAnswerC(){return answerC;}
    public String getQuestionContent(){return questionContent;}
    public int getImageId(){ return imageId;}


    @Override // for the abstract method
    public boolean checkAnswer(String userAnswer){
        if(userAnswer.equals(correctAnswer)){
            this.isAnswerCorrect = true;
        } else{
            this.isAnswerCorrect = false;
        }
        return this.isAnswerCorrect;
    }
}

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    TextView questionTxtv;
    RadioButton r1,r2,r3;
    ImageView image;
    RadioGroup radioGroup;

    int score = 0;
    int currentQuestionIndex = 0;

    MultipleChoiceQuestion[] questionList; // array of objects

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.button);
        questionTxtv = findViewById(R.id.questionTxtv);
        r1 = findViewById(R.id.radioButton1);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        image = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);

        questionList = new MultipleChoiceQuestion[]{ // filling this array
                new MultipleChoiceQuestion("Which mountain hut is this?", R.drawable.question1, "On Rysianka.", "On Wielka Racza.", "On Wielka Rycerzowa.", "On Wielka Racza."),
                new MultipleChoiceQuestion("The animal in the photo is", R.drawable.question2, "a sheepdog.", "a wolf.", "a chamois.", "a sheepdog."),
                new MultipleChoiceQuestion("In the distance you can see", R.drawable.question3, "The Himalayas.", "The Alps.", "The Tatras.", "The Tatras.")
        };

        displayQuestion(currentQuestionIndex);

        btnNext.setOnClickListener(view -> {
            String userAnswer = "";
            if(r1.isChecked()) userAnswer = r1.getText().toString();
            else if (r2.isChecked()) {
                userAnswer = r2.getText().toString();
            } else if (r3.isChecked()) {
                userAnswer = r3.getText().toString();
            }

            MultipleChoiceQuestion currentQuestion = questionList[currentQuestionIndex];

            if(currentQuestion.checkAnswer(userAnswer)){
                score++;
                Toast.makeText(this, "Points: " + score, Toast.LENGTH_SHORT).show();
            }

            currentQuestionIndex++;
            if(currentQuestionIndex>=questionList.length){
                currentQuestionIndex = 0;
            }

            displayQuestion(currentQuestionIndex);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    private void displayQuestion(int index){
        MultipleChoiceQuestion p = questionList[index];

        questionTxtv.setText(p.getQuestionContent());
        r1.setText(p.getAnswerA());
        r2.setText(p.getAnswerB());
        r3.setText(p.getAnswerC());

        image.setImageResource(p.getImageId());

        radioGroup.clearCheck();
    }
}