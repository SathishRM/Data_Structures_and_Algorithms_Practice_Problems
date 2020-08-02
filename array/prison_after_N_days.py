def prisonAfterNDays(cells: list([int]), N: int) -> list([int]):
    ''' There are 8 cells in row
    Condition - both the adjacent are either occupied or vacant, the cell will become occupied on next day
    '''
    no_cells = len(cells)
    no_shifts = N % 14
    if no_shifts == 0:
        no_shifts = 14
    for i in range(no_shifts):
        prev_day = cells[:]
        # print(prev_day)
        for j in range(1,no_cells-1):

            if prev_day[j-1] == prev_day[j+1]:
                cells[j] = 1
            else:
                cells[j] = 0
            # print(prev_day[j-1],prev_day[j+1],cells[j])
        else:
            cells[0], cells[no_cells-1] = 0 ,0
    return cells

cells = [0,1,0,1,1,0,0,1]
print(prisonAfterNDays(cells,7))
