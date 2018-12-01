package aula.fib.br.listapersonalizada

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException
import java.io.InputStream

class DetalheContato: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_contato)


        val intent = intent
        if (intent != null) {
            val contato = intent.getSerializableExtra("contato") as Contato
            val nomecontato = findViewById<TextView>(R.id.nomecontato)
            val foto = findViewById<ImageView>(R.id.fotocontato)
            val descricao = findViewById<TextView>(R.id.descricao)
            foto?.setImageBitmap(this.getBitmapFromAsset(contato.id))
            nomecontato.text = contato.nome
            descricao.text = contato.descricao

        }
    }
    private fun getBitmapFromAsset(id: Long): Bitmap {
        val assetManager = assets
        var istr: InputStream? = null
        try {
            istr = assetManager.open("images/c$id.png")
        } catch (e: IOException) {
            istr = assetManager.open("images/face_error.jpg")
        }
        return BitmapFactory.decodeStream(istr)
    }
}