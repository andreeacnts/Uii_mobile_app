package p6.uii_mobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import p6.uii_mobile.R;

public class jogging extends AppCompatActivity {

    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public ImageButton position_back;
    public ImageButton position_forward;
    public ImageButton position_left;
    public ImageButton position_right;
    public ImageButton position_up;
    public ImageButton position_down;
    public ImageButton close;
    public ImageButton open;
    public ImageButton orientation_up;
    public ImageButton orientation_down;
    public ImageButton orientation_left;
    public ImageButton orientation_right;
    public ImageButton rotation_left;
    public ImageButton rotation_right;


    private static Socket s;
    private static ServerSocket ss;
    private static InputStreamReader isr;
    private static BufferedReader br;
    private static PrintWriter printWriter;
    private String ip;
    private int port;
    String message = "";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogging);

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            ip = extras.getString("ServerIP");
            port = Integer.parseInt(extras.getString("ServerPort"));
        }




        position_forward = findViewById(R.id.position_forward);

        position_forward.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                myTask task;
                task = new myTask ();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message = "Moving forward\n";
                        Toast.makeText(getApplicationContext(), Integer.toString(port), Toast.LENGTH_SHORT).show();
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message = "Stopped\n";
                        Toast.makeText(getApplicationContext(), ip, Toast.LENGTH_SHORT).show();
                        task.execute();
                        break;
                    default:
                        break;
                }

                return false;
            }



        });
        position_back = findViewById(R.id.position_back);

        position_back.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message = "Moving backward\n";
                        // Toast.makeText(getApplicationContext(), message , Toast.LENGTH_SHORT).show();
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message = "Stopped\n";
                        // Toast.makeText(getApplicationContext(), message , Toast.LENGTH_SHORT).show();
                        task.execute();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        position_left = findViewById(R.id.position_left);

        position_left.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message = "Moving left\n";
                        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message = "Stopped\n";
                        //  Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        task.execute();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        position_right = findViewById(R.id.position_right);

        position_right.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Moving right\n";
                        // Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message = "Stopped\n";
                        // Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        task.execute();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        position_up = findViewById(R.id.position_up);

        position_up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Moving up\n";
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message = "Stopped\n";
                        task.execute();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        position_down = findViewById(R.id.position_down);

        position_down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Moving down\n";
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message = "Stopped\n";
                        task.execute();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        close = findViewById(R.id.close);

        close.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Closed\n";
                        task.execute();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        open = findViewById(R.id.open);

        open.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Open\n";
                        task.execute();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        orientation_down = findViewById(R.id.orientation_down);

        orientation_down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Rotating y backward\n";
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message ="Stopped\n";
                        task.execute();
                    default:
                        break;
                }
                return false;
            }
        });

        orientation_up = findViewById(R.id.orientation_up);

        orientation_up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Rotating y forward\n";
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message ="Stopped\n";
                        task.execute();
                    default:
                        break;
                }
                return false;
            }
        });

        orientation_left = findViewById(R.id.orientation_left);

        orientation_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Rotating x backward\n";
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message ="Stopped\n";
                        task.execute();
                    default:
                        break;
                }
                return false;
            }
        });

        orientation_right = findViewById(R.id.orientation_right);

        orientation_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Rotating x forward\n";
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message ="Stopped\n";
                        task.execute();
                    default:
                        break;
                }
                return false;
            }
        });

        rotation_left = findViewById(R.id.rotation_left);

        rotation_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Rotating z backward\n";
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message ="Stopped\n";
                        task.execute();
                    default:
                        break;
                }
                return false;
            }
        });

        rotation_right = findViewById(R.id.rotation_right);

        rotation_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                myTask task;
                task = new myTask();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        message ="Rotating z forward\n";
                        task.execute();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        message ="Stopped\n";
                        task.execute();
                    default:
                        break;
                }
                return false;
            }
        });
    }

    class myTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... params)
        {
            try
            {
                s = new Socket (ip, port);
                printWriter = new PrintWriter(s.getOutputStream());
                printWriter.write(message);
                printWriter.flush();
                printWriter.close();
                s.close();


            }catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        }
    }


}

