package com.ankita.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ankita.quizapp.MainActivity
import com.ankita.quizapp.R
import com.ankita.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var textViewScore: TextView
    private lateinit var textViewName: TextView
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewScore = findViewById(R.id.tv_score)
        textViewName = findViewById(R.id.tv_name)
        finishButton = findViewById(R.id.buttonFinish)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.SCORE,0)
        val name = intent.getStringExtra(Constants.USER_NAME)

        textViewScore.text = "Your score is $score out of $totalQuestions"
        textViewName.text = name

        finishButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}