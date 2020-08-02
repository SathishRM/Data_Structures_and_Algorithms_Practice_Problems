def isPathCrossing(path: str) -> bool:
    directed_path = {'NS': 0, 'EW': 0}
    for i in range(len(path)):
        if i > 0:
            if path[i] == 'N' and path[i-1] == 'S':
                directed_path['NS'] += 1
                return True
            elif path[i] == 'S' and path[i-1] == 'N':
                directed_path['NS'] -= 1
                return True
            elif path[i] == 'E' and path[i-1] == 'W':
                directed_path['EW'] += 1
                return True
            elif path[i] == 'W' and path[i-1] == 'E':
                directed_path['EW'] -= 1
                return True

        if path[i] == 'N':
            directed_path['NS'] += 1
        elif path[i] == 'S':
            directed_path['NS'] -= 1
        elif path[i] == 'E':
            directed_path['EW'] += 1
        elif path[i] == 'W':
            directed_path['EW'] -= 1

        print(directed_path)
        if directed_path['NS'] == 0 and directed_path['EW'] == 0:
            return True

    return False

path="NESWW"
print(isPathCrossing(path))
