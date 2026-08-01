/*
 https://leetcode.com/problems/combine-two-tables/description/
 */

SELECT firstName, lastName, city, state
FROM Person AS p
         LEFT JOIN Address AS a
                   ON p.personId = a.personId;