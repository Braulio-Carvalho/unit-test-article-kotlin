package br.com.jake.unittestarticlekotlin.config

import br.com.jake.unittestarticlekotlin.model.UserIsValid

class UserIsValidBuilder {

    companion object {
        lateinit var userIsValid: UserIsValid

        fun builder(): Companion {
            this.userIsValid = UserIsValid()
            return this
        }

        fun build(): UserIsValid {
            return this.userIsValid
        }
    }
}