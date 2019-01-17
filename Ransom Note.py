def checkMagazine(magazine, note):
    magazine_dict = {word: 0 for word in magazine + note}
    print(magazine_dict)
    note_dict = {word: 0 for word in note}
    print(note_dict)
    for word in note:
        note_dict[word] += 1

    for word in magazine:
        magazine_dict[word] += 1

    for word in note:
        if note_dict[word] != magazine_dict[word]:
            print("No")
            return

    print("Yes")


checkMagazine(['a', 'b'], ['c'])
