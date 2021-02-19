import math


def main():
    # A negative binomial experiment is a statistical experiment that has the following properties:
    # The experiment consists of  repeated trials.
    # The trials are independent.
    # The outcome of each trial is either success (s) or failure (f)
    # Probability(success) is the same for every trial.
    # The experiment continues until  x successes are observed.
    #
    # If X is the number of experiments until the  x^th success occurs, then X  is a discrete
    # random variable called a negative binomial.

    # let's define our distribution
    # The number of successes to be observed is n.
    # The total number of trials is n.
    # The probability of success of  1 trial is p.
    # The probability of failure of  1 trial is q , where q = 1-p .
    # p+q = 1 because of the fact that we limit the experience in tow possibilities
    # either success or failure so our space is {success, failure} , we suppose that an
    # experience with failure status does not affect an experience with a success status so the intersection
    # between the {success} space and the {failure } space is empty space:
    # Pr{total space } = Pr{success} + Pr{failure} = p + q = 1

    def factorial(n0):
        if n0 == 0:
            return 1
        else:
            return n0 * factorial(n0 - 1)

    def combination(n0, x):
        return factorial(n0) / (factorial(x) * factorial(n0 - x))

    def negative_binomial_distribution(x0, n0, p):
        q = 1 - p
        return combination(n0 - 1, x0 - 1) * p ** x0 * q ** (n0 - x0)

    def geometric_distribution(n0, p):
        q = 1 - p
        return p ** (n0 - 1) * q

    arr = [int(a) for a in input().split(' ')]
    n = int(input())
    q = float(arr[0] / arr[1])
    p = 1 - q
    prob = 0
    # let's compute the probability of having a failure in n trials
    # having one failure after one success or having 1 failure after 2 success or ... or having
    # one failure after n  success

    for i in range(1, n + 1):
        prob += geometric_distribution(i, p)

    print('{:.3f}'.format(prob))


if __name__ == '__main__':
    main()
