package ayds.nene2.Wikipedia.external

import ayds.nene2.Wikipedia.external.wikipedia.WikipediaInfoResponse

interface ExternalService {

    fun getInfo(movieTitle: String, movieYear: String): WikipediaInfoResponse

}