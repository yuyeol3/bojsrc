class Dunchi:
    def __init__(self, weight, height) -> None:
        self.weight = weight
        self.height = height
        self.rank = 1

    def __eq__(self, other):
        if self.weight == other.weight and self.height == other.height:
            return True

        elif (self.weight <= other.weight and self.height >= other.height) or\
            (self.weight >= other.weight and self.height <= other.height):
            return True

        else:
            return False

    def __gt__(self, other):
        return (self.weight > other.weight and self.height > other.height)

    def __lt__(self, other):
        return (self.weight < other.weight and self.height < other.height)

    def __repr__(self) -> str:
        return f"<Dunchi weight={self.weight}, height={self.height}>"


if __name__ == "__main__":
    n = int(input())
    duncies = []
    for _ in range(n):
        dunchi = tuple(map(int, input().split()))
        duncies.append(Dunchi(*dunchi))

    for dunci in duncies:
        for to_cmp in duncies:
            if dunci < to_cmp:
                dunci.rank += 1

    for dunci in duncies:
        print(dunci.rank, end=" ")
    print()