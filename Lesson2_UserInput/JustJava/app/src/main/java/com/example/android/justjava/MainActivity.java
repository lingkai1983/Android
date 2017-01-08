/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 *
 */
package com.example.android.justjava;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

import static android.R.attr.checked;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

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
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
    * @param number
    * @param  creamChecked
     */

    private  String createOrderSummary(int number, boolean creamChecked, boolean chocolateChcecked){
        String s = "Name: Lingkai Zuo\n";
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
        int totalPrice = calculatePrice();

        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        boolean creamChecked = checkbox.isChecked();

        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean  chocolateChecked = chocolateCheckbox.isChecked();

        String priceMessage = createOrderSummary(totalPrice,creamChecked,chocolateChecked);
        displayMessage(priceMessage);
    }

    public void increment(View view){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        quantity = quantity - 1;
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
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}
