package ca.georgiancollege.ice6

import ca.georgiancollege.ice6.databinding.ActivityMainBinding

class Calculator(dataBinding: ActivityMainBinding) {
    private var binding: ActivityMainBinding = dataBinding
    private var result: String = ""
    private var currentOperand: String = ""
    private var currentOperator: String = ""

    init {
        createButtonReferences()
    }

    private fun createButtonReferences() {
        val operandButtons = arrayOf(
            binding.oneButton, binding.twoButton, binding.threeButton, binding.fourButton,
            binding.fiveButton, binding.sixButton, binding.sevenButton, binding.eightButton,
            binding.nineButton, binding.zeroButton, binding.plusMinusButton, binding.decimalButton,
            binding.deleteButton
        )

        val operatorButtons = arrayOf(
            binding.minusButton, binding.plusButton, binding.mulitplyButton, binding.divideButton,
            binding.percentButton, binding.clearButton, binding.equalsButton
        )

        operandButtons.forEach { it.setOnClickListener { operandHandler(it.tag as String) } }

        operatorButtons.forEach { it.setOnClickListener { operatorHandler(it.tag as String) } }
    }

    private fun operandHandler(tag: String) {
        when (tag) {
            "." -> {
                if (!binding.resultTextView.text.contains(".")) {
                    result += if (result.isEmpty()) "0." else "."
                    binding.resultTextView.text = result
                }
            }
            "delete" -> {
                result = result.dropLast(1)
                binding.resultTextView.text = if (result.isEmpty() || result == "-") "0" else result
            }
            "plus_minus" -> {
                result = if (result.startsWith("-")) {
                    result.substring(1)
                } else {
                    "-$result"
                }
                binding.resultTextView.text = result
            }
            else -> {
                result = if (binding.resultTextView.text == "0") {
                    tag
                } else {
                    result + tag
                }
                binding.resultTextView.text = result
            }
        }
    }

    private fun operatorHandler(tag: String) {
        when (tag) {
            "clear" -> clear()
            "equals" -> calculateResult()
            else -> {
                if (currentOperand.isNotEmpty()) {
                    calculateResult()
                } else {
                    currentOperand = binding.resultTextView.text.toString()
                    result = ""
                    binding.resultTextView.text = ""
                }
                currentOperator = tag
            }
        }
    }

    private fun calculateResult() {
        if (currentOperand.isEmpty() || result.isEmpty()) return
        val operand1 = currentOperand.toFloatOrNull() ?: return
        val operand2 = result.toFloatOrNull() ?: return
        result = when (currentOperator) {
            "plus" -> (operand1 + operand2).toString()
            "minus" -> (operand1 - operand2).toString()
            "multiply" -> (operand1 * operand2).toString()
            "divide" -> if (operand2 != 0f) (operand1 / operand2).toString() else "Error"
            else -> result
        }
        binding.resultTextView.text = result
        currentOperand = result
        result = ""
    }

    private fun clear() {
        result = ""
        binding.resultTextView.text = "0"
        currentOperand = ""
        currentOperator = ""
    }
}
