import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.LongBinaryOperator;

import static java.lang.Math.max;
import static java.lang.Math.pow;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Solution {
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}; // primes up to 30
    private static final long MAX = (long) pow(10, 9) + 7;
    private static final LongBinaryOperator ADD = (x, y) -> (x + y) % MAX;

    private final Map<Integer, OptionalInt> isGood = new HashMap<>();
    
    public int numberOfGoodSubsets(int[] A) {
        var freq = Arrays.stream(A)
                         .filter(a -> a > 1)
                         .mapToObj(this::test)
                         .filter(OptionalInt::isPresent)
                         .collect(groupingBy(OptionalInt::getAsInt, counting()));

        Map<Integer, Long> cache = new HashMap<>();
        cache.put(0, 0L); // or we can set its value to 1 and in the end use: subSetWithoutOne - 1

        for (var numFreq : freq.entrySet()) {
            int a = numFreq.getKey();
            long aCount = numFreq.getValue();

            for (int b : cache.keySet().toArray(Integer[]::new)) {
                if ((a & b) > 0)
                    continue;

                long bCount = cache.get(b); // Note: cache.get(b) is zero when b is 0

                cache.merge(a | b, (aCount * max(1, bCount)) % MAX, ADD::applyAsLong);
            }
        }

        int ones = (int) Arrays.stream(A)
                               .filter(a -> a == 1)
                               .count();
        long effectOfOne = powAndRemainder(2, ones, MAX);
        long subSetWithoutOne = cache.values()
                                     .stream()
                                     .mapToLong(x -> x)
                                     .reduce(0L, ADD);

        return (int) ((effectOfOne * subSetWithoutOne) % MAX);
    }

    /**
     * @param x
     * @param n
     * @param r
     * @return (x ^ n) % r
     */
    private static long powAndRemainder(int x, int n, long r) {
        if (n == 0)
            return 1;

        long out = powAndRemainder(x, n / 2, r);
        out = (out * out) % r;

        if (n % 2 == 1)
            out = (out * x) % r;

        return out;
    }

    /**
     * tests if given number a is good number or not.
     *
     * @param a
     * @return OptionalInt.empty() if a is not a good number else OptionalInt object containing masked representation of
     * the number "a" where ith bit of the mask is 1 if prime i divides the number a
     */
    private OptionalInt test(int a) {
        OptionalInt output = isGood.get(a);

        if (nonNull(output))
            return output;

        int repr = 0;

        for (int i = 0, num = a, p, mask; i < PRIMES.length && num > 1; ) {
            if (num % (p = PRIMES[i]) != 0) {
                i++;
                continue;
            }

            mask = 1 << p;

            if ((mask & repr) > 0) {
                repr = 0;
                break;
            }

            repr |= mask;
            num /= p;
        }

        output = repr == 0 ? OptionalInt.empty() : OptionalInt.of(repr);

        isGood.put(a, output);

        return output;
    }
}