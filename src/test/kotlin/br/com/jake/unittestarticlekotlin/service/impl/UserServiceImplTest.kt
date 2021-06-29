package br.com.jake.unittestarticlekotlin.service.impl

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
        val mockUserIsValid = Mockito.mock(UserIsValid::class.java)


        //fazendo o mock static para exacutar a ação
        Mockito.mockStatic(UserIsValid::class.java, Mockito.RETURNS_DEEP_STUBS)
            .use { userValid ->

                userValid.`when`<UserIsValid> {
                    UserIsValid.builder().build()
                }.thenReturn(mockUserIsValid)


                Mockito.doReturn(true)
                    .`when`(mockUserIsValid).userValidation(userExpected)

                Mockito.doReturn(userExpected).`when`(userRepository).save(userExpected)

                //verificando o resultado
                assertEquals(userExpected, userService.userSave(userExpected))
            }
    }

}