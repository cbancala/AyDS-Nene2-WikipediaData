package ayds.nene2.Wikipedia.external

import ayds.nene2.Wikipedia.external.wikipedia.WikipediaAPI
import ayds.nene2.Wikipedia.external.wikipedia.WikipediaResponseToWikipediaInfoResolverImpl
import ayds.nene2.Wikipedia.external.wikipedia.WikipediaService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object WikipediaDataModule {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://en.wikipedia.org/w/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

    private fun getWikipediaAPI(): WikipediaAPI = retrofit.create(WikipediaAPI::class.java)

    val wikipediaService: ExternalService = WikipediaService(getWikipediaAPI(),
            WikipediaResponseToWikipediaInfoResolverImpl())
}