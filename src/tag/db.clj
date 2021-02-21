(ns tag.db
  (:require [mount.core :refer [defstate]]
            [clojure.java.io :as io]
            [clojure.string :as string]
            [jsonista.core :as json]
            [tag.fetch :as fetch]))

(defn- read-json
  [f]
  (json/read-value (slurp (io/resource f))))

(defstate animals
  :start (read-json "animals.json"))

(defstate animals-rhyming
  :start (read-json "animals_rhyming.json"))

(defstate actions
  :start (read-json "actions.json"))


(defn rhyme-parts
  "Parts of a single rhyme"
  [animals animals-rhyming actions]
  (let [animal (rand-nth animals)]
    [(rand-nth actions)
     animal
     (rand-nth (get animals-rhyming animal))]))

(defn rhyme
  ([sep]
   (string/join sep (rhyme-parts animals animals-rhyming actions)))
  
  ([]
   (rhyme " ")))


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
