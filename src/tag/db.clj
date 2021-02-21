(ns tag.db
  (:require [jsonista.core :as json]
            [tag.fetch :as fetch]))

(def animals
  ["goat"
   "donkey"
   "frog"
   "mule"
   "doggy"
   "llama"
   "cat"
   "newt"])

(def actions
  ["yawning"
   "poking"
   "dancing"
   "smiling"
   "eating"
   "jesting"
   "gigging"])


(defn rhyming-words
  "Coll of words related to word"
  [n ^String word]
  (map :word (take n (shuffle (fetch/rhyming-words word)))))


(defn gen-rhyming
  [n-per-word words]
  (into {}
        (map
         (fn [word]
           [word (rhyming-words n-per-word word)])
         words)))


(defn- spit-animals!
  []
  (spit "resources/animals.json" (json/write-value-as-string animals)))

(defn- spit-actions!
  []
  (spit "resources/actions.json" (json/write-value-as-string actions)))

(defn- spit-animals-rhyming!
  []
  (spit "resources/animals_rhyming.json" (json/write-value-as-string (gen-rhyming 8 animals))))
