(ns tag.fetch
  (:import [java.net URI])
  (:require [jsonista.core :as json]))

;; http://www.datamuse.com/api/
;; words that rhyme with forgetful	/words?rel_rhy=forgetful
;; https://api.datamuse.com/words?rel_rhy=forgetful

(def base-url "https://api.datamuse.com/words?rel_rhy=%s")

(defn rhyming-words-uri
  [^String word]
  (URI. (format base-url word)))

(defn rhyming-words
  "Map of words that rhyme with word"
  [^String word]
  (json/read-value (slurp (rhyming-words-uri word)) json/keyword-keys-object-mapper))
