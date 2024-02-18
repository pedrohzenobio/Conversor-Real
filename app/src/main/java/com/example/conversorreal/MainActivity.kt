package com.example.conversorreal

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversorreal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun calculate() {

        if (isValid()) {
            val value = binding.editValue.text.toString().toFloat()
            val euro = binding.editEuro.text.toString().toFloat()
            val dollar = binding.editDollar.text.toString().toFloat()

            val total_euro = value / euro
            val total_dollar = value / dollar

            binding.textResultDollar.text = "R$ : ${"%.2f".format(total_dollar)}"
            binding.textResultEuro.text = "R$ : ${"%.2f".format(total_euro)}"
        }else   {
            Toast.makeText(this, R.string.no_validated, Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValid(): Boolean {
        return return (binding.editValue.text.toString() != ""
                && binding.editEuro.text.toString() != ""
                && binding.editEuro.text.toString().toFloat() != 0f
                && binding.editDollar.text.toString() != ""
                && binding.editDollar.text.toString().toFloat() != 0f)
    }
}