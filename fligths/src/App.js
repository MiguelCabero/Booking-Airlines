import Layout from "./Layout";
import { Routes, Route } from "react-router-dom";
import Main from "./Components/Main";
import NotFound from "./NotFound/NotFoundComponent";
import About from "./Components/AboutComponent/About";
import Login from "./Components/LoginComponent/Login";
function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" exact={true} element={<Main />} />
        <Route path="/about" exact={true} element={<About />} />
        <Route path="*" exact={true} element={<NotFound />} />
        <Route path="/login" exact={true} element={<Login />} />
      </Routes>
    </Layout>
  );
}

export default App;
