import sys

def solve():
    input = sys.stdin.readline
    n = int(input())

    arr = []
    for _ in ragne(n):
        arr.append(list(map(int, input().split())))

    arr.sort(key = lambda x : (x[1],x[0]))

    time, cnt = 0, 0
    for start, end in arr:
        if start >= time:
            time = end
            cnt += 1

    print(cnt)

solve()