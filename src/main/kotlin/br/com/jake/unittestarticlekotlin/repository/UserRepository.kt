package br.com.jake.unittestarticlekotlin.repository

import br.com.jake.unittestarticlekotlin.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}