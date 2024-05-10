package me.muhaimin.likesapp

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import me.muhaimin.likesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mBitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
    private val mCanvas = Canvas(mBitmap)
    private val mPaint = Paint()

    private val halfOfWidth = (mBitmap.width / 2).toFloat()
    private val halfOfHeight = (mBitmap.height / 2).toFloat()

    private val left = 150f
    private val top = 250f
    private val right = mBitmap.width - left
    private val bottom = mBitmap.height.toFloat() - 50f

    private val message = "Apakah kamu suka bermain ?"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setImageBitmap(mBitmap)
        showText()

        binding.like.setOnClickListener {
            showFace()
            showMouth(true)
            showEyes()
        }

        binding.dislike.setOnClickListener {
            showFace()
            showMouth(false)
            showEyes()
        }
    }

    private fun showText() {
        val mPaintText = Paint(Paint.FAKE_BOLD_TEXT_FLAG).apply {
            textSize = 50f
            color = ResourcesCompat.getColor(resources, R.color.black, null)
        }

        val mBounds = Rect()
        mPaintText.getTextBounds(message, 0, message.length, mBounds)

        val x: Float = halfOfWidth - mBounds.centerX()
        val y = 50f
        mCanvas.drawText(message, x, y, mPaintText)
    }

    private fun showFace() {
        val face = RectF(left, top , right, bottom)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.yellow_left_skin, null)
        mCanvas.drawArc(face, 90f, 180f, false, mPaint)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.yellow_right_skin, null)
        mCanvas.drawArc(face, 270f, 180f, false, mPaint)
    }

    private fun showEyes() {
        mPaint.color = ResourcesCompat.getColor(resources, R.color.black, null)
        mCanvas.drawCircle(halfOfWidth - 100f, halfOfHeight - 10f, 50f, mPaint)
        mCanvas.drawCircle(halfOfWidth + 100f, halfOfHeight - 10f, 50f, mPaint)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.white, null)
        mCanvas.drawCircle(halfOfWidth - 120f, halfOfHeight - 20f, 15f, mPaint)
        mCanvas.drawCircle(halfOfWidth + 80f, halfOfHeight - 20f, 15f, mPaint)
    }

    private fun showMouth(isHappy: Boolean) {
        when (isHappy) {
            true -> {
                mPaint.color = ResourcesCompat.getColor(resources, R.color.black, null)
                val lip = RectF(
                    halfOfWidth - 200f,
                    halfOfHeight - 100f,
                    halfOfWidth + 200f,
                    halfOfHeight + 400f
                )
                mCanvas.drawArc(lip, 25f, 130f, false, mPaint)

                mPaint.color = ResourcesCompat.getColor(resources, R.color.white, null)
                val mouth = RectF(
                    halfOfWidth - 180f,
                    halfOfHeight,
                    halfOfWidth + 180f,
                    halfOfHeight + 380f,
                )
                mCanvas.drawArc(mouth, 25f, 130f, false, mPaint)
            }
            false -> {
                mPaint.color = ResourcesCompat.getColor(resources, R.color.black, null)
                val lip = RectF(
                    halfOfWidth - 200f,
                    halfOfHeight + 250f,
                    halfOfWidth + 200f,
                    halfOfHeight + 350f
                )
                mCanvas.drawArc(lip, 0f, -180f, false, mPaint)

                mPaint.color = ResourcesCompat.getColor(resources, R.color.white, null)
                val mouth = RectF(
                    halfOfWidth - 180f,
                    halfOfHeight + 260f,
                    halfOfWidth + 180f,
                    halfOfHeight + 330f,
                )
                mCanvas.drawArc(mouth, 0f, -180f, false, mPaint)
            }
        }
    }
}