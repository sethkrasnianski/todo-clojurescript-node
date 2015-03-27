(defproject todo "0.1.0-SNAPSHOT"
  :description "Todo app in clojurescript"
  :url "http://github.com/sethkrasnianski/todo-clojurescript-node"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2755"]]

  :node-dependencies [[source-map-support "0.2.8"]
                      [express "4.12.3"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-npm "0.4.0"]]

  :source-paths ["src" "target/classes"]

  :clean-targets  ["out/server/pow"  "out/server/pow.js"]

  :cljsbuild {
    :builds [{:id "server"
              :source-paths ["src/server"]
              :compiler {
                :main todo.core
                :output-to "out/server/todo.js"
                :output-dir "out/server"
                :optimizations :simple
                :target :nodejs
                :cache-analysis true
                :source-map "out/server/pow.js.map"}}
             {:id "release"
              :source-paths ["src"]
              :compiler {
                :main todo.core
                :output-to "out-adv/todo.min.js"
                :output-dir "out-adv"
                :optimizations :advanced
                :pretty-print false}}]})
