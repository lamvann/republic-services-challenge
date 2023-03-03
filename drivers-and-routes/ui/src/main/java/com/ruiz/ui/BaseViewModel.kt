@file:OptIn(InternalCoroutinesApi::class)

package com.ruiz.ui

import android.app.Application
import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ruiz.domain.usecase.UseCase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiStateType: UiState>(
    app: Application,
    initialState: UiStateType
) : AndroidViewModel(app)  {
    private val _uiStateLiveData = MutableLiveData(initialState)
    val uiStateLiveData: LiveData<UiStateType> = _uiStateLiveData

    val uiState get() = uiStateLiveData.value ?: throw IllegalStateException("UiState cannot be null")

    fun updateUiState(predicate: UiStateType.() -> UiStateType) {
        _uiStateLiveData.value = predicate(uiState)
    }

    fun <
        UseCaseType : UseCase.Async<EntityType, ArgsType>,
        ArgsType,
        EntityType,
    > executeUseCase(
        useCase: UseCaseType,
        args: ArgsType,
        onError: (Throwable) -> Unit = ::onError,
        onSuccess: (EntityType) -> Unit
    ) {
        viewModelScope.launch {
            runCatching {
                onSuccess(
                    useCase(args)
                )
            }.onFailure(onError)
        }
    }

    fun <
        UseCaseType : UseCase.Sync<EntityType, ArgsType>,
        ArgsType,
        EntityType,
    > executeUseCase(
        useCase: UseCaseType,
        args: ArgsType,
        onError: (Throwable) -> Unit = ::onError,
        onSuccess: (EntityType) -> Unit
    ) {
        viewModelScope.launch {
            runCatching {
                onSuccess(
                    useCase(args)
                )
            }.onFailure(onError)
        }
    }

    @CallSuper
    open fun onError(throwable: Throwable) {
        throwable.printStackTrace()
    }
}