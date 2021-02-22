import math
import numpy as np
def main():
    # get the transpose of a matrix NxN
    def compute_b(x, y):
        a = x.transpose().dot(x)
        inv = np.linalg.inv(a)
        return inv.dot(x.transpose().dot(y))


