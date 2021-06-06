package com.kadamab.accionflicker.viewModel

import androidx.lifecycle.ViewModel
import com.kadamab.android.domain.Photo
import com.kadamab.android.networking.WebClient

class PhotosViewModel : ViewModel() {
    suspend fun fetchImages(searchTerm: String): List<Photo> {
        if (searchTerm.isBlank()) {
            return emptyList()
        }

        val searchResponse = WebClient.client.fetchImages(searchTerm,)
        return searchResponse.photos.photo.map { photo ->
            Photo(
                id = photo.id,
                url = "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg",
                title = photo.title
            )
        }
    }
}
