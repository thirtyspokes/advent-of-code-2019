(ns advent-of-code-2019.day-one-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2019.day_one :refer [fuel-mass recursive-fuel-mass]]))

(deftest testing-fuel-mass
  (testing "It calculates the nonrecursive fuel mass"
    (is (= 2 (fuel-mass 12)))
    (is (= 2 (fuel-mass 14)))
    (is (= 654 (fuel-mass 1969)))
    (is (= 33583 (fuel-mass 100756)))))

(deftest testing-recursive-fuel-mass
  (testing "It calculates the recursive fuel mass"
    (is (= 2 (recursive-fuel-mass 12)))
    (is (= 966 (recursive-fuel-mass 1969)))
    (is (= 50346 (recursive-fuel-mass 100756)))))
