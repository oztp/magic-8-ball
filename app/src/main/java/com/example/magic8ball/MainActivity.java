package com.example.magic8ball;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.animation.RotateAnimation;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ball;
    private TextView respuesta;
    private String[] respuestaArray = {"ni vendiendo tu alma", "iras al infierno pero si", "se cumplira sin esfuerzo", "aprobado por baphomet",
            "reza a otro santo", "por 10 almas quiza", "no pasara", "dios dice si, yo no"};
    private boolean reestablecer;
    private int angulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // variable de la imagen
        ball = findViewById(R.id.boton);
        //segundo texto
        respuesta = findViewById(R.id.respuesta);

        ball.setOnClickListener(this);

        Toast.makeText(MainActivity.this, "buscando...", Toast.LENGTH_SHORT).show();

        TextView tx = (TextView) findViewById(R.id.titulo);
        Typeface Fuentea = Typeface.createFromAsset(getAssets(), "fuentes/Bloodthirsty.ttf");
        tx.setTypeface(Fuentea);


        TextView tex = (TextView) findViewById(R.id.respuesta);
        Typeface fuenteb = Typeface.createFromAsset(getAssets(), "fuentes/Bloodthirsty.ttf");
        tex.setTypeface(fuenteb);
    }

    @Override
    public void onClick(View v) {

            RotateAnimation animation = new RotateAnimation(0, 360,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(2000);
            ball.startAnimation(animation);

            switch (v.getId()) {
            case R.id.boton:
                int random = new Random().nextInt(respuestaArray.length);
                respuesta.setText(respuestaArray[random]);
                break;
        }

    }

}
