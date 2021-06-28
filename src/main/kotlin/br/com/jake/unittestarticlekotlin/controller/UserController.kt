package br.com.jake.unittestarticlekotlin.controller

import br.com.jake.unittestarticlekotlin.model.User
import br.com.jake.unittestarticlekotlin.service.impl.UserServiceImpl
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/usuarios")
class UserController(val userService: UserServiceImpl) {

    @GetMapping
    fun listaUsuarios(): List<User?>? {
        return userService.listaUsuarios()
    }

    @GetMapping("/{id}")
    fun buscaUsuarioPorId(@PathVariable id: Long): User {
        return userService.buscaUsuarioPorId(id)
    }

    @PostMapping("/save")
    fun salvaUsuario(@RequestBody user: User): User {
        return userService.userSave(user)
    }

    @DeleteMapping("/delete/{id}")
    fun deletaUsuario(@PathVariable id: Long) {
        userService.deletaUsuario(id)
    }
}