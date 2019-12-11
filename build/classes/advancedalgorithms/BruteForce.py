import sys
from itertools import combinations, chain

def powerset(iterable):
    s = list(iterable)
    return chain.from_iterable(combinations(s, r) for r in range(len(s)+1))

def bruteforce(text, width):
    words = text.split()
    count = len(words)

    minimum = float("inf")
    breaks = ()
    for b in powerset(range(1, count)):
        m = 0
        i = 0
        for j in chain(b, (count,)):
            w = len(' '.join(words[i:j]))
            if w > width:
                break
            m += (width - w) ** 2
            i = j
        else:
            if m < minimum:
                minimum = m
                breaks = b

    lines = []
    i = 0
    for j in chain(breaks, (count,)):
        lines.append(' '.join(words[i:j]))
        i = j
    print("\n".join ( lines ))
    return lines

if __name__ == "__main__":
    text=str(sys.argv[1])
    width=int(sys.argv[2])
    bruteforce(text, width)
