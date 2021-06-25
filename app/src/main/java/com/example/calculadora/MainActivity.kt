package com.example.calculadora

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        btAC.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        btLeft.setOnClickListener {
            input.text = addToInputText("(")
        }
        btRight.setOnClickListener {
            input.text = addToInputText(")")
        }
        btCero.setOnClickListener {
            input.text = addToInputText("0")
        }
        btUno.setOnClickListener {
            input.text = addToInputText("1")
        }
        btDos.setOnClickListener {
            input.text = addToInputText("2")
        }
        btTres.setOnClickListener {
            input.text = addToInputText("3")
        }
        btCuatro.setOnClickListener {
            input.text = addToInputText("4")
        }
        btCinco.setOnClickListener {
            input.text = addToInputText("5")
        }
        btSeis.setOnClickListener {
            input.text = addToInputText("6")
        }
        btSiete.setOnClickListener {
            input.text = addToInputText("7")
        }
        btOcho.setOnClickListener {
            input.text = addToInputText("8")
        }
        btNueve.setOnClickListener {
            input.text = addToInputText("9")
        }
        btPunto.setOnClickListener {
            input.text = addToInputText(".")
        }
        btDivision.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        btMulti.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }
        btMenos.setOnClickListener {
            input.text = addToInputText("-")
        }
        btMas.setOnClickListener {
            input.text = addToInputText("+")
        }

        btIgual.setOnClickListener {
            showResult()
        }

    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }


}