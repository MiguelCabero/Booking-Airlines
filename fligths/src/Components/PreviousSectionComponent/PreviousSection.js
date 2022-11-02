import AppContext from "../../store/app-context";
import useContext from "react";

const PreviousSection = () => {
  const currentAppContext = useContext(AppContext);
  function handlePrevious(event) {
    event.preventDefault();
    currentAppContext.setStep(--currentAppContext.step);
  }

  return (
    <>
      <button onClick={handlePrevious}>Previous Section</button>
      {/* <input type={button}>Previous Section</input> */}
    </>
  );
}

export default PreviousSection;
