(ns todo.core
  (:require [cljs.nodejs :as node]))

(node/enable-util-print!)

(def express
  (node/require "express"))

(defn handler [req res]
  (.send res "Hello there"))

(defn started! []
  (println "Server started on port 3838"))

(defn -main []
  (let [app (express)]
    (.get app "/" handler)
    (.listen app 3838 started!)))

(set! *main-cli-fn* -main)
