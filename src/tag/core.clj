(ns tag.core
  (:require [mount.core :as mount]
            [clojure.string :as string]
            [tag.db :refer [rhyme]])
  (:gen-class))

(defn argm
  [args]
  {:num-rhymes (or (if-let [arg1 (first args)]
                     (Integer/parseInt arg1))
                   1)
   :separator (or (second args) " ")
   :verbose? (some #{"-v"} args)})

(defn uniq-rhymes
  [num-rhymes separator]
  (loop [cnt num-rhymes
         rhymes []]
    
    (if (zero? cnt)
      rhymes

      (let [rhyme (rhyme separator)
            new-rhyme? (not (some #{rhyme} rhymes))]
        (recur (- cnt (if new-rhyme? 1, 0))
               (if new-rhyme?
                 (conj rhymes rhyme)
                 rhymes))))))

(defn -main
  [& args]
  (try
    (let [{:keys [verbose? num-rhymes separator] :as config} (argm args)]
      (mount/start)

      (when verbose?
        (println "tag maker running with config:" (pr-str config)))
      
      (println (string/join "\n" (shuffle (uniq-rhymes num-rhymes separator)))))

    (catch Exception ex
      (println "tag <num-rhymes> <separator>\n\n" (.getMessage ex)))))

;; (-main "2" "-" "-v")
