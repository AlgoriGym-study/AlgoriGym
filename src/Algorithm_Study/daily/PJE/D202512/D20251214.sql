SELECT
    COUNT(*) AS COUNT
FROM
    ECOLI_DATA
WHERE
    -- 2번 형질을 보유하지 않는 조건 (2^1 = 2)
    (GENOTYPE & 2) = 0
    AND
    -- 1번 형질 (2^0 = 1) 또는 3번 형질 (2^2 = 4)을 보유하는 조건 (1 | 4 = 5)
    (GENOTYPE & 5) != 0;
