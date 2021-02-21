package io.expresso.api

import org.junit.Assert.assertNotNull
import org.junit.Test

class ExpressoClientTests {

    private val expressoClient = ExpressoClient()

    @Test
    fun `GET articles`() {
        val articles = expressoClient.api.getArticles().execute()
        assertNotNull(articles.body()?.articles)
    }
}