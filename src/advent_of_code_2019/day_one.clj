(ns advent-of-code-2019.day_one
  (:require [clojure.core.reducers :as r]
            [advent-of-code-2019.core :refer [read-file]]))

(defn fuel-mass
  [mass]
  (- (quot mass 3) 2))

(defn recursive-fuel-mass
  ([mass]
   (recursive-fuel-mass mass 0))
  ([mass total]
   (if (<= mass 8)
     total
     (let [fuel-mass (fuel-mass mass)]
       (recur fuel-mass (+ total fuel-mass))))))

(defn part-one
  [filename]
  (->> (read-file filename)
       (r/map #(Integer/parseInt %))
       (r/map fuel-mass)
       (r/reduce +)))

(defn part-two
  [filename]
  (->> (read-file filename)
       (r/map #(Integer/parseInt %))
       (r/map recursive-fuel-mass)
       (r/reduce +)))
