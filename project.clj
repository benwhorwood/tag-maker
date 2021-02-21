(defproject tag "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [metosin/jsonista "0.3.1"]

                 ;; REBL for this project
                 ;; https://github.com/DaveWM/nrepl-rebl
                 ;;https://github.com/jafingerhut/rebl-experiments
                 [org.openjfx/javafx-fxml "11.0.1"]
                 [org.openjfx/javafx-controls "11.0.1"]
                 [org.openjfx/javafx-swing "11.0.1"]
                 [org.openjfx/javafx-base "11.0.1"]
                 [org.openjfx/javafx-web "11.0.1"]
                 [nrepl-rebl "0.1.1"]
                 [com.cognitect/rebl "0.9.242"]]
  :main ^:skip-aot tag.core
  :repl-options {;;:init-ns enuf.repl
                 ;;:init (start)
                 :nrepl-middleware [nrepl-rebl.core/wrap-rebl]}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
