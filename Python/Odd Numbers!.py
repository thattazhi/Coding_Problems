import itertools
def findMaxGoalsProbability(teamGoals):
    # Write your code here
    sums = []
    for i, j in itertools.combinations(teamGoals, 2):
        sums.append(i+j)
    result = sums.count(max(sums)) / len(sums)
    print (result)
    print (sums)
    if len(str(result)) == 3:
        print (str(result) + "0")
        return str(result) + "0"
    else:
        print (str(result)[:4])
        return str(result)[:4]

print (findMaxGoalsProbability([1,2,2,3]))