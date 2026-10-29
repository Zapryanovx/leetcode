# https://leetcode.com/problems/text-justification/description

class Solution:
    def fullJustify(self, words: list[str], maxWidth: int) -> list[str]:
        start = 0
        text = []
        curr_length = 0
        cnt = 0

        for i in range(len(words)):
            if curr_length + len(words[i]) + cnt > maxWidth:
                spaces = maxWidth - curr_length

                if cnt == 1:
                    row = words[start] + " " * spaces
                else:
                    spaces_between_two = spaces // (cnt - 1)
                    diff = spaces % (cnt - 1)

                    row = ""
                    for word in words[start:i-1]:
                        row += word + " " * spaces_between_two
                        if diff > 0:
                            row += " "
                            diff -= 1

                    row += words[i-1]

                text.append(row)
                start = i
                curr_length = len(words[i])
                cnt = 1
            else:
                curr_length += len(words[i])
                cnt += 1


        if cnt > 0:
            row = ""
            for word in words[start:len(words) - 1]:
                row += word + " "

            row += words[len(words)-1] + " " * (maxWidth - (len(words) - start - 1) - curr_length)
            text.append(row)

        return text