package ayds.nene2.Wikipedia.external.wikipedia

import ayds.nene2.Wikipedia.external.ExternalService
import retrofit2.Response

class WikipediaService (
    private val wikipediaAPI: WikipediaAPI,
    private val wikipediaInfoResolver: WikipediaResponseToWikipediaInfoResolver
) : ExternalService {

    override fun getInfo(movieTitle: String, movieYear: Int): WikipediaInfoResponse {
        val callResponse = getWikipediaInfoFromService(movieTitle,movieYear)
        return wikipediaInfoResolver.getInfoFromExternalData(callResponse.body(),movieTitle)
    }

    private fun getWikipediaInfoFromService(movieTitle: String, movieYear: Int): Response<String> {
        return wikipediaAPI.getTerm("$movieTitle $movieYear film").execute()
    }

}