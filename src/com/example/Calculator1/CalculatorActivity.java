package com.example.Calculator1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    char operator = 0;
    double op1 = 0;
    boolean dotted=false, clear=false;

    Button n0,n1,n2,n3,n4,n5,n6,n7,n8,n9,add,minus,product,div,signal,power,sqrt,c,ce,dot,mosavi;
    EditText screen;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        n0= (Button)findViewById(R.id.n0);
        n1= (Button)findViewById(R.id.n1);
        n2= (Button)findViewById(R.id.n2);
        n3= (Button)findViewById(R.id.n3);
        n4= (Button)findViewById(R.id.n4);
        n5= (Button)findViewById(R.id.n5);
        n6= (Button)findViewById(R.id.n6);
        n7= (Button)findViewById(R.id.n7);
        n8= (Button)findViewById(R.id.n8);
        n9= (Button)findViewById(R.id.n9);
        add= (Button)findViewById(R.id.add);
        minus= (Button)findViewById(R.id.minus);
        product= (Button)findViewById(R.id.product);
        div= (Button)findViewById(R.id.div);
        signal= (Button)findViewById(R.id.signal);
        power= (Button)findViewById(R.id.power);
        sqrt= (Button)findViewById(R.id.sqrt);
        c= (Button)findViewById(R.id.c);
        ce= (Button)findViewById(R.id.ce);
        dot= (Button)findViewById(R.id.dot);
        screen= (EditText)findViewById(R.id.screen);
        mosavi = (Button) findViewById(R.id.mosavi);

        mosavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                func();
                operator = 0;
            }
        });

        n0.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('0');}
        });
        n1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('1');}
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('2');}
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('3');}
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('4');}
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('5');}
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('6');}
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('7');}
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('8');}
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {insert('9');}
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                if(!dotted){
                    insert('.');
                    dotted=true;
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                if(operator==0) op1 = Double.parseDouble(screen.getText().toString());
                else func();
                operator='+';
                clear=true;
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                if(operator==0) op1 = Double.parseDouble(screen.getText().toString());
                else func();
                operator='-';
                clear=true;
            }
        });
        product.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                if(operator==0) op1 = Double.parseDouble(screen.getText().toString());
                else func();
                operator='*';
                clear=true;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                if(operator==0) op1 = Double.parseDouble(screen.getText().toString());
                else func();
                operator='/';
                clear=true;
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                if(operator==0) op1 = Double.parseDouble(screen.getText().toString());
                else func();
                operator='p';
                clear=true;
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                if(operator==0) op1 = Double.parseDouble(screen.getText().toString());
                else func();
                operator='s';
                clear=true;
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                if(clear) {screen.setText("0");}
                String sc= screen.getText().toString();
                int len= sc.length();
                if(sc.charAt(len-1)=='.') dotted=false;
                if(len>1)screen.setText(screen.getText().delete(len-1, len));
                else screen.setText("0");

            }
        });
        ce.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                screen.setText("0");
                dotted=false;
                operator=0;
                op1=0;
            }
        });
        signal.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                if(screen.getText().charAt(0) != '-')
                    screen.setText("-" + screen.getText());
                else
                    screen.setText(screen.getText().delete(0, 1));
            }
        });
    }

    void insert(char n)
    {
        String s= screen.getText().toString();
        if((s.length() == 1 && s.charAt(0) == '0') || clear) {
            screen.setText(n + "");
            clear = false;
            dotted = false;
        } else
            screen.setText(s + n);
    }

    void func(){
        switch (operator) {
            case '+': op1 = op1 + Double.parseDouble(screen.getText().toString());break;
            case '-': op1 = op1 - Double.parseDouble(screen.getText().toString());break;
            case '*': op1 = op1 * Double.parseDouble(screen.getText().toString());break;
            case '/': op1 = op1 / Double.parseDouble(screen.getText().toString());break;
            case 'p': op1 = Math.pow(op1, Double.parseDouble(screen.getText().toString()));break;
            case 's': op1 = Math.sqrt(op1);break;
        }
        screen.setText( op1 + "" );
    }
}
