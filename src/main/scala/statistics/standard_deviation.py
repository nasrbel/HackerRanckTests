import math

#ref : https://www.hackerrank.com/challenges/s10-standard-deviation/problem?h_r=next-challenge&h_v=zen


def main():

    n = int(input())
    arr = [int(a) for a in input().split(' ')]

    def mean(input_arr):
        nu = 0
        for a in input_arr:
            nu += a
        nu = float(nu/len(input_arr))
        return nu

    def standard_deviation(input_arr):
        nu = mean(input_arr)
        st_devi = 0
        for a in input_arr:
            st_devi += (a - nu)**2

        st_devi /= len(input_arr)
        st_devi = math.sqrt(st_devi)

        return st_devi

    std_deviation = standard_deviation(arr)
    print("{:.1f}".format(std_deviation))

if __name__ == '__main__':
    #excute main()
    main()

