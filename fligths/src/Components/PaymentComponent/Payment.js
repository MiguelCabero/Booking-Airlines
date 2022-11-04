import React from "react";
import "./Payment.component.css";

function Payment() {
  return (
    <div className="row">
      <link
        href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css"
        rel="stylesheet"
        type="text/css"
      ></link>
      <div className="col-75">
        <div className="container">
          <form action="/action_page.php">
            <div className="row">
              <div className="col-50">
                <h3>Billing Address</h3>
                <label htmlFor="fname">
                  <i className="fa fa-user"></i> Full Name
                </label>
                <input type="text" id="fname" name="firstname" placeholder="" />
                <label htmlFor="email">
                  <i className="fa fa-envelope"></i> Email
                </label>
                <input type="text" id="email" name="email" placeholder="" />
                <label htmlFor="adr">
                  <i className="fa fa-address-card-o"></i> Address
                </label>
                <input type="text" id="adr" name="address" placeholder="" />
                <label htmlFor="city">
                  <i className="fa fa-institution"></i> City
                </label>
                <input type="text" id="city" name="city" placeholder="" />

                <div className="row">
                  <div className="col-50">
                    <label htmlFor="state">State</label>
                    <input type="text" id="state" name="state" placeholder="" />
                  </div>
                  <div className="col-50">
                    <label htmlFor="zip">Zip</label>
                    <input type="text" id="zip" name="zip" placeholder="" />
                  </div>
                </div>
              </div>

              <div className="col-50">
                <h3>Payment</h3>
                <label htmlFor="fname">Accepted Cards</label>
                <div className="icon-container">
                  <i className="fa fa-cc-visa"></i>
                  <i className="fa fa-cc-amex"></i>
                  <i className="fa fa-cc-mastercard"></i>
                  <i className="fa fa-cc-discover"></i>
                </div>
                <label htmlFor="cname">Name on Card</label>
                <input type="text" id="cname" name="cardname" placeholder="" />
                <label htmlFor="ccnum">Credit card number</label>
                <input
                  type="text"
                  id="ccnum"
                  name="cardnumber"
                  placeholder=""
                />
                <label htmlFor="expmonth">Exp Month</label>
                <input
                  type="text"
                  id="expmonth"
                  name="expmonth"
                  placeholder=""
                />

                <div className="row">
                  <div className="col-50">
                    <label htmlFor="expyear">Exp Year</label>
                    <input
                      type="text"
                      id="expyear"
                      name="expyear"
                      placeholder=""
                    />
                  </div>
                  <div className="col-50">
                    <label htmlFor="cvv">CVV</label>
                    <input type="text" id="cvv" name="cvv" placeholder="" />
                  </div>
                </div>
              </div>
            </div>
            <label>
              <input type="checkbox" name="sameadr" />
              Shipping address same as billing
            </label>
            <input type="button" value="Continue to checkout" className="btn" />
          </form>
        </div>
      </div>
    </div>
  );
}

export default Payment;
