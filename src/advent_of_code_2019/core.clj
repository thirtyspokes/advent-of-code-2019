(ns advent-of-code-2019.core)

(defn read-file
  "Read a file line-by-line as a lazyseq."
  [filename]
  (clojure.string/split (slurp filename) #"\n"))
