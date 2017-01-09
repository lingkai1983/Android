/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 *
 */
package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(boolean hasCream, boolean hasChocolate) {
        int price = quantity * 5;

        if(hasCream){
            price = price + quantity*1;
        }

        if (hasChocolate) {
            price = price + quantity*2;
        }

        return price;
    }

    /**
    * @param number
    * @param  creamChecked
     */

    private  String createOrderSummary(int number, boolean creamChecked, boolean chocolateChcecked,
                                       String userName){
        String s = "Name: " +userName + "\n";
        s += "Added Whipped Cream? " +  creamChecked + "\n";
        s += "Adeed Chocolate? " + chocolateChcecked + "\n";
        s += "Quantity: " + quantity +"\n";
        s += "Total: $" + number +"\n";
        s += "Thank you!";
        return s;
        }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        boolean creamChecked = checkbox.isChecked();

        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean  chocolateChecked = chocolateCheckbox.isChecked();

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String userName = nameField.getText().toString();

        int totalPrice = calculatePrice(creamChecked, chocolateChecked);

        // generate the message want to send
        String priceMessage = createOrderSummary(totalPrice,creamChecked,chocolateChecked,userName);

        // create an intent to send email
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Jave Order to: " + userName);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        // displayMessage(priceMessage);
    }

    public void increment(View view){
        if (quantity <= 9) {
            quantity = quantity + 1;
        } else {
            Context context = getApplicationContext();
            CharSequence text = "You can only order up to 10 coffees!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        displayQuantity(quantity);
    }

    public void decrement(View view){
        if (quantity >=2) {
            quantity = quantity - 1;
        } else {
            Context context = getApplicationContext();
            CharSequence text = "You need to order at least 1 cup of coffee";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
        }

        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
/*    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }*/

}
