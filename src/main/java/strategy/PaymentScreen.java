package strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {

    private WebDriver driver;
    private UserInformation userInformation;
    private Checkout checkout;
    private PaymentOptions paymentOptions;

    public PaymentScreen(WebDriver driver){
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.checkout = PageFactory.initElements(driver, Checkout.class);
    }

    public void goTo(){
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }


    public UserInformation getUserInformation(){
        return this.userInformation;
    }

    public Checkout getCheckout(){
        return this.checkout;
    }

    public PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(PaymentOptions paymentOptions) {
        this.paymentOptions = paymentOptions;
        PageFactory.initElements(driver, this.paymentOptions);
    }

    public void pay(Map<String, String> paymentDetails){
        this.paymentOptions.enterPaymentInformation(paymentDetails);
    }
}
