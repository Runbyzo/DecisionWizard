package com.runbyzo.decisionwizard.decisionMethods


//val companies = listOf<String>("Mpstats.io", "Moneyplace.io", "Маяк", "MarketGuru", "Shopstat")
//
//val props = listOf(
//    doubleArrayOf(1.0,9.0,8.0,8.0,7.0),
//    doubleArrayOf(9.0,9.0,8.0,7.0,6.0),
//    doubleArrayOf(9.0,8.0,8.0,8.0,7.0),
//    doubleArrayOf(10.0,9.0,7.0,8.0,7.0),
//    doubleArrayOf(9.0,8.0,9.0,9.0,6.0),
//    doubleArrayOf(5.0,6.0,9.0,7.0,10.0)
//)
//
//val benefit = booleanArrayOf(true, true, true, true, false)
//val weights = doubleArrayOf(0.25, 0.25, 0.15, 0.25, 0.10)

class SAW() {
    fun sawMethod(names: List<String>,
                  criteria: List<DoubleArray>,
                  benefits: BooleanArray,
                  weight: DoubleArray): MutableList<Pair<String, Double>> {
        val m = criteria[0].size

        val mins = mutableListOf<Double>()
        val maxs = mutableListOf<Double>()
        for (j in 0 until m) {
            var minVal = criteria[0][j]
            var maxVal = criteria[0][j]
            for (row in criteria) {
                if (row[j] < minVal) minVal = row[j]
                if (row[j] > maxVal) maxVal = row[j]
            }
            mins.add(minVal)
            maxs.add(maxVal)
        }

        val results = mutableListOf<Pair<String, Double>>()
        for (i in names.indices) {
            var score = 0.0
            for (j in 0 until m) {
                val v = criteria[i][j]
                val norm: Double
                if (benefits[j]) {
                    norm = if (maxs[j] != 0.0) v / maxs[j] else 0.0
                } else {
                    norm = if (v != 0.0) mins[j] / v else 1.0
                }
                score += norm * weight[j]
            }
            results.add(Pair(names[i], score))
        }

        for (i in 0 until results.size - 1) {
            for (j in 0 until results.size - 1 - i) {
                if (results[j].second < results[j + 1].second) {
                    val tmp = results[j]
                    results[j] = results[j + 1]
                    results[j + 1] = tmp
                }
            }
        }

        return results

    }
}
