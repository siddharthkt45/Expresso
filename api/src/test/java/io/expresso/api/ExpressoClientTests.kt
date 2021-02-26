package io.expresso.api

import io.expresso.api.models.entities.SignupData
import io.expresso.api.models.requests.SignupRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.random.Random

class ExpressoClientTests {

    private val expressoClient = ExpressoClient()

    @Test
    fun `GET articles`() {
        runBlocking {
            val articles = expressoClient.publicApi.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by author`() {
        runBlocking {
            val articles = expressoClient.publicApi.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by tags`() {
        runBlocking {
            val articles = expressoClient.publicApi.getArticles(tag = "dragons")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `POST users - create user`() {
        val userCreds = SignupData(
            email = "testemail${Random.nextInt(999, 9999)}@test.com",
            password = "pass${Random.nextInt(9999, 999999)}",
            username = "rand_user_${Random.nextInt(99, 999)}"
        )

        runBlocking {
            val resp = expressoClient.publicApi.signupUser(SignupRequest(userCreds))
            assertEquals(userCreds.username, resp.body()?.user?.username)
        }
    }
}