package com.curiousapps.bambupractice.network

import com.curiousapps.bambupractice.domain.BamItem
import com.curiousapps.bambupractice.util.URL_EXT
import retrofit2.http.GET

interface BamApi {

    @GET(URL_EXT)
    suspend fun fetchBamList(): List<BamItem>
}