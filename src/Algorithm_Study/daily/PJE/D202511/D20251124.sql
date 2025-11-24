SELECT
    c.ITEM_ID,
    c.ITEM_NAME,
    c.RARITY
FROM ITEM_INFO p          -- 부모 아이템 (PARENT)
JOIN ITEM_TREE t
    ON p.ITEM_ID = t.PARENT_ITEM_ID
JOIN ITEM_INFO c          -- 자식 아이템 (다음 업그레이드 아이템)
    ON c.ITEM_ID = t.ITEM_ID
WHERE p.RARITY = 'RARE'   -- 부모의 희귀도가 RARE
ORDER BY c.ITEM_ID DESC;
