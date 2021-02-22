import math
import numpy as np
def main():
    # get the transpose of a matrix NxN
    def compute_b(x, y):
        a = x.transpose().dot(x)
        inv = np.linalg.inv(a)
        return inv.dot(x.transpose().dot(y))

    line = input().split()
    m = int(line[0])
    n = int(line[1])

    x = np.zeros(n, m)
    y = np.zeros(n)
    for i in range(n):
        inputLine = input().split()
        y[i] = float(inputLine[len(inputLine)])
        for j in range(m):
            x[i][j] = float(inputLine[j])
    b = compute_b(x, y)
    q = int(input())
    x_test = np.zeros(q, m)
    for k in range(q):
        test_line = input().split()
        for p in range(m):
            x_test[k][p] = float(test_line[p])




