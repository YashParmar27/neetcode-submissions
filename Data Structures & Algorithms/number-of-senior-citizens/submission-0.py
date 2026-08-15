class Solution:
    def countSeniors(self, details: List[str]) -> int:
        res = 0
        for elem in details:
            age = int(elem[11:13]);
            if age > 60:
                res += 1
        return res