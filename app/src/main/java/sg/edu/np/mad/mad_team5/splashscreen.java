package sg.edu.np.mad.mad_team5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class splashscreen extends AppCompatActivity {

    ProgressBar pb;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        progbar();
    }

    public void progbar()
    {
        pb = findViewById(R.id.progressBar);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run()
            {
                counter++;
                pb.setProgress(counter);

                if(counter == 100)
                    t.cancel();

            }
        };
        t.schedule(tt,0,100);
    }
}