package com.tecmi.oscar.androidactividad3v5;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private static final String debugTag = "Gestures";
    private GestureDetectorCompat mDetector;
    private TextView textView;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        textView = findViewById(R.id.hola_mundo);
        /*textView.setText("Touch coordinates : " +
                String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
        textView.setTextColor(Color.RED);//Opaca a los demas
        */
        /*view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLACK);*/ //Opaca a los demas

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(debugTag,"on Down event presente");//Crashea si tratas de cambiar el texto o la pantalla
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {//Si jala
        textView.setText("MAGENTA");
        textView.setTextColor(Color.MAGENTA);
        view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.GRAY);
        textView.setTextAppearance(this, R.style.CasualBold);
        view.requestPointerCapture();
        return false;
    }
    @Override
    public boolean onDoubleTap(MotionEvent event) {//Si jala, pero no el texto
        textView.setText("NEGRO");
        textView.setTextColor(Color.BLACK);
        view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.WHITE);
        textView.setTextAppearance(this, R.style.SansSerifCondensedNormal);
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {//Si jala
        //if the second tap hadn't been released and it's being moved
        if(event.getAction() == MotionEvent.ACTION_MOVE)
        {
            textView.setText("VERDE");
            textView.setTextColor(Color.GREEN);
            view = this.getWindow().getDecorView();
            view.setBackgroundColor(Color.MAGENTA);
            textView.setTextAppearance(this, R.style.SerifMonospaceItalic);
        }
        else if(event.getAction() == MotionEvent.ACTION_UP)//user released the screen
        {
            textView.setText("VERDE");
            textView.setTextColor(Color.GREEN);
            view = this.getWindow().getDecorView();
            view.setBackgroundColor(Color.MAGENTA);
            textView.setTextAppearance(this, R.style.SerifMonospaceItalic);
        }
        return false;
    }



    @Override
    public void onShowPress(MotionEvent event) {//Si jala
        textView.setText("GRIS");
        textView.setTextColor(Color.GRAY);
        view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.YELLOW);
        textView.setTextAppearance(this, R.style.SansSerifBold);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {//Si jala
        textView.setText("CYAN");
        textView.setTextColor(Color.CYAN);
        view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLACK);
        textView.setTextAppearance(this, R.style.CursiveBold);
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {//Si jala
        textView.setText("BLANCO");
        textView.setTextColor(Color.WHITE);
        view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLUE);
        textView.setTextAppearance(this, R.style.CasualItalic);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {//Si jala
        textView.setText("AZUL");
        textView.setTextColor(Color.BLUE);
        view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.GREEN);
        textView.setTextAppearance(this, R.style.CursiveItalic);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {//Si jala
        textView.setText("AMARILLO");
        textView.setTextColor(Color.YELLOW);
        view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.RED);
        textView.setTextAppearance(this, R.style.CursiveNormal);
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {//Si jala
        textView.setText("ROJO");
        textView.setTextColor(Color.RED);
        view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLACK);
        textView.setTextAppearance(this, R.style.SansSerifCondensedBold);

    }
}

