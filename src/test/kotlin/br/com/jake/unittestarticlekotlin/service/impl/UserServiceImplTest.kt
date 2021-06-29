package br.com.jake.unittestarticlekotlin.service.impl

import br.com.jake.unittestarticlekotlin.config.UserIsValidBuilder
import br.com.jake.unittestarticlekotlin.model.User
import br.com.jake.unittestarticlekotlin.model.UserIsValid
import br.com.jake.unittestarticlekotlin.repository.UserRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserServiceImplTest {

    @InjectMocks
    private lateinit var userService: UserServiceImpl

    @Mock
    private lateinit var userRepository: UserRepository

    @Test
    fun `Should save a user valid`() {

        //mockando as entradas e saídas esperadas
        val userExpected = User(1L, "Francisco", "")
        val mockUserBuild = UserIsValidBuilder.builder()
        val mockUserBuilder = UserIsValid()


        //fazendo o mock static para exacutar a ação
        Mockito.mockStatic(UserIsValidBuilder::class.java, Mockito.RETURNS_DEEP_STUBS)
            .use { userValid ->

                userValid.`when`<UserIsValidBuilder> {
                    UserIsValidBuilder.builder().build()
                }.thenReturn(mockUserBuild)

                Mockito.doReturn(userExpected)
                    .`when`(userService).userSave(userExpected)

                Mockito.doNothing().`when`(userRepository).save(userExpected)

                //verificando o resultado
                assertEquals(User(1L, "Francisco", ""), userService.userSave(userExpected))
            }


    }

}