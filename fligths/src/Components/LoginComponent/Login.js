import { React, useContext, useRef } from "react";
import "./Login.component.css";
import AppContext from "../../store/app-context";
import axios from "axios";
import AdminView from "../AdminComponent/AdminView";
const Login = () => {
  const emailRef = useRef(null);
  const passwordRef = useRef(null);
  const currentAutenticated = useContext(AppContext);

  async function request(event) {
    event.preventDefault();
    try {
      await axios
        .post(
          "http://localhost:8081/api/auth",
          {
            email: emailRef.current.value,
            password: passwordRef.current.value,
          },
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        )
        .then((response) => (window.location.href = "/"));
    } catch (err) {
      if (err.response) alert("Wrong user");
    }
  }
  return (
    <div className="login-form">
      <form>
        <div className="input-container">
          <label htmlFor="email">Email: </label>
          <input type="email" placeholder="Email" name="email" ref={emailRef} />
        </div>
        <div className="input-container">
          <label htmlFor="password">Password: </label>
          <input
            type="password"
            placeholder="Password"
            name="password"
            ref={passwordRef}
          />
        </div>
        <div className="submit-container">
          <input type="submit" defaultValue="Accept" onClick={request} />
        </div>
      </form>
    </div>
  );
};

export default Login;
