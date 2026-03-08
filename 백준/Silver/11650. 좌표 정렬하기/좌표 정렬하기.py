import sys

class Coordinate:
    def __init__(self, coord):
        self.x = coord[0]
        self.y = coord[1]

    def __lt__(self, other):
        if self.x < other.x:
            return True

        elif self.x == other.x and self.y < other.y:
            return True

        return False

    def __gt__(self, other):
        if self.x > other.x:
            return True
        
        elif self.x == other.x and self.y > other.y:
            return True

        return False


if __name__ == "__main__":
    n = int(sys.stdin.readline().rstrip())

    nums = []
    for _ in range(n):
        nums.append(
           Coordinate(tuple(map(int, sys.stdin.readline().rstrip().split())))
        )

    nums.sort()
    

    for e in nums:
        sys.stdout.write(f"{e.x} {e.y}\n")
