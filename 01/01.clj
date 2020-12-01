#!/usr/local/bin/clj -M

(def input (nth *command-line-args* 0))

(def content (with-open [rdr (clojure.java.io/reader input)]
  (reduce conj [] (line-seq rdr))))

(loop [j 0]
  (when (< j (count content))
    (loop [i (+ j 1)]
      (when (< i (count content)) 
        (def a (Integer/parseInt (get content i)))
        (def b (Integer/parseInt (get content j)))
        (when (= 2020 (+ a b))
          (println "Part 1: " (* a b)))
        (recur (+ i 1))))
    (recur (+ j 1))))

(def cont true)
(loop [j 0]
  (when (and cont (< j (count content)))
    (loop [i (+ j 1)]
      (when (and cont (< i (count content)))
        (loop [k (+ j 1)]
          (when (and cont (< k (count content)))
            (def a (Integer/parseInt (get content i)))
            (def b (Integer/parseInt (get content j)))
            (def c (Integer/parseInt (get content k)))
            (when (= 2020 (+ a b c))
              (println "Part 2: " (* a b c))
              (def cont false))
          (recur (+ k 1))))
        (recur (+ i 1))))
    (recur (+ j 1))))
