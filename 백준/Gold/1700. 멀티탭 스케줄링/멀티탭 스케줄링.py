import sys
from collections import deque

class Plug:
    def __init__(self, num):
        self.set = set()
        self.freed_plug = num

    def plug_in(self, item):
        self.set.add(item)
        self.freed_plug -= 1
    
    def plug_off(self, item):
        self.set.remove(item)
        self.freed_plug += 1
    
    def get_item_to_plug_off(self, left_items: deque):
        max_idx = -1
        to_return = 0
        for item in self.set:
            found = False
            for idx, val in enumerate(left_items):
                if val == item:
                    if idx > max_idx:
                        to_return = val
                        max_idx = idx
                    found = True
                    break
            
            if not found:
                return item

        return to_return



plug_num, tot_usage = map(int, sys.stdin.readline().split())
plugs = Plug(plug_num)

items = deque(map(int, sys.stdin.readline().split()))

count = 0
while (items):
    item = items.popleft()    
    # 꽂아야 하는 아이템이 이미 플러그에 있는 경우
    if item not in plugs.set:
        # 플러그에 여유공간이 있는 경우
        if plugs.freed_plug:
            plugs.plug_in(item)

        else:
            plugs.plug_off(
                plugs.get_item_to_plug_off(items.copy())
            )
            plugs.plug_in(item)
            count += 1

sys.stdout.write(f"{count}\n")