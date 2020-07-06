package ayds.nene2

import ayds.nene2.wikipedia.WikipediaInfo

interface WikipediaService {

    fun getInfo(movieTitle: String, movieYear: String): WikipediaInfo

}