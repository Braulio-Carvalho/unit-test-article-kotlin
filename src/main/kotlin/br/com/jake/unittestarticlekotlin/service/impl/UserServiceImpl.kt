package br.com.jake.unittestarticlekotlin.service.impl


import br.com.jake.unittestarticlekotlin.model.User
import br.com.jake.unittestarticlekotlin.model.UserIsValid
import br.com.jake.unittestarticlekotlin.repository.UserRepository
import br.com.jake.unittestarticlekotlin.service.UserService
import org.springframework.stereotype.Service


@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {


    override fun listaUsuarios(): List<User> {
        return userRepository.findAll()
    }

    override fun buscaUsuarioPorId(id: Long): User {
        return userRepository.findById(id).get()
    }

    override fun userSave(user: User): User {
        var build = UserIsValid.builder().build()
        if (!build.userValidation(user)) {
            throw Exception("Address Not Valid")
        }
        return userRepository.save(user)
    }

    override fun deletaUsuario(id: Long) {
        userRepository.deleteById(id)
    }

}