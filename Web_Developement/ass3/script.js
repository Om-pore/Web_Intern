// Select display element
const display = document.getElementById('display');

// Variables to store the current input and operation
let currentInput = '';
let previousInput = '';
let operator = null;

// Add event listeners to buttons
document.querySelectorAll('.btn').forEach((button) => {
  button.addEventListener('click', () => {
    const value = button.getAttribute('data-value');

    if (value === 'clear') {
      clearDisplay();
    } else if (value === '=') {
      calculateResult();
    } else if (['+', '-', '*', '/'].includes(value)) {
      setOperator(value);
    } else {
      appendNumber(value);
    }
  });
});

// Append numbers or decimal point to the display
function appendNumber(value) {
  if (value === '.' && currentInput.includes('.')) return; // Prevent multiple decimals
  currentInput += value;
  updateDisplay(currentInput);
}

// Update the display
function updateDisplay(value) {
  display.textContent = value || '0';
}

// Set the operator for the calculation
function setOperator(op) {
  if (currentInput === '') return;
  if (previousInput !== '') {
    calculateResult();
  }
  operator = op;
  previousInput = currentInput;
  currentInput = '';
}

// Perform the calculation
function calculateResult() {
  if (operator === null || currentInput === '') return;

  const num1 = parseFloat(previousInput);
  const num2 = parseFloat(currentInput);

  let result;
  switch (operator) {
    case '+':
      result = num1 + num2;
      break;
    case '-':
      result = num1 - num2;
      break;
    case '*':
      result = num1 * num2;
      break;
    case '/':
      result = num1 / num2;
      break;
    default:
      return;
  }

  currentInput = result.toString();
  operator = null;
  previousInput = '';
  updateDisplay(currentInput);
}

// Clear the display and reset variables
function clearDisplay() {
  currentInput = '';
  previousInput = '';
  operator = null;
  updateDisplay('0');
}
