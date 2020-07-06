package ayds.nene2

import ayds.nene2.wikipedia.WikipediaAPI
import ayds.nene2.wikipedia.WikipediaResponseToWikipediaInfoResolverImpl
import ayds.nene2.wikipedia.WikipediaService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object WikipediaDataModule {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://en.wikipedia.org/w/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

    private fun getWikipediaAPI(): WikipediaAPI = retrofit.create(
        WikipediaAPI::class.java)

    val WIKIPEDIA_SERVICE: ayds.nene2.WikipediaService =
        WikipediaService(
            getWikipediaAPI(),
            WikipediaResponseToWikipediaInfoResolverImpl()
        )
}