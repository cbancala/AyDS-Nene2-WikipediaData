package ayds.nene2.Wikipedia.external.wikipedia

import ayds.nene.movieinfo.home.model.entities.OmdbMovie
import ayds.nene.movieinfo.moredetails.model.entities.WikipediaInfo
import ayds.nene2.Wikipedia.external.ExternalService
import retrofit2.Response

class WikipediaService (
    private val wikipediaAPI: WikipediaAPI,
    private val wikipediaInfoResolver: WikipediaResponseToWikipediaInfoResolver
) : ExternalService {

    override fun getInfo(movie: OmdbMovie): WikipediaInfoResponse {
        val callResponse = getWikipediaInfoFromService(movie)
        return wikipediaInfoResolver.getInfoFromExternalData(callResponse.body(),movie.title)
    }

    private fun getWikipediaInfoFromService(movie : OmdbMovie): Response<String> {
        return wikipediaAPI.getTerm(movie.title + " " + movie.year + " film").execute()
    }

}