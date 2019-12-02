(ns advent-of-code-2019.day_two
  (:require [advent-of-code-2019.core :refer [read-file]]
            [clojure.math.combinatorics :as combo]))

(defn parse-input
  [filename]
  (->> (clojure.string/split (first (read-file filename)) #",")
             (map #(Integer/parseInt %))
             (into [])))

(defn intcode-processor
  ([inputs]
   (intcode-processor inputs 0))
  ([inputs current-index]
   (if (> current-index (- (count inputs) 5))
     inputs
     (let [opcode (nth inputs current-index)
           x (nth inputs (nth inputs (+ 1 current-index)))
           y (nth inputs (nth inputs (+ 2 current-index)))
           result-index (nth inputs (+ 3 current-index))
           next-index (+ 4 current-index)]
       (case opcode
         99 inputs
         1 (recur (assoc inputs result-index (+ x y)) next-index)
         2 (recur (assoc inputs result-index (* x y)) next-index)
         (recur inputs next-index))))))

(defn part-one
  [filename pos-1-val pos-2-val]
  (let [raw-inputs (parse-input filename)
        inputs (assoc raw-inputs 1 pos-1-val 2 pos-2-val)]
    (first (intcode-processor inputs))))

(defn part-two
  [filename]
  (let [raw-inputs (parse-input filename)
        attempts (combo/cartesian-product (range 100) (range 100))]
    (reduce (fn [_ [x y]]
              (let [inputs (assoc raw-inputs 1 x 2 y)
                    result (first (intcode-processor inputs))]
                (when (= 19690720 result)
                  (reduced (+ (* 100 x) y)))))
            attempts)))
