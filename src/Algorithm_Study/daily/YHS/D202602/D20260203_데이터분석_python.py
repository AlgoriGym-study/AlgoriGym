def solution(data, ext, val_ext, sort_by):
    idx = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}

    ext_i = idx[ext]
    sort_i = idx[sort_by]

    filtered = []
    for row in data:
        if row[ext_i] < val_ext:
            filtered.append(row)

    filtered.sort(key = lambda x : x[sort_i])

    return filtered