package vn.edu.stu.phuongtrinhbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText txtSoA,txtSoB,txtSoC;
    Button btnTim;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls(){
        txtSoA = findViewById(R.id.txtSoA);
        txtSoB = findViewById(R.id.txtSoB);
        txtSoC = findViewById(R.id.txtSoC);
        btnTim = findViewById(R.id.btnTim);
        txtKetQua = findViewById(R.id.txtKetQua);
    }

    private void addEvents(){
        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtSoA.getText().toString().isEmpty()&&!txtSoB.getText().toString().isEmpty() &&!txtSoC.getText().toString().isEmpty()) {
                    double a = Double.parseDouble(txtSoA.getText().toString());
                    double b = Double.parseDouble(txtSoB.getText().toString());
                    double c = Double.parseDouble(txtSoC.getText().toString());
                    String ketqua = giaiPhuongTrinhBac2(a, b, c);
                    txtKetQua.setText(ketqua);
                }
            }
        });
    }

    private String giaiPhuongTrinhBac2(double a, double b, double c) {
        String result = "";
        if (a + b + c == 0) {
            double x2 = c / a;
            result = "PTB2 co 2 nghiem phan biet  x1 = 1" + ", x2 = " + String.valueOf(x2);
        }
        else if (a - b + c == 0) {
            double x2 = -c / a;
            result = "PTB2 co 2 nghiem phan biet  x1 = -1" + ", x2 = " + String.valueOf(x2);
        }
        else {
            double delta = Math.pow(b, 2) - 4 * a * c;
            if (delta < 0) {
                result = "PTB2 vo nghiem";
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "PTB2 co nghiem kep  x1 = x2 = " + String.valueOf(x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "PTB2 co 2 nghiem phan biet  x1 = " + String.valueOf(x1) + ", x2 = " + String.valueOf(x2);
            }
        }
        return result;
    }

}


