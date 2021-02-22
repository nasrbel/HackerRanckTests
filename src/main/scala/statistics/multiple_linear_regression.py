import math
import numpy as np
def main():
    # get the transpose of a matrix NxN
    def compute_b(x, y):
        a = x.transpose().dot(x)
        inv = np.linalg.inv(a)
        return inv.dot(x.transpose().dot(y))

    line = input().split(' ')
    m = int(line[0])
    n = int(line[1])
    x = np.zeros((n, m+1))
    y = np.zeros(n)
    for i in range(n):
        inputLine = input().split(' ')
        y[i] = float(inputLine[len(inputLine)-1])
        x[i][0] = 1.0
        for j in range(m):
            x[i][j+1] = float(inputLine[j])
    b = compute_b(x, y)
    q = int(input())
    x_test = np.zeros((q, m+1))
    for k in range(q):
        test_line = input().split(' ')
        x_test[k][0] = 1.0
        for p in range(m):
            x_test[k][p+1] = float(test_line[p])

    output_y = x_test.dot(b)
    for y0 in output_y:
        value = '{:.2f}'.format(y0)
        print(value)


if __name__ == '__main__':
    main()



