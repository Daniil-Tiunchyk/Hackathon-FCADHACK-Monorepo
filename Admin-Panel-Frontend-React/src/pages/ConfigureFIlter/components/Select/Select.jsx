import React, { useRef, useState } from 'react'
import './Select.css'


const Select = ({ options, value, setValue }) => {
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);
  const dropdownRef = useRef(null);

const handleClickOutside = (event) => {
    document.body.style.overflow = 'unset';
    if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
      setIsDropdownOpen(false);
    }
  };

  React.useEffect(() => {
    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  const toggleDropdown = () => {
    document.body.style.overflow = 'hidden';
    setIsDropdownOpen((prev) => !prev);
  };

  const handleSelectClick = (option) => {
    setValue(option); // Сохраняем выбранное значение
    setIsDropdownOpen(false);
  };

  return (
    <>
      {isDropdownOpen && <div className="bg"></div>}
      <div className="select-container" ref={dropdownRef}>
        <div className="select_inner" onClick={toggleDropdown}>
          {value === "" ? "Выбрать" : value}
          <img
            className={isDropdownOpen ? "open" : ""}
            src="./arrow.svg"
            alt="arrow"
          />
        </div>
        {isDropdownOpen && (
          <div className="options-selectdropdown">
            {options.map((option, index) => (
              <div
                key={option.id}
                onClick={() => handleSelectClick(option.name)}
              >
                <div className="option-select">{option.name}</div>
              </div>
            ))}
          </div>
        )}
      </div>
    </>
  );
};

export default Select