def solution(park, routes):
    n = len(park)
    m = len(park[0])

    x = y = -1
    for i in range(n):
        for j in range(m):
            if park[i][j] == 'S':
                x, y = i, j
                break
        if x != -1:
            break

    dir_map = {
        'N' : (-1,0),
        'S' : (1,0),
        'W' : (0,-1),
        'E' : (0,1)
    }

    for op in routes:
        dir, cnt = op.split()
        cnt = int(cnt)
        dx, dy = dir_map[dir]

        nx, ny = x, y
        OK = True

        for _ in range(cnt):
            nx += dx
            ny += dy

            if not (0 <= nx < n and 0 <= ny < m):
                OK = False
                break
            if park[nx][ny] == 'X':
                OK = False
                break

        if OK:
            x, y = nx, ny

    return [x,y]