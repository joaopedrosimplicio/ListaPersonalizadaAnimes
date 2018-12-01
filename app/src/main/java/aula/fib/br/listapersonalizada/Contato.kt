package aula.fib.br.listapersonalizada

import java.io.Serializable

class Contato(var id: Long,
              var nome: String,
              val email: String? = null,
              val endereco: String? = null,
              val descricao: String? = null) : Serializable