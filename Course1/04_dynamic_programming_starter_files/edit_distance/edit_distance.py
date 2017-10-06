# Uses python3
def edit_distance(s, t):
  lengthS = len(s)
  lengthT = len(t)
  D = [[0]*(lengthT + 1) for i in range(lengthS + 1)]

  for i in range(lengthS + 1):
    D[i][0] = i

  for i in range(lengthT + 1):
    D[0][i] = i

  for i in range(1,lengthS + 1):
    for j in range(1,lengthT + 1):
      if s[i-1] == t[j-1]:
        D[i][j] = min(D[i-1][j-1], D[i-1][j]+1, D[i][j-1]+1)
      else:
        D[i][j] = min(D[i-1][j-1] + 1, D[i-1][j]+1, D[i][j-1]+1)

  return D[lengthS][lengthT]



if __name__ == "__main__":
    print(edit_distance(input(), input()))
