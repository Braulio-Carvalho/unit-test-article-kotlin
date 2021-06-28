package br.com.jake.unittestarticlekotlin.service

import br.com.jake.unittestarticlekotlin.model.User
import java.util.*

interface UserService {

    fun listaUsuarios(): List<User>

    fun buscaUsuarioPorId(id: Long): User

    fun userSave(user: User): User

    fun deletaUsuario(id: Long)
}