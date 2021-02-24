import math


def main():
    def ma_function(x):
        y = math.exp(-x**2)
        return y

    def erf(x2):
        if x2 < 0:
            x2 = -x2
        x = 0
        dx = 0.00001
        aire = 0
        while x <= x2:
            y = ma_function(x)
            petite_aire = y*dx
            aire += petite_aire
            x += dx
        return (2/math.sqrt(math.pi)) * aire

    def phi_function(x, x_mean0, x_std0):
        value = 0.5*(1 + erf((x - x_mean0) / (x_std0 * math.sqrt(2))))
        return value

    line = input().split(' ')
    x_mean = float(line[0])
    x_std = float(line[1])
    x11 = float(input())
    x22 = float(input())
    value1 = 1 - phi_function(x11,x_mean,x_std)
    value2 = 1 - phi_function(x22,x_mean,x_std)
    value3 = phi_function(x22,x_mean,x_std)
    print('{:.2f}'.format(100*value1))
    print('{:.2f}'.format(100*value3))
    print('{:.2f}'.format(100*value2))



if __name__ =='__main__':
    main()

