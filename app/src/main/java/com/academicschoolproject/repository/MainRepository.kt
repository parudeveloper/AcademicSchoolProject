package com.academicschoolproject.repository

import com.academicschoolproject.data.ApiService
import com.academicschoolproject.model.HighSchoolListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
class MainRepository @Inject constructor(private val apiService: ApiService) {
    /*suspend fun getAllHighSchoolData() : NetworkResult<HighSchoolList> = flow {
        emit(NetworkResult.Loading(true))
        val response = apiService.getAllHighSchools()
        emit(NetworkResult.Success(response.item))
    }.catch { error ->
        emit(NetworkResult.Failure(error.message ?: "Unknown Error"))
    }*/

    suspend fun getAllHighSchoolData(): Flow<NetworkResult<List<HighSchoolListItem>>> = flow {
        emit(NetworkResult.Loading(true))
        try {
            val data = apiService.getAllHighSchools()
            emit(NetworkResult.Success(data)) // Emit success state with data
        } catch (e: Exception) {
            emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
        }
    }
}