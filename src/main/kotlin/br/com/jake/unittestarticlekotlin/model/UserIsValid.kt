package br.com.jake.unittestarticlekotlin.model

class UserIsValid {

    fun userValidation(user: User): Boolean {
        return user.endereco.isNotEmpty()
    }


}