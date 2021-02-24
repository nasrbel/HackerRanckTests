import math


def main():
    x = int(input())
    n = int(input())
    mu = int(input())
    sigma = int(input())
    mu_sum = n * mu
    sigma_sum = math.sqrt(n) * sigma

    def cdf(x, mu, sigma):
        Z = (x - mu)/sigma
        return 0.5*(1 + math.erf(Z/(math.sqrt(2))))
    value = cdf(x,mu_sum,sigma_sum)
    print('{:.4f}'.format(value))


if __name__ == '__main__':
    main()

