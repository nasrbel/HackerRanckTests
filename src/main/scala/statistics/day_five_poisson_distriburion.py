import math


def main():
    def poisson_distribution(n, lambda_value_input):
        return lambda_value_input ** n * math.exp(-lambda_value_input) / math.factorial(n)

    lambda_value = float(input())
    n = int(input())
    value = poisson_distribution(n,lambda_value)
    print('{:.3f}'.format(value))


if __name__ == '__main__':
    main()
