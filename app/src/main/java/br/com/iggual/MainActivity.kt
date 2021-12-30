package br.com.iggual

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.iggual.contracts.IggualCaptureActivityContract
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn = findViewById<Button>(R.id.button1);

        btn.setOnClickListener {
            val input = InputData(
//                document = "ZWRjOGU1MGNkZmNlMWZhNzhmMzFiM2Q4YmFlZGM0NDcwM2IyNjk2MjAyZmE1NGM1OGZjNDAxZmQyOTc5ZDhhMQ==",
                document = "YWYyNjg1NDQ4ZTBmNTMxMDcwZDc0ZGYyY2NjNjliNGIxNzFjOWJlYzJiZjkzMmYwMjU2M2UyYzQ4ZDFmM2M4Yw==",
                authorizationCode = "SPPASS",
                type = "ENROLLMENT",
                personData = PersonData(
                    name = "TESTE NOME",
                    email = "testeemail@email.com",
                    mobilePhone = "+5511999999999",
                    dateOfBirth = "dob"
                )

            )
            pickResult.launch(Json.encodeToString(input))
        }

    }

    private val pickResult = registerForActivityResult(IggualCaptureActivityContract()) { result ->
        println("Resultado: $result");
    }


}

@Serializable
private data class InputData(
    val document: String,
    val authorizationCode: String,
    val type: String,
    val personData: PersonData
)

@Serializable
data class PersonData(
    val name: String,
    val email: String,
    val mobilePhone: String,
    val dateOfBirth: String
)
