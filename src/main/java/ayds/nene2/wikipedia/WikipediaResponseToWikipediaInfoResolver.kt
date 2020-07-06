package ayds.nene2.wikipedia

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

interface WikipediaResponseToWikipediaInfoResolver {

    fun getInfoFromExternalData(body: String?, title: String): WikipediaInfo
}

internal class WikipediaResponseToWikipediaInfoResolverImpl :
    WikipediaResponseToWikipediaInfoResolver {

    private val SNIPPET = "snippet"
    private val PAGE_ID = "pageid"
    private val SEARCH = "search"
    private val QUERY = "query"
    private val NO_RESULTS = "No Results"
    private val WIKIPEDIA_LOGO_URL =
        "https://upload.wikimedia.org/wikipedia/commons/8/8c/Wikipedia-logo-v2-es.png"

    private fun getJsonMovieFromAPI (body : String? ): JsonObject {
        val resultIterator : Iterator<JsonElement>? = getMovieIteratorFromAPI(body)
        if (resultIterator != null && resultIterator.hasNext())
            return resultIterator.next().asJsonObject;
        return JsonObject()
    }
    private fun getMovieIteratorFromAPI (body : String? ): Iterator<JsonElement> {
        val gson = Gson()
        var jsonObject = gson.fromJson(body, JsonObject::class.java)
        jsonObject = jsonObject.get(QUERY).getAsJsonObject()
        return jsonObject.get(SEARCH).getAsJsonArray().iterator()
    }

    override fun getInfoFromExternalData(body: String?, title: String): WikipediaInfo {

        val result = getJsonMovieFromAPI(body);
        val extract = result.get(SNIPPET)
        val pageId = result.get(PAGE_ID).asString
        val summary = getSummary(extract,pageId);
        val toReturn = WikipediaInfo()
        toReturn.title = title
        toReturn.summary = summary!!
        toReturn.imageUrl = WIKIPEDIA_LOGO_URL
        toReturn.pageUrl = "https://en.wikipedia.org/?curid="+pageId
        return toReturn
    }

    private fun getSummary(extract: JsonElement?, pageId: String?): String? {
        if (extract != null && pageId != null) {
            val text = extract.asString
            return text
        }
        return NO_RESULTS
    }



}