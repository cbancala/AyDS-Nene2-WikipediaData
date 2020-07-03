package ayds.nene2.Wikipedia.external

import ayds.nene.movieinfo.home.model.entities.OmdbMovie
import ayds.nene.movieinfo.moredetails.model.entities.WikipediaInfo

interface ExternalService {

    fun getInfo(movie: OmdbMovie): WikipediaInfo

}