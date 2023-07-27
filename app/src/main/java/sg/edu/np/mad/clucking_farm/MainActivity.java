package sg.edu.np.mad.clucking_farm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView countdownText;
    private Button countdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 3600000;
    private boolean timerRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent secondActivityIntent = new Intent(
                this, MainActivity.class
        );
        startActivity(secondActivityIntent);

        countdownText = findViewById(R.id.countdown_text);
        countdownButton = findViewById(R.id.countdown_button);

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });

        updateTimer();
    }
    public void startStop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        countdownButton.setText("Pause");
        timerRunning = true;
    }
    public void stopTimer() {
        countDownTimer.cancel();
        countdownButton.setText("Start");
        timerRunning = false;
    }
    public void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 /1000;

        String timeLeftText;
        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }
}