package com.github.ognen67.exercises.lists;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PayChocolate {

    public static List<List<Integer>> payChocolate(Integer chocolatePrice) {
        List<Integer> minimumCombination = getMinimumCombinationOfCoinsToPay(chocolatePrice);
        Set<List<Integer>> lists = expandToDifferentCombinations(minimumCombination);
        return generateDifferentPermutations(lists);
    }

    private static List<Integer> getMinimumCombinationOfCoinsToPay(Integer chocolatePrice) {
        int oddChocolatePrice = chocolatePrice % 2;
        int numberOfMinimalCoins = chocolatePrice / 2 + oddChocolatePrice;
        Integer[] integers = new Integer[numberOfMinimalCoins];
        Arrays.fill(integers, 2);
        if (oddChocolatePrice == 1) {
            integers[integers.length - 1] = 1;
        }
        return Arrays.asList(integers);
    }

    private static Set<List<Integer>> expandToDifferentCombinations(List<Integer> arrangement) {
        Map<Integer, Long> quantityOfCoinsOfEachType = arrangement.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<List<Integer>> result = new HashSet<>();
        result.add(generateList(quantityOfCoinsOfEachType));
        while (thereAreCoinsOfTwo(quantityOfCoinsOfEachType)) {
            quantityOfCoinsOfEachType.computeIfPresent(2, PayChocolate::removeCoinOfTwo);
            quantityOfCoinsOfEachType.compute(1, PayChocolate::replaceCoinOfTwoByTwoCoinsOfOne);
            result.add(generateList(quantityOfCoinsOfEachType));
        }
        return result;
    }

    private static boolean thereAreCoinsOfTwo(Map<Integer, Long> collect) {
        return collect.getOrDefault(2, 0L) != 0;
    }

    private static Long removeCoinOfTwo(Integer coinValue, Long quantity) {
        assert coinValue.equals(2);
        return quantity - 1L;
    }

    private static Long replaceCoinOfTwoByTwoCoinsOfOne(Integer coinValue, Long quantity) {
        assert coinValue.equals(1);
        return quantity == null ? 2 : quantity + 2L;
    }

    private static List<Integer> generateList(Map<Integer, Long> collect) {
        return collect.entrySet()
                .stream()
                .flatMap(PayChocolate::convertToList)
                .collect(Collectors.toList());
    }

    private static Stream<? extends Integer> convertToList(Map.Entry<Integer, Long> entry) {
        return Collections.nCopies(entry.getValue().intValue(), entry.getKey()).stream();
    }

    private static List<List<Integer>> generateDifferentPermutations(Set<List<Integer>> lists) {
        //20 lknes of code
        return lists.stream()
                .map(PayChocolate::generateDistinctPerms)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static Set<List<Integer>> generateDistinctPerms(List<Integer> original) {
        return generateDistinctPermsAux(new LinkedList<>(original));
    }

    public static Set<List<Integer>> generateDistinctPermsAux(List<Integer> original) {
        // base case
        if (original.isEmpty()) {
            return new HashSet<>(Collections.singletonList(Collections.emptyList()));
        }
        // general case
        Integer firstElement = original.remove(0);
        Set<List<Integer>> returnValue = new HashSet<>();
        Set<List<Integer>> permutations = generateDistinctPermsAux(original);
        for (List<Integer> smallerPermuted : permutations) {
            for (int index = 0; index <= smallerPermuted.size(); index++) {
                List<Integer> temp = new ArrayList<>(smallerPermuted);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

//    @Benchmark
//    public void benchmark(Blackhole blackhole) {
//        blackhole.consume(payChocolate(10));
//    }

    public static void main(String[] args) throws Exception {
		/*final Options options = new OptionsBuilder().forks(1)
				.warmupIterations(1)
				.include(PayChocolate.class.getCanonicalName())
				.build();
		new Runner(options).run();*/
        test();
    }

    public static <T> Set<T> symmetricDiff(final Collection<? extends T> s1, final Collection<? extends T> s2) {
        Set<T> symmetricDiff = new HashSet<T>(s1);
        symmetricDiff.addAll(s2);
        Set<T> tmp = new HashSet<T>(s1);
        tmp.retainAll(s2);
        symmetricDiff.removeAll(tmp);
        return symmetricDiff;
    }

    private static void test() {
        Set<List<Integer>> expectedCombinationsForFour = new HashSet<>(
                List.of(List.of(2, 2), List.of(2, 1, 1), List.of(1, 1, 2), List.of(1, 2, 1),
                        List.of(1, 1, 1, 1)));
        Set<List<Integer>> missingCombinations = symmetricDiff(expectedCombinationsForFour,
                payChocolate(4));
        System.out.println(missingCombinations);
        System.out.println(payChocolate(4));
		/* System.out.println(payChocolate(0));
		System.out.println(payChocolate(1));
		System.out.println(payChocolate(2));
		System.out.println(payChocolate(3));
		System.out.println(payChocolate(4));
		System.out.println(payChocolate(5));
		System.out.println(payChocolate(6));
		System.out.println(payChocolate(7));
		System.out.println(payChocolate(8)); */
    }
}