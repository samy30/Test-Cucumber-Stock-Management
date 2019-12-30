package tp1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import static tp1.refundConstants.MAX_DAYS;
import static tp1.refundConstants.MAX_STOCK;

class CanHeRefund {

    static String canHeRefund(int daysSinceTransaction, int stock, double cash, double price, int numberOfPieces, boolean isProductDamaged) {
        if((daysSinceTransaction <= MAX_DAYS)&&(stock + numberOfPieces <= MAX_STOCK )&&(cash-price >=0)&&(!isProductDamaged))
        return ("Yup");
        else {
            return ("Nope");
        }
    }
}

public class StepDefinitions {
    private int daysSinceTransaction;
    private int stock;
    private double cash;
    private boolean isProductDamaged;
    private double price;
    private int numberOfPieces;
    private String actualAnswer;

    @Given("transaction done {int} days ago")
    public void transaction_done_days_ago(Integer int1) {
        daysSinceTransaction = int1;
    }

    @Given("Stock is {int}")
    public void stock_is(Integer int1) {
        stock = int1;
    }


    @Given("Product is Damaged")
    public void product_is_Damaged() {
        isProductDamaged = true;
    }

    @Given("Product is Not Damaged")
    public void product_is_Not_Damaged() {
        isProductDamaged = false;
    }

    @Given("Cash is {double}")
    public void cash_is(Double double1) {
        cash = double1;
    }

    @Given("Price is {double}")
    public void price_is(Double double1) {
        price = double1;
    }



    @Given("NumberOfPieces is {int}")
    public void numberofpieces_is(Integer int1) {
        numberOfPieces = int1;
    }

    @When("I ask whether he can get refund")
    public void i_ask_whether_he_can_get_refund() {
        actualAnswer = CanHeRefund.canHeRefund(daysSinceTransaction,stock,cash,price,numberOfPieces,isProductDamaged);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }


}
