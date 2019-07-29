package edu.cps.auzdavinis.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val resultText: TextView = findViewById(R.id.result_text)
        val die1: ImageView = findViewById(R.id.die_image_1)
        val die2: ImageView = findViewById(R.id.die_image_2)

        rollButton.setOnClickListener {
            var count = 0
            val repetitions = 1000
            repeat(repetitions) {
                if (rollDie(die1) == rollDie(die2)) ++count
            }
            resultText.text = "Percent score: %${count.toDouble() / repetitions * 100}\nTotal: $count"
        }
    }

    private fun rollDie(image: ImageView): Int {
        val randInt = Random.nextInt(6) + 1
        image.setImageResource(when (randInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        })
        return randInt
    }
}
