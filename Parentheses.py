def solution(parantheses):

    count = 0
    str = ''
    for i in range(len(parantheses)):
        if parantheses[i] == '(':
            count += 1

        elif parantheses[i] == ')' and count != 0:
            count -= 1

        else:
            str = '(' + str

    str = str + parantheses

    for i in range(count):
        str += ')'

    return str

print(solution(')(()('))