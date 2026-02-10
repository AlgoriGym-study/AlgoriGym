import sys
input = sys.stdin.readline

n, k = map(int, input().split())

coins = [int(input().strip()) for _ in range(n)]

coins.sort(reverse=True)

count = 0

for coin in coins:
    if k == 0:
        break
    count += k // coin
    k %= coin

print(count)