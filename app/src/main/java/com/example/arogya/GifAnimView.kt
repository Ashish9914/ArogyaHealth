package com.example.arogya

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Movie
import android.graphics.Paint
import android.os.SystemClock
import android.util.AttributeSet
import android.view.View
import java.io.IOException
import java.io.InputStream


@SuppressLint("NewApi")
class GifAnimView(context: Context, attrs: AttributeSet) :
    View(context, attrs) {
    private val _context: Context
    private var gifMovie: Movie? = null
    private var gifName: String? = "not set"
    private var gifStream: InputStream? = null
    private var width = 0
    private var height = 0
    private var startTime: Long = 0
    private var paint: Paint? = null

    init {
        initGif(context, attrs)
        _context = context
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (gifStream == null || gifMovie == null) {
            canvas.drawColor(Color.WHITE)
            canvas.drawText(gifName!!, (width / 2).toFloat(), (height / 2).toFloat(), paint!!)
            return
        }
        val now = SystemClock.uptimeMillis()
        val relTime = ((now - startTime) % gifMovie!!.duration()).toInt()
        gifMovie!!.setTime(relTime)
        gifMovie!!.draw(canvas, 0f, 0f)
        this.invalidate()
    }

    private fun initGif(context: Context, attrs: AttributeSet) {
        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.GifAnimView, 0, 0
        )
        gifName = a.getString(R.styleable.GifAnimView_gifSrc)
        try {
            gifStream = context.assets.open(gifName!!)
            gifMovie = Movie.decodeStream(gifStream)
            startTime = SystemClock.uptimeMillis()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        paint = Paint()
        paint!!.textSize = 40f
        paint!!.textAlign = Paint.Align.CENTER
        paint!!.style = Paint.Style.FILL
        a.recycle()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        width = w
        height = h
        super.onSizeChanged(w, h, oldw, oldh)
    }
}