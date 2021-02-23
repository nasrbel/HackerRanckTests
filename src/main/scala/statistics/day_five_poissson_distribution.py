import math


def main():
    # A Poisson random variable is the number of successes that result
    # from a Poisson experiment. The probability distribution of a Poisson
    # random variable is called a Poisson distribution
    #the mean of the cost is : a + b*E(x^2)= a + b*(lambda + lambda^2)
    def cost_a(x):
        cost_value = 160 + 40 * (x**2 + x)
        return '{:.3f}'.format(cost_value)

    def cost_b(y):
        cost_value = 128 + 40 * (y**2 + y)
        return '{:.3f}'.format(cost_value)

    #we need to compute the number of success per day
    line = input().split(' ')
    lambda_x = float(line[0])
    lambda_y = float(line[1])
    print(cost_a(lambda_x))
    print(cost_b(lambda_y))


if __name__ == '__main__':
        main()