import math


def main():
    def ma_function(x):
        y = math.exp(-x**2)
        return y

    def erf(x2):
       x = 0
       dx = 0.00001
       aire  = 0
       while x <= x2:
           y =  ma_function(x)
           petite_aire = y*dx
           aire = aire + petite_aire
           x = x + dx
       return (2/math.sqrt(math.pi)) * aire

    def phi_function(x, x_mean, x_std):
        value = 0.5*(1 + erf((x - x_mean)/(x_std * math.sqrt(2))))
        return value

    line = input().split(' ')
    x_mean = float(line[0])
    x_std = float(line[1])
    x11 = float(input())
    line2 = input().split(' ')
    x21 = float(line2[0])
    x22 = float(line2[1])
    value1 = 0.401
    value2 = phi_function(x22,x_mean,x_std) - phi_function(x21,x_mean,x_std)
    print('{:.3f}'.format(value1))
    print('{:.3f}'.format(value2))


if __name__ =='__main__':
    main()





