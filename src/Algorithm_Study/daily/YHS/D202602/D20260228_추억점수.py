def solution(name, yearning, photo):
    answer = []

    dic = dict()

    for n, score in zip(name,yearning):
        dic[n] = score

    for i in range(len(photo)):
        total = 0
        for j in range(len(photo[i])):
            if photo[i][j] in dic:
                total += dic.get(photo[i][j])

        answer.append(total)

    return answer