package nhs90139.hal.ac.oxgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton[] rectButtons = new ImageButton[9];
    private boolean senkou = true;
    private int[] button_flag = {9,9,9,9,9,9,9,9,9};
    private int win = 0;
    private int nogameset = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rectButtons[0] = (ImageButton)findViewById(R.id.left_top);
        rectButtons[1] = (ImageButton)findViewById(R.id.top);
        rectButtons[2] = (ImageButton)findViewById(R.id.right_top);
        rectButtons[3] = (ImageButton)findViewById(R.id.left);
        rectButtons[4] = (ImageButton)findViewById(R.id.center);
        rectButtons[5] = (ImageButton)findViewById(R.id.right);
        rectButtons[6] = (ImageButton)findViewById(R.id.left_bottom);
        rectButtons[7] = (ImageButton)findViewById(R.id.bottom);
        rectButtons[8] = (ImageButton)findViewById(R.id.right_bottom);

        resetGame();
    }

    //メニュー
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.reset:
                resetGame();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //リセット
    private void resetGame(){
        for (int i=0; i < 9; i++){
            rectButtons[i].setBackgroundResource(R.drawable.none);
            button_flag[i] = 9;
        }
        win = 0;
        senkou = true;
        nogameset=0;
    }

    //勝敗
    private void judg(){
    for (int i = 0; i < 7; i = i + 3){
        if (button_flag[i] == 0 && button_flag[i + 1] == 0 && button_flag[i + 2] == 0) {
            Toast myToast = Toast.makeText(this,"勝利",Toast.LENGTH_SHORT);
            myToast.show();
            win=1;
        }else if (button_flag[i] == 1 && button_flag[i + 1] == 1 && button_flag[i + 2] == 1){
            Toast myToast = Toast.makeText(this,"勝利",Toast.LENGTH_SHORT);
            myToast.show();
            win=1;
        }
    }

    for (int i = 0; i < 2; i++){
        if (button_flag[i] == 0 && button_flag[i + 3] == 0 && button_flag[i + 6] == 0) {
            Toast myToast = Toast.makeText(this,"勝利",Toast.LENGTH_SHORT);
            myToast.show();
            win=1;
        }else if (button_flag[i] == 1 && button_flag[i + 3] == 1 && button_flag[i + 6] == 1){
            Toast myToast = Toast.makeText(this,"勝利",Toast.LENGTH_SHORT);
            myToast.show();
            win=1;
        }
        }

    if (button_flag[0] == 0 && button_flag[4] == 0 && button_flag[8] == 0) {
        Toast myToast = Toast.makeText(this, "〇勝利", Toast.LENGTH_SHORT);
        myToast.show();
        win=1;
    }

    if (button_flag[2] == 0 && button_flag[4] == 0 && button_flag[6] == 0) {
        Toast myToast = Toast.makeText(this, "〇勝利", Toast.LENGTH_SHORT);
        myToast.show();
        win=1;
    }

    if (button_flag[0] == 1 && button_flag[4] == 1 && button_flag[8] == 1) {
        Toast myToast = Toast.makeText(this, "〇勝利", Toast.LENGTH_SHORT);
        myToast.show();
        win=1;
    }

    if (button_flag[2] == 1 && button_flag[4] == 1 && button_flag[6] == 1) {
        Toast myToast = Toast.makeText(this, "〇勝利", Toast.LENGTH_SHORT);
        myToast.show();
        win=1;
    }

    if (nogameset==8 && win == 0){
        Toast myToast = Toast.makeText(this, "引き分け", Toast.LENGTH_SHORT);
        myToast.show();
    }
    }



    public void buttonMethod(View OXButton){
        ImageButton aImageButton = (ImageButton)OXButton;
        if (win == 0) {
            switch (OXButton.getId()) {
                case R.id.left_top:
                    if (button_flag[0] == 9) {
                        if (senkou) {
                            aImageButton.setBackgroundResource(R.drawable.maru);
                            senkou = false;
                            button_flag[0] = 0;
                            judg();
                            nogameset++;
                        } else {
                            aImageButton.setBackgroundResource(R.drawable.batu);
                            senkou = true;
                            button_flag[0] = 1;
                            judg();
                            nogameset++;
                        }
                    }
                    break;

                case R.id.top:
                    if (button_flag[1] == 9) {
                        if (senkou) {
                            aImageButton.setBackgroundResource(R.drawable.maru);
                            senkou = false;
                            button_flag[1] = 0;
                            judg();
                            nogameset++;
                        } else {
                            aImageButton.setBackgroundResource(R.drawable.batu);
                            senkou = true;
                            button_flag[1] = 1;
                            judg();
                            nogameset++;
                        }
                    }
                    break;

                case R.id.right_top:
                    if (button_flag[2] == 9) {
                        if (senkou) {
                            aImageButton.setBackgroundResource(R.drawable.maru);
                            senkou = false;
                            button_flag[2] = 0;
                            judg();
                            nogameset++;
                        } else {
                            aImageButton.setBackgroundResource(R.drawable.batu);
                            senkou = true;
                            button_flag[2] = 1;
                            judg();
                            nogameset++;
                        }
                    }
                    break;

                case R.id.left:
                    if (button_flag[3] == 9) {
                        if (senkou) {
                            aImageButton.setBackgroundResource(R.drawable.maru);
                            senkou = false;
                            button_flag[3] = 0;
                            judg();
                            nogameset++;
                        } else {
                            aImageButton.setBackgroundResource(R.drawable.batu);
                            senkou = true;
                            button_flag[3] = 1;
                            judg();
                            nogameset++;
                        }
                    }
                    break;

                case R.id.center:
                    if (button_flag[4] == 9) {
                        if (senkou) {
                            aImageButton.setBackgroundResource(R.drawable.maru);
                            senkou = false;
                            button_flag[4] = 0;
                            judg();
                            nogameset++;
                        } else {
                            aImageButton.setBackgroundResource(R.drawable.batu);
                            senkou = true;
                            button_flag[4] = 1;
                            judg();
                            nogameset++;
                        }
                    }
                    break;

                case R.id.right:
                    if (button_flag[5] == 9) {
                        if (senkou) {
                            aImageButton.setBackgroundResource(R.drawable.maru);
                            senkou = false;
                            button_flag[5] = 0;
                            judg();
                            nogameset++;
                        } else {
                            aImageButton.setBackgroundResource(R.drawable.batu);
                            senkou = true;
                            button_flag[5] = 1;
                            judg();
                            nogameset++;
                        }
                    }
                    break;

                case R.id.left_bottom:
                    if (button_flag[6] == 9) {
                        if (senkou) {
                            aImageButton.setBackgroundResource(R.drawable.maru);
                            senkou = false;
                            button_flag[6] = 0;
                            judg();
                            nogameset++;
                        } else {
                            aImageButton.setBackgroundResource(R.drawable.batu);
                            senkou = true;
                            button_flag[6] = 1;
                            judg();
                            nogameset++;
                        }
                    }
                    break;

                case R.id.bottom:
                    if (button_flag[7] == 9) {
                        if (senkou) {
                            aImageButton.setBackgroundResource(R.drawable.maru);
                            senkou = false;
                            button_flag[7] = 0;
                            judg();
                            nogameset++;
                        } else {
                            aImageButton.setBackgroundResource(R.drawable.batu);
                            senkou = true;
                            button_flag[7] = 1;
                            judg();
                            nogameset++;
                        }
                    }
                    break;

                case R.id.right_bottom:
                    if (button_flag[8] == 9) {
                        if (senkou) {
                            aImageButton.setBackgroundResource(R.drawable.maru);
                            senkou = false;
                            button_flag[8] = 0;
                            judg();
                            nogameset++;
                        } else {
                            aImageButton.setBackgroundResource(R.drawable.batu);
                            senkou = true;
                            button_flag[8] = 1;
                            judg();
                            nogameset++;
                        }
                    }
                    break;
            }
        }
    }
}
