import sys

substrs = set()
N = 0
dp = [-1] * 101
target_str = ""

def check(start_idx: int)-> bool:
    if (start_idx >= len(target_str)):
        return True

    if (dp[start_idx] != -1):
        return dp[start_idx]

    to_check : str = target_str[start_idx:]

    for substr in substrs:
        strlen = len(substr)
        if (to_check[0:strlen]== substr):
            res = check(start_idx+strlen)

            if (res):
                dp[start_idx] = True
                return True

    dp[start_idx] = False
    return False


def main():
    global N, target_str
    target_str = sys.stdin.readline().rstrip()
    N = int(sys.stdin.readline().rstrip())
    for _ in range(N):
        temp = sys.stdin.readline().rstrip()
        substrs.add(temp)

    if (check(0)):
        sys.stdout.write("1\n")
    else:
        sys.stdout.write("0\n")


if __name__ == "__main__":
    main()

