(ns advent-of-code-2019.day-two-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2019.day_two :refer [intcode-processor]]))

(deftest testing-intcode-processor
  (testing "It can execute programs"
    (is (= [3500 9 10 70 2 3 11 0 99 30 40 50] (intcode-processor [1 9 10 3 2 3 11 0 99 30 40 50])))
    (is (= [2 0 0 0 99] (intcode-processor [1 0 0 0 99])))
    (is (= [2 3 0 6 99] (intcode-processor [2 3 0 3 99])))
    (is (= [2 4 4 5 99 9801] (intcode-processor [2 4 4 5 99 0])))
    (is (= [30 1 1 4 2 5 6 0 99] (intcode-processor [1 1 1 4 99 5 6 0 99])))))
