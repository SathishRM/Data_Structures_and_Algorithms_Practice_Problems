def angleClock(hour: int, minutes: int) -> float:
    '''Needs to return the smallest angel between clock hands
    '''
    first_position = (hour % 12) * 5
    # minutes / 60 * 5
    position_after_min = minutes / 12
    cal_angle = abs(first_position + position_after_min - minutes) * 6
    if cal_angle > 180:
        cal_angle = 360 - cal_angle

    return cal_angle

print(angleClock(1,57))
