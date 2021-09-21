package br.com.iggual

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.iggual.services.IggualBiometricConnector

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button1);

        btn.setOnClickListener {
            val conn = IggualBiometricConnector("","");
            conn.capture( pickResult);
        }

    }

  private val pickResult = registerForActivityResult(IggualFingerActivityContract()) {
      result -> println("Resultado: $result");
  }

}