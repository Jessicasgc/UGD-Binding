package com.example.ugdnyakawan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrasiActivity : AppCompatActivity() {
    private lateinit var iusername: TextInputEditText
    private lateinit var ipassword: TextInputEditText
    private lateinit var iemail: TextInputEditText
    private lateinit var itglLahir: TextInputEditText
    private lateinit var inotelp: TextInputEditText

    private lateinit var lusername: TextInputLayout
    private lateinit var lpassword: TextInputLayout
    private lateinit var lemail: TextInputLayout
    private lateinit var ltglLahir: TextInputLayout
    private lateinit var lnotelp: TextInputLayout
    private lateinit var registrasiLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        iusername = findViewById(R.id.etUsername)
        ipassword = findViewById(R.id.etPassword)
        iemail = findViewById(R.id.etEmail)
        itglLahir = findViewById(R.id.etTglLahir)
        inotelp = findViewById(R.id.etNoTelp)
        registrasiLayout = findViewById(R.id.registrasiLayout)

        lusername = findViewById(R.id.tilUsername)
        lpassword = findViewById(R.id.tilPassword)
        lemail = findViewById(R.id.tilEmail)
        ltglLahir = findViewById(R.id.tilTglLahir)
        lnotelp = findViewById(R.id.tilNoTelp)

        val btnClear: Button = findViewById(R.id.btnClear)
        val btnRegistrasi: Button = findViewById(R.id.btnRegistrasi)
        val tvLogin: TextView = findViewById(R.id.tvLogin)

        tvLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnClear.setOnClickListener {
            lusername.getEditText()?.setText("")
            lpassword.getEditText()?.setText("")
            lemail.getEditText()?.setText("")
            ltglLahir.getEditText()?.setText("")
            lnotelp.getEditText()?.setText("")

            Snackbar.make(registrasiLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }


        btnRegistrasi.setOnClickListener {
            val intentToLogin = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            //memasukkan data ke dalam bundle
            val username : String = lusername.getEditText()?.getText().toString()
            val password : String = lpassword.getEditText()?.getText().toString()
            val email : String = lemail.getEditText()?.getText().toString()
            val tanggalLahir : String = ltglLahir.getEditText()?.getText().toString()
            val nomorTelepon : String = lnotelp.getEditText()?.getText().toString()
            //melakukan intent dengan memanggil bundle


            if(username.isEmpty()) {
                iusername.setError("Username must be filled correctly")
            }
            if(password.isEmpty()){
                ipassword.setError("Password must be filled correctly")
            }
            if(email.isEmpty()) {
                iemail.setError("Email must be filled correctly")
            }
            if(tanggalLahir.isEmpty()) {
                itglLahir.setError("Tanggal Lahir must be filled correctly")
            }
            if(nomorTelepon.isEmpty()) {
                inotelp.setError("Nomor Telepon must be filled correctly")
            }else{
                bundle.putString("username", lusername.getEditText()?.getText().toString())
                bundle.putString("password", lpassword.getEditText()?.getText().toString())
                bundle.putString("email", lemail.getEditText()?.getText().toString())
                bundle.putString("tanggalLahir", ltglLahir.getEditText()?.getText().toString())
                bundle.putString("nomorTelpon", lnotelp.getEditText()?.getText().toString())
                intentToLogin.putExtras(bundle)
                startActivity(intentToLogin)
        }
    }
}
}