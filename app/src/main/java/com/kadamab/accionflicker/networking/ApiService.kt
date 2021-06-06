package com.kadamab.android.networking

import com.kadamab.android.data.PhotosSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1&api_key=ded6c18e1ff7c075f142d556d75f9344")
    suspend fun fetchImages(@Query(value = "text") searchTerm: String): PhotosSearchResponse
}
