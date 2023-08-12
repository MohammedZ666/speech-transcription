import React, { useState } from "react";
import "./GenerateInput.css";

const GenerateInput = (props) => {
  const [focused, setFocused] = useState(false);
  const { label, errorMessage, onChange, id, ...inputProps } = props;

  const handleFocus = (e) => {
    setFocused(true);
  };

  return (
    <div className="generateInput">
      <label className="generate-label">{label}</label>
      <input
        className="generate-input"
        {...inputProps}
        onChange={onChange}
        onBlur={handleFocus}
        onFocus={() =>
          inputProps.name === "confirmPassword" && setFocused(true)
        }
        focused={focused.toString()}
      />
      <span className="generate-span">{errorMessage}</span>
    </div>
  );
};

export default GenerateInput;
