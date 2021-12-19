package nhs90139.hal.ac.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class Result extends AppCompatActivity {
    private TextView bmi_1, judgment,stn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        bmi_1 = (TextView)findViewById(R.id.bmi);
        judgment = (TextView)findViewById(R.id.judgment);
        stn = (TextView)findViewById(R.id.stn);

        Bundle extras = getIntent().getExtras();
        if(judgment != null){
            Float bmi = extras.getFloat("bmi");
            Float dif = extras.getFloat("dif");

            bmi_1.setText(String.valueOf(bmi));
            stn.setText(String.valueOf(dif));

            if (bmi < 18.5){
                judgment.setText(R.string.slim);
            }else if(bmi > 25.0){
                judgment.setText(R.string.fat);
            }else {
                judgment.setText(R.string.normal);
            }


        }
    }

    public void ButtonMethod2(View myButton){
        finish();

        Intent result_act = new Intent(Result.this,MainActivity.class);
        startActivity(result_act);
    }
}
