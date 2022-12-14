package com.dlight.algoguide.dsa.sorting.bubble_sort.domain.use_cases

import com.dlight.algoguide.dsa.sorting.bubble_sort.domain.model.SortModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BubbleSortUseCase {

    operator fun invoke(list: MutableList<Int>): Flow<SortModel> = flow {
        var listSizeToCompare = list.size - 1
        while (listSizeToCompare > 1) {
            var innerIterator = 0
            while (innerIterator < listSizeToCompare) {
                val currentListItem = list[innerIterator]
                val nextListItem = list[innerIterator + 1]
                emit(
                    SortModel(
                        currentItem = innerIterator,
                        shouldSwap = false,
                        hasNoEffect = false
                    )
                )
                kotlinx.coroutines.delay(500)
                if (currentListItem > nextListItem) {
                    list.swap(innerIterator, innerIterator + 1)
                    emit(
                        SortModel(
                            currentItem = innerIterator,
                            shouldSwap = true,
                            hasNoEffect = false
                        )
                    )
                } else {
                    SortModel(currentItem = innerIterator, shouldSwap = false, hasNoEffect = true)
                }
                kotlinx.coroutines.delay(500)
                innerIterator++
            }
            listSizeToCompare--
        }
    }
}

private fun <E> MutableList<E>.swap(indexOne: Int, indexTwo: Int) {
    val tempOne = this[indexOne]
    this[indexOne] = this[indexTwo]
    this[indexTwo] = tempOne
}
