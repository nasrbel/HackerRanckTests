# In this script we will:
# The ratio of boys to girls for babies born in Russia is .
# If there is  child born per birth, what proportion of Russian families
# with exactly  children will have at least  boys?
# Write a program to compute the answer using the above parameters.
# Then print your result, rounded to a scale of  decimal places (i.e.,  format)
# You can refer to this link: https://www.hackerrank.com/challenges/s10-binomial-distribution-1/problem
#
# p = probablity(of having a boy)
# p = numbr of boys / total number = nb(boys)/nb(boys)+nb(girls) = 1.09*nb(girsl)/nb(girls)+1.09 nb(girls) = 0.909


def main():
    def factorial(n):
        if n == 0:
            return 1
        else:
            return n*factorial(n - 1)

    def combination(x, n):
        return float(factorial(n) / (factorial(x) * factorial(n - x)))

    def probability(x, n, p, q):
        return float(combination(x, n) * p**x * q**(n - x))

    def binoprobability(x, n, p, q):
        pr = 0.0
        for r in range(x, n):
            pr += probability(r, n, p, q)
        return pr

    p = 1.09/2.09
    q = 1-p
    value = binoprobability(3, 6, p, q)
    print("{:.3f}".format(value))


if __name__ == "__main__":
    # execute only if run as a script
    main()

