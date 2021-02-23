
def main():
    def factorial(n):
        if n == 0:
            return 1
        else:
            return n*factorial(n - 1)

    def combination(x, n):
        return float(factorial(n) / (factorial(x) * factorial(n - x)))

    def probability(x, n, p, q):
        return float(combination(x, n) * q**x * p**(n - x))

    def binoprobability1(x, n, p, q):
        pr = 0.0
        for r in range(0, x+1):
            pr += probability(r, n, p, q)
        return pr
    def binoprobability2(x, n, p, q):
        pr = 0.0
        for r in range(x, n+1):
            pr += probability(r, n, p, q)
        return pr

    line = input().split(' ')
    q = float(int(line[0])/100)
    p = 1 - q
    n = int(line[1])
    value1 = binoprobability1(2, n, p, q)
    value2 = binoprobability2(2, n, p, q)
    print("{:.3f}".format(value1))
    print("{:.3f}".format(value2))


if __name__ == "__main__":
    # execute only if run as a script
    main()