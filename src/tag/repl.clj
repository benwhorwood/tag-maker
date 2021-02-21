(ns tag.repl
  (:require [mount.core :as mount]
            [tag.db]))

(defn repl-start []
  (mount/start))
