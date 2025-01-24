package com.curiousapps.bambupractice.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiousapps.bambupractice.domain.BamItem
import com.curiousapps.bambupractice.domain.BamRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BamViewModel @Inject constructor(
    private val repo: BamRepo
): ViewModel() {

    private val _state = MutableStateFlow(BamState())
    val state: Flow<BamState>
        get() {
            return _state
        }

    init {
        fetchBamList()
    }

    private fun  fetchBamList(){
        viewModelScope.launch {
            val result = repo.fetchBamList()
            when{
                result.isSuccess ->{
                    _state.value = BamState(
                        isLoading = false,
                        bamList = result.getOrNull()!!
                    )
                }
                result.isFailure ->{
                    _state.value = BamState(
                        isLoading = false,
                        bamList = emptyList()
                    )
                }
            }
        }
    }


    data class BamState(
        val isLoading: Boolean = true,
        val bamList: List<BamItem> = emptyList()
    )
}