// Set을 이용하여 중복을 제거
// 회원별 대출 건수 계산
fun getUniqueBorrowers(records:List<Pair<String, String>>) : Set<String> {
    val borrowers = mutableSetOf<String>()

    for (record in records) {
        borrowers.add(record.second)
    }
    return borrowers
}

// 회원 명을 key로 대출 건수를 value로 저장
fun countLoansPerUser(records: List<Pair<String, String>>) : Map<String, Int> {
    val userLoanCounts = mutableMapOf<String, Int>()

    for (record in records) {
        val user = record.second
        val previousCount = userLoanCounts[user]
        // 처음 등장한 회원은 1회, 이미 등장한 회원은 기존 횟수에 1을 더함
        if (previousCount == null) {
            userLoanCounts[user] = 1
        } else {
            userLoanCounts[user] = previousCount + 1
        }
    }
    return userLoanCounts
}

// 가장 많이 대출된 도서 찾기
fun getMostBorrowedBook(records : List<Pair<String, String>>): Pair<String, Int> {
    val bookLoanCounts = mutableMapOf<String, Int>()

    for (record in records) {
        val book = record.first
        val previousCount = bookLoanCounts[book]

        if (previousCount == null) {
            bookLoanCounts[book] = 1
        } else {
            bookLoanCounts[book] = previousCount + 1
        }
    }
    // 기록이 없으면 빈 도서명과 0회를 반환
    var mostBorrowedBood = ""
    var maxCount = 0

    for ((book, count) in bookLoanCounts) {
        // 동률이면 기록에 먼저 등장한 도서 유지
        if (count > maxCount) {
            mostBorrowedBood = book
            maxCount = count
        }
    }
    return Pair(mostBorrowedBood, maxCount)
}

// 한도 이상 대출한 회원 찾기
fun getOverLimitUsers(userLoanCounts: Map<String, Int>, limit: Int): List<String> {
    val overLimitUsers = mutableListOf<String>()

    for ((user, count) in userLoanCounts) {
        if (count >= limit) {
            overLimitUsers.add(user)
        }
    }
    return overLimitUsers
}

fun main() {
    // 각 Pair는 "도서명" to "회원명" 형태의 대출 기록
    val loanRecords = listOf(
        "코틀린" to "홍길동",
        "자바" to "성춘향",
        "코틀린" to "이몽룡",
        "코틀린" to "홍길동",
        "알고리즘" to  "홍길동"
    )
    val limit = 3
    // 통계 계산을 각각의 일반 함수에 위임
    val borrowers = getUniqueBorrowers(loanRecords)
    val userLoanCounts = countLoansPerUser(loanRecords)
    val mostBorrowedBook = getMostBorrowedBook(loanRecords)
    val overLimitUsers = getOverLimitUsers(userLoanCounts, limit)

    println("=== 도서관 대출 데이터 분석 ===")
    println("1. 대출 이용 회원 목록 ( 중복 제외 ) : $borrowers")
    println("2. 가장 많이 대출된 도서 : ${mostBorrowedBook.first} ( 총 ${mostBorrowedBook.second} 회 대출 )")
    println("3. 회원별 대출 건수 : ")

    for ((user, count) in userLoanCounts) {
        println(" - ${user} : ${count} 건")
    }

    println("4. 대출 한도(${limit} 권) 이상 이용자 : ${overLimitUsers}")
}