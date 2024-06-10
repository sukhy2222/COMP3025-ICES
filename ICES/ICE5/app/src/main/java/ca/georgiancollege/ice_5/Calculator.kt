package ca.georgiancollege.ice_5
import android.widget.Button
import ca.georgiancollege.ice_5.databinding.ActivityMainBinding

class Calculator(private val binding: ActivityMainBinding) {

    private var result: String = ""

    init {
        result = ""
        createButtonReferences()
    }

    private fun createButtonReferences() {
        val operandButtons = arrayOf(
            binding.oneButton, binding.twoButton, binding.threeButton, binding.fourButton,
            binding.fiveButton, binding.sixButton, binding.sevenButton, binding.eightButton,
            binding.nineButton, binding.zeroButton, binding.plusMinusButton, binding.decimalButton,
            binding.clearButton
        )

        val operatorButtons = arrayOf(
            binding.subtractButton, binding.addButton, binding.multiplyButton, binding.divideButton,
            binding.percentButton
        )

        operandButtons.forEach { it.setOnClickListener { operandHandler(it as Button) } }

        operatorButtons.forEach {
            if (it != null) {
                it.setOnClickListener { operatorHandler(it as Button) }
            }
        }

        binding.clearButton.setOnClickListener { clear() }
        binding.backspaceButton.setOnClickListener { backspace() }
    }

    private fun operandHandler(button: Button) {
        val tag = button.tag.toString()
        when (tag) {
            "." -> {
                if (!result.contains(".")) {
                    result += if (result.isEmpty()) "0." else "."
                    binding.resultTextView.text = result
                }
            }
            "delete" -> {
                result = result.dropLast(1)
                binding.resultTextView.text = if (result.isEmpty() || result == "-") "0" else result
            }
            "plus_minus" -> {
                result = if (result.startsWith("-")) result.substring(1) else "-$result"
                binding.resultTextView.text = result
            }
            else -> {
                if (binding.resultTextView.text == "0") {
                    result = tag
                } else {
                    result += tag
                }
                binding.resultTextView.text = result
            }
        }
    }

    private fun operatorHandler(button: Button) {
    }

    private fun clear() {
        result = ""
        binding.resultTextView.text = "0"
    }

    private fun backspace() {
        if (result.isNotEmpty()) {
            result = result.dropLast(1)
            binding.resultTextView.text = if (result.isEmpty() || result == "-") "0" else result
        }
    }
}
