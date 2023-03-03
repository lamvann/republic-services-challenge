package com.ruiz.domain.usecase

import com.ruiz.domain.entity.Driver
import com.ruiz.domain.entity.Route

class FilterRouteByDriver :
    UseCase.Sync<List<Route>, FilterRouteByDriver.FilterRouteByDriverParams> {
    data class FilterRouteByDriverParams(
        val chosenDriver: Driver,
        val routes: List<Route>
    )

    override fun invoke(args: FilterRouteByDriverParams): List<Route> {
        val idsMatch = args.routes.filter {
            it.id == args.chosenDriver.id.toInt()
        }
        return when {
            idsMatch.isNotEmpty() -> idsMatch
            args.chosenDriver.id.toInt() % 2 == 0 -> listOf(args.routes.first { it.type == "R" })
            args.chosenDriver.id.toInt() % 5 == 0 -> listOf(args.routes.filter { it.type == "C" }[1])
            else -> listOf(args.routes.last { it.type == "I" })
        }
    }
}