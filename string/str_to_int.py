def check_int_range(num):
    if num < (2**31 * -1):
        return (2**31 * -1)
    elif num  > (2**31 -1):
        return (2**31 -1)
    else:
        return num

def string_to_int(s):
     s = str.strip()
    if s:
        sign_value = 1
        if s[0] == '-':
            sign_value = -1
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]

        if len(s) > 0 and s[0] >= '0' and s[0] <= '9':
            for i in range(len(s)):
                if not (s[i] >= '0' and s[i] <= '9'):
                    break
            else:
                return self.check_int_range(int(s) * sign_value)
            if i > 0:
                return self.check_int_range(int(s[:i]) * sign_value)
    return 0

s = "42"
print(string_to_int(s))

# if s[0] in ['-','+',] or (s[0] >= '0' and s[0] <= '9'):
#     print(s)
