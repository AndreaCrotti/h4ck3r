(ns h4ck3r.core)

;; the actual conversion should probably be a protocol
;; which defines how things can be matched

(def default-trimmed-size 2)
(def vowels (set "aeiou"))

(defn wordify [string]
  "Return a list of words"
  (re-seq #"\w+" string))

(defmulti convert-internal
  (fn [to-convert] (:strategy to-convert)))

(defmethod convert-internal :trim
  [to-convert]
  (subs (:word to-convert) 0 default-trimmed-size))

(defmethod convert-internal :cons
  [to-convert]
  (apply str (filter (complement vowels) (seq (:word to-convert))))
  )

(defn convert [string strategy]
  "Transform a string"
  (let [words (wordify string)
        mapping (apply merge
                       (for [wr words] {wr (convert-internal {:strategy strategy :word wr})}))]
    
    {:shortened
     (clojure.string/join " " (vals mapping))
     :mapping mapping}))
