package ayds.nene2.wikipedia

import ayds.nene2.WikipediaService
import retrofit2.Response

internal class WikipediaService (
    private val wikipediaAPI: WikipediaAPI,
    private val wikipediaInfoResolver: WikipediaResponseToWikipediaInfoResolver
) : WikipediaService {

    override fun getInfo(movieTitle: String, movieYear: String): WikipediaInfo {
        val callResponse = getWikipediaInfoFromService(movieTitle,movieYear)
        return wikipediaInfoResolver.getInfoFromExternalData(callResponse.body(),movieTitle)
    }

    private fun getWikipediaInfoFromService(movieTitle: String, movieYear: String): Response<String> {
        return wikipediaAPI.getTerm("$movieTitle $movieYear film").execute()
    }

}