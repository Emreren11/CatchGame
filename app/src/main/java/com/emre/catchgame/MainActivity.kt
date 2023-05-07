package com.emre.catchgame

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.emre.catchgame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        gameStart()

    }

    //Start Game Function

    fun gameStart() {
        score = 0
        binding.scoreText.text = "Score: ${score}"
        var countDownTimer = object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timeText.text = "Time: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                alertDialog()
            }

        }.start()

        var timerForStars = object : CountDownTimer(15000, 500) {
            override fun onTick(millisUntilFinished: Long) {
                showStar()
            }

            override fun onFinish() {
                invisibleStar()
            }

        }.start()
    }

    // AlertDialog Function

    fun alertDialog() {
        val alert = AlertDialog.Builder(this)

        alert.create()

        alert.setTitle("Game Over")
        alert.setMessage("Restart The Game?")
        alert.setPositiveButton("Yes") { dialog, which ->
            gameStart()
        }
        alert.setNegativeButton("No") { dialog, which ->
            Toast.makeText(
                this@MainActivity,
                "Congratulation! Your score is ${score}",
                Toast.LENGTH_LONG
            ).show()
        }

        alert.show()
    }

    // Invisible Stars Function

    private fun invisibleStar() {
        binding.imageView1.visibility = View.INVISIBLE
        binding.imageView2.visibility = View.INVISIBLE
        binding.imageView3.visibility = View.INVISIBLE
        binding.imageView4.visibility = View.INVISIBLE
        binding.imageView5.visibility = View.INVISIBLE
        binding.imageView6.visibility = View.INVISIBLE
        binding.imageView7.visibility = View.INVISIBLE
        binding.imageView8.visibility = View.INVISIBLE
        binding.imageView9.visibility = View.INVISIBLE
    }

    // Visible Stars Function

    val rnd = Random(10)
    private fun showStar() {

        var star = rnd.nextInt(1, 10)

        when (star) {
            1 -> {
                invisibleStar()
                binding.imageView1.visibility = View.VISIBLE
            }

            2 -> {
                invisibleStar()
                binding.imageView2.visibility = View.VISIBLE
            }

            3 -> {
                invisibleStar()
                binding.imageView3.visibility = View.VISIBLE
            }

            4 -> {
                invisibleStar()
                binding.imageView4.visibility = View.VISIBLE
            }

            5 -> {
                invisibleStar()
                binding.imageView5.visibility = View.VISIBLE
            }

            6 -> {
                invisibleStar()
                binding.imageView6.visibility = View.VISIBLE
            }

            7 -> {
                invisibleStar()
                binding.imageView7.visibility = View.VISIBLE
            }

            8 -> {
                invisibleStar()
                binding.imageView8.visibility = View.VISIBLE
            }

            9 -> {
                invisibleStar()
                binding.imageView9.visibility = View.VISIBLE
            }
        }

    }

    // Score Function
    var score = 0
    fun score(view: View) {
        score++
        binding.scoreText.text = "Score: ${score}"

    }
}