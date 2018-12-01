package aula.fib.br.listapersonalizada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaContatos = ArrayList<Contato>()
        val c1 = Contato(1L, "Nelliel Tu Odelschwanck", "Nelliel@hotmail.com", "Hueco Mundo","Nelliel Tu Odelschwanck é a ex-Tres (três) Espada. Ela também é conhecida como Nel Tu (ネル・トゥ, Neru Tu), e ela é uma pequena, bem-humorada, Arrancar criança. Ela vive no deserto do Hueco Mundo com seus irmãos adotivos e ex-Fracción, Dondochakka Birstanne e Pesche Guatiche, e seu animal de estimação, Bawabawa.")
        val c2 = Contato(2L, "Naruto Uzumaki", "Naruto@hotmail.com", "Konoha","Naruto Uzumaki (うずまき ナルト, Uzumaki Naruto?) é o protagonista da série Naruto.  Na série, Naruto tem a ambição de se tornar Hokage, o líder da Vila da Folha. Por ele ser o hospedeiro de Kurama, a raposa de nove caudas que atacou Konoha, ele é desprezado pelos outros habitantes.")
        val c3 = Contato(3L, "Tier Harribel", "Harribel@hotmail.com", "hueco mundo","Tier Harribel (ティア·ハリベル, Tia Hariberu) é uma Arrancar e antiga Tres (3ª) Espada no exército de Sōsuke Aizen até a derrota do mesmo. Algum tempo depois da derrota de Aizen, ela se tornou a governante de Hueco Mundo.")
        val c4 = Contato(4L, "Son Gohan", "Gohan@hotmail.com", "Terra","Gohan é o primeiro filho do protagonista da série Goku e sua esposa Chichi, o mais irmão mais velho de Goten, o esposo de Videl e pai de Pan. Gohan é o primeiro híbrido (meio terráqueo, meio Saiyajin) a aparecer nas séries. Ele é nomeado após o avô adotivo de Goku, Gohan.")


        listaContatos.add(c1)
        listaContatos.add(c2)
        listaContatos.add(c3)
        listaContatos.add(c4)

        val adapter = ContatoAdapter(applicationContext, listaContatos,assets)

        val lista = findViewById<ListView>(R.id.lista)
        lista.setAdapter(adapter)
        lista.setOnItemClickListener {parent, view, position, id ->
            val contato = listaContatos.get(position)
            val intent = Intent(this, DetalheContato::class.java)
            intent.putExtra("contato", contato)
            startActivity(intent)
        }


    }
}
