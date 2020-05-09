def check_straight_line(coordinates: list([list([int])])) -> bool:
    coord_len = len(coordinates)
    if coord_len == 2:
        return True
    elif coord_len > 2:
        for i in range(2,coord_len):
            x_diff1 = coordinates[i][0] - coordinates[i-1][0]
            y_diff1 = coordinates[i][1] - coordinates[i-1][1]
            x_diff2 = coordinates[i-1][0] - coordinates[i-2][0]
            y_diff2 = coordinates[i-1][1] - coordinates[i-2][1]

            if x_diff1 and x_diff2:
                cur_slope = y_diff1 / x_diff1
                pre_slope = y_diff2 / x_diff2
                if pre_slope != cur_slope:
                    return False
            elif x_diff1 != x_diff2:
                return False
        else:
            return True
    else:
        return False

#coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
#False
coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
#True
print(check_straight_line(coordinates))
