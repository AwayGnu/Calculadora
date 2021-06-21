package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var tvResultado: TextView? = null
    var numero1 = 0.0f
    var numero2 = 0.0f
    var operacion = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        tvResultado = findViewById(R.id.tvResultado);

    }

    fun EscribirCero(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "0"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "0"
        }
    }

    fun EscribirUno(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "1"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "1"
        }
    }

    fun EscribirDos(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "2"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "2"
        }
    }

    fun EscribirTres(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "3"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "3"
        }
    }

    fun EscribirCuatro(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "4"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "4"
        }
    }

    fun EscribirCinco(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "5"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "5"
        }
    }

    fun EscribirSeis(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "6"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "6"
        }
    }

    fun EscribirSiete(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "7"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "7"
        }
    }

    fun EscribirOcho(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "8"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "8"
        }
    }

    fun EscribirNueve(view: View?) {
        val valor = tvResultado!!.text.toString().toFloat()
        if (valor == 0.0f) {
            tvResultado!!.text = "9"
        } else {
            tvResultado!!.text = tvResultado!!.text.toString() + "9"
        }
    }

    fun EscribirPunto(view: View?) {
        tvResultado!!.text = tvResultado!!.text.toString() + "."

    }

    fun LimpiarResultado(view: View?) {
        numero1 = 0.0f
        numero2 = 0.0f
        operacion = ""
        tvResultado!!.text = "0"
    }

    fun CambioSigno(view: View?) {
        var valor = tvResultado!!.text.toString().toFloat()
        valor *= -1.0f
        tvResultado!!.text = "" + if("$valor".endsWith(".0")) { "$valor".replace(".0","") } else { (valor).toString() } //Quita el cero sobrante de los decimales //Agregado en Version 1.03
    }

    fun OperacionPorcentaje(view: View?) {
        numero1 = tvResultado!!.text.toString().toFloat()
        operacion = "%"
        tvResultado!!.text = "0"
    }

    fun OperacionDividir(view: View?) {
        numero1 = tvResultado!!.text.toString().toFloat()
        operacion = "/"
        tvResultado!!.text = "0"
    }

    fun OperacionMulti(view: View?) {
        numero1 = tvResultado!!.text.toString().toFloat()
        operacion = "*"
        tvResultado!!.text = "0"
    }

    fun OperacionMenos(view: View?) {
        numero1 = tvResultado!!.text.toString().toFloat()
        operacion = "-"
        tvResultado!!.text = "0"
    }

    fun OperacionMas(view: View?) {
        numero1 = tvResultado!!.text.toString().toFloat()
        operacion = "+"
        tvResultado!!.text = "0"
    }

    fun MostrarResultado(view: View?) {
        numero2 = tvResultado!!.text.toString().toFloat()
        var result = 0.0f
        if (operacion == "%") {
            result = numero1 / 100.0f * numero2
        }
        if (operacion == "/") {
            if (numero2 != 0.0f) {
                result = numero1 / numero2
            } else {
                result = 0.0f
                Toast.makeText(this, "OPERACION NO VALIDA", Toast.LENGTH_LONG).show()
            }
        } else if (operacion == "*") {
            result = numero1 * numero2
        } else if (operacion == "-") {
            result = numero1 - numero2
        } else if (operacion == "+") {
            result = numero1 + numero2
        }
        tvResultado!!.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { (result).toString() } //Quita el cero sobrante de los decimales /Agregado en Version 1.03
        numero1 = 0.0f
        numero2 = 0.0f
        operacion = ""
    }

}