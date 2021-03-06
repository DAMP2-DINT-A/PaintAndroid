package com.example.asus.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by asus on 22/01/2017.
 */

public class Pizarra extends View {
    private float x, y = 50;
    private String accion = "Accion";
    public int colorido=Color.BLUE;
    public int ancho=6;
    public boolean flag=false;

    public Paint paint;
    public Path path;

    public Pizarra(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        paint = new Paint();
        path = new Path();



    }



    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        // Rellenar canvas

        if(flag==false) {

            canvas.drawColor(Color.WHITE);


            // Configurar lapiz

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(ancho);
            paint.setColor(colorido);


            if (accion.equals("DOWN)")) {
                // Cambiar posicion comienzo path
                path.moveTo(x, y);
            }
            if (accion.equals("MOVE")) {
                // A�adir l�nea al path
                path.lineTo(x, y);
            }

        }
        if(flag){

            canvas.drawColor(Color.WHITE);


            // Configurar lapiz

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(ancho);
            paint.setColor(colorido);


            if (accion.equals("DOWN)")) {
                // Cambiar posicion comienzo path
                path.moveTo(x, y);
            }
            if (accion.equals("MOVE")) {
                // A�adir l�nea al path
                path.lineTo(x, y);
            }

        }
        canvas.drawPath(path, paint);
    }

    public int color(int color){
        paint.setColor(color);

        return color;

    }

    public void clearCanvas()
    {
        flag =true;
        invalidate();
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        x = event.getX();
        y = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            accion = "DOWN";
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE){
            accion = "MOVE";
        }

        invalidate();
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
