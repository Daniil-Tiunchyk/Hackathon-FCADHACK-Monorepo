import React from 'react'
import './Button.css'

const Button = ({...props}) => {
  return (
    <button {...props}>
        {props.children}
    </button>
  )
}

export default Button