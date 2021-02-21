import math


def main():
    def sigma(x_variable, nu_x):
        s = 0
        for x0 in x_variable:
            s += (x0 - nu_x) ** 2
        s = math.sqrt(s / len(x_variable))
        return s

    n = int(input())
    x = [float(x0) for x0 in input().split()]
    y = [float(y0) for y0 in input().split()]
    mean_x = float(sum(x)/n)
    mean_y = float(sum(y)/n)
    p_x_y = 0
    for i in range(len(x)):
        p_x_y += (x[i]-mean_x)*(y[i]-mean_y)
    p_x_y /= n * sigma(x, mean_x) * sigma(y, mean_y)
    print('{:.3f}'.format(p_x_y))


if __name__ == '__main__':

    main()