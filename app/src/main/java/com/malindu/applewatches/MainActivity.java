package com.malindu.applewatches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        CarouselView carouselView=findViewById(R.id.caroselview);
        carouselView.setPageCount(3);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                switch (position){

                    case 0:
                        imageView.setImageResource(R.drawable.image1);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.image2);
                        break;
                    default:
                        imageView.setImageResource(R.drawable.image3);




                }
            }
        });
    }

    int qunatity=1;/**declare integer type variable for quantity**/
    float totprice; /**declare float type variable for price**/
    float item; /**declare float type variable for item**/
    public void decrease(View view){

        qunatity-=1;

        TextView displayInteger=(TextView)findViewById(R.id.quantity);

        if(qunatity<0){
            qunatity=0;
            displayInteger.setText(""+ qunatity);

        }
        else{

            displayInteger.setText(""+ qunatity);
        }
        price();

    }/**quanity decrease button method**/


    public void increase(View view){

        qunatity+=1;
        TextView displayInteger=(TextView)findViewById(R.id.quantity);
        if(qunatity<0){
            qunatity=0;
            displayInteger.setText(""+ qunatity);

        }
        else{

            displayInteger.setText(""+ qunatity);
        }
        price();
    }/**quanity increase button method**/

    public void price(){
        TextView displayFloat=findViewById(R.id.price);
        totprice=qunatity*item;
        displayFloat.setText("$"+totprice);
    }/**new method create for price calculate**/

    public  void  cart(View view){

        Context context=getApplicationContext();

        CharSequence text="Item Added to your Cart";

        int duration= Toast.LENGTH_LONG;
        Toast toast=Toast.makeText(context,text,duration);
        toast.show();

    }/**onclick method popup message**/

    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.one:
                if (checked){
                    item=450;
                    price();
                }

                    break;
            case R.id.two:
                if (checked){
                    item=300;
                    price();
                }

                    break;
            default:
                if (checked){
                    item=500;
                    price();
                }
        }


    }/**Radio button method for sizes**/




}