package nhs90139.hal.ac.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.Instant;


public class MainActivity extends AppCompatActivity {
private EditText height,width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText)findViewById(R.id.height);
        width = (EditText)findViewById(R.id.width);
    }

    public void ButtonMethod(View myButton){
//BMI
        String strH = height.getText().toString();
        String strW = width.getText().toString();

        float H = Float.parseFloat(strH);
        float W = Float.parseFloat(strW);

        H = H/100;

        float BMI = W / ( H * H );

        //標準体重
        float STN = H * H * 22;

        float DIF = STN - W;





        Intent result_act = new Intent(MainActivity.this,Result.class);
        result_act.putExtra("bmi",BMI);
        result_act.putExtra("dif",DIF);
        startActivity(result_act);

    }
}
