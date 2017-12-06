(ns todoer.db
  (:require
    [clojure.test.check.generators :as gen]))

(def nouns
  (gen/elements
    ["dog" "cat" "mouse"
     "bitcoin" "tesla"
     "laptop" "chain"
     "house" "bicycle"]))

(def verbs
  (gen/elements
    ["rent" "buy"
     "sell" "tip toe on"
     "encourage"
     "terrorize"
     "feed" "pet"]))

(def articles
  (gen/elements
    ["his" "her" "the" "a"]))

(def tasks
  (->>
    (gen/tuple verbs articles nouns)
    (gen/fmap (partial clojure.string/join " "))))

(defn ->task
  [s]
  {:edit? false
   :text s})

(def default-db
  {:name "Todoer"
   :todos (vec (for [t (gen/sample tasks 10)]
                 (->task t)))})
