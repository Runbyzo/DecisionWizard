package com.runbyzo.decisionwizard.decisionMethods

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
