#include <iostream>
#include <vector>
#include <deque>
#include <cmath>
using std::cin;
using std::cout;
using std::vector;
using std::pair;
using std::deque;
const char endl = '\n';

void ios_preset()
{
    std::ios_base::sync_with_stdio(false); 
	std::cin.tie(NULL); 
	std::cout.tie(NULL); 
}

struct Box 
{
    int l, w, h;
    Box(int _l=0, int _w=0, int _h=0) : l(_l), w(_w), h(_h) 
    {}
};

struct Cube : public Box
{
    Cube(int _exponent) : 
    Box(1 << _exponent, 1 << _exponent, 1 << _exponent)
    {} 
};

bool sizeCheck(Box &target, int blockSide)
{
    int blockLength = blockSide;
    return (target.l >= blockLength && target.w >= blockLength && target.h >= blockLength);
}


int getLeftVolumeBoxes(Box &box, Cube &cube, deque<Box> &boxes, int toUse)
{
    // ?????? ?????????? ???????? ???????? ?? ???? Box?? ???? ?? ?????? ????
    // l w h ?? ?? ???? ?????? ??????
    Box stackedBlock;
    int usable = toUse;
    for (; usable > 0; --usable)
    {
        int longestSideLength = cube.l * usable;
        if (box.l >= longestSideLength)
        {
            stackedBlock.l = longestSideLength;
            stackedBlock.w = cube.l;
            stackedBlock.h = cube.l;
            break;
        }
        else if (box.w >= longestSideLength)
        {
            stackedBlock.l = cube.l;
            stackedBlock.w = longestSideLength;
            stackedBlock.h = cube.l;
            break;
        }
        else if (box.h >= longestSideLength)
        {
            stackedBlock.l = cube.l;
            stackedBlock.w = cube.l;
            stackedBlock.h = longestSideLength;
            break;
        }
    }

    if (!usable)
        return 0;    

    if (box.l - stackedBlock.l && box.w && box.h)
        boxes.push_back(Box(box.l - stackedBlock.l, box.w, box.h));
    
    if (stackedBlock.l && box.w - stackedBlock.w &&box.h)
        boxes.push_back(Box(stackedBlock.l, box.w - stackedBlock.w, box.h));

    if (stackedBlock.l && stackedBlock.w && box.h - stackedBlock.h)
        boxes.push_back(Box(stackedBlock.l, stackedBlock.w, box.h - stackedBlock.h));

    return usable;
}

int main()
{
    ios_preset();
    int l, w, h, n;
    cin >> l >> w >> h;
    cin >> n;

    deque<Box> boxes;
    vector<pair<Cube, int>> blocks;
    boxes.push_back(Box(l, w, h));

    int totBlocks = 0;
    for (int i = 0, _ln, c; i < n; ++i)
    {
        cin >> _ln >> c;
        totBlocks += c;
        blocks.push_back(pair<Cube, int>(Cube(_ln), c));
    }

    int usedBlocks = 0;
    long removedVolume = 0;
    while (!boxes.empty())
    {
        if (totBlocks < usedBlocks)
        {
            cout << -1 << endl;
            return 0;
        }
        
        Box target = boxes.front();
        boxes.pop_front();
        long boxVolume = static_cast<long>(target.l) * target.w * target.h;
    

        for (int i = n-1; i >= 0; --i)
        {            
            // ???? ???? ?????? ????????
            if (!blocks[i].second || !sizeCheck(target, blocks[i].first.l))
                continue;

            long blockVolume = static_cast<long>(blocks[i].first.l) * blocks[i].first.h * blocks[i].first.w;
            int toUse = boxVolume / blockVolume <= blocks[i].second ? 
                        boxVolume / blockVolume : blocks[i].second;

            int res = getLeftVolumeBoxes(target, blocks[i].first, boxes, toUse);
            usedBlocks += res;
            blocks[i].second -= res;
            removedVolume += blockVolume * res;
            break;
        }
    }


    if (static_cast<long>(l) * w * h == removedVolume)
        cout << usedBlocks << endl;
    else
        cout << -1 << endl;

    return 0;
}