package com.ruiz.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UseCase {
    interface Sync<Entity, Args> {
        operator fun invoke(args: Args): Entity
    }
    interface Async<Entity, Args> {
        suspend operator fun invoke(args: Args): Entity
    }
    interface AsyncFlow<Entity, Args> {
        operator fun invoke(args: Args): Flow<Entity>
    }
}