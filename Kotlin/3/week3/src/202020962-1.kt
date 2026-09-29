// 점수를 입력받아 학점을 반환하는 함수
fun getGrade(score: Int) : Char {
    if (score >= 90) {
        return 'A'
    } else if (score >= 80) {
        return 'B'
    } else if (score >= 70) {
        return 'C'
    } else {
        return 'F'
    }
}

// 점수의 합을 학생 수로 나누어 평균을 반환
fun calculateAverage(scores:List<Int>): Double {
    // 점수가 비어있을 경우 0.0을 반환
    if (scores.isEmpty()) {
        return 0.0
    }
    var total = 0
    for (score in scores) {
        total += score
    }
    // 실수 나눗셈을 사용하여 평균의 소수 부분을 보존
    return total.toDouble() / scores.size
}

fun main() {
    // 같은 인덱스를 가진 이름과 점수가 한 학생의 정보를 나타냄
    val names : List<String> = listOf("김철수", "이영희", "박민수")
    val scores : List<Int> = listOf(85, 92, 68)
    var totalScore = 0

    println("=== 학생 성적 보고서 ===")

    // 학생 별 점수와 학점을 출력하면서 총점을 누적
    for (i in names.indices) {
        val grade = getGrade(scores[i])
        totalScore += scores[i]
        println("${names[i]} : ${scores[i]} (학점 : $grade)")
    }

    val average = calculateAverage(scores)
    val formattedAverage = String.format("%.2f", average)

    println("-------------------------------")
    println("총점 : ${totalScore} 점 / 평균 : ${formattedAverage} 점")
}

