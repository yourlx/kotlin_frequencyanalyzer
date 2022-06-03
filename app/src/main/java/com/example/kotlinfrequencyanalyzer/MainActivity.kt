package com.example.kotlinfrequencyanalyzer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var _input_field: EditText;
    private lateinit var _output_field: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _input_field = findViewById(R.id.input_field);
        _output_field = findViewById(R.id.output_field);
        _output_field.text = frequencyAnalyzer(_input_field.text.toString()).toString();
        _input_field.addTextChangedListener {
            _output_field.text = frequencyAnalyzer(_input_field.text.toString()).toString();
        }
    }
}

private fun MainActivity.frequencyAnalyzer(str: String) : HashMap<String, Int> {
    val words = str.split(" ").toTypedArray();
    val hashMap : HashMap<String, Int>  = HashMap<String, Int> ();
    for (word in words) {
        if (hashMap.containsKey(word)) {
            hashMap[word] = hashMap.getValue(word) + 1;
        } else {
            if (word != "") {
                hashMap[word] = 1;
            }
        }
    }
    return hashMap;
}