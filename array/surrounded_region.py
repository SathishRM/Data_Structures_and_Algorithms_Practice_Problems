class solution:
    def solve(board: list(list([str]))) -> None:
        row_len = len(board)
        if row_len > 2:
            for n in range(1,row_len-1):
                inner_len = len(board[n])
                if inner_len > 2:
                    if n == 1:
                        row_inc = -1
                    elif n == row_len - 2:
                        row_inc = 1
                    else:
                        row_inc = 0
                    for m in range(1, inner_len-1):
                        if inner_len > 2:
                            if m == 1:
                                col_inc = -1
                            elif m == inner_len - 2:
                                col_inc = 1
                            else:
                                col_inc = 0

                            if board[n][m] == 'o':
                                if row_inc != 0:
                                    # print("row",n,n+row_inc,m,board[n+row_inc][m])
                                    if board[n+row_inc][m] == 'o':
                                        continue
                                if col_inc != 0:
                                    # print("col",n,m,m+col_inc,board[n][m+col_inc])
                                    if board[n][m+col_inc] == 'o':
                                        continue

                                board[n][m] = 'x'



board = [['x','x','x','x'],['x','o','o','x'],['x','x','o','x'],['x','o','x','x']]

print(board)
solution.solve(board)
print(board)
