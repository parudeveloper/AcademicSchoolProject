package com.academicschoolproject.ui

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.academicschoolproject.model.HighSchoolList
import com.academicschoolproject.model.HighSchoolListItem
import com.academicschoolproject.repository.MainRepository
import com.academicschoolproject.repository.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

   /* private var _movieResponse = MutableLiveData<NetworkResult<HighSchoolList>>()
    val movieResponse: LiveData<NetworkResult<HighSchoolList>> = _movieResponse

    init {
        fetchAllMovies()
    }
    private fun fetchAllMovies() {
        viewModelScope.launch {
            mainRepository.getAllHighSchoolData().collect { data : NetworkResult<HighSchoolList> ->
                _movieResponse.postValue(data)
            }
        }
    }*/

    private val _data = MutableStateFlow<NetworkResult<List<HighSchoolListItem>>>(NetworkResult.Loading(true))
    val data = _data.asStateFlow()

    fun fetchAllSchoolDetails() {
        viewModelScope.launch {
            mainRepository.getAllHighSchoolData().collect { response ->
                _data.value = response // Update the state based on the API response
            }
        }
    }

}