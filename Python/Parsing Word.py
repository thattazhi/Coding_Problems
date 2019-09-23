from collections import deque

def wordparser(input_lines):
    ans = 'words\n'

    word_characters = [chr(i) for i in range(97, 123)]

    input_length = len(input_lines)

    words = []
    word_count = []
    total_word_count = 0
    letters = word_characters
    letter_count = [0] * 26

    queue = deque()
    flag = 0

    for i in range(input_length):

        if (input_lines[i] == ' ' or input_lines[i] == '\n') \
                and i != 0:
            flag = 0
            string = ''
            for s in queue:
                string += s

            if string in words:
                word_count[words.index(string)] += 1

            else:
                words.append(string)
                word_count.append(1)

            total_word_count += 1
            queue.clear()

        elif input_lines[i] in word_characters \
                and flag != 1:
            queue.append(input_lines[i])
            # current_letter_count[letters.index(input_lines[i])] += 1
            letter_count[letters.index(input_lines[i])] += 1

        else:
            for j in range(len(queue)):
                if letter_count[letters.index(queue[j])] == 1:
                    letter_count.pop(letters.index(queue[j]))
                    letters.remove(queue[j])
            queue.clear()
            flag = 1

        if i == input_length - 1:
            flag = 0
            string = ''
            for s in queue:
                string += s

            if string in words:
                word_count[words.index(string)] += 1

            else:
                words.append(string)
                word_count.append(1)

            queue.clear()

    ans = str(total_word_count) + '\n' + ans
    for i in range(len(words)):
        ans += words[i] + ' ' + str(word_count[i]) + '\n'

    ans += 'letters\n'
    for i in range(len(letters)):
        ans += letters[i] + ' ' + str(letter_count[i]) + '\n'

    return ans


print(wordparser('a to the four where supers i be the other four'))
