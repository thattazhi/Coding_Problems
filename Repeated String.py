def repeatedString(s, n):
    l = len(s)

    if n < l:
        s = s[: n]
        count = len([c for c in s if c == 'a'])
        return count

    count = len([c for c in s if c == 'a'])

    count *= n // l

    x = (n - l) % l
    if x != 0:
        s = s[: x]
        count += len([c for c in s if c == 'a'])

    return count


s = 'aba'
n = 10

result = repeatedString(s, n)
print(result)


s = 'a'
n = 1000000000000

result = repeatedString(s, n)
print(result)
