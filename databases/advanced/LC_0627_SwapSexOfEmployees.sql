/*
 https://leetcode.com/problems/swap-sex-of-employees/description/
 */

UPDATE Salary
SET sex = (
    CASE
        WHEN sex = 'm' THEN 'f'
        ELSE 'm'
        END
    );