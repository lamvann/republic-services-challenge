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

//        val routeList = mutableListOf<Route>()
//        val idsMatch = args.routes.filter { it.id == args.chosenDriver.id.toInt() }
//        if (idsMatch.isNotEmpty()) routeList.addAll(idsMatch)
//        if (args.chosenDriver.id.toInt() % 2 == 0)
//            routeList.addAll(
//                listOf(args.routes.first { it.type == "R" })
//            )
//        if (args.chosenDriver.id.toInt() % 5 == 0)
//            routeList.add(
//                args.routes.filter { it.type == "C" }[1]
//            )
//        if (routeList.isEmpty())
//            routeList.add(
//                args.routes.last { it.type == "I" }
//            )
//        return routeList
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