package com.academicschoolproject.data

import com.academicschoolproject.model.HighSchoolList
import com.academicschoolproject.model.HighSchoolListItem
import okhttp3.Response
import retrofit2.http.GET

interface ApiService {
/*    @GET("resource/s3k6-pzi2.json")
    suspend fun getAllHighSchools(): Response<HighSchoolList>*/

    @GET("resource/s3k6-pzi2.json")
    suspend fun getAllHighSchools(): List<HighSchoolListItem>
}